FROM maven:3.8.4-openjdk-17-slim
WORKDIR /app
COPY . .
RUN mvn package
CMD ["java", "-jar", "target/postgresapi-0.0.1-SNAPSHOT.jar"]