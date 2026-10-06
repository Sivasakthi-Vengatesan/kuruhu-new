# Kuruhu (PRAMAAN) — Spring Boot Backend Architecture Scaffold

> **Spring Boot backend architecture scaffold / implementation foundation**

This directory contains the Spring Boot 3 enterprise Java architecture scaffold for the Kuruhu (PRAMAAN) crime investigation platform.

## Architectural Layout (`com.kuruhu.*`)

- **`config/`**: Security, OpenAPI/Swagger, CORS, JPA, PGVector, LangChain4j and Async configurations.
- **`controller/`**: 15 REST controllers handling authentication, FIRs, Cases, Persons, Evidence, Graph, AI, Chat, Settings, and System Audit.
- **`service/` & `service/impl/`**: 22 domain service contracts and scaffold implementations.
- **`entity/`**: 26 JPA entity models with relational mappings (`@ManyToOne`, `@OneToMany`, `@ManyToMany`).
- **`repository/`**: 26 Spring Data JPA repository interfaces extending `JpaRepository`.
- **`dto/`**: 40 strongly-typed Request/Response DTOs equipped with constructors and builders.
- **`mapper/`**: 9 domain mappers bridging entities and DTOs.
- **`security/`**: JWT filter, Token provider, UserPrincipal, and CustomUserDetailsService.
- **`ai/` & `rag/`**: AI Investigator, LLM service, Prompt builders, RAG context retriever, and PGVector embeddings.
- **`graph/`**: Graph engine and network analysis foundations.
- **`investigation/` & `search/`**: Unified search engine, case workflows, and timeline builders.
- **`audit/` & `notification/`**: Security auditor, audit loggers, and alert dispatchers.
- **`exception/`**: Global exception handler and domain exceptions.
- **`enums/` & `model/`**: Strongly-typed business enums and value objects.
- **`util/`**: Utility classes for hashing, JSON formatting, validation, and security contexts.
- **`src/test/java/com/kuruhu/`**: 14 JUnit 5 & Mockito test suites.

## Build & Test

```bash
mvn clean test-compile
mvn test
```
