## Template script

```bash

#!/bin/bash
# Update system packages
sudo apt update -y

# Install Git, Java, and Maven
sudo apt install git -y
sudo apt install default-jdk -y
sudo apt install maven -y

# Clone the Spring Boot repo
sudo git clone https://github.com/ramanujds/spring-boot /app
cd /app

# Build the Spring Boot app
sudo mvn clean package

# Run the app in the background and log output
sudo nohup java -jar target/spring-boot-aws.jar --server.port=80 &

```