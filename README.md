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
- [Contributing](#contributing)
- [License](#license)

## Description

The Movie and Actor Management Backend provides RESTful endpoints to manage movies and actors. It allows you to perform CRUD operations for both movies and actors. Additionally, you can list all movies and actors, use pagination support for listing, and search for movies by title.

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

- Java 11 or later
- Apache Maven or Gradle
- Docker (optional for Dockerization)
- Docker Compose (optional for Docker Compose setup)

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

The following endpoints are available for movies and actors:

### Movies

- `GET /movies`: List all movies.
- `GET /movies/{id}`: Get a specific movie by ID.
- `GET /movies?page={pageNumber}&size={pageSize}`: List movies with pagination support.
- `GET /movies/search?title={movieTitle}`: Search for movies by title.
- `POST /movies`: Create a new movie.
- `PUT /movies/{id}`: Update an existing movie.
- `DELETE /movies/{id}`: Delete a movie by ID.

### Actors

- `GET /actors`: List all actors.
- `GET /actors/{id}`: Get a specific actor by ID.
- `GET /actors?page={pageNumber}&size={pageSize}`: List actors with pagination support.
- `POST /actors`: Create a new actor.
- `PUT /actors/{id}`: Update an existing actor.
- `DELETE /actors/{id}`: Delete an actor by ID.

### Request Count

- `GET /requestcount`: Get a number of requests returned as simple number

## Dockerization

To run the application in a Docker container, follow these steps:

1. Build the Docker image:

   ```bash
   docker build -t src-backend-coding-challenge .
   ```

2. Run the Docker container:

   ```bash
   docker run -p 8080:8080 src-backend-coding-challenge
   ```

The application should now be accessible at http://localhost:8080.

## Optional: Docker Compose

If you prefer to use Docker Compose to set up the application and the PostgreSQL database, follow these steps:

1. Make sure you have Docker Compose installed.

2. Create a `docker-compose.yml` file with the following contents:

   ```yaml
   version: '3'
   services:
     backend:
       image: src-backend-coding-challenge
       ports:
         - "8080:8080"
       depends_on:
         - database
       environment:
         - QUARKUS_DATASOURCE_URL=jdbc:postgresql://database:5432/your-database-name
         - QUARKUS_DATASOURCE_USERNAME=your-database-username
         - QUARKUS_DATASOURCE_PASSWORD=your-database-password
     database:
       image: postgres:latest
       environment:
         - POSTGRES_USER=your-database-username
         - POSTGRES_PASSWORD=your-database-password
         - POSTGRES_DB=your-database-name
   ```

3. Run the application and database using Docker Compose:

   ```bash
   docker-compose up
   ```

The application should now be running on http://localhost:8080, and the PostgreSQL database should be available at http://localhost:5432.

## Testing

To run the unit tests for the application, execute the following command:

```bash
# With Maven
./mvnw test
```

## Contributing

We welcome contributions to this project! If you find any issues or have suggestions for improvements, please feel free to open an issue or submit a pull request.

## License

This project is licensed under the MIT License. See the [LICENSE](LICENSE) file for details.