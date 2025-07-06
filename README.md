# Reservation Management API

A REST API for a reservation management system, built with Java and Spring Boot. This project serves as a practical and in-depth study of software architecture and engineering best practices.

## Table of Contents

* [About the Project](#about-the-project)
* [Architecture Decisions](#architecture-decisions)
* [Technologies Used](#technologies-used)
* [How to Run the Project](#how-to-run-the-project)
* [API Documentation](#api-documentation)
* [License](#license)
* [Author](#author)

## About the Project

The main goal of this API is not only to provide features of a reservation system, but also to serve as a study environment for applying advanced software engineering concepts in the Java/Spring ecosystem.
The focus is on building a robust, scalable, testable, and maintainable system by following the principles of **Clean Architecture** and **Domain-Driven Design (DDD)**.

## Architecture Decisions

The structure of this project is designed to maximize decoupling and clarity, even in early stages. The main architectural decisions include:

### Layered (Hexagonal) Architecture

The code is divided into four main layers:

* `domain`: Contains the purest business entities and rules, with no framework dependencies. It is the heart of the application.
* `application`: Orchestrates business flows (use cases).
* `infrastructure`: Contains technical implementations, such as database communication (repositories).
* `adapters`: Connects the application to the external world (e.g., REST API controllers).

### Use Case per Class

Each user action in the API is encapsulated in its own class (e.g., `CreateResourceUseCase`).
This strictly adheres to the **Single Responsibility Principle (SRP)** and improves testability and clarity.

### Dependency Injection

Constructor-based dependency injection is used to manage component dependencies — a Spring Framework pillar that encourages low coupling.

### Centralized Exception Handling

A `GlobalExceptionHandler` annotated with `@RestControllerAdvice` intercepts business exceptions and translates them into standardized, meaningful HTTP responses — avoiding the leakage of internal application errors.

## Technologies Used

* Java 17+
* Spring Boot 3+
* Spring Data JPA
* H2 Database (in-memory, for development)
* Maven (build and dependency manager)
* Jakarta Bean Validation

## How to Run the Project

### Prerequisites

Make sure you have the following installed:

* JDK (version 17 or higher)
* Maven (version 3.8 or higher)
* Git

### Running Locally

```bash
# Clone this repository
git clone [https://github.com/your-username/your-repository.git](https://github.com/your-username/your-repository.git)

# Navigate into the project folder
cd reservation_management

# Run the project with Maven
mvn spring-boot:run
```
The API will be available at `http://localhost:8080`.

## API Documentation

The following endpoints are currently available.

### Resource

#### `POST /api/resources`

Creates a new resource (e.g., a meeting room, a hotel room).

**Request Body:**
```json
{
  "name": "Alpha Meeting Room",
  "description": "Main room with a projector and whiteboard.",
  "capacity": 10
}
```

**Success Response:**
* **Code:** `201 Created`
* **Body:** The created resource object, including its ID.
    ```json
    {
      "id": 1,
      "name": "Alpha Meeting Room",
      "description": "Main room with a projector and whiteboard.",
      "capacity": 10
    }
    ```

**Error Responses:**
* **Code:** `409 Conflict` - If a resource with the same `name` already exists.
    ```json
    {
      "timestamp": "2025-07-06T00:53:12.428Z",
      "status": 409,
      "message": "A resource with the name 'Alpha Meeting Room' already exists."
    }
    ```
* **Code:** `400 Bad Request` - If any request field fails validation (e.g., blank `name` or null `capacity`).
  
  #### `GET /api/resources/:id`

Get a specific resource by id (e.g., a meeting room, a hotel room).

**Success Response:**
* **Code:** `200 OK`
* **Body:** The resource object.
    ```json
    {
      "id": 1,
      "name": "Alpha Meeting Room",
      "description": "Main room with a projector and whiteboard.",
      "capacity": 10
    }
    ```

**Error Responses:**
* **Code:** `404 Conflict` - If the resource with the specified `id` does not exist.
    ```json
    {
      "timestamp": "2025-07-06T00:53:12.428Z",
      "status": 404,
      "message": "A resource with the id '{id}' was not found."
    }
    ```
  


## License

This project is licensed under the MIT License. See the [LICENSE.md](LICENSE.md) file for more details.

## Author

Brenno Costa
