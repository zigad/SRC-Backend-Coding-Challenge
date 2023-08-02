# Movie and Actor Management Backend

Welcome to the Movie and Actor Management Backend! This is a backend application for managing movies and actors via a REST API. The application is built using the Quarkus framework and utilizes PostgreSQL as the database for data persistence.

## Table of Contents

- [Description](#description)
- [Features](#features)
- [Requirements](#requirements)
- [Getting Started](#getting-started)
- [Endpoints](#endpoints)
- [Dockerization](#dockerization)
- [Optional: Docker Compose](#optional-docker-compose)
- [Testing](#testing)

## Description

The Movie and Actor Management Backend provides RESTful endpoints to manage movies and actors. It allows you to perform CRUD operations for both movies and actors. Additionally, you can list all movies and actors, use pagination support for listing, and search for movies by keyword in Title and Description using SQL statement.

## Features

- RESTful API for movies and actors management
- PostgreSQL database for data persistence
- Request counter for all REST calls
- CRUD operations for movies
- CRUD operations for actors
- List all movies with pagination support
- List all actors with pagination support
- Search movies by title

## Requirements

Before running the application, make sure you have the following installed:

- Java 17 or later
- Apache Maven
- Docker (for Postgres DB)

## Getting Started

1. Clone this Git repository to your local machine.

2. Set up PostgreSQL on your local machine or use a remote PostgreSQL instance.

3. Update the `src/main/resources/application.properties` file to configure the PostgreSQL connection properties. Modify the following properties with your PostgreSQL database details:

   ```properties
   quarkus.datasource.jdbc.url=jdbc:postgresql://your-postgresql-host:5432/your-database-name
   quarkus.datasource.username=your-database-username
   quarkus.datasource.password=your-database-password
   ```

4. Build the application using Maven:

   ```bash
   ./mvnw clean package
   ```

5. Run the application:

   ```bash
   ./mvnw quarkus:dev
   ```

The application should now be running on http://localhost:8080.

## Endpoints

Please check [openapi.json](openapi.json) file for the available endpoints.

## Dockerization

To run the application in a Docker container, follow these steps:

1. Package the project
   ```bash
   ./mvnw package
   ```
2. Build the Docker image:

   ```bash
   docker build -f src/main/docker/Dockerfile.jvm -t src-backend-coding-challenge .
   ```

3. Run the Docker container:

   ```bash
   docker run -p 8080:8080 src-backend-coding-challenge
   ```

The application should now be accessible at http://localhost:8080.

## Testing

To run the unit tests for the application, execute the following command:

```bash
# With Maven
./mvnw test
```