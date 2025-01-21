# **Project Documentation for Online Banking Management System**

## **1. Introduction**
The Online Banking Management System (OBMS) is a comprehensive web application designed to simplify and secure banking operations for both users and administrators. Built using Java Spring Boot and JSP, the application offers features such as user registration, login, account management, and transaction tracking.

---

## **2. Directory Structure Overview**
The project is organized into a structured directory to ensure maintainability and scalability.

### **Root Directory**
- **Readme.md**: Project overview and usage instructions.
- **Online_banking.pptx**: Project presentation.
- **bank.css, bank.html, bank.js**: Static files for the main banking interface.
- **pom.xml**: Maven configuration file.
- **mvnw/**: Maven wrapper scripts.

### **Source Code Directory (`src/`)**

#### **1. Main Directory (`src/main/`)**
- **Java Classes (`java/com/example/OBMS/`)**:
  - **OBMS.java**: Main application class.
  - **dao/**: Data Access Objects for interacting with the database.
    - **AdminDAO.java**: Manages administrator database operations.
    - **UserDAO.java**: Handles user-related database transactions.
  - **model/**: Data models representing database entities.
    - **Admin.java**: Admin model.
    - **User.java**: User model.
  - **servlets/**: Handles HTTP requests and responses.
    - **AdminServlet.java**: Administrator-related requests.
    - **UserServlet.java**: User-related requests.
    - Other servlets handle login, registration, and navigation.
  - **utils/DBConnection.java**: Manages database connections.

- **Resources (`resources/`)**:
  - **Configuration Files**:
    - **application.properties, application.yml**: Spring Boot configurations.
    - **db.properties**: Database connection properties.
  - **SQL Files**:
    - **admin.sql**: Schema and data for admin operations.
    - **user.sql**: Schema and data for user operations.
    - **schema.sql**: Complete database schema.

- **Web Application (`webapp/`)**:
  - **JSP Files**:
    - **admins.jsp, index.jsp, users.jsp**: Dynamic web pages.
  - **WEB-INF/web.xml**: Deployment descriptor.

#### **2. Static Assets (`webapp/static/`)**
Organized into feature-based directories:
  - **Admin/**: Admin dashboard assets (HTML, CSS, JS).
  - **Cover/**: Landing page assets.
  - **Login/**: Login page assets.
  - **Main/**: Main application assets.
  - **Register/**: User registration assets.
  - **Table/**: Table view assets.

#### **3. Templates (`webapp/templates/`)**
  - **Main/index.html**: Main application page template.
  - **Table/index.html**: Transaction table page template.

#### **4. Tests (`test/java/com/example/OBMS/`)**
- **Unit Tests**:
  - **OBMSTest.java**: Tests main application logic.
  - **dao/**: Tests for DAOs.
    - **AdminDAOTest.java**: Admin DAO tests.
    - **UserDAOTest.java**: User DAO tests.

---

## **3. Key Features**

### **1. User Features**
- User registration and login.
- View current balance, deposits, and withdrawals.
- Perform deposits and withdrawals.
- View transaction history.

### **2. Admin Features**
- Manage user accounts.
- Monitor transactions.
- Generate reports.

### **3. Technical Highlights**
- Secure database connection with JDBC.
- Modular design with DAO pattern.
- JSP for dynamic content rendering.
- CSS and JS for a responsive and interactive UI.

---

## **4. Tools and Technologies**
- **Backend**: Java Spring Boot, JSP.
- **Frontend**: HTML, CSS, JavaScript.
- **Database**: MySQL.
- **Build Tool**: Maven.
- **Testing**: JUnit.
- **Version Control**: Git.

---

## **5. Setup Instructions**

### **1. Prerequisites**
- Java JDK 11 or higher.
- MySQL Server.
- Apache Tomcat (if deploying manually).
- Maven.

### **2. Steps to Run**
1. Clone the repository:
   ```bash
   git clone https://github.com/Prem-Kumar-Dev/ABCD-Project.git
   ```
2. Configure the database:
   - Import the `schema.sql`, `admin.sql`, and `user.sql` files into MySQL.
   - Update database credentials in `db.properties`.
3. Build the project:
   ```bash
   mvn clean install
   ```
4. Run the application:
   ```bash
   mvn spring-boot:run
   ```
5. Access the application at `http://localhost:8080`.

---

## **6. Future Enhancements**
- Add password encryption for enhanced security.
- Implement multi-factor authentication.
- Provide RESTful APIs for external integrations.
- Add analytics dashboards for admins.

---

## **7. References**
- [Spring Boot Documentation](https://spring.io/projects/spring-boot)
- [JDBC Guide](https://docs.oracle.com/javase/tutorial/jdbc/)
- [Maven Documentation](https://maven.apache.org/guides/index.html)

---

## **8. Conclusion**
The Online Banking Management System provides a robust, user-friendly, and scalable solution for modern banking needs. With its modular design and clear separation of concerns, it serves as a strong foundation for future enhancements.

