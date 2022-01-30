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

    public ResultSet getResultSet() {
        try {
            conn = connection.setConnection();
            statement = conn.prepareStatement(Queries.GET_ALL_TODOS);
            resultSet = statement.executeQuery();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return resultSet;
    }
}
