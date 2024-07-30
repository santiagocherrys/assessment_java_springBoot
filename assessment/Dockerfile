FROM eclipse-temurin:17-jdk-alpine
VOLUME /tpm
COPY assessment/*.jar app.jar
ENTRYPOINT ["java", "-jar","/app.jar"]