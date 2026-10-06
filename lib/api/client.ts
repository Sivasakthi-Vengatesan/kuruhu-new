/**
 * PRAMAAN REST API Client
 * Centralized HTTP client communicating with the Java Spring Boot Backend.
 */

const API_BASE_URL = process.env.NEXT_PUBLIC_API_URL || 'http://localhost:8080';

export interface ApiResponse<T> {
  success: boolean;
  message?: string;
  data: T;
  timestamp: string;
}

export interface PageResponse<T> {
  content: T[];
  page: number;
  size: number;
  totalElements: number;
  totalPages: number;
  last: boolean;
}

export class ApiError extends Error {
  constructor(
    public status: number,
    public error: string,
    message: string,
    public validationErrors?: Record<string, string>
  ) {
    super(message);
    this.name = 'ApiError';
  }
}

function getAuthHeader(): HeadersInit {
  if (typeof window === 'undefined') return {};
  const token = localStorage.getItem('pramaan_jwt_token') || localStorage.getItem('sb-auth-token');
  if (!token) return {};
  return {
    Authorization: `Bearer ${token.replace(/^"|"$/g, '')}`,
  };
}

async function request<T>(
  endpoint: string,
  options: RequestInit = {}
): Promise<T> {
  const url = endpoint.startsWith('http') ? endpoint : `${API_BASE_URL}${endpoint}`;
  
  const headers: HeadersInit = {
    'Content-Type': 'application/json',
    ...getAuthHeader(),
    ...(options.headers || {}),
  };

  try {
    const res = await fetch(url, {
      ...options,
      headers,
    });

    if (!res.ok) {
      let errorData: any = {};
      try {
        errorData = await res.json();
      } catch {}

      throw new ApiError(
        res.status,
        errorData.error || res.statusText,
        errorData.message || `API request failed with status ${res.status}`,
        errorData.validationErrors
      );
    }

    // Handle 204 No Content
    if (res.status === 204) {
      return {} as T;
    }

    const contentType = res.headers.get('content-type');
    if (contentType && contentType.includes('application/json')) {
      const json = await res.json();
      // If wrapped in standard backend ApiResponse<T>, unwrap data
      if (json && typeof json === 'object' && 'data' in json && 'success' in json) {
        return json.data as T;
      }
      return json as T;
    }

    return (await res.text()) as unknown as T;
  } catch (err: any) {
    if (err instanceof ApiError) throw err;
    throw new ApiError(0, 'NETWORK_ERROR', err.message || 'Network request failed');
  }
}

export const apiClient = {
  get: <T>(endpoint: string, options?: RequestInit) =>
    request<T>(endpoint, { ...options, method: 'GET' }),

  post: <T>(endpoint: string, body?: any, options?: RequestInit) =>
    request<T>(endpoint, {
      ...options,
      method: 'POST',
      body: body ? JSON.stringify(body) : undefined,
    }),

  put: <T>(endpoint: string, body?: any, options?: RequestInit) =>
    request<T>(endpoint, {
      ...options,
      method: 'PUT',
      body: body ? JSON.stringify(body) : undefined,
    }),

  patch: <T>(endpoint: string, body?: any, options?: RequestInit) =>
    request<T>(endpoint, {
      ...options,
      method: 'PATCH',
      body: body ? JSON.stringify(body) : undefined,
    }),

  delete: <T>(endpoint: string, options?: RequestInit) =>
    request<T>(endpoint, { ...options, method: 'DELETE' }),

  // -------------------------------------------------------------
  // Specific Resource Endpoints
  // -------------------------------------------------------------

  // Auth
  auth: {
    login: (credentials: { identifier: string; credential?: string; role?: string; district?: string }) =>
      request<any>('/api/v1/auth/login', {
        method: 'POST',
        body: JSON.stringify(credentials),
      }),
    signup: (data: { email: string; password?: string; name: string; district?: string; role?: string; phone?: string }) =>
      request<any>('/api/v1/auth/signup', {
        method: 'POST',
        body: JSON.stringify(data),
      }),
    me: () => request<any>('/api/v1/auth/me'),
    requestOtp: (mobileNumber: string) =>
      request<any>('/api/v1/auth/otp/request', {
        method: 'POST',
        body: JSON.stringify({ mobileNumber }),
      }),
    verifyOtp: (mobileNumber: string, otp: string) =>
      request<any>('/api/v1/auth/otp/verify', {
        method: 'POST',
        body: JSON.stringify({ mobileNumber, otp }),
      }),
  },

  // FIRs
  firs: {
    list: (params?: { page?: number; size?: number; query?: string; status?: string; priority?: string; station?: string }) => {
      const q = new URLSearchParams();
      if (params?.page !== undefined) q.append('page', String(params.page));
      if (params?.size !== undefined) q.append('size', String(params.size));
      if (params?.query) q.append('query', params.query);
      if (params?.status) q.append('status', params.status);
      if (params?.priority) q.append('priority', params.priority);
      if (params?.station) q.append('station', params.station);
      return request<any>(`/api/v1/firs?${q.toString()}`);
    },
    getById: (id: string | number) => request<any>(`/api/v1/firs/${id}`),
    create: (data: any) => request<any>('/api/v1/firs', { method: 'POST', body: JSON.stringify(data) }),
    update: (id: string | number, data: any) => request<any>(`/api/v1/firs/${id}`, { method: 'PUT', body: JSON.stringify(data) }),
    delete: (id: string | number) => request<any>(`/api/v1/firs/${id}`, { method: 'DELETE' }),
    addTimeline: (id: string | number, event: any) => request<any>(`/api/v1/firs/${id}/timeline`, { method: 'POST', body: JSON.stringify(event) }),
  },

  // Persons
  persons: {
    list: (params?: { page?: number; size?: number; query?: string; role?: string }) => {
      const q = new URLSearchParams();
      if (params?.page !== undefined) q.append('page', String(params.page));
      if (params?.size !== undefined) q.append('size', String(params.size));
      if (params?.query) q.append('query', params.query);
      if (params?.role) q.append('role', params.role);
      return request<any>(`/api/v1/persons?${q.toString()}`);
    },
    getById: (id: string | number) => request<any>(`/api/v1/persons/${id}`),
    create: (data: any) => request<any>('/api/v1/persons', { method: 'POST', body: JSON.stringify(data) }),
    update: (id: string | number, data: any) => request<any>(`/api/v1/persons/${id}`, { method: 'PUT', body: JSON.stringify(data) }),
    delete: (id: string | number) => request<any>(`/api/v1/persons/${id}`, { method: 'DELETE' }),
  },

  // Evidence
  evidence: {
    list: (firId?: string | number) => {
      const q = firId ? `?firId=${firId}` : '';
      return request<any[]>(`/api/v1/evidence${q}`);
    },
    create: (data: any) => request<any>('/api/v1/evidence', { method: 'POST', body: JSON.stringify(data) }),
  },

  // Vehicles
  vehicles: {
    list: () => request<any[]>('/api/v1/vehicles'),
    create: (data: any) => request<any>('/api/v1/vehicles', { method: 'POST', body: JSON.stringify(data) }),
  },

  // Graph
  graph: {
    get: (params?: { centerPersonId?: string; filterRole?: string; filterFir?: string; search?: string }) => {
      const q = new URLSearchParams();
      if (params?.centerPersonId) q.append('centerPersonId', params.centerPersonId);
      if (params?.filterRole) q.append('filterRole', params.filterRole);
      if (params?.filterFir) q.append('filterFir', params.filterFir);
      if (params?.search) q.append('search', params.search);
      return request<any>(`/api/v1/graph?${q.toString()}`);
    },
    getByPersonId: (personId: string | number) => request<any>(`/api/v1/graph/${personId}`),
  },

  // Search
  search: {
    query: (query: string, type?: string, district?: string, page = 0, size = 15) => {
      const q = new URLSearchParams({ query, type: type || 'all', district: district || 'all', page: String(page), size: String(size) });
      return request<any>(`/api/v1/search?${q.toString()}`);
    },
  },

  // AI Investigator
  investigator: {
    query: (question: string, language = 'en', context?: any) =>
      request<any>('/api/v1/investigator/query', {
        method: 'POST',
        body: JSON.stringify({ question, language, context }),
      }),
    findings: () => request<any[]>('/api/v1/investigator/findings'),
    verifyFinding: (id: string, action: string, notes?: string) =>
      request<any>(`/api/v1/investigator/findings/${id}/verify`, {
        method: 'POST',
        body: JSON.stringify({ action, notes }),
      }),
    hotspots: () => request<any[]>('/api/v1/investigator/hotspots'),
    earlyWarnings: () => request<any[]>('/api/v1/investigator/early-warnings'),
    patrolRoutes: () => request<any[]>('/api/v1/investigator/patrol-routes'),
    patterns: () => request<any[]>('/api/v1/investigator/patterns'),
  },

  // Chat
  chat: {
    send: (messages: any[], context?: any) =>
      request<any>('/api/v1/chat', {
        method: 'POST',
        body: JSON.stringify({ messages, context }),
      }),
  },

  // TTS
  tts: {
    speak: async (text: string, language = 'en', speaker = 'Mary') => {
      const url = `${API_BASE_URL}/api/v1/tts`;
      const res = await fetch(url, {
        method: 'POST',
        headers: {
          'Content-Type': 'application/json',
          ...getAuthHeader(),
        },
        body: JSON.stringify({ text, language, speaker }),
      });
      if (!res.ok) {
        throw new Error(`TTS service returned ${res.status}`);
      }
      return await res.blob();
    },
  },

  // Dashboard
  dashboard: {
    summary: () => request<any>('/api/v1/dashboard/summary'),
  },

  // Activity / Audit
  activity: {
    list: (query = 'all', type = 'all') =>
      request<any[]>(`/api/v1/activity?query=${encodeURIComponent(query)}&type=${encodeURIComponent(type)}`),
    create: (data: any) => request<any>('/api/v1/activity', { method: 'POST', body: JSON.stringify(data) }),
  },

  // Notifications
  notifications: {
    list: (unreadOnly?: boolean) => {
      const q = unreadOnly ? '?unreadOnly=true' : '';
      return request<any[]>(`/api/v1/notifications${q}`);
    },
    markAsRead: (id: string | number) =>
      request<any>(`/api/v1/notifications/${id}/read`, { method: 'PATCH' }),
  },

  // Health
  health: () => request<any>('/api/v1/health'),
};

export default apiClient;
