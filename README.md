
---

# REST Countries API Test Suite

This project is a Java-based test suite for the [REST Countries API](https://restcountries.com/), using Maven, TestNG, RestAssured, and Log4j2 for logging.

## Features

- Automated REST API tests for country data
- Error handling and assertion for test reliability
- Project-level logging of request and response details for failed tests using Log4j2

## Tech Stack

- Java
- Maven
- TestNG
- RestAssured
- Log4j2

## Setup

1. Clone the repository.
2. Ensure Java and Maven are installed.
3. Add Log4j2 dependencies to `pom.xml`:
    ```xml
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-api</artifactId>
        <version>2.20.0</version>
    </dependency>
    <dependency>
        <groupId>org.apache.logging.log4j</groupId>
        <artifactId>log4j-core</artifactId>
        <version>2.20.0</version>
    </dependency>
    ```

## Running Tests

Run the tests using Maven:
```
mvn test
```

## Logging

- Request and response details for failed tests are logged using Log4j2.
- Configure logging output in `src/test/resources/log4j2.xml`.

## Directory Structure

- `src/test/java/` - Test classes
- `src/test/resources/` - Test resources

---

