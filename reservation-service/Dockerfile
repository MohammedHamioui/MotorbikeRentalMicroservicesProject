# reservation-service/Dockerfile
FROM openjdk:17-jdk

# Set the working directory in the container
WORKDIR /app

# Copy the JAR file into the container (adjust if your service is using a different build tool)
COPY target/reservation-service-0.0.1-SNAPSHOT.jar /app/reservation-service.jar

# Expose the port your service will run on
EXPOSE 8082

# Run the application
ENTRYPOINT ["java", "-jar", "reservation-service.jar"]
