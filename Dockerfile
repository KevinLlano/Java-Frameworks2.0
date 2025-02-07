# Use an official OpenJDK runtime as a parent image
FROM openjdk:17-jdk-slim

# Set the working directory in the container
WORKDIR /app

# Copy the Maven wrapper and pom.xml to the container
COPY mvnw pom.xml ./

# Download dependencies (uses the wrapper to avoid requiring Maven pre-installed)
RUN ./mvnw dependency:go-offline

# Copy the entire project into the container
COPY . /app

# Build the Spring Boot app using Maven
RUN ./mvnw clean package -DskipTests

# Expose the port the Spring Boot app will run on (default is 8080)
EXPOSE 8080

# Command to run the Spring Boot application
CMD ["java", "-jar", "target/*.jar"]
