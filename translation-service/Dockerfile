FROM openjdk:17
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/translation-service.jar
ENTRYPOINT ["java", "-jar", "translation-service.jar"]
EXPOSE 8081