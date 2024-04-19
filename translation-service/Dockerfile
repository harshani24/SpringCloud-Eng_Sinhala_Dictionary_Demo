FROM openjdk:17
WORKDIR /app
ARG JAR_FILE=target/translation-service.jar
COPY ${JAR_FILE} /app
ENTRYPOINT ["java", "-jar", "translation-service.jar"]
EXPOSE 8081