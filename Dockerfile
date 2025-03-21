
FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . /app

RUN ./mvnw package

RUN chmod +x mvnw


ADD target/gk-springboot-new.jar gk-springboot-new.jar
# Use the following line if you want to run the application with a specific profile
ENTRYPOINT ["java", "-jar", "target/gk-springboot-new.jar"]

EXPOSE 8882
