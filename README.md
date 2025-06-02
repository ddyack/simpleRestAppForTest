# Student Management REST API

Simple REST API for managing student records built with Spring Boot.

## Features

- CRUD operations for student management
- In-memory data storage
- Swagger UI for API documentation
- Error handling with appropriate HTTP status codes

## Technologies

- Java 21
- Spring Boot 3.3.0
- Gradle
- Lombok
- SpringDoc OpenAPI (Swagger)

## Getting Started

### Prerequisites

- Java 21 or higher
- Gradle 8.x

### Running the application

1. Clone the repository
```bash
git clone https://github.com/mrDekker/simpleRestAppForTest.git
cd simpleRestAppForTest
```

2. Run the application
```bash
./gradlew bootRun
```

The application will start on `http://localhost:8080`

### API Documentation

Swagger UI is available at: `http://localhost:8080/swagger-ui.html`

## API Endpoints

- GET `/api/students` - Get all students
- GET `/api/students/{id}` - Get student by ID
- POST `/api/students` - Create a new student
- PUT `/api/students/{id}` - Update a student
- DELETE `/api/students/{id}` - Delete a student

## Example Request

Creating a new student:
```bash
curl -X POST http://localhost:8080/api/students \
     -H "Content-Type: application/json" \
     -d '{"name":"John Doe","age":20}'
``` 