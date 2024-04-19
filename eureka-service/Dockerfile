FROM openjdk:17
WORKDIR /app
ARG JAR_FILE=target/eureka-service.jar
COPY ${JAR_FILE} /app
ENTRYPOINT ["java","-jar", "eureka-service.jar"]
EXPOSE 8761



