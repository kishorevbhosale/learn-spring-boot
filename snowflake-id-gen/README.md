# Spring Boot Snowflake ID Sequencer

## Overview

This Spring Boot application provides a high-performance, distributed ID generation service based on the Snowflake algorithm. The Snowflake algorithm is designed to ensure uniqueness, maintain ordering, support high scalability, and offer low latency, all while providing fault tolerance.

## Features

- **Uniqueness**: Each generated ID is unique across all nodes.
- **Ordering**: IDs are sequential within each millisecond to preserve event order.
- **Scalability**: Handles millions to billions of ID requests per second.
- **Low Latency**: Fast ID generation with minimal delay.
- **Fault Tolerance**: The system continues to operate even if some components fail.

## Architecture

The Snowflake ID is a 64-bit integer composed of:

- **1 bit** for the sign (always 0)
- **41 bits** for the timestamp (millisecond precision, supports 69 years)
- **10 bits** for a machine ID (to distinguish different nodes/machines)
- **12 bits** for a sequence number (to handle requests in the same millisecond)

## Prerequisites

- Java 11 or higher
- Maven 3.6 or higher

## Getting Started

### Clone the Repository

### Accessing the API
To generate a new ID, navigate to:
```bash
http://localhost:8080/api/id
```

### Sample ID Generated
```bash
487446035241635840
```

## Configuration
The Snowflake ID generation parameters can be configured in the SnowflakeIdGenerator class:
```
nodeId: Represents the node ID (default is 1). Each instance should have a unique node ID.
epoch: Custom epoch for timestamp calculation (default is Sept 7, 2024).
```

---

### Happy Coding! 🎉

--- 
