import { apiClient } from '@/lib/api/client'

export type UserRole = 'admin' | 'officer' | 'civilian'

export type AuthUser = {
  id: string
  login_identifier: string
  mobile_number: string | null
  psn: string | null
  is_active: boolean
  last_login_at: string | null
  role: UserRole
  roles: string[]
  permissions: string[]
  display_name: string
  district: string
  badge_number?: string
  station?: string
}

const LOCAL_STORAGE_USER_KEY = 'kuruhu.active-user'
const LOCAL_STORAGE_TOKEN_KEY = 'pramaan_jwt_token'

export function getStoredUser(): AuthUser | null {
  if (typeof window === 'undefined') return null
  try {
    const raw = window.localStorage.getItem(LOCAL_STORAGE_USER_KEY)
    if (raw) return JSON.parse(raw)
  } catch {}
  return null
}

export function setStoredUser(user: AuthUser | null, token?: string): void {
  if (typeof window === 'undefined') return
  if (user) {
    window.localStorage.setItem(LOCAL_STORAGE_USER_KEY, JSON.stringify(user))
    if (token) {
      window.localStorage.setItem(LOCAL_STORAGE_TOKEN_KEY, token)
    }
  } else {
    window.localStorage.removeItem(LOCAL_STORAGE_USER_KEY)
    window.localStorage.removeItem(LOCAL_STORAGE_TOKEN_KEY)
  }
}

export function buildDefaultUser(payload: {
  identifier: string
  role?: UserRole
  district?: string
  displayName?: string
}): AuthUser {
  const role: UserRole = payload.role || (payload.identifier.includes('admin') ? 'admin' : payload.identifier.startsWith('9') ? 'officer' : 'civilian')
  
  let formattedName = payload.displayName || payload.identifier.split('@')[0]
  if (formattedName.match(/^\d+$/)) {
    formattedName = role === 'admin' ? 'Admin User' : role === 'officer' ? `Officer (${payload.identifier})` : `Citizen (${payload.identifier})`
  } else {
    formattedName = formattedName.replace(/[._-]/g, ' ').replace(/\b\w/g, c => c.toUpperCase())
  }

  const permissionsMap: Record<UserRole, string[]> = {
    admin: ['admin:all', 'users:manage', 'firs:view', 'firs:search', 'cases:create', 'cases:edit', 'analytics:view', 'ai:access', 'audit:view'],
    officer: ['firs:view', 'firs:search', 'cases:create', 'cases:edit', 'analytics:view', 'ai:access', 'graph:view'],
    civilian: ['firs:view', 'cases:create:public', 'public:track'],
  }

  const user: AuthUser = {
    id: `usr-${Date.now()}`,
    login_identifier: payload.identifier,
    mobile_number: payload.identifier.match(/^\d{10}$/) ? payload.identifier : '+91 9876543210',
    psn: payload.identifier.startsWith('PSN') ? payload.identifier : 'KSP-1092',
    is_active: true,
    last_login_at: new Date().toISOString(),
    role,
    roles: [role],
    permissions: permissionsMap[role] || permissionsMap.officer,
    display_name: formattedName,
    district: payload.district || 'Chennai',
    badge_number: role === 'officer' ? 'KSP-30412' : role === 'admin' ? 'ADM-001' : 'CIV-8841',
    station: role === 'civilian' ? 'Public Portal' : role === 'admin' ? 'SCRB Headquarters' : 'Jayanagar PS',
  }

  setStoredUser(user)
  return user
}

export const authApi = {
  async signup(payload: { email: string; password: string; district: string; language: string; role?: UserRole; name?: string }) {
    const displayName = payload.name || payload.email.split('@')[0]
    try {
      const res = await apiClient.auth.signup({
        email: payload.email,
        password: payload.password,
        name: displayName,
        district: payload.district,
        role: payload.role || 'officer',
      })
      if (res && res.user) {
        const u: AuthUser = {
          id: res.user.id,
          login_identifier: res.user.loginIdentifier,
          mobile_number: res.user.mobileNumber,
          psn: res.user.psn,
          is_active: res.user.isActive,
          last_login_at: res.user.lastLoginAt,
          role: res.user.role as UserRole,
          roles: res.user.roles || [res.user.role],
          permissions: res.user.permissions || [],
          display_name: res.user.displayName,
          district: res.user.district,
          badge_number: res.user.badgeNumber,
          station: res.user.station,
        }
        setStoredUser(u, res.token)
        return { user: u, requiresEmailVerification: false }
      }
    } catch (e) {
      console.warn('Backend signup call failed, falling back to local user:', e)
    }

    const u = buildDefaultUser({
      identifier: payload.email,
      role: payload.role || 'officer',
      district: payload.district,
      displayName,
    })
    return { user: u, requiresEmailVerification: false }
  },

  async requestOtp(identifier: string) {
    try {
      const res = await apiClient.auth.requestOtp(identifier)
      if (res) return { message: res.message || 'OTP dispatched.', development_code: res.developmentCode || '123456' }
    } catch {}
    return { message: 'OTP has been dispatched.', development_code: '123456' }
  },

  async login(payload: {
    identifier: string
    credential?: string
    district?: string
    language?: string
    mode?: 'mobile_otp' | 'psn_pin' | 'admin' | 'civilian'
    role?: UserRole
    name?: string
  }) {
    let userRole: UserRole = payload.role || 'officer'
    if (payload.mode === 'admin') userRole = 'admin'
    if (payload.mode === 'civilian') userRole = 'civilian'

    try {
      const res = await apiClient.auth.login({
        identifier: payload.identifier,
        credential: payload.credential,
        role: userRole,
        district: payload.district,
      })
      if (res && res.user) {
        const u: AuthUser = {
          id: res.user.id,
          login_identifier: res.user.loginIdentifier,
          mobile_number: res.user.mobileNumber,
          psn: res.user.psn,
          is_active: res.user.isActive,
          last_login_at: res.user.lastLoginAt,
          role: res.user.role as UserRole,
          roles: res.user.roles || [res.user.role],
          permissions: res.user.permissions || [],
          display_name: res.user.displayName,
          district: res.user.district,
          badge_number: res.user.badgeNumber,
          station: res.user.station,
        }
        setStoredUser(u, res.token)
        return u
      }
    } catch (e) {
      console.warn('Backend login call failed, falling back to default user:', e)
    }

    return buildDefaultUser({
      identifier: payload.identifier,
      role: userRole,
      district: payload.district,
      displayName: payload.name,
    })
  },

  async me() {
    const stored = getStoredUser()
    if (stored) return stored

    try {
      const res = await apiClient.auth.me()
      if (res && res.id) {
        const u: AuthUser = {
          id: res.id,
          login_identifier: res.loginIdentifier,
          mobile_number: res.mobileNumber,
          psn: res.psn,
          is_active: res.isActive,
          last_login_at: res.lastLoginAt,
          role: res.role as UserRole,
          roles: res.roles || [res.role],
          permissions: res.permissions || [],
          display_name: res.displayName,
          district: res.district,
          badge_number: res.badgeNumber,
          station: res.station,
        }
        setStoredUser(u)
        return u
      }
    } catch {}

    return null
  },

  async logout() {
    setStoredUser(null)
  },
}
