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

	GET /api/questions: Retrieve all questions.
	POST /api/questions: Add a new question.
	PUT /api/questions/{id}: Update a question by ID.
	DELETE /api/questions/{id}: Delete a question by ID.
	GET /api/questions/category/{categoryId}: Retrieve questions by category.

 ###Contributing

Contributions are welcome! Fork the repository, create a feature branch, and submit a pull request.
