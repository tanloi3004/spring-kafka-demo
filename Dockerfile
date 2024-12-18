# First stage: build the application
FROM openjdk:21-jdk-slim AS build

# Set the working directory
WORKDIR /app

# Copy the project files to the container
COPY . .

# Compile the jar file
RUN ./mvnw clean package

# Second stage: create the final image
FROM openjdk:21-jdk-slim

# Set the working directory
WORKDIR /app

# Copy the compiled jar file from the build stage
COPY --from=build /app/target/*.jar app.jar

# Expose the port
EXPOSE 8080

# Set the entry point
ENTRYPOINT ["java", "-jar", "app.jar"]