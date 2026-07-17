# 🚀 Ventory

<p align="center">
  <img src="https://img.shields.io/badge/Java-21-red" />
  <img src="https://img.shields.io/badge/Spring%20Boot-3.x-brightgreen" />
  <img src="https://img.shields.io/badge/Spring%20Security-JWT-success" />
  <img src="https://img.shields.io/badge/Database-MySQL-orange" />
  <img src="https://img.shields.io/badge/Build-Maven-blue" />
  <img src="https://img.shields.io/badge/Architecture-Layered-important" />
</p>

## 📌 Overview

Ventory is a **production-style Inventory Management System** built with **Java 21** and **Spring Boot**.

The project was created to demonstrate modern backend engineering practices including secure authentication, layered architecture, clean code principles, DTO mapping, exception handling, validation, and scalable REST API design.

Rather than being a simple CRUD application, Ventory focuses on writing maintainable, production-ready backend code following industry best practices.

---

# ✨ Features

## Authentication & Security

- JWT Authentication
- Spring Security
- Role-Based Authorization
- Password Encryption
- Stateless Authentication

---

## Inventory Management

- Products Management
- Categories Management
- Suppliers Management
- Stock Movement Tracking
- Inventory Quantity Updates

---

## Backend Engineering

- Layered Architecture
- DTO Pattern
- Repository Pattern
- Dependency Injection
- Service Layer
- Global Exception Handling
- Bean Validation
- Clean REST APIs

---

## Persistence

- Spring Data JPA
- Hibernate ORM
- Entity Relationships
- Transaction Management

---

# 🛠 Technology Stack

| Category | Technology |
|----------|------------|
| Language | Java 21 |
| Framework | Spring Boot 3 |
| Security | Spring Security + JWT |
| ORM | Hibernate / Spring Data JPA |
| Database | MySQL |
| Build Tool | Maven |
| Validation | Jakarta Bean Validation |
| Mapping | DTO + Mapper Classes |
| Utilities | Lombok |

---

# 🏗 Architecture

```
Client

        │
        ▼

Spring Security (JWT)

        │
        ▼

Controllers

        │
        ▼

Services

        │
        ▼

Repositories

        │
        ▼

MySQL Database
```

The application follows a **Layered Architecture**, separating responsibilities into independent layers to improve maintainability, readability, and scalability.

---

# 📂 Project Structure

```
src/main/java

controller/

service/

repository/

entity/

dto/

mapper/

security/

exception/

config/

enums/
```

Each package has a single responsibility following the **SOLID principles**.

---

# 🔐 Authentication Flow

```
Client

↓

POST /api/auth/login

↓

Spring Security

↓

Authentication Manager

↓

JWT Generation

↓

JWT Returned

↓

Authorization Header

↓

Protected Endpoints
```

---

# 📦 Main REST APIs

## Authentication

```
POST /api/auth/register

POST /api/auth/login
```

---

## Products

```
GET /api/products

GET /api/products/{id}

POST /api/products

PUT /api/products/{id}

DELETE /api/products/{id}
```

---

## Categories

```
GET /api/categories

POST /api/categories
```

---

## Suppliers

```
GET /api/suppliers

POST /api/suppliers
```

---

## Stock Movements

```
GET /api/stock-movements

POST /api/stock-movements
```

---

# 📝 Example Request

## Login

```http
POST /api/auth/login
```

Request

```json
{
  "username": "admin",
  "password": "123456"
}
```

Response

```json
{
  "token": "eyJhbGciOiJIUzI1NiJ9..."
}
```

---

# 🚀 Running the Project

## Requirements

- Java 21
- Maven
- MySQL

Clone the repository

```bash
git clone https://github.com/bishoySouser/ventory.git
```

Navigate to the project

```bash
cd ventory
```

Run

```bash
./mvnw spring-boot:run
```

Application starts on

```
http://localhost:8080
```

---

# 🎯 Engineering Practices

This project demonstrates:

- Clean Architecture Principles
- SOLID Principles
- RESTful API Design
- DTO Mapping
- Exception Handling
- Bean Validation
- Layered Design
- Constructor Injection
- Stateless Authentication
- Repository Pattern

---

# 📈 Roadmap

- [x] JWT Authentication
- [x] Spring Security
- [x] Products Module
- [x] Categories Module
- [x] Suppliers Module
- [x] Stock Movement Module
- [x] DTO Mapping
- [x] Global Exception Handling
- [ ] Swagger / OpenAPI
- [ ] Docker Support
- [ ] Docker Compose
- [ ] Redis Caching
- [ ] Flyway Migration
- [ ] Unit Testing (JUnit + Mockito)
- [ ] Integration Testing
- [ ] Pagination & Sorting
- [ ] Search & Filtering
- [ ] Audit Logging
- [ ] GitHub Actions CI/CD

---

# 👨‍💻 Author

**Bishoy Souser**

Backend Software Engineer

- LinkedIn: https://linkedin.com/in/bishoysouser
- GitHub: https://github.com/bishoySouser
- Email: bishoysouser@gmail.com

---

## ⭐ Why this project?

Ventory was built as a hands-on backend engineering project to strengthen expertise in the Java ecosystem and demonstrate the ability to design production-ready backend services using Spring Boot, Spring Security, Hibernate, and RESTful architecture while applying clean code and software engineering best practices.