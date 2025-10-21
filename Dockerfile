# --- Build stage ---
FROM maven:3.9-eclipse-temurin-17 AS build
WORKDIR /app
COPY pom.xml .
RUN mvn -q -DskipTests dependency:go-offline
COPY src ./src
RUN mvn -q -DskipTests package

# --- Runtime stage ---
FROM eclipse-temurin:17-jre-alpine
WORKDIR /app
ENV JAVA_OPTS="-XX:+UseContainerSupport -XX:MaxRAMPercentage=70.0"
COPY --from=build /app/target/patrones-ms-0.1.0.jar app.jar
EXPOSE 8080
ENTRYPOINT ["sh","-c","java $JAVA_OPTS -jar app.jar"]
