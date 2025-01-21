package com.example.OBMS.dao;

import static org.junit.jupiter.api.Assertions.*;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import com.example.OBMS.model.Admin;

public class AdminDAOTest {

    private AdminDAO adminDAO;

    @BeforeEach
    public void setUp() throws SQLException {
        // Assuming you have a proper JDBC URL, username, and password
        String jdbcURL = "jdbc:mysql://localhost:3306/yourdb";
        String jdbcUsername = "root";
        String jdbcPassword = "password";

        Connection connection = DriverManager.getConnection(jdbcURL, jdbcUsername, jdbcPassword);
        adminDAO = new AdminDAO(connection);
    }

    @Test
    public void testAddAdmin() throws SQLException {
        Admin admin = new Admin();
        admin.setName("Test Admin");
        admin.setEmail("testadmin@example.com");
        admin.setPassword("password123");
        admin.setPhoneNumber("1234567890");
        admin.setRole("ADMIN");
        admin.setStatus("ACTIVE");

        adminDAO.addAdmin(admin);

        Admin retrievedAdmin = adminDAO.getAdminById(admin.getAdminId());
        assertNotNull(retrievedAdmin);
        assertEquals("Test Admin", retrievedAdmin.getName());
    }

    @Test
    public void testGetAdminById() throws SQLException {
        Admin admin = adminDAO.getAdminById(1);  // Assuming there's an admin with ID 1
        assertNotNull(admin);
        assertEquals("root@example.com", admin.getEmail());
    }

    @Test
    public void testUpdateAdmin() throws SQLException {
        Admin admin = adminDAO.getAdminById(1);
        admin.setName("Updated Admin Name");
        adminDAO.updateAdmin(admin);

        Admin updatedAdmin = adminDAO.getAdminById(1);
        assertEquals("Updated Admin Name", updatedAdmin.getName());
    }

    @Test
    public void testDeleteAdmin() throws SQLException {
        Admin admin = adminDAO.getAdminById(1);  // Assuming there's an admin with ID 1
        adminDAO.deleteAdmin(admin.getAdminId());

        Admin deletedAdmin = adminDAO.getAdminById(1);
        assertNull(deletedAdmin);
    }
}
