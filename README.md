# Spring Boot Flashcard Application

A Spring Boot application for flashcard functionality with user authentication and money transfer features.

## Features

- User authentication and authorization with Spring Security
- User account management with profile information
- User connections and relationships
- Money transfer system with fee tracking
- Thymeleaf-based web interface
- MySQL database integration
- JPA/Hibernate data persistence

## Technology Stack

- **Java**: 17
- **Spring Boot**: 3.0.4
- **Spring Security**: Authentication and authorization
- **Spring Data JPA**: Data persistence
- **Hibernate**: ORM
- **Thymeleaf**: Template engine
- **MySQL**: Database
- **Lombok**: Boilerplate code reduction
- **Maven**: Build tool
- **JaCoCo**: Code coverage

## Prerequisites

- Java 17 or higher
- Maven 3.6+ (or use included Maven wrapper)
- MySQL 8.0+
- Git

## Getting Started

### 1. Clone the Repository

```bash
git clone <repository-url>
cd java-springboot-flashcard
```

### 2. Database Setup

Create a MySQL database and user:

```sql
CREATE DATABASE flashcard;
CREATE USER 'flashcard'@'localhost' IDENTIFIED BY 'your_password';
GRANT ALL PRIVILEGES ON flashcard.* TO 'flashcard'@'localhost';
FLUSH PRIVILEGES;
```

Ensure MySQL is running on port 3380, or update the port in `src/main/resources/application.yaml`.

### 3. Configure Environment

Set the database password as an environment variable:

```bash
export FLASHCARD_DB_PASSWORD=your_password
```

### 4. Build the Application

```bash
./mvnw clean package
```

### 5. Run the Application

```bash
./mvnw spring-boot:run
```

The application will start and automatically create/update database tables based on JPA entities.

## Development

### Running Tests

```bash
./mvnw test
```

### Run Specific Test

```bash
./mvnw test -Dtest=YourTestClassName
./mvnw test -Dtest=YourTestClassName#specificTestMethod
```

### Code Coverage

Generate coverage report:

```bash
./mvnw test jacoco:report
```

View report at: `target/site/jacoco/index.html`

### Hot Reload

The application includes Spring Boot DevTools for automatic restart during development. Simply make changes to your code and the application will restart automatically.

## Project Structure

```
src/
├── main/
│   ├── java/com/ericbouchut/java/springboot/flashcard/
│   │   ├── Application.java              # Main application entry point
│   │   ├── config/                       # Configuration classes
│   │   │   ├── SecurityConfiguratio.java # Spring Security setup
│   │   │   └── MvcConfig.java            # MVC configuration
│   │   ├── model/                        # JPA entities
│   │   │   ├── User.java                 # User entity
│   │   │   ├── UserAccount.java          # User account details
│   │   │   ├── Link.java                 # User connections
│   │   │   └── Transfer.java             # Money transfers
│   │   ├── service/                      # Business logic
│   │   ├── repository/                   # Data access layer
│   │   ├── controller/                   # Web controllers
│   │   └── dto/                          # Data transfer objects
│   └── resources/
│       ├── application.yaml              # Application configuration
│       └── templates/                    # Thymeleaf templates
└── test/
    └── java/                             # Test classes
```

## Configuration

### Application Properties

Key configuration in `src/main/resources/application.yaml`:

- **Database**: MySQL connection on `localhost:3380`
- **JPA**: Hibernate with auto DDL update
- **Logging**: DEBUG level for Hibernate SQL and application code
- **Thymeleaf**: Template caching disabled for development

### Environment Variables

- `FLASHCARD_DB_PASSWORD`: MySQL database password (required)

## Domain Model

### User
- Authentication and profile information
- Email (unique), password, first name, last name
- Connected to UserAccount (one-to-one)
- Connected to Links (many-to-many)

### UserAccount
- Additional account information for users
- One-to-one relationship with User

### Link
- Represents connections between two users
- Many-to-one relationships with User

### Transfer
- Money transfers between users
- Tracks amount before and after fees
- Includes timestamp and from/to users

## Testing

The project uses:
- Spring Boot Test
- Spring Security Test
- JaCoCo for code coverage

Coverage exclusions:
- Application entry points
- Exception classes
- DTOs

## Contributing

1. Fork the repository
2. Create a feature branch (`git checkout -b feature/amazing-feature`)
3. Commit your changes (`git commit -m 'Add some amazing feature'`)
4. Push to the branch (`git push origin feature/amazing-feature`)
5. Open a Pull Request

## License

This project is licensed under the terms specified in the LICENSE file.

## Resources

- [Spring Boot Documentation](https://docs.spring.io/spring-boot/)
- [Spring Security Documentation](https://docs.spring.io/spring-security/)
- [Spring Data JPA Documentation](https://docs.spring.io/spring-data/jpa/)
- [Thymeleaf Documentation](https://www.thymeleaf.org/documentation.html)
