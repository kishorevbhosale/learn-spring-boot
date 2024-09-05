# Employee Management System with MongoDB

This project is a Spring Boot application that provides a RESTful API for performing CRUD operations on employee data, using MongoDB as the database.

## Prerequisites

- Java 8 or higher
- Maven
- MongoDB (running locally or in a container)

## How to Run

1. Clone this repository
   
2. Configure MongoDB connection in `application.properties`:
    ```properties
    spring.data.mongodb.host=localhost
    spring.data.mongodb.port=27017
    spring.data.mongodb.database=employee_db
    ```

3. Build and run the application:
    ```bash
    mvn spring-boot:run
    ```

The application will run on `http://localhost:8080`.

## API Endpoints

### 1. Get All Employees
- **Endpoint**: `GET /api/employees`
- **Response**:
    ```json
    [
        {
            "id": "1",
            "name": "Kishor Bhosale",
            "department": "Engineering",
            "salary": 60000
        },
        ...
    ]
    ```

### 2. Get Employee by ID
- **Endpoint**: `GET /api/employees/{id}`
- **Response**:
    ```json
    {
        "id": "1",
        "name": "Kishor Bhosale",
        "department": "Engineering",
        "salary": 60000
    }
    ```

### 3. Add a New Employee
- **Endpoint**: `POST /api/employees`
- **Request Body**:
    ```json
    {
        "name": "Kishor Bhosale",
        "department": "Engineering",
        "salary": 60000
    }
    ```

### 4. Update an Employee
- **Endpoint**: `PUT /api/employees/{id}`
- **Request Body**:
    ```json
    {
        "name": "Kishor Bhosale",
        "department": "Marketing",
        "salary": 70000
    }
    ```

### 5. Delete an Employee
- **Endpoint**: `DELETE /api/employees/{id}`

---

## CURL Commands for Testing

### Add an Employee
```bash
curl -X POST http://localhost:8080/api/employees \
-H "Content-Type: application/json" \
-d '{
  "name": "Kishor Bhosale",
  "department": "Engineering",
  "salary": 60000
}'
