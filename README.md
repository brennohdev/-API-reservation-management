🚀 Reservation Management API
A RESTful API for a reservation management system, built with Java and Spring Boot. This project serves as a practical and in-depth exploration of modern software architecture and engineering best practices.

📋 Table of Contents
About the Project

🏛️ Architecture Decisions

🛠️ Technologies Used

🚀 How to Run the Project

📖 API Documentation

📄 License

✍️ Author

💻 About the Project
The main objective of this API is not just to implement a reservation system, but to serve as a study case for applying advanced software engineering principles in the Java/Spring ecosystem.

The focus is on building a system that is:

Robust

Scalable

Testable

Maintainable

It follows Clean Architecture and Domain-Driven Design (DDD).

🏛️ Architecture Decisions
The project’s structure was designed to promote clarity and low coupling from the start. Key architectural decisions include:

🔷 Hexagonal (Layered) Architecture
The code is split into four main layers:

domain: Contains pure business entities and logic, independent of frameworks — the core of the application.

application: Coordinates business use cases.

infrastructure: Handles technical details such as database access (Repositories).

adapters: Interfaces with the outside world (e.g., REST API Controllers).

🧩 Use Case per Class
Each action a user can perform is encapsulated in its own class (e.g., CreateResourceUseCase).
This strictly adheres to the Single Responsibility Principle (SRP) and improves testability and readability.

🔄 Dependency Injection
Constructor-based dependency injection is used to manage relationships between components, promoting loose coupling, a core value in the Spring ecosystem.

❗ Centralized Exception Handling
A @RestControllerAdvice-based GlobalExceptionHandler intercepts business exceptions and converts them into consistent and meaningful HTTP responses, avoiding internal error leaks.

🛠️ Technologies Used
Java 17+

Spring Boot 3+

Spring Data JPA

H2 Database (in-memory, for development)

Maven (Build and Dependency Management)

Jakarta Bean Validation

🚀 How to Run the Project
✅ Prerequisites
Make sure the following are installed on your machine:

Java JDK 17 or higher

Maven 3.8 or higher

Git

▶️ Running the Application
bash
Copiar
Editar
# Clone the repository
git clone https://github.com/your-username/your-repo.git

# Navigate to the project directory
cd reservation_management

# Run the application using Maven
mvn spring-boot:run
The API will be available at:
http://localhost:8080

📖 API Documentation
📌 Resource: Resource
➕ Create Resource
POST /api/resources

Creates a new resource (e.g., meeting room, hotel room).

Request Body:

json
Copiar
Editar
{
  "name": "Meeting Room Alpha",
  "description": "Room with projector and whiteboard.",
  "capacity": 10
}
Success Response:

Status: 201 Created

Body:

json
Copiar
Editar
{
  "id": 1,
  "name": "Meeting Room Alpha",
  "description": "Room with projector and whiteboard.",
  "capacity": 10
}
Error Responses:

409 Conflict – A resource with the same name already exists.

json
Copiar
Editar
{
  "timestamp": "2025-07-06T00:53:12.428Z",
  "status": 409,
  "message": "A resource with the name 'Meeting Room Alpha' already exists."
}
400 Bad Request – Validation failure (e.g., empty name, null capacity).

📄 License
This project is licensed under the MIT License.
See the LICENSE file for details.

✍️ Author
Brenno Costa
