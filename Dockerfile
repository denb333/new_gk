FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . /app

RUN chmod +x mvnw
RUN ./mvnw clean install -DskipTests  # Đảm bảo Maven tạo JAR

# Chạy lệnh sau nếu JAR nằm trong thư mục target
RUN ls -la target

# Copy JAR từ đúng thư mục
COPY target/gk-springboot-new.jar gk-springboot-new.jar  

ENTRYPOINT ["java", "-jar", "gk-springboot-new.jar"]

EXPOSE 8882
