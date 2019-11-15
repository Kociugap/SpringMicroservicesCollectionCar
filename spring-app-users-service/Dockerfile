FROM openjdk:8-jdk-alpine
COPY target/AppUserService-0.0.1-SNAPSHOT.jar user-microservices.jar
EXPOSE 8181
ENTRYPOINT ["java", "-jar", "user-microservices.jar"]