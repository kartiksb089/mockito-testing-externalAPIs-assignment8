# Module 8 – Assignment Set 3  
## Mocking External Dependencies using Mockito

---

# Objective

The objective of this assignment is to understand how to test business logic independently by mocking external dependencies using Mockito and JUnit 5.

The assignment demonstrates:
- Mocking external dependencies
- Stubbing successful and failure responses
- Simulating exceptions
- Verifying method interactions
- Improving testability through refactoring

---

# Technologies Used

- Java 17
- JUnit 5
- Mockito
- Maven

---

# Project Structure

```text
src
├── main
│   └── java
│       └── com.mockito.test
│           ├── dependency
│           │   └── PaymentGatewayClient.java
│           │
│           └── service
│               └── PaymentService.java
│
└── test
    └── java
        └── com.mockito.test.tests
            └── PaymentServiceTest.java
