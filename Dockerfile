
FROM ubuntu:latest AS build


RUN apt-get update
RUN apt-get install openjdk-17-jdk -y


COPY src/main .


RUN apt-get install maven -y
RUN mvn clean install


FROM openjdk:17-jdk-slim


EXPOSE 8080


COPY --from=build /target/classes/com/rfonseca985/projeto_backend ProjetoBackendApplication.jar

ENTRYPOINT ["java", "-jar", "app.jar"]