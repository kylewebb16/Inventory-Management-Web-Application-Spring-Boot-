# Inventory Management Web Application

Project: Web-Based Spring Inventory Application  
Scenario: Kyle's Workout Warehouse — a gym equipment distributor.

## Summary
A Spring Boot web application that models Products composed of Parts with a server-rendered Thymeleaf UI. The system enforces inventory rules (min/max), supports a purchase flow that decrements inventory, seeds safe sample data, and includes unit tests for core business rules.

## Impact & functionality
- Clear inventory management UI for creating, updating, deleting, and purchasing items.
- Business-rule enforcement: part inventory must remain within configured min/max bounds.
- Atomic purchase behavior: "Buy Now" verifies availability and updates inventory with user feedback on success or failure.
- Safe sample-data seeding: representative inventory is added only when the datastore is empty.
- Testable design: domain logic and services are structured for unit testing of critical behaviors.

## Technical overview
- Framework: Spring Boot (Java, Maven)
- Presentation: Thymeleaf server-side templates
- Persistence: Spring Data repositories (embedded or file-backed via `src/main/resources/application.properties`)
- Validation: Custom validators and server-side checks in services/controllers
- Tests: JUnit-based unit tests located under `src/test/java`

## How to run (Windows)
Prerequisites: JDK 17+, Maven, IntelliJ IDEA (optional).
- From IDE: run `src/main/java/com/example/demo/DemoApplication.java`
- From command line (project root):
    - Build: `mvn -DskipTests=false clean package`
    - Run: `mvn spring-boot:run`
    - Tests: `mvn test`  
      Open the app at: http://localhost:8080/

## Project layout (quick reference)
- Main app: `src/main/java/com/example/demo/DemoApplication.java`
- Bootstrap/sample data: `src/main/java/com/example/demo/bootstrap/BootStrapData.java`
- Controllers: `src/main/java/com/example/demo/controllers/`
- Domain models: `src/main/java/com/example/demo/domain/` (`Part`, `Product`, etc.)
- Services: `src/main/java/com/example/demo/service/`
- Validators: `src/main/java/com/example/demo/validators/`
- Templates: `src/main/resources/templates/`
- Configuration: `src/main/resources/application.properties`
- Tests: `src/test/java/`

## Competencies demonstrated
- Implemented user interfaces with server-rendered templates and form validation.
- Applied Spring Boot patterns: controllers, services, repositories, dependency injection, and lifecycle bootstrapping.
- Built and tested business rules for inventory management and transactional purchase behavior.
- Practiced maintainability: safe data seeding, focused unit tests, and removal of unused code.

## Notes
This repository is intended as a technical demo of engineering fundamentals in a small, end-to-end application.

Author: `kylewebb16`


