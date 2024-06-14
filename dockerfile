
#FROM maven:3.8.3-openjdk-17-slim AS build
#WORKDIR /app
#COPY pom.xml .
#RUN mvn dependency:go-offline
#COPY src ./src
#RUN mvn package -DskipTests

#Etapa de ejecución
FROM openjdk:17-jdk-slim
#WORKDIR /app
#COPY --from=build /app/target/wanted-0.0.1-SNAPSHOT.jar /app/Wanted.jar
COPY target/wanted-0.0.1-SNAPSHOT.jar /app/Wanted.jar
EXPOSE 7071

ENTRYPOINT ["java", "-jar", "Wanted.jar"]