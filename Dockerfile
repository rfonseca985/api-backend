# Fase de construção usando a imagem base Ubuntu
FROM ubuntu:latest AS build

# Atualiza o sistema e instala o JDK 17
RUN apt-get update
RUN apt-get install openjdk-17-jdk -y

# Copia o código-fonte para o diretório de trabalho
COPY src/main .

# Instala o Maven e realiza a construção do projeto
RUN apt-get install maven -y
RUN mvn clean install

# Segunda fase usando a imagem base OpenJDK 17 Slim
FROM openjdk:17-jdk-slim

# Expondo a porta 8080 (se a aplicação Spring Boot estiver configurada para usar essa porta)
EXPOSE 8080

# Copia o arquivo JAR construído na fase anterior
COPY --from=build /target/projeto_backend-0.0.1-SNAPSHOT.jar app.jar

# Comando de entrada para executar a aplicação quando o contêiner iniciar
ENTRYPOINT ["java", "-jar", "app.jar"]
