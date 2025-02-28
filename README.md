# Library - Quarkus Application
## Overview
This repository contains an alternative implementation of the Library Management System using Quarkus, a Kubernetes-native Java framework optimized for cloud and containerized environments. The application mirrors the functionality of the original Spring Boot-based system, providing the same set of features, business logic, and test cases. The primary differences lie in the framework-specific annotations and the use of Quarkus's architecture.

The application supports CRUD operations for books, users, and rentals. It is designed to be a drop-in replacement for the Spring Boot version, ensuring compatibility with existing tests. The original Spring Boot application can be find here https://github.com/Hiuekrav/Library-Spring-Boot-Application.

## Key changes
The following changes have been made to the original application:
1. **Controllers**:
  - Modified to use Quarkus annotations (e.g., ```@Path```, ```@GET```, ```@POST```).
  - Return ```Response``` instead of ```ResponseEntity```.
  - Example:
  ```
  @POST
  @Path("create")
  @Consumes(MediaType.APPLICATION_JSON)
  @Produces(MediaType.APPLICATION_JSON)
  Response createBook(@Valid BookCreateDTO bookCreateDTO);
  ```
2. **Services**:
  - Annotations updated to use Quarkus-specific annotations (e.g., ```@ApplicationScoped```).
  - Example:
  ```
  @ApplicationScoped
  public class BookService extends ObjectService implements IBookService {
      // Business logic remains unchanged
  }
  ```
3. **Repositories**:
  - Updated to use Quarkus annotations (e.g., ```@Singleton```, ```@Inject```).
  - Example:
  ```
  @Singleton
  public class BookRepository extends ObjectRepository<BookMgd> implements IBookRepository {
    // Data access methods remain unchanged
  }
  ```
4. **Exception Handling**:
  - Replaced Spring's ```@ControllerAdvice``` with Quarkus's ```ExceptionMapper```.
  - Example:
  ```
  public class BookExceptionResolver implements ExceptionMapper<BookBaseException> {
    @Override
    public Response toResponse(BookBaseException e) {
        if (e instanceof BookNotFoundException) {
            return Response.status(Response.Status.NOT_FOUND)
                    .entity(new ExceptionOutputDTO(e.getMessage()))
                    .build();
        }
        return Response.status(Response.Status.BAD_REQUEST)
                .entity(new ExceptionOutputDTO(e.getMessage()))
                .build();
    }
  }
  ```
5. **Database Initialization**:
  - Updated to use Quarkus's ```@ApplicationScoped``` and ```@Observes``` for startup events.
  ```
  @ApplicationScoped
  public class DatabaseInit {
    @Inject
    IRentRepository rentRepository;

    @Inject
    IBookRepository bookRepository;

    @Inject
    IUserRepository userRepository;

    public void init(@Observes StartupEvent event) {
        // Initialization logic unchanged
    }
  }
  ```
6. **Tests**:
  - Updated to use Quarkus testing annotations (e.g., ```@QuarkusTest```).
  - Example:
  ```
  @QuarkusTest
  public class BookControllerTests {
    @Inject
    private IBookService bookService;
    // Test cases remain unchanged
  }
  ```

## Setup and Testing the Project
### Prerequisites
- Docker
- Java 21
- Maven

### Installation
1. Clone this repository.
2. Set up MongoDB replica set by running services directly from docker-compose using IDE or by executing ```docker-compose up -d``` command.
3. Build the project: ```mvn clean install```
4. Run the application: use ```mvn quarkus:dev``` command from REST directory in your terminal (or run main method from RestApplication class in your IDE).
5. Access **Swagger UI** (recommended): Open your browser and navigate to http://localhost:8080/swagger-ui/index.html to access the Swagger UI for API documentation and testing. Alternatively you can use Postman or cURL for testing endpoints.

### Testing
Execute the test suite using Maven:
```
mvn test
```
or using your IDE.

## Authors

### Wiktoria Bilecka
### Grzegorz Janasek
