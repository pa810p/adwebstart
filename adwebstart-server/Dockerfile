# Use the official OpenJDK as the base image
FROM openjdk:23-jdk-slim

# Set environment variables
ENV DEBIAN_FRONTEND=noninteractive

WORKDIR /app

# Copy Spring Boot JAR file into the container
COPY ./target/adwebstart-server-1.0-SNAPSHOT.jar /app/adwebstart.jar
COPY ./target/classes/application.properties /app/application.properties
RUN ls -al /app/adwebstart.jar

# Spring Boot port
EXPOSE 9000

CMD ["java", "-jar", "adwebstart.jar", "--spring.config.location=file:./application.properties"]
