FROM openjdk:17-alpine
COPY target/quarkus-app quarkus-app/
EXPOSE 8080
ENTRYPOINT ["java", "-jar", "quarkus-app/quarkus-run.jar"]