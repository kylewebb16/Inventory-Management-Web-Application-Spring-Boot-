# Kyle's Workout Warehouse — Inventory Management Web Application

A production-ready Spring Boot application for managing inventory of products composed from parts. Kyle's Workout Warehouse is a retail scenario where assembled products (for example, "Workout Kits" or apparel bundles) are built from discrete parts (e.g., pair of matching shoes, set of resistance bands). The application provides a robust server-rendered administrative UI (Thymeleaf), enforces domain constraints, and is implemented with operational concerns in mind (validation, safe seeding, logging, monitoring, and testability).

Table of contents
- Overview
- Customer scenario
- Key capabilities
- Business rules
- Architecture & technical stack
- Configuration & persistence
- Running (development and production)
- Testing
- Observability, security, and operational guidance
- Project layout (quick reference)
- Contributing
- License & contact
- Changelog

Overview
This application models Parts and Products:
- Part: a discrete inventory item, tracked with inventory count, min and max thresholds, and supplier information (in-house vs outsourced).
- Product: an assembled SKU composed of one or more parts in specified quantities; products also maintain their own inventory metadata.

The application supports full CRUD for Parts and Products, product composition management, a "Buy Now" purchase flow that atomically checks and updates inventory, custom validation for domain invariants, and safe sample-data seeding to avoid overwriting production data.

Customer scenario
Kyle's Workout Warehouse sells assembled workout kits and accessories. Example flows:
- Create and maintain Parts (e.g., pair of dumbbell handles, weight plates, branded T-shirt).
- Assemble Products by associating Parts and required quantities (e.g., "Starter Home Gym Kit" composed of 1 pair of handles, 2 weight plates, 1 resistance band).
- Sales team uses "Buy Now" to record a purchase and decrement inventory while enforcing min/max thresholds.
- Operations team configures persistence and monitoring for production deployments.

Key capabilities
- CRUD operations for Parts and Products with server-rendered forms (Thymeleaf).
- Product composition management: associate Parts with quantities to form Products.
- Inventory enforcement: min/max thresholds at Part level; Product operations respect associated Part constraints.
- Buy Now purchase flow: checks availability and min constraints across all involved Parts, updates inventory atomically.
- Safe data seeding: sample data only inserted when the datastore is empty.
- Testable, layered architecture (controllers, services, repositories, validators).
- Production-oriented guidance: external DB support, health endpoints, logging, and Docker-ready build.

Business rules (examples)
- Part inventory must always be between configured min and max values. Attempts to set an inventory value that violates these constraints are rejected.
- A Product cannot be saved if its composition would allow future purchases to reduce associated Parts below their minimum values.
- Product deletion or modification is prevented if the change would violate part-related constraints for existing inventory.
- Purchase/Buy Now validates stock for all required Parts and fails with a descriptive error if constraints cannot be satisfied.
- Sample data seeding executes only when the persistence layer is empty.

Architecture & technical stack
- Java 17+
- Spring Boot (web, data, validation)
- Thymeleaf for server-side UI rendering
- Spring MVC controllers, Service layer encapsulating business logic
- Spring Data repositories for persistence
- Custom validators for cross-field/domain constraints
- Maven build system
- Tests: JUnit + Spring Test support


Running locally (developer)
Prerequisites
- JDK 17+
- Maven 3.8+
- Optional: IntelliJ IDEA or other IDE

From IDE
- Launch the main class: src/main/java/com/example/demo/DemoApplication.java

From command line (project root)
- Build: mvn -DskipTests=false clean package
- Run: mvn spring-boot:run
- Open: http://localhost:8080/


Data seeding
- BootStrapData inserts representative parts and products only when the configured repository is empty—this prevents seeding from overwriting persisted production data.
- For production, disable seeding or gate it behind a profile (e.g., spring.profiles.active=dev).

Testing
- Unit tests are located under src/test/java. Tests focus on service-layer business logic (min/max inventory validation, product composition rules, purchase flow).
- Run tests: mvn test
- Integration tests can be added to exercise the controller and persistence layers using Testcontainers to spin up a throwaway DB.


Project layout (quick reference)
- Main app: src/main/java/com/example/demo/DemoApplication.java
- Bootstrap/sample data: src/main/java/com/example/demo/bootstrap/BootStrapData.java
- Controllers: src/main/java/com/example/demo/controllers/
- Domain: src/main/java/com/example/demo/domain/ (Part, InhousePart, OutsourcedPart, Product)
- Services: src/main/java/com/example/demo/service/
- Repositories: src/main/java/com/example/demo/repository/
- Validators: src/main/java/com/example/demo/validators/
- Templates: src/main/resources/templates/
- Configuration: src/main/resources/application.properties
- Tests: src/test/java/


Contributing
- Fork the repository and create a feature branch.
- Add descriptive commit messages and a succinct PR description.
- Include unit tests for any new business logic and update documentation if behavior changes.
- Run the full test suite locally before opening a PR.

License & contact
- Author / Maintainer: kylewebb16
- Contact: via GitHub profile (https://github.com/kylewebb16)

