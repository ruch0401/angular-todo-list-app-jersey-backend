package com.example.service;

import com.example.database.PostDAO;
import com.example.model.Post;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

public class PostService {

    PostDAO postDAO = new PostDAO();

    public List<Post> getPosts() {
        List<Post> posts = new ArrayList<>();
        try {
            ResultSet rs = postDAO.getResultSet("SELECT * FROM todoschema.todotable");
            while (rs.next()) {
                int id = rs.getInt(1);
                String text = rs.getString(2);
                String day = rs.getString(3);
                boolean reminder = rs.getBoolean(4);
                Post p = new Post(id, text, day, reminder);
                posts.add(p);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return posts;
    }

    public Post getPost(int id) {
        try {
            String sql = String.format("SELECT * FROM todoschema.todotable WHERE id = %d", id);
            ResultSet rs = postDAO.getResultSet(sql);
            while (rs.next()) {
                int tid = rs.getInt(1);
                String text = rs.getString(2);
                String day = rs.getString(3);
                boolean reminder = rs.getBoolean(4);
                return new Post(tid, text, day, reminder);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }
}
