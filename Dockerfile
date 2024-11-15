FROM maven:3.8.6-openjdk-17-slim AS build

WORKDIR /app

COPY pom.xml .
RUN mvn dependency:go-offline

COPY src /app/src

RUN mvn clean package -DskipTests

FROM openjdk:17-jdk-slim

WORKDIR /app

COPY --from=build /app/target/*.jar app.jar

# เปิดพอร์ตที่ต้องการ
EXPOSE 8080

ENTRYPOINT ["java", "-jar", "app.jar"]
