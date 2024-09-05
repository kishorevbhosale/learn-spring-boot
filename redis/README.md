# Employee Management System

This is a Spring Boot-based application that performs CRUD operations on employee data using Redis.

![Employee Management Diagram](./image/employee-management-diagram.png)

## Expert Tricks and Fast Optimizations

1. **Use `LettuceConnectionFactory`:**  
   Lettuce is a non-blocking, scalable Redis client that supports asynchronous operations and provides better performance than Jedis in many cases. It's already used in the `RedisConfig`. Lettuce is recommended for applications requiring high concurrency due to its non-blocking nature.

2. **Serialization Performance:**  
   Redis operates best when data is serialized efficiently. You can use custom serializers like `GenericToStringSerializer` or opt for JSON serialization with the Jackson library. Proper serialization is especially important when handling large datasets to minimize serialization overhead and boost performance.

3. **Efficient Hash Usage:**  
   Redis hashes (`opsForHash()`) are highly memory efficient, especially when storing structured objects like employee records. By grouping related data into a single Redis hash, you can reduce memory usage and improve lookup performance.

4. **Cache TTL for Expiry:**  
   You can configure TTL (Time-to-Live) for Redis entries to automatically expire old data. For example, in the service layer, you can set the expiration time for hash keys to avoid stale data accumulation:
   ```java
   redisTemplate.expire(HASH_KEY, Duration.ofHours(24));


# Employee Management CRUD Application using Spring Boot and Redis

This project demonstrates a **Spring Boot** application that performs basic **CRUD (Create, Read, Update, Delete)** operations on employee data, with **Redis** as the database. The project is designed to handle employee details and store them in Redis using the `opsForHash()` Redis hash operations, providing both fast read/write operations and efficient memory usage.

## Features
- Add a new employee
- Retrieve all employees
- Retrieve a specific employee by ID
- Delete an employee by ID
- Fast and optimized data storage using Redis

## CURLs

### Add new employee
```bash
curl --location 'http://localhost:8080/api/employees' \
--header 'Content-Type: application/json' \
--data '{
    "id": "1",
    "name": "Mithil Bhosale",
    "department": "IT",
    "salary" : "3500"
}'
```

### Retrieve all employees
```bash
curl --location 'http://localhost:8080/api/employees'
```

### Retrieve a specific employee by ID
```bash
curl --location 'http://localhost:8080/api/employees/1'
```

### Delete an employee by ID
```bash
curl --location --request DELETE 'http://localhost:8080/api/employees/1'
```