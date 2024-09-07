# Database-Based Sequencer with Spring Boot

This project demonstrates how to implement a database-based sequencer using **Spring Boot** and **H2** in-memory database. The application provides a simple mechanism to generate unique, sequential numbers that can be used for purposes like order numbers or transaction IDs. The solution is thread-safe and scalable across multiple instances of the application.


## Prerequisites

To run this project, you will need the following:

- Java 17 or above
- Maven 3.6 or above

## Project Setup

### 1. Clone the repository

### 2. Build and run the project

You can build and run the project using Maven:

```bash
mvn spring-boot:run
```

The application will start on `http://localhost:8080` by default.

### 3. Access the API

Once the application is running, you can interact with the REST API to get sequential numbers.

## How It Works

The sequence generation is handled by a dedicated database table called `sequence_generator`. This table stores the current value of a named sequence, which can be incremented each time a new value is requested.

### Database Schema

The table `sequence_generator` is defined as follows:

```sql
-- Create the sequence_generator table
CREATE TABLE sequence_generator (
    id BIGINT AUTO_INCREMENT PRIMARY KEY,
    name VARCHAR(100) NOT NULL,
    current_value BIGINT NOT NULL
);
```

A default sequence (`order_sequence`) is initialized with a value of 0:

```sql
INSERT INTO sequence_generator (name, current_value) VALUES ('order_sequence', 0);
```

The service layer ensures that the sequence is updated in a thread-safe manner using Spring's `@Transactional` annotation.

### Key Components:

1. **Entity**: The `SequenceGenerator` entity maps the table in the database.
2. **Repository**: The `SequenceGeneratorRepository` provides methods to access the sequence generator data.
3. **Service**: The `SequenceService` handles the business logic for fetching and incrementing the sequence.
4. **Controller**: The `SequenceController` exposes an API endpoint to retrieve the next value in the sequence.


The application automatically initializes the `sequence_generator` table and inserts initial data through an SQL script located at `src/main/resources/data.sql`:



## API Usage

The application exposes a REST API to get the next value of the sequence.

### Endpoint:

**GET** `/sequence/{name}`

- **Path Variable:**
    - `name`: The name of the sequence (e.g., `order_sequence`).

#### Example Request:

```bash
curl http://localhost:8080/sequence/order_sequence
```

#### Example Response:

```json
1
```

Each subsequent call to this endpoint will return the next value in the sequence.

## H2 Console Access

You can access the H2 database console at the following URL:

```
http://localhost:8080/h2-console
```

---

### Happy Coding! 🎉

--- 