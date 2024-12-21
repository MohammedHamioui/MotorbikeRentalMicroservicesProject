# motorbike-service/Dockerfile
FROM openjdk:11-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container (adjust if your service is using a different build tool)
COPY target/motorbike-service.jar /app/motorbike-service.jar

# Expose the port your service will run on
EXPOSE 8080

# Run the application
ENTRYPOINT ["java", "-jar", "motorbike-service.jar"]
