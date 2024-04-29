FROM openjdk:17
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/api-gateway.jar
ENTRYPOINT ["java" , "-jar", "api-gateway.jar"]
EXPOSE 8085