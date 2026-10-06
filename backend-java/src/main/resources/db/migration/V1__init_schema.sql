-- PRAMAAN Database Schema Migration V1
-- Supports standard PostgreSQL and PGVector extension if available

CREATE EXTENSION IF NOT EXISTS "uuid-ossp";
CREATE EXTENSION IF NOT EXISTS vector;

-- 1. Reference Masters
CREATE TABLE IF NOT EXISTS roles (
    id BIGSERIAL PRIMARY KEY,
    name VARCHAR(50) UNIQUE NOT NULL,
    description VARCHAR(255)
);

CREATE TABLE IF NOT EXISTS police_stations (
    id BIGSERIAL PRIMARY KEY,
    station_code VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(150) NOT NULL,
    district VARCHAR(100) NOT NULL,
    state VARCHAR(100) DEFAULT 'Karnataka',
    jurisdiction_area TEXT,
    contact_number VARCHAR(50),
    latitude NUMERIC(10, 6),
    longitude NUMERIC(10, 6),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS officers (
    id BIGSERIAL PRIMARY KEY,
    badge_number VARCHAR(50) UNIQUE NOT NULL,
    name VARCHAR(150) NOT NULL,
    rank_title VARCHAR(100) NOT NULL,
    police_station_id BIGINT REFERENCES police_stations(id) ON DELETE SET NULL,
    phone VARCHAR(50),
    email VARCHAR(150),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS users (
    id BIGSERIAL PRIMARY KEY,
    username VARCHAR(100) UNIQUE NOT NULL,
    email VARCHAR(150) UNIQUE NOT NULL,
    password_hash VARCHAR(255) NOT NULL,
    full_name VARCHAR(150) NOT NULL,
    phone VARCHAR(50),
    badge_number VARCHAR(50),
    district VARCHAR(100),
    police_station_id BIGINT REFERENCES police_stations(id) ON DELETE SET NULL,
    is_active BOOLEAN DEFAULT TRUE,
    last_login_at TIMESTAMP WITH TIME ZONE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS user_roles (
    user_id BIGINT NOT NULL REFERENCES users(id) ON DELETE CASCADE,
    role_id BIGINT NOT NULL REFERENCES roles(id) ON DELETE CASCADE,
    PRIMARY KEY (user_id, role_id)
);

-- 2. Core Case & FIR Entities
CREATE TABLE IF NOT EXISTS firs (
    id BIGSERIAL PRIMARY KEY,
    fir_number VARCHAR(100) UNIQUE NOT NULL,
    title VARCHAR(255) NOT NULL,
    summary TEXT NOT NULL,
    police_station_id BIGINT REFERENCES police_stations(id) ON DELETE SET NULL,
    station_name VARCHAR(150) NOT NULL,
    district VARCHAR(100) NOT NULL,
    investigating_officer VARCHAR(150) NOT NULL,
    priority VARCHAR(50) NOT NULL DEFAULT 'medium', -- critical, high, medium, low
    status VARCHAR(50) NOT NULL DEFAULT 'registered', -- draft, registered, investigating, review, closed
    sections JSONB DEFAULT '[]'::jsonb,
    incident_date TIMESTAMP WITH TIME ZONE,
    registered_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    source_case_master_id BIGINT,
    source_payload JSONB
);

CREATE TABLE IF NOT EXISTS fir_timelines (
    id BIGSERIAL PRIMARY KEY,
    fir_id BIGINT NOT NULL REFERENCES firs(id) ON DELETE CASCADE,
    event_time TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    title VARCHAR(255) NOT NULL,
    detail TEXT NOT NULL,
    actor VARCHAR(150) NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- 3. Persons, Aliases & Demographic Profile
CREATE TABLE IF NOT EXISTS persons (
    id BIGSERIAL PRIMARY KEY,
    person_code VARCHAR(50) UNIQUE,
    canonical_name VARCHAR(150) NOT NULL,
    age_years INT,
    gender VARCHAR(10) DEFAULT 'M',
    primary_role VARCHAR(50) DEFAULT 'suspect', -- accused, suspect, complainant, witness, victim
    risk_level VARCHAR(50) DEFAULT 'medium', -- critical, high, medium, low
    phone VARCHAR(50),
    address TEXT,
    identifier_ref VARCHAR(100), -- Aadhaar/DL masked reference
    known_locations JSONB DEFAULT '[]'::jsonb,
    socio_demographics JSONB,
    behavioral_profile JSONB,
    last_activity TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS person_aliases (
    id BIGSERIAL PRIMARY KEY,
    person_id BIGINT NOT NULL REFERENCES persons(id) ON DELETE CASCADE,
    alias_name VARCHAR(150) NOT NULL
);

CREATE TABLE IF NOT EXISTS case_parties (
    id BIGSERIAL PRIMARY KEY,
    fir_id BIGINT NOT NULL REFERENCES firs(id) ON DELETE CASCADE,
    person_id BIGINT NOT NULL REFERENCES persons(id) ON DELETE CASCADE,
    role VARCHAR(50) NOT NULL, -- accused, suspect, complainant, witness, victim
    notes TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    CONSTRAINT uq_fir_person UNIQUE (fir_id, person_id, role)
);

CREATE TABLE IF NOT EXISTS person_relationships (
    id BIGSERIAL PRIMARY KEY,
    person_id BIGINT NOT NULL REFERENCES persons(id) ON DELETE CASCADE,
    related_person_id BIGINT NOT NULL REFERENCES persons(id) ON DELETE CASCADE,
    relationship_label VARCHAR(100) NOT NULL,
    fir_reference_id BIGINT REFERENCES firs(id) ON DELETE SET NULL,
    is_verified BOOLEAN DEFAULT TRUE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- 4. Evidence, Vehicles, Locations
CREATE TABLE IF NOT EXISTS evidence (
    id BIGSERIAL PRIMARY KEY,
    evidence_code VARCHAR(50) UNIQUE,
    fir_id BIGINT NOT NULL REFERENCES firs(id) ON DELETE CASCADE,
    label VARCHAR(255) NOT NULL,
    evidence_type VARCHAR(50) NOT NULL, -- physical, digital, document, biological, cctv
    status VARCHAR(50) DEFAULT 'collected', -- collected, in-analysis, verified, archived
    collected_by VARCHAR(150) NOT NULL,
    collected_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    location_description TEXT,
    notes TEXT,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS vehicles (
    id BIGSERIAL PRIMARY KEY,
    registration_number VARCHAR(50) UNIQUE NOT NULL,
    make VARCHAR(100),
    model VARCHAR(100),
    color VARCHAR(50),
    registered_owner VARCHAR(150),
    chassis_number_hash VARCHAR(255),
    engine_number_hash VARCHAR(255),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS fir_vehicles (
    fir_id BIGINT NOT NULL REFERENCES firs(id) ON DELETE CASCADE,
    vehicle_id BIGINT NOT NULL REFERENCES vehicles(id) ON DELETE CASCADE,
    notes TEXT,
    PRIMARY KEY (fir_id, vehicle_id)
);

CREATE TABLE IF NOT EXISTS location_records (
    id BIGSERIAL PRIMARY KEY,
    location_code VARCHAR(50) UNIQUE,
    name VARCHAR(200) NOT NULL,
    area VARCHAR(150) NOT NULL,
    district VARCHAR(100) NOT NULL,
    latitude NUMERIC(10, 6),
    longitude NUMERIC(10, 6),
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS fir_locations (
    fir_id BIGINT NOT NULL REFERENCES firs(id) ON DELETE CASCADE,
    location_id BIGINT NOT NULL REFERENCES location_records(id) ON DELETE CASCADE,
    PRIMARY KEY (fir_id, location_id)
);

-- 5. AI Findings, Hotspots, Predictions, Intelligence Clusters
CREATE TABLE IF NOT EXISTS ai_findings (
    id BIGSERIAL PRIMARY KEY,
    finding_code VARCHAR(50) UNIQUE,
    question TEXT NOT NULL,
    title VARCHAR(255) NOT NULL,
    summary TEXT NOT NULL,
    confidence NUMERIC(4, 3) DEFAULT 0.900,
    status VARCHAR(50) DEFAULT 'pending', -- verified, pending, rejected
    risk VARCHAR(50) DEFAULT 'medium', -- high, medium, low
    citations JSONB DEFAULT '[]'::jsonb,
    related_fir_ids JSONB DEFAULT '[]'::jsonb,
    related_person_ids JSONB DEFAULT '[]'::jsonb,
    detected_relationships JSONB DEFAULT '[]'::jsonb,
    verified_by VARCHAR(150),
    generated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP,
    updated_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS crime_hotspots (
    id BIGSERIAL PRIMARY KEY,
    hotspot_code VARCHAR(50) UNIQUE,
    district VARCHAR(100) NOT NULL,
    location_name VARCHAR(200) NOT NULL,
    latitude NUMERIC(10, 6) NOT NULL,
    longitude NUMERIC(10, 6) NOT NULL,
    crime_count INT DEFAULT 0,
    dominant_crime_type VARCHAR(150) NOT NULL,
    risk_level VARCHAR(50) DEFAULT 'high', -- critical, high, moderate
    peak_hours VARCHAR(100),
    predicted_trend VARCHAR(50) DEFAULT 'stable', -- increasing, stable, decreasing
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS predictive_early_warnings (
    id BIGSERIAL PRIMARY KEY,
    warning_code VARCHAR(50) UNIQUE,
    title VARCHAR(255) NOT NULL,
    description TEXT NOT NULL,
    district VARCHAR(150) NOT NULL,
    risk_category VARCHAR(100) NOT NULL,
    confidence NUMERIC(4, 3) DEFAULT 0.900,
    recommended_action TEXT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS proactive_patrol_routes (
    id BIGSERIAL PRIMARY KEY,
    route_code VARCHAR(50) UNIQUE,
    route_name VARCHAR(255) NOT NULL,
    district VARCHAR(100) NOT NULL,
    assigned_station VARCHAR(150) NOT NULL,
    target_hotspots JSONB DEFAULT '[]'::jsonb,
    optimal_time_window VARCHAR(100) NOT NULL,
    efficiency_score INT DEFAULT 90,
    status VARCHAR(50) DEFAULT 'active', -- active, scheduled, completed
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS crime_pattern_clusters (
    id BIGSERIAL PRIMARY KEY,
    cluster_code VARCHAR(50) UNIQUE,
    pattern_name VARCHAR(255) NOT NULL,
    category VARCHAR(100) NOT NULL,
    affected_districts JSONB DEFAULT '[]'::jsonb,
    fir_count INT DEFAULT 0,
    suspects_identified INT DEFAULT 0,
    mo_signature TEXT NOT NULL,
    risk_level VARCHAR(50) DEFAULT 'high',
    key_insight TEXT NOT NULL,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- 6. Audit Logs, Notifications, Document Embeddings (PGVector)
CREATE TABLE IF NOT EXISTS audit_logs (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id) ON DELETE SET NULL,
    actor_name VARCHAR(150) NOT NULL,
    actor_role VARCHAR(100) NOT NULL,
    action VARCHAR(100) NOT NULL,
    target_description VARCHAR(255) NOT NULL,
    target_type VARCHAR(50) NOT NULL, -- fir, person, evidence, ai-finding, system, auth
    detail TEXT,
    ip_address VARCHAR(50),
    timestamp TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS notifications (
    id BIGSERIAL PRIMARY KEY,
    user_id BIGINT REFERENCES users(id) ON DELETE CASCADE,
    title VARCHAR(255) NOT NULL,
    body TEXT NOT NULL,
    kind VARCHAR(50) DEFAULT 'system', -- assignment, verification, deadline, system, escalation
    action_required BOOLEAN DEFAULT FALSE,
    is_read BOOLEAN DEFAULT FALSE,
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

CREATE TABLE IF NOT EXISTS document_embeddings (
    id BIGSERIAL PRIMARY KEY,
    document_type VARCHAR(50) NOT NULL, -- fir, person, evidence, finding, pattern
    source_id VARCHAR(100) NOT NULL,
    title VARCHAR(255) NOT NULL,
    content TEXT NOT NULL,
    metadata JSONB,
    embedding vector(384), -- 384 dimensions for all-MiniLM-L6-v2 or configurable
    created_at TIMESTAMP WITH TIME ZONE DEFAULT CURRENT_TIMESTAMP
);

-- Indexes for performance
CREATE INDEX IF NOT EXISTS idx_firs_status ON firs(status);
CREATE INDEX IF NOT EXISTS idx_firs_priority ON firs(priority);
CREATE INDEX IF NOT EXISTS idx_firs_district ON firs(district);
CREATE INDEX IF NOT EXISTS idx_firs_registered_at ON firs(registered_at DESC);
CREATE INDEX IF NOT EXISTS idx_persons_name ON persons(canonical_name);
CREATE INDEX IF NOT EXISTS idx_persons_role ON persons(primary_role);
CREATE INDEX IF NOT EXISTS idx_case_parties_fir ON case_parties(fir_id);
CREATE INDEX IF NOT EXISTS idx_case_parties_person ON case_parties(person_id);
CREATE INDEX IF NOT EXISTS idx_evidence_fir ON evidence(fir_id);
CREATE INDEX IF NOT EXISTS idx_audit_logs_time ON audit_logs(timestamp DESC);
CREATE INDEX IF NOT EXISTS idx_notifications_user ON notifications(user_id, is_read);
