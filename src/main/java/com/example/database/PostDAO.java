package com.example.database;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;

public class PostDAO {

    DBConnection connection = new DBConnection();
    Connection conn = null;
    PreparedStatement statement = null;
    ResultSet resultSet = null;

    public ResultSet getResultSet(String sql) {
        try {
            conn = connection.setConnection();
            statement = conn.prepareStatement(sql);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }

    public int insertUpdateOrDelete(String sql) {
        conn = connection.setConnection();
        try {
            return conn.prepareStatement(sql).executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        System.out.println("Unsuccessful insert or update");
        return -1;
    }
}
