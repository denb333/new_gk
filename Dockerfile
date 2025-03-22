FROM openjdk:17-jdk-slim

WORKDIR /app

COPY . /app

RUN chmod +x mvnw
# Bước này sẽ tạo ra file JAR trong thư mục target với tên gk-springboot-new.jar
RUN ./mvnw clean package -DskipTests

# Kiểm tra xem file JAR đã được tạo chưa
RUN ls -la /app/target

# Di chuyển file JAR đã tạo vào thư mục gốc của container
RUN cp /app/target/gk-springboot-new.jar /app/

ENTRYPOINT ["java", "-jar", "gk-springboot-new.jar"]

EXPOSE 8882