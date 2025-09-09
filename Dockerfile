# Imagem base
FROM maven:3.9.6-eclipse-temurin-21 AS build

# Diretório da aplicação
WORKDIR /app

# Copia pom.xml e faz download das dependências
COPY pom.xml .
RUN mvn dependency:go-offline -B

# Copia todo o código fonte
COPY src ./src

# Builda o JAR, pulando testes
RUN mvn clean package -DskipTests

FROM eclipse-temurin:21-jdk-alpine
WORKDIR /app
COPY --from=build /app/target/Mysql-0.0.1-SNAPSHOT.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]
