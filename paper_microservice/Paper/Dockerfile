# PAPER MICROSERVICE DOCKERFILE
# Use an official OpenJDK runtime as a parent image
FROM openjdk:21

# Set the working directory in the container
WORKDIR /app

# Copy the jar file into the container at /app
COPY target/*.jar app.jar

# Make port 8094 available to the world outside this container
EXPOSE 8094

# Create a group and user to run the application
RUN groupadd -r appgroup && useradd -r -g appgroup appuser

# Change ownership of the app directory
RUN chown -R appuser:appgroup /app

# Switch to the new user
USER appuser

# Run the jar file
ENTRYPOINT ["java", "-jar", "app.jar"]