package main.java.com.example.OBMS.dao;

import main.java.com.example.OBMS.model.Admin;

import java.sql.*;
import java.util.ArrayList;
import java.util.List;

public class AdminDAO {

    private final Connection connection;

    public AdminDAO(Connection connection) {
        this.connection = connection;
    }

    // Add a new admin
    public void addAdmin(Admin admin) throws SQLException {
        String sql = "INSERT INTO admin (name, email, password, phone_number, role, status) VALUES (?, ?, ?, ?, ?, ?)";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, admin.getName());
            statement.setString(2, admin.getEmail());
            statement.setString(3, admin.getPassword());
            statement.setString(4, admin.getPhoneNumber());
            statement.setString(5, admin.getRole());
            statement.setString(6, admin.getStatus());
            statement.executeUpdate();
        }
    }

    // Get all admins
    public List<Admin> getAllAdmins() throws SQLException {
        List<Admin> admins = new ArrayList<>();
        String sql = "SELECT * FROM admin";
        try (Statement statement = connection.createStatement();
             ResultSet resultSet = statement.executeQuery(sql)) {
            while (resultSet.next()) {
                Admin admin = new Admin();
                admin.setAdminId(resultSet.getInt("admin_id"));
                admin.setName(resultSet.getString("name"));
                admin.setEmail(resultSet.getString("email"));
                admin.setPassword(resultSet.getString("password"));
                admin.setPhoneNumber(resultSet.getString("phone_number"));
                admin.setRole(resultSet.getString("role"));
                admin.setStatus(resultSet.getString("status"));
                admins.add(admin);
            }
        }
        return admins;
    }

    // Get an admin by ID
    public Admin getAdminById(int adminId) throws SQLException {
        String sql = "SELECT * FROM admin WHERE admin_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, adminId);
            try (ResultSet resultSet = statement.executeQuery()) {
                if (resultSet.next()) {
                    Admin admin = new Admin();
                    admin.setAdminId(resultSet.getInt("admin_id"));
                    admin.setName(resultSet.getString("name"));
                    admin.setEmail(resultSet.getString("email"));
                    admin.setPassword(resultSet.getString("password"));
                    admin.setPhoneNumber(resultSet.getString("phone_number"));
                    admin.setRole(resultSet.getString("role"));
                    admin.setStatus(resultSet.getString("status"));
                    return admin;
                }
            }
        }
        return null;
    }

    // Update admin details
    public void updateAdmin(Admin admin) throws SQLException {
        String sql = "UPDATE admin SET name = ?, email = ?, password = ?, phone_number = ?, role = ?, status = ? WHERE admin_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setString(1, admin.getName());
            statement.setString(2, admin.getEmail());
            statement.setString(3, admin.getPassword());
            statement.setString(4, admin.getPhoneNumber());
            statement.setString(5, admin.getRole());
            statement.setString(6, admin.getStatus());
            statement.setInt(7, admin.getAdminId());
            statement.executeUpdate();
        }
    }

    // Delete an admin by ID
    public void deleteAdmin(int adminId) throws SQLException {
        String sql = "DELETE FROM admin WHERE admin_id = ?";
        try (PreparedStatement statement = connection.prepareStatement(sql)) {
            statement.setInt(1, adminId);
            statement.executeUpdate();
        }
    }
}
