package com.example.database;

import java.sql.*;

public class MyDBConnection {
    private static String JDBC_URL = "jdbc:postgresql://localhost:5432/tododb";

    public static void main(String[] args) {
        try {
            Class.forName("org.postgresql.Driver");
            Connection connection = DriverManager.getConnection(JDBC_URL);
            System.out.println("Successfully connected to POSTGRESQL DB");

            PreparedStatement statement = connection.prepareStatement("select * from todoschema.todotable");
            ResultSet rs = statement.executeQuery();

            while (rs.next()) {
                String sb = rs.getString(1) + "\n" +
                        rs.getString(2) + "\n" +
                        rs.getString(3) + "\n" +
                        rs.getString(4) + "\n";
                System.out.println(sb);
            }
            connection.close();
        } catch (SQLException ex) {
            System.out.println("Error occurred while connecting to POSTGRESQL DB");
            ex.printStackTrace();
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
