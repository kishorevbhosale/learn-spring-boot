Here's the `README.md` in markdown format:

---

# UUID Generation API

This project is a simple Spring Boot application that provides RESTful APIs for generating, storing, retrieving, and deleting Universally Unique Identifiers (UUIDs). It uses an in-memory H2 database for persistence and provides the necessary CRUD operations on the UUIDs.

## Features

- Generate a UUID and save it to the database.
- Retrieve all UUIDs stored in the database.
- Retrieve a specific UUID by its ID.
- Delete a UUID by its ID.
- Uses H2 in-memory database for simplicity.

## Technologies Used

- **Spring Boot** (version 2.x)
- **Spring Data JPA** for data access
- **H2 Database** as an in-memory database
- **Lombok** for reducing boilerplate code
- **Maven** for dependency management

## Getting Started

### Prerequisites

- Java 8 or higher
- Maven 3.x

### Clone the Repository

### Run the Application

1. **Using Maven**:
   ```bash
   mvn spring-boot:run
   ```

2. **Using an IDE**:
    - Import the project as a Maven project.
    - Run the `UuidDemoApplication.java` file as a Java application.

Once the application is running, it will be accessible at `http://localhost:8080`.

## API Endpoints

### 1. Generate a new UUID

- **URL**: `/api/uuids/generate`
- **Method**: `POST`
- **Description**: Generates a new UUID and stores it in the database.
- **Response**:
  ```json
  {
    "id": 1,
    "uuid": "e8bff7f5-1c46-4e85-960d-546bb53933a2"
  }
  ```

### 2. Get all UUIDs

- **URL**: `/api/uuids`
- **Method**: `GET`
- **Description**: Retrieves all UUIDs stored in the database.
- **Response**:
  ```json
  [
    {
      "id": 1,
      "uuid": "e8bff7f5-1c46-4e85-960d-546bb53933a2"
    },
    {
      "id": 2,
      "uuid": "b7c4f5d8-3bf8-4fb3-8297-99e0f4d51e58"
    }
  ]
  ```

### 3. Get a UUID by ID

- **URL**: `/api/uuids/{id}`
- **Method**: `GET`
- **Description**: Retrieves a UUID by its unique ID.
- **Example**: `/api/uuids/1`
- **Response**:
  ```json
  {
    "id": 1,
    "uuid": "e8bff7f5-1c46-4e85-960d-546bb53933a2"
  }
  ```

### 4. Delete a UUID by ID

- **URL**: `/api/uuids/{id}`
- **Method**: `DELETE`
- **Description**: Deletes a UUID by its unique ID.
- **Example**: `/api/uuids/1`

## H2 Database Console

You can access the H2 database console at the following URL:

- **URL**: `http://localhost:8080/h2-console`
- **JDBC URL**: `jdbc:h2:mem:testdb`
- **Username**: `sa`
- **Password**: `password`

The H2 console is enabled by default in the `application.properties` file.

## Project Structure

```bash
src/
├── main/
│   ├── java/com/msk/uuid/
│   │   ├── controller/    # Contains the REST controller for UUID operations
│   │   ├── model/         # Contains the entity model for UUID
│   │   ├── repo/    # Contains the Spring Data JPA repository
│   │   ├── service/       # Contains the service layer with business logic
│   │   └── UuidApplication.java  # Main entry point for the Spring Boot application
│   └── resources/
│       ├── application.properties    # Application configuration file (H2 DB setup)
│       └── data.sql                  # (Optional) Initial data to load into the H2 database
└── test/
    └── java/com/example/uuiddemo/    # Contains unit and integration tests
```

## Dependencies

The main dependencies used in this project are:

- **Spring Boot Starter Web**: For creating RESTful web services.
- **Spring Boot Starter Data JPA**: For database access using JPA.
- **H2 Database**: In-memory database for development and testing.
- **Lombok**: For reducing boilerplate code like getters, setters, and constructors.
- **Spring Boot DevTools**: For automatic restarts during development.

All dependencies are managed through Maven in the `pom.xml` file.

## Configuration

The following configurations are found in `src/main/resources/application.properties`:

```properties
# H2 In-Memory Database Configuration
spring.datasource.url=jdbc:h2:mem:testdb
spring.datasource.driverClassName=org.h2.Driver
spring.datasource.username=sa
spring.datasource.password=password
spring.jpa.database-platform=org.hibernate.dialect.H2Dialect

# Enable H2 console
spring.h2.console.enabled=true
spring.h2.console.path=/h2-console
```


---

### Happy Coding! 🎉

--- 

