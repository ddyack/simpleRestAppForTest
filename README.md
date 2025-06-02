# Student Management REST API

Simple REST API for managing student records built with Spring Boot.

## Features

- CRUD operations for student management
- In-memory data storage
- Swagger UI for API documentation
- Error handling with appropriate HTTP status codes
- Containerized with Docker
- Deployed on Render

## Technologies

- Java 21
- Spring Boot 3.2.3
- Gradle
- Lombok
- SpringDoc OpenAPI (Swagger)
- Docker
- Render (Cloud Platform)

## Live Demo

The application is deployed and available at:
- API Base URL: `https://simplerestappfortest.onrender.com`
- Swagger UI: `https://simplerestappfortest.onrender.com/swagger-ui/index.html`

## Getting Started

### Prerequisites

- Java 21 or higher
- Gradle 8.x
- Docker (optional, for container builds)

### Running Locally

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

### Building Docker Image

```bash
docker build -t simplerestapp .
docker run -p 8080:8080 simplerestapp
```

### API Documentation

- Local Swagger UI: `http://localhost:8080/swagger-ui/index.html`
- Production Swagger UI: `https://simplerestappfortest.onrender.com/swagger-ui/index.html`

## API Endpoints

- GET `/api/students` - Get all students
- GET `/api/students/{id}` - Get student by ID
- POST `/api/students` - Create a new student
- PUT `/api/students/{id}` - Update a student
- DELETE `/api/students/{id}` - Delete a student

## Example Requests

### Creating a new student:
```bash
# Local
curl -X POST http://localhost:8080/api/students \
     -H "Content-Type: application/json" \
     -d '{"name":"John Doe","age":20}'

# Production
curl -X POST https://simplerestappfortest.onrender.com/api/students \
     -H "Content-Type: application/json" \
     -d '{"name":"John Doe","age":20}'
```

## Deployment

The application is automatically deployed to Render when changes are pushed to the main branch. The deployment process:
1. Builds the application using Gradle
2. Creates a Docker container
3. Deploys to Render's container runtime

Configuration for Render deployment can be found in `render.yaml`. 