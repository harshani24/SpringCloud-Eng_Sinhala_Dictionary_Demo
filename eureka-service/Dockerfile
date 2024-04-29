FROM openjdk:17
WORKDIR /app
ARG JAR_FILE=target/*.jar
COPY ${JAR_FILE} /app/eureka-server.jar
ENTRYPOINT ["java","-jar", "eureka-server.jar"]
EXPOSE 8761



