# Campus Task Board API

## Homework 8: Security and Final Enhancements

This project is a Spring Boot REST API for managing campus tasks. It demonstrates CRUD operations, validation, exception handling, security configuration, API versioning, logging, and API documentation.

---

# Technologies Used

- Java 17
- Spring Boot
- Spring Web
- Spring Data JPA
- Spring Security
- Spring Boot Actuator
- SpringDoc OpenAPI / Swagger
- H2 Database
- Maven

---

# Features Implemented

## CRUD Operations
- Create tasks
- Read tasks
- Update tasks
- Delete tasks

## Validation
- Title validation
- Description validation
- Priority validation

## Exception Handling
- Global exception handler
- Custom `TaskNotFoundException`
- Structured error responses

## Soft Delete
Tasks are marked as deleted instead of being permanently removed from the database.

## Security Configuration
Spring Security was added using `SecurityConfig`.

Features:
- CSRF disabled for REST API development
- Public API endpoints
- Security filter chain configured

## API Versioning
A versioned controller was added:

```text
/api/v1/tasks
