# Use an official OpenJDK runtime as a parent image
FROM openjdk:21-jre-slim

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container at /app
COPY target/*.jar app.jar

# Make port 8080 available to the world outside this container
EXPOSE 8091

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]