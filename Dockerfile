FROM maven:3.8.5-openjdl-17 AS build
COPY . .
RUN mvn clean package -DskipTests

FROM openjdk:17.0.1-jdk-slim
COPY --from=build /target/pruebafractal-0.0.1-SNAPSHOT.jar pruebafractal.jar
EXPOSE 8098
ENTRYPOINT ["java","-jar","pruebafractal.jar"] 
