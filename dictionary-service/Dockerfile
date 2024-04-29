FROM openjdk:17
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/dictionary-service.jar
ENTRYPOINT ["java" , "-jar" ,"dictionary-service.jar" ]
EXPOSE 8080