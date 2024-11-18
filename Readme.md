# Online Banking Management System

## Overview

The **Online Banking Management System** is a web-based application designed to allow users to manage their banking activities online. Developed as a university project, this system utilizes Java Spring Boot for backend services, HTML, CSS, and JavaScript for frontend development, and JDBC with MySQL for database operations.

### Features

- **User Registration and Login**: Secure user and admin authentication.
- **Account Management**: Create, view, and manage bank accounts.
- **Fund Transfers**: Transfer funds between accounts with transaction tracking.
- **Transaction History**: View detailed transaction history.
- **Admin Panel**: Manage users, accounts, and system settings.
- **Security Features**: Data protection via encryption and access control.

## Technology Stack

- **Backend**: Java, Spring Boot, JDBC
- **Frontend**: HTML, CSS, JavaScript
- **Database**: MySQL
- **Tools & Libraries**: 
  - Spring Security (for authentication and authorization)
  - JDBC (for database connectivity and operations)

## Prerequisites

To set up this project locally, you’ll need:

- **Java Development Kit (JDK)**: Version 11 or later
- **Maven**: For dependency management
- **MySQL**: Database management system
- **IDE**: Recommended IntelliJ IDEA or Eclipse
- **Git**: For version control

## Installation

### 1. Clone the Repository

```bash
git clone https://github.com/Prem-Kumar-Dev/ABCD-Project.git
cd ABCD-Project
```

### 2. Configure the Database [In Progress]

Create a new database in MySQL, then update your `application.properties` file to configure the database connection.

```properties
# application.properties
spring.datasource.url=jdbc:mysql://localhost:3306/your_database_name
spring.datasource.username=your_username
spring.datasource.password=your_password
spring.datasource.driver-class-name=com.mysql.cj.jdbc.Driver
spring.jpa.hibernate.ddl-auto=update
```

### 3. Build the Project

Use Maven to install dependencies and build the project:

```bash
mvn clean install
```

### 4. Run the Application

Run the application using Maven:

```bash
mvn spring-boot:run
```

### 5. Access the Application

Open your browser and go to `http://localhost:8080` to access the Online Banking Management System.

## Project Structure

```
ABCD-Project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/banking/  # Java classes for controllers, services, and JDBC operations
│   │   ├── resources/
│   │   │   ├── templates/            # HTML templates
│   │   │   └── static/               # CSS, JS, and images
│   └── test/                         # Unit and integration tests
├── pom.xml                           # Maven configuration file
└── README.md
```

## Usage

### User Functionalities

- **Register**: Create a new user account.
- **Login**: Access account details securely.
- **Fund Transfers**: Transfer funds to another account.
- **Transaction History**: View transaction records and history.

### Admin Functionalities

- **Manage Accounts**: Create, edit, and delete accounts.
- **Monitor Transactions**: Track and monitor transactions.
- **User Management**: Admin control over user accounts.

## JDBC Implementation Notes

- **Database Connection**: Uses Spring's `JdbcTemplate` to connect to MySQL.
- **SQL Queries**: SQL queries are used to insert, update, and retrieve data.
- **Transaction Management**: Ensures data consistency, especially for fund transfers, with transaction handling via Spring.

