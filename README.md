# Developer Interviews Backend

A backend solution for managing multiple-choice interview questions, built with Spring Boot and Java. This service supports an interview preparation app and provides an API to manage and organize questions by categories and topics.

## Features

- **Question Management**: Add, update, and delete multiple-choice questions.
- **Category and Topic Organization**: Organize questions into categories and topics for structured navigation.
- **Question Type Support**: Handles various question types, including multiple-choice and true/false.
- **API Authentication**: Implements security for authenticated API access.
- **API Documentation**: Uses Swagger for interactive API documentation.

## Tech Stack

- **Java 11**
- **Spring Boot**: Core framework for building the API.
- **Spring Data JPA**: Provides data persistence and relational database interaction.
- **MySQL Database**: Supports both in-memory (H2) and persistent (MySQL) databases.
- **Swagger**: For API documentation and testing.

## Getting Started

### Prerequisites

- **Java 11** or higher
- **Maven**: For project building and dependency management.
- **MySQL** (optional) for persistent storage; otherwise, the application defaults to H2 for testing.

### Installation and Setup

1. **Clone the repository:**

   ```bash
   git clone https://github.com/bee-honey/developerinterviews.git
   cd developerinterviews

2. **Configure the database:**
   Update application.properties to configure the database:
   ```bash
    spring.datasource.url=jdbc:mysql://localhost:3306/interview_db
    spring.datasource.username=root
    spring.datasource.password=your_password
    spring.jpa.hibernate.ddl-auto=update
   
4. **Build and Run the Application:**
   ```bash
   mvn clean install
   mvn spring-boot:run
  

 ### API Endpoints

Below are some key endpoints:

# API Endpoints Documentation

## User Controller

- **GET** `/profile`
  - Retrieves the user's profile information.

- **PUT** `/profile`
  - Updates the user's profile information.

- **GET** `/users`
  - Retrieves a list of all users.

- **DELETE** `/deactivate`
  - Deactivates the user's account.

---

## Category Controller

- **GET** `/categories/{id}`
  - Fetches details of a specific category by its ID.

- **PUT** `/categories/{id}`
  - Updates the information of a specific category by its ID.

- **GET** `/categories`
  - Retrieves a list of all categories.

- **POST** `/categories`
  - Creates a new category.

- **DELETE** `/categories`
  - Deletes a category.

---

## Question Controller

- **GET** `/categories/{categoryId}/topics/{topicId}/questions/{id}`
  - Fetches a specific question by category and topic IDs.

- **PUT** `/categories/{categoryId}/topics/{topicId}/questions/{id}`
  - Updates a specific question by category and topic IDs.

- **GET** `/categories/{categoryId}/topics/{topicId}/questions`
  - Retrieves a list of questions under a specific category and topic.

- **POST** `/categories/{categoryId}/topics/{topicId}/questions`
  - Creates a new question under a specific category and topic.

- **DELETE** `/categories/{categoryId}/topics/{topicId}/questions`
  - Deletes a question under a specific category and topic.

---

## Topic Controller

- **GET** `/categories/{categoryId}/topics/{id}`
  - Fetches a specific topic by category ID.

- **PUT** `/categories/{categoryId}/topics/{id}`
  - Updates a specific topic by category ID.

- **GET** `/categories/{categoryId}/topics`
  - Retrieves a list of topics under a specific category.

- **POST** `/categories/{categoryId}/topics`
  - Creates a new topic under a specific category.

- **DELETE** `/categories/{categoryId}/topics`
  - Deletes a topic under a specific category.

---

## Auth Controller

- **POST** `/register`
  - Registers a new user.

- **POST** `/login`
  - Authenticates a user and provides access tokens.

---

Each endpoint is organized by controller with clear HTTP method labels, path parameters, and basic descriptions for easy reference.

 ### Contributing

Contributions are welcome! Fork the repository, create a feature branch, and submit a pull request.
