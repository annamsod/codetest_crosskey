FROM eclipse-temurin:17-jdk-jammy

WORKDIR /app/

COPY target/codetest_crosskey-1.0-SNAPSHOT.jar .
COPY src/main/resources/prospects.txt .

CMD ["java", "-jar", "codetest_crosskey-1.0-SNAPSHOT.jar"]