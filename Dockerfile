FROM maven:3.8.5-openjdk-17 AS build
COPY . .
RUN mvn clean package -DskipTests

# Etapa de producción
FROM openjdk:17.0.1-jdk-slim

# Configuración específica para Fly.io (puerto, entrada, etc.)
EXPOSE 8080
ENV PORT=8080

# Copiar el archivo JAR desde la etapa de compilación
COPY --from=build /target/pruebafractal-0.0.1-SNAPSHOT.jar pruebafractal.jar

# Comando de inicio
CMD ["java", "-jar", "pruebafractal.jar"]
