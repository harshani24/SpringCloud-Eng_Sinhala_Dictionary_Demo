FROM openjdk:17
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/config-server.jar
ENTRYPOINT ["java","-jar", "config-server.jar"]
EXPOSE 9296


