# PRAMAAN (ಪ್ರಮಾಣ) — Java Spring Boot 3 Backend
**Evidence • Intelligence • Justice — Karnataka State Police Investigation Platform**

---

## 1. Overview
The PRAMAAN Java backend is a production-grade enterprise application built with **Spring Boot 3**, **Spring Data JPA**, **Spring Security + JWT**, **PostgreSQL + PGVector**, and **LangChain4j**.

---

## 2. Architecture & Modules
- **`com.pramaan.config`**: Security, OpenAPI Swagger, CORS, and AI configurations.
- **`com.pramaan.security`**: JWT generation & validation, stateless filter, BCrypt password hashing, role-based authorization.
- **`com.pramaan.controller`**: Layered REST controllers (`/api/v1/auth`, `/api/v1/firs`, `/api/v1/persons`, `/api/v1/evidence`, `/api/v1/vehicles`, `/api/v1/graph`, `/api/v1/search`, `/api/v1/investigator`, `/api/v1/chat`, `/api/v1/tts`, `/api/v1/activity`, `/api/v1/notifications`, `/api/v1/dashboard`, `/api/v1/health`).
- **`com.pramaan.service`**: Business logic, entity management, graph calculation, RAG synthesis, and audit trails.
- **`com.pramaan.repository`**: Spring Data JPA repositories with query specifications.
- **`com.pramaan.entity`**: Relational entities and vector embeddings mapped to PostgreSQL tables.
- **`com.pramaan.dto`**: Request and response data transfer objects.
- **`com.pramaan.ai`**: LLM client abstraction (Groq, OpenAI, Ollama), 384-dim vector embeddings, and RAG retrieval.
- **`com.pramaan.exception`**: Global exception handling with RFC-compliant structured error JSON responses.

---

## 3. Prerequisites
- **Java 17+** (JDK 17, 21, or 27)
- **Maven 3.8+**
- **PostgreSQL 15+ with pgvector extension**

---

## 4. Running Locally

### Step 1: Start PostgreSQL
```bash
docker run --name pramaan-postgres -e POSTGRES_DB=pramaan -e POSTGRES_USER=pramaan -e POSTGRES_PASSWORD=change-me -p 5432:5432 -d pgvector/pgvector:pg17
```

### Step 2: Configure Environment
Copy `.env.example` to `.env` or set environment variables:
```bash
export DATABASE_URL=jdbc:postgresql://localhost:5432/pramaan
export DATABASE_USERNAME=pramaan
export DATABASE_PASSWORD=change-me
export JWT_SECRET=404E635266556A586E3272357538782F413F4428472B4B6250645367566B5970
```

### Step 3: Build & Run
```bash
mvn clean spring-boot:run
```

The backend server starts on port `8080`.
- **REST API Base**: `http://localhost:8080/api/v1`
- **Swagger Documentation**: `http://localhost:8080/swagger-ui.html`
- **Health Check**: `http://localhost:8080/api/v1/health`

---

## 5. Running Tests
```bash
mvn test
```
