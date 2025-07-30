FROM openjdk:21-jdk-slim
WORKDIR /app
COPY .mvn/ .mvn/
COPY mvnw pom.xml ./
RUN ./mvnw dependency:go-offline
COPY src ./src
RUN ./mvnw package -DskipTests
CMD ["java", "-jar", "target/gateway-0.0.1-SNAPSHOT.jar"]