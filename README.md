# Project Structure

```text
src/
├── main
│   ├── java
│   │   └── org
│   │       └── example
│   │           └── ventory
│   │               ├── controller
│   │               │   └── ProductController.java
│   │               ├── dto
│   │               │   ├── ProductRequestDTO.java
│   │               │   └── ProductResponseDTO.java
│   │               ├── entity
│   │               │   ├── Category.java
│   │               │   └── Product.java
│   │               ├── exception
│   │               │   ├── GlobalExceptionHandler.java
│   │               │   └── ProductNotFoundException.java
│   │               ├── mapper
│   │               │   └── ProductMapper.java
│   │               ├── repository
│   │               │   └── ProductRepository.java
│   │               ├── service
│   │               │   └── ProductService.java
│   │               └── VentoryApplication.java
│   └── resources
│       └── application.properties
└── test
    └── java
        └── org
            └── example
                └── ventory
                    └── VentoryApplicationTests.java
```

## Package Description

| Package | Responsibility |
|----------|---------------|
| `controller` | Handles HTTP requests and responses. |
| `dto` | Contains Data Transfer Objects used for API communication. |
| `entity` | JPA entities representing database tables. |
| `exception` | Custom exceptions and global exception handling. |
| `mapper` | Converts between entities and DTOs. |
| `repository` | Data access layer using Spring Data JPA. |
| `service` | Business logic layer. |
| `resources` | Application configuration files. |
| `test` | Unit and integration tests. |

## Architecture

The project follows a layered architecture:

```text
Controller
    ↓
Service
    ↓
Repository
    ↓
Database
```

DTOs are used to transfer data between the API and the service layer, while Mappers handle conversions between DTOs and Entities.