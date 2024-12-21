# api-gateway/Dockerfile
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container (adjust if your service is using a different build tool)
COPY target/api-gateway-0.0.1-SNAPSHOT.jar /app/api-gateway.jar

# Expose the port your service will run on
EXPOSE 8083

# Run the application
ENTRYPOINT ["java", "-jar", "api-gateway.jar"]
