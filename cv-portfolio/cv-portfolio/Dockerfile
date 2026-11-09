# Etapa 1: compilar con Maven y Java 23
FROM maven:3.9-eclipse-temurin-23 AS build
WORKDIR /app
COPY pom.xml .
COPY src ./src
RUN mvn -q -DskipTests package

# Etapa 2: imagen ligera solo con el JRE y el jar
FROM eclipse-temurin:23-jre
WORKDIR /app
COPY --from=build /app/target/cv-portfolio.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
