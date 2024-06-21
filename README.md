# Jobsity Challenge

## Table of Contents
- [Introduction](#introduction)
- [Architecture](#architecture)
- [Technologies Used](#technologies-used)
- [Prerequisites](#prerequisites)
- [Installation](#installation)
- [Running the Project](#running-the-project)
- [Project Structure](#project-structure)
- [Author](#author)

## Introduction
The Jobsity Challenge is a sample application designed to demonstrate the integration of various modern technologies and best practices in software development. It leverages Java with Spring Boot for the backend, MongoDB as the database, and Angular for the frontend. The project follows the Hexagonal Architecture to ensure a clean separation of concerns and maintainability. It also incorporates Materialize for styling and RxJS for reactive programming in the frontend.

## Architecture
The project follows Hexagonal Architecture (also known as Ports and Adapters Architecture), which aims to separate the core business logic from the external concerns (such as databases, web frameworks, etc.). This architecture helps in maintaining the application by making it easier to test and extend.

## Technologies Used
- **Java**: Programming language for the backend.
- **Spring Boot**: Framework for building the backend services.
- **MongoDB**: NoSQL database for storing application data.
- **Angular**: Framework for building the frontend application.
- **RxJS**: Library for reactive programming in JavaScript.
- **Materialize**: Utility-first CSS framework for styling the frontend.
- **Docker**: Containerization tool to simplify deployment.
- **Docker Compose**: Tool for defining and running multi-container Docker applications.

## Prerequisites
Before you begin, ensure you have the following installed on your local machine:
- **Docker**: [Install Docker](https://docs.docker.com/get-docker/)
- **Docker Compose**: [Install Docker Compose](https://docs.docker.com/compose/install/)

## Installation
1. **Backend Setup**:
    - Navigate to the backend directory:
        ```sh
        cd ./task_server
        ```
    - Build the backend project:
        ```sh
        ./gradlew build
        ```

2. **Frontend Setup**:
    - Navigate to the frontend directory:
        ```sh
        cd ./task_ui
        ```
    - Install dependencies:
        ```sh
        npm install
        ```
    - Build the frontend project:
        ```sh
        npm run build
        ```

## Running the Project
To run the project, you will need to use Docker and Docker Compose. The Docker Compose file is configured to start both the backend and frontend services along with a MongoDB instance.

1. **Run the application**:
    ```sh
    docker-compose up --build
    ```

2. **Access the application**:
    - The backend API will be available at: `http://localhost:8080`
    - The frontend application will be available at: `http://localhost:4200`

## Project Structure
The project follows a structured layout to maintain a clean and organized codebase:

```
jobsity-challenge/
├── task-server/
│   ├── src/
│   │   ├── main/
│   │   │   ├── java/
│   │   │   │   └── com/jobsity/task/
│   │   │   │       ├── customer/
│   │   │   │       │   ├── adapters/
│   │   │   │       │   │   ├── in/
│   │   │   │       │   │   └── out/
│   │   │   │       │   ├── domain/
│   │   │   │       │   │   ├── model/
│   │   │   │       │   │   └── service/
│   │   │   │       │   └── ports/
│   │   │   │       │       ├── in/
│   │   │   │       │       └── out/
│   │   │   └── resources/
│   ├── build.gradle
│   └── settings.gradle
├── task-ui/
│   ├── src/
│   │   ├── app/
│   ├── angular.json
│   ├── package.json
├── docker-compose.yml
├── mongo-init.js
└── README.md
```

- **task-server/**: Contains the backend Spring Boot application.
- **task-ui/**: Contains the frontend Angular application.
- **docker-compose.yml**: Docker Compose configuration file.

## Author
Ikaro Sales  
<ifs.sales.12@gmail.com>