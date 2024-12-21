package com.example.OBMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import com.example.OBMS.model.User;
import com.example.OBMS.utils.DBConnection;

public class UserDAO {
    private static final String INSERT_USER = "INSERT INTO User (name, email, password, phone_number, account_balance, status) VALUES (?, ?, ?, ?, ?, ?)";
    private static final String SELECT_USER_BY_ID = "SELECT * FROM User WHERE user_id = ?";
    private static final String SELECT_USER_BY_EMAIL = "SELECT * FROM User WHERE email = ?"; // Query for email
    private static final String SELECT_ALL_USERS = "SELECT * FROM User";
    private static final String UPDATE_USER = "UPDATE User SET name = ?, email = ?, phone_number = ?, account_balance = ?, status = ? WHERE user_id = ?";
    private static final String DELETE_USER = "DELETE FROM User WHERE user_id = ?";

    public void addUser(User user) throws SQLException {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(INSERT_USER)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPassword());
            stmt.setString(4, user.getPhoneNumber());
            stmt.setBigDecimal(5, user.getAccountBalance());
            stmt.setString(6, user.getStatus());
            stmt.executeUpdate();
        }
    }

    public User getUserById(int userId) throws SQLException {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_USER_BY_ID)) {
            stmt.setInt(1, userId);
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapToUser(rs);
            }
        }
        return null;
    }

    public User getUserByEmail(String email) throws SQLException {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(SELECT_USER_BY_EMAIL)) {
            stmt.setString(1, email); // Set email parameter
            ResultSet rs = stmt.executeQuery();
            if (rs.next()) {
                return mapToUser(rs); // Map result set to User object
            }
        }
        return null; // Return null if no user found
    }

    public List<User> getAllUsers() throws SQLException {
        List<User> users = new ArrayList<>();
        try (Connection conn = DBConnection.getConnection();
             Statement stmt = conn.createStatement();
             ResultSet rs = stmt.executeQuery(SELECT_ALL_USERS)) {
            while (rs.next()) {
                users.add(mapToUser(rs));
            }
        }
        return users;
    }

    public void updateUser(User user) throws SQLException {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(UPDATE_USER)) {
            stmt.setString(1, user.getName());
            stmt.setString(2, user.getEmail());
            stmt.setString(3, user.getPhoneNumber());
            stmt.setBigDecimal(4, user.getAccountBalance());
            stmt.setString(5, user.getStatus());
            stmt.setInt(6, user.getUserId());
            stmt.executeUpdate();
        }
    }

    public void deleteUser(int userId) throws SQLException {
        try (Connection conn = DBConnection.getConnection();
             PreparedStatement stmt = conn.prepareStatement(DELETE_USER)) {
            stmt.setInt(1, userId);
            stmt.executeUpdate();
        }
    }

    private User mapToUser(ResultSet rs) throws SQLException {
        User user = new User();
        user.setUserId(rs.getInt("user_id"));
        user.setName(rs.getString("name"));
        user.setEmail(rs.getString("email"));
        user.setPassword(rs.getString("password"));
        user.setPhoneNumber(rs.getString("phone_number"));
        user.setAccountBalance(rs.getBigDecimal("account_balance"));
        user.setCreatedAt(rs.getTimestamp("created_at"));
        user.setUpdatedAt(rs.getTimestamp("updated_at"));
        user.setStatus(rs.getString("status"));
        return user;
    }
}
