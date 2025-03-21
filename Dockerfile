
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . /app

RUN ./mvnw package


CMD ["java", "-jar", "target/app.jar"]


EXPOSE 8882
