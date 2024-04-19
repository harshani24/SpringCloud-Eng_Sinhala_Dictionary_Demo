FROM openjdk:17
WORKDIR /app
ARG JAR_FILE=target/dictionary-service.jar
COPY ${JAR_FILE} /app
ENTRYPOINT ["java" , "-jar" ,"dictionary-service.jar" ]
EXPOSE 8080