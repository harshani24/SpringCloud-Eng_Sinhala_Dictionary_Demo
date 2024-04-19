FROM openjdk:17
WORKDIR /app
ARG JAR_FILE=target/api-gateway.jar
COPY ${JAR_FILE} /app
ENTRYPOINT ["java" , "-jar", "api-gateway.jar"]
EXPOSE 8085