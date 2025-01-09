# Use an official Java runtime as a parent image
FROM openjdk:11-jre-slim

# Set the working directory inside the container
WORKDIR /app

# Copy the Spring Boot jar to the container
COPY target/*.jar demoAssignment-0.0.1-SNAPSHOT.jar

# Expose the application port (adjust based on your app's port)
EXPOSE 8080

# Command to run the application
ENTRYPOINT ["java", "-jar", "demoAssignment-0.0.1-SNAPSHOT.jar"]
