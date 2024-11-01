# Stock Alert Observer

## Overview
Stock Alert Observer is a Java-based application designed to notify users when a product they are interested in is back in stock. The project leverages the Observer design pattern to manage subscriptions and notifications.

## Tech Stack
- **Java**: Core programming language.
- **Spring Boot**: Framework for building the application.
- **H2 Database**: In-memory database for development and testing.
- **SMTP**: Protocol for sending email notifications.
- **Swagger**: API documentation and testing.

## Branches

### `feature-1`
- **Status**: Complete
- **Description**: This branch implements the Observer pattern fully. The mail function is not included in this branch.

### `feature-2`
- **Status**: Complete with modifications
- **Description**: This branch includes the mail function to notify users when a product is back in stock. While it follows the Observer pattern, some changes were made during development, so it does not adhere 100% to the original pattern.

## Getting Started

### Prerequisites
- Java 17
- Gradle
- An SMTP server for sending emails

### Installation
1. Clone the repository:
   ```bash
   git clone https://github.com/BibhutiJavaNaut/StockAlertObserver.git
   cd stock-alert-observer
