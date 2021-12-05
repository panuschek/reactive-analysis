FROM openjdk:17-alpine
COPY target/spring-imperative-*.jar app.jar
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "app.jar"]