# Inventory Management Web Application

Project type: Spring Boot web application  
Purpose: Portfolio / technical interview demonstration of a customized inventory system for a retail customer (\`Kyle's Workout Warehouse\`).

## Summary
A small, production-like Spring Boot application that models Products composed of Parts with server-side HTML views (Thymeleaf). Core capabilities include inventory tracking with min/max constraints, a purchase flow that decrements product inventory, sample data seeding, server-side validation, and unit tests. The codebase demonstrates full-stack feature implementation using Spring MVC, services, repositories, and validators.

## Impact & functionality
- Provides a clear, user-facing inventory management UI for product and part lifecycle (create, update, delete, purchase).
- Enforces business rules: inventory must remain within configured minimum/maximum bounds; products cannot be modified in ways that break part constraints.
- Safe sample-data seeding: inserts a representative inventory only when the data store is empty to avoid overwriting user data.
- Readable feedback: purchase success/failure and validation errors are surfaced in the UI to improve user trust and reduce errors.
- Testable design: services and domain objects are structured to allow unit testing of critical business rules.

## Technical overview
- Presentation: Thymeleaf templates render server-side HTML and display validation messages.
- Controllers: handle HTTP requests, coordinate services, and return views.
- Services: encapsulate business logic and coordinate repositories.
- Repositories: Spring Data interfaces for persistence.
- Validation: custom validators enforce domain constraints before persistence.
- Persistence: file- or embedded-based persistence configured in \`src/main/resources/application.properties\`.

## How to run (Windows)
Prerequisites: JDK 17+, Maven, IntelliJ IDEA (or any IDE).  
From IntelliJ: run the main application class \`src/main/java/com/example/demo/DemoApplication.java\`.  
From command line (project root):
- Build: \`mvn -DskipTests=false clean package\`
- Run: \`mvn spring-boot:run\`
- Tests: \`mvn test\`  
  Open: http://localhost:8080/

## Tests
Unit tests are located under \`src/test/java\`. Critical tests validate min/max inventory behavior for parts and related domain logic.

## Key locations (quick reference)
- Main app: \`src/main/java/com/example/demo/DemoApplication.java\`
- Bootstrap/sample data: \`src/main/java/com/example/demo/bootstrap/BootStrapData.java\`
- Controllers: \`src/main/java/com/example/demo/controllers/\`
- Domain models: \`src/main/java/com/example/demo/domain/\` (\`Part\`, \`InhousePart\`, \`OutsourcedPart\`, \`Product\`)
- Services & implementations: \`src/main/java/com/example/demo/service/\`
- Validators: \`src/main/java/com/example/demo/validators/\`
- Templates: \`src/main/resources/templates/\` (main UI, forms, about, confirmations, errors)
- Configuration: \`src/main/resources/application.properties\`

## Competencies demonstrated
- UI implementation: server-side templates, navigation, and user feedback flows.
- Framework usage: Spring Boot MVC, Data repositories, dependency injection, lifecycle/bootstrapping, and validators.
- Engineering practices: safe data seeding, unit testing, and removal of unused code to improve maintainability.


