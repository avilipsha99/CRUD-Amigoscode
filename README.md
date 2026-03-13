Spring Boot CRUD Application
A RESTful CRUD API built with Spring Boot, PostgreSQL, and Docker

Tech Stack
TechnologyVersionJava21Spring Boot3.4.0Spring Data JPA3.4.0PostgreSQLLatestDockerLatestMaven3.x

Project Structure
amigoscode/
├── src/
│   └── main/
│       ├── java/com/amigoscode/
│       │   ├── AmigoscodeApplication.java       # Main entry point
│       │   ├── SoftwareEngineer.java             # Entity / Model
│       │   ├── SoftwareEngineerController.java   # REST Controller
│       │   ├── SoftwareEngineerService.java      # Business Logic
│       │   └── SoftwareEngineerReposistory.java  # JPA Repository
│       └── resources/
│           └── application.properties            # App configuration
├── docker-compose.yml                            # PostgreSQL Docker setup
└── pom.xml                                       # Maven dependencies

Running PostgreSQL with Docker
Step 1 — Start Docker Desktop
Make sure Docker Desktop is running before proceeding.
Step 2 — Start the PostgreSQL container
bashdocker compose up -d
Step 3 — Verify the container is running
bashdocker ps
You should see postgres-spring-boot running.
To stop the container:
bashdocker compose down

Configuration
The application.properties file is configured as follows:
propertiesspring.datasource.url=jdbc:postgresql://localhost:5332/amigoscode
spring.datasource.username=amigoscode
spring.datasource.password=password
spring.datasource.driver-class-name=org.postgresql.Driver
spring.jpa.hibernate.ddl-auto=create-drop
spring.jpa.show-sql=true
spring.jpa.properties.hibernate.dialect=org.hibernate.dialect.PostgreSQLDialect
spring.jpa.properties.hibernate.format_sql=true
spring.jpa.properties.hibernate.jdbc.time_zone=UTC

Note: Port 5332 is used (mapped from container's 5432).


Running the Application
Step 1 — Open Docker Desktop and start the container:
bashdocker compose up -d
Step 2 — Run the Spring Boot app in IntelliJ:
Click the ▶️ Run button or use:
bashmvn spring-boot:run
Add -Duser.timezone=UTC to VM options in IntelliJ Run Configuration to avoid timezone issues.
The app will start at: http://localhost:8080

API Endpoints
Base URL: http://localhost:8080/api/v1/software-engineers
MethodEndpointDescriptionGET/api/v1/software-engineersGet all software engineersPOST/api/v1/software-engineersAdd a new software engineerPUT/api/v1/software-engineers/{id}Update a software engineerDELETE/api/v1/software-engineers/{id}Delete a software engineer

Testing with Postman
GET — Fetch all engineers
GET http://localhost:8080/api/v1/software-engineers
POST — Add a new engineer
POST http://localhost:8080/api/v1/software-engineers

Docker Compose Configuration
yamlservices:
  db:
    container_name: postgres-spring-boot
    image: postgres:latest
    environment:
      POSTGRES_USER: amigoscode
      POSTGRES_PASSWORD: password
      PGDATA: /data/postgres
    volumes:
      - db:/data/postgres
    ports:
      - "5332:5432"
    networks:
      - db
    restart: unless-stopped

networks:
  db:
    driver: bridge

volumes:
  db:

Concepts Covered:
REST API with Spring Boot
Dependency Injection and IoC
Spring Data JPA with PostgreSQL
Entity mapping with Hibernate annotations
Docker for running PostgreSQL locally
CRUD operations (Create, Read, Update, Delete)

