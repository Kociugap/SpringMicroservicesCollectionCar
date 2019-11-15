FROM openjdk:8-jdk-alpine
COPY target/AppZuulService-0.0.1-SNAPSHOT.jar AppZuulService-0.0.1-SNAPSHOT.jar
EXPOSE 8765
ENTRYPOINT ["java", "-jar", "AppZuulService-0.0.1-SNAPSHOT.jar"]