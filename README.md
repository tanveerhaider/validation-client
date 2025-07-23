# Credit Card Application Validation API

## Overview

This project is a Spring Boot-based REST API for validating credit card applications. It demonstrates advanced validation using standard and custom annotations, including:

- Field-level validation (e.g., required fields, value ranges)
- Nested object validation
- Custom constraints (e.g., unique email, unique SSN)
- Aggregated error reporting

## Features

- Validate credit card application data before processing
- Custom validation for unique email and SSN
- Support for primary and co-applicants
- Business information validation
- Configurable credit limit range
- Terms acceptance enforcement

## Technologies

- Java 17+
- Spring Boot
- Jakarta Bean Validation (JSR 380)
- Maven

## Getting Started

### Prerequisites

- Java 17 or higher
- Maven 3.6+

### Build & Run

```bash
mvn clean install
mvn spring-boot:run