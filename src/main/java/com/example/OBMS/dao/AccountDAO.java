package main.java.com.example.OBMS.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class AccountDAO {
    private Connection connection;

    public AccountDAO(Connection connection) {
        this.connection = connection;
    }

    public void addAccount(String name, String email, double balance) throws SQLException {
        String query = "INSERT INTO accounts (name, email, balance) VALUES (?, ?, ?)";
        try (PreparedStatement stmt = connection.prepareStatement(query)) {
            stmt.setString(1, name);
            stmt.setString(2, email);
            stmt.setDouble(3, balance);
            stmt.executeUpdate();
        }
    }
}
