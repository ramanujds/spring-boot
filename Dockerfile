FROM openjdk:21-jdk-slim
RUN apt update && apt install -y maven
WORKDIR /app
COPY . .
RUN mvn clean package
CMD ["java", "-jar", "target/spring-boot-aws.jar"]

