# Online Banking Management System

![Java](https://img.shields.io/badge/Java-11%2B-blue)  
![Spring Boot](https://img.shields.io/badge/Spring%20Boot-2.7-green)  
![MySQL](https://img.shields.io/badge/MySQL-8-orange)

## Table of Contents
1. [Overview](#overview)
2. [Features](#features)
3. [Technology Stack](#technology-stack)
4. [Prerequisites](#prerequisites)
5. [Installation](#installation)
6. [Project Structure](#project-structure)
7. [Usage](#usage)
    - [User Functionalities](#user-functionalities)
    - [Admin Functionalities](#admin-functionalities)
8. [JDBC Implementation Notes](#jdbc-implementation-notes)
9. [Screenshots](#screenshots)
10. [License](#license)

---

## Overview

The **Online Banking Management System** is a university project designed to simplify banking operations for users and administrators. It provides a secure and user-friendly interface for managing banking activities such as account creation, fund transfers, and transaction tracking.

Developed using **Spring Boot** for backend operations, **JDBC** for database interaction, and **HTML/CSS/JavaScript** for the frontend, the system ensures seamless and efficient banking management.

---

## Features

### User Features
- **Secure Login and Registration**: Users can sign up or log in using encrypted credentials.
- **Account Management**: View account details and update personal information.
- **Fund Transfers**: Secure and real-time fund transfers with transaction history.
- **Transaction History**: Access comprehensive records of past transactions.

### Admin Features
- **User Management**: Manage user accounts, reset passwords, and lock/unlock accounts.
- **Transaction Monitoring**: Monitor all user transactions in real time.
- **Account Settings**: Configure and update account types and limits.

---

## Technology Stack

| Layer              | Technology           |
|--------------------|----------------------|
| **Backend**        | Java, Spring Boot    |
| **Frontend**       | HTML, CSS, JavaScript |
| **Database**       | MySQL               |
| **Security**       | Spring Security     |
| **Database Access**| JDBC                |

---

## Prerequisites

Before setting up the project locally, ensure the following software is installed:

- **Java Development Kit (JDK)**: Version 11 or later.
- **Apache Maven**: For dependency management and builds.
- **MySQL**: Version 8 or later.
- **Git**: For cloning the repository.
- **IDE**: IntelliJ IDEA, Eclipse, or your preferred Java IDE.

---

## Installation

### Step 1: Clone the Repository
```bash
git clone https://github.com/Prem-Kumar-Dev/ABCD-Project.git
cd ABCD-Project
```

### Step 2: Configure the Database
1. Create a new database in MySQL (e.g., `online_banking`).
2. Update `application.properties` with your database details:
   ```properties
   spring.datasource.url=jdbc:mysql://localhost:3306/online_banking
   spring.datasource.username=your_username
   spring.datasource.password=your_password
   spring.jpa.hibernate.ddl-auto=update
   ```

### Step 3: Build the Project
Use Maven to install dependencies and package the project:
```bash
mvn clean install
```

### Step 4: Run the Application
Launch the application using:
```bash
mvn spring-boot:run
```

### Step 5: Access the Application
Visit [http://localhost:8080](http://localhost:8080) in your browser.

---

## Project Structure

```
ABCD-Project/
├── src/
│   ├── main/
│   │   ├── java/
│   │   │   └── com/example/banking/
│   │   │       ├── dao/               # Data Access Objects for JDBC
│   │   │       ├── model/             # POJOs for database entities
│   │   │       ├── servlets/          # Servlets for request handling
│   │   │       └── utils/             # JDBC connection utility
│   │   ├── resources/
│   │   │   └── db.properties          # Database configuration
│   │   ├── webapp/
│   │   │   ├── WEB-INF/
│   │   │   │   ├── web.xml            # Deployment descriptor
│   │   │   ├── index.jsp              # Entry point
│   │   │   ├── static/                # CSS, JavaScript, images
│   ├── test/                          # Unit tests
├── pom.xml                             # Maven dependencies and build config
└── README.md                           # Project documentation
```

---

## Usage

### User Functionalities
- **Registration**: Create an account to access the banking system.
- **Login**: Log in to view account details and perform transactions.
- **Fund Transfer**: Send money to other accounts securely.
- **Transaction History**: View transaction history with timestamps.

### Admin Functionalities
- **User Management**: Add, update, or deactivate user accounts.
- **Monitor Transactions**: Review transaction logs and detect anomalies.
- **System Settings**: Configure global settings for the bank.

---

## JDBC Implementation Notes

1. **Database Connection**:
   - The application uses Spring's `JdbcTemplate` for interaction with MySQL.
2. **Transaction Handling**:
   - Transactions are managed programmatically using Spring's transaction management APIs.
3. **SQL Queries**:
   - Native SQL is used for CRUD operations, optimized for MySQL.

---

## Screenshots

### Login Page
![Login Page](https://via.placeholder.com/600x400?text=Login+Page)

### Dashboard
![Dashboard](https://via.placeholder.com/600x400?text=User+Dashboard)

### Transaction History
![Transaction History](https://via.placeholder.com/600x400?text=Transaction+History)

*Note: Will replace placeholder images with actual screenshots when ready.*

---

## License

This project is licensed under [MIT License](https://opensource.org/licenses/MIT). See the LICENSE file for details.
```
