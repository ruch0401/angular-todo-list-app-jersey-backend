package com.example.database;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class DBConnection {
    Connection connection = null;

    DBConnection() {
        try {
            Class.forName("org.postgresql.Driver");
            System.out.println("Postgres Driver loaded successfully");
        } catch (ClassNotFoundException e) {
            System.out.println("Unable to find Postgres driver");
            e.printStackTrace();
        }
    }

    public Connection setConnection() {
        try {
            connection = DriverManager.getConnection(DBProperties.JDBC_URL);
        } catch (SQLException e) {
            System.out.println("Error while establishing connection with PostgreSQL");
            e.printStackTrace();
        }
        return connection;
    }
}
