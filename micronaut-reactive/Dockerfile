FROM openjdk:17-alpine
COPY target/micronaut-reactive-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]