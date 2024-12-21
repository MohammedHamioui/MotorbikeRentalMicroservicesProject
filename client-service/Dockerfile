# client-service/Dockerfile
FROM openjdk:11-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container (adjust if your service is using a different build tool)
COPY target/client-service.jar /app/client-service.jar

# Expose the port your service will run on
EXPOSE 8081

# Run the application
ENTRYPOINT ["java", "-jar", "client-service.jar"]
