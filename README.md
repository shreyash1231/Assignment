# Spring Boot Quiz Application

This is a simple Spring Boot application designed to create a quiz platform. It uses an H2 in-memory database and includes basic functionality for user signup, login, and taking a quiz.

## Features

- User signup with email and password.
- User login with session management.
- Random quiz question retrieval.
- Answer submission with result calculation.
- Quiz result submission and clearing quiz data from the database.

## Technologies Used

- Java
- Spring Boot
- H2 Database (for in-memory storage)
- Spring Session (for session management)
- Spring Web

## Prerequisites

- Java 8 or higher
- Maven (or use your IDE's built-in Maven support)
- IDE (like IntelliJ IDEA, Eclipse, or Visual Studio Code)
- H2 Database (included by default in the application)

## Installation

1. Clone the repository or download the project files.
2. Navigate to the project directory.
3. Open the project in your preferred IDE.
4. Build the project using Maven:
   ```bash
   mvn clean install
   ```

5. Run the application:
   ```bash
   mvn spring-boot:run
   ```
   Or, you can run the main class from your IDE (typically `QuizApplication.java`).

6. The application will start on port `8080`.

## Database Setup

The application uses an H2 in-memory database. A `data.sql` file is included to pre-load quiz data into the database.

- You can modify the `data.sql` file for custom quiz questions.
  
## API Endpoints

### 1. **Signup** (POST)
   - **URL:** `http://localhost:8080/signup`
   - **Request Body:**
     ```json
     {
       "email": "user@example.com",
       "password": "password123"
     }
     ```
   - **Description:** Used for user signup. A new user will be created with the provided email and password.

### 2. **Login** (POST)
   - **URL:** `http://localhost:8080/login`
   - **Request Body:**
     ```json
     {
       "email": "user@example.com",
       "password": "password123"
     }
     ```
   - **Description:** Used for user login. A session will be created for the user upon successful login.

### 3. **Start Quiz** (GET)
   - **URL:** `http://localhost:8080/startquiz`
   - **Description:** Starts the quiz by fetching a random quiz question from the database.

### 4. **Quiz Answer** (GET)
   - **URL:** `http://localhost:8080/quizanswer/{option}`
   - **Description:** Submit an answer for the quiz question.
   - **Parameters:** 
     - `option`: The selected option (A, B, C, or D).
   - **Example:** 
     `http://localhost:8080/quizanswer/A`

### 5. **Submit Quiz** (GET)
   - **URL:** `http://localhost:8080/submit`
   - **Description:** Submit the quiz and get the result. After submission, the quiz data will be deleted from the database.

## Testing the Application

You can test the application using Postman or any HTTP client.

1. **Signup**:
   - Send a POST request to `http://localhost:8080/signup` with the required email and password.

2. **Login**:
   - After signup, send a POST request to `http://localhost:8080/login` with the same email and password to create a session.

3. **Start Quiz**:
   - Send a GET request to `http://localhost:8080/startquiz` to get a random quiz question.

4. **Answer Submission**:
   - Send a GET request to `http://localhost:8080/quizanswer/{option}` (replace `{option}` with A, B, C, or D) to submit your answer.

5. **Submit Quiz**:
   - Send a GET request to `http://localhost:8080/submit` to get the quiz results. After submitting the quiz, result will be shown and the data will be deleted from the database.

## Troubleshooting

- If you encounter issues with session management, ensure that cookies are enabled in your HTTP client (e.g., Postman).
- Make sure the H2 database is being populated correctly from `data.sql`. You can check the H2 console for a direct view of the database.
# Assignment
