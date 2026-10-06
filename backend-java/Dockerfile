# Multi-stage Docker build for PRAMAAN Spring Boot backend
FROM eclipse-temurin:17-jdk-alpine AS builder
WORKDIR /app
COPY pom.xml .
COPY src ./src
# Install maven and package
RUN apk add --no-cache maven && \
    mvn clean package -DskipTests

FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
RUN addgroup -S pramaan && adduser -S pramaan -G pramaan
COPY --from=builder /app/target/pramaan-backend-1.0.0.jar app.jar
USER pramaan
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
