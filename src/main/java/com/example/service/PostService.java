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
                String text = rs.getString(2);
                String day = rs.getString(3);
                boolean reminder = rs.getBoolean(4);
                Post p = new Post(text, day, reminder);
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
                String text = rs.getString(2);
                String day = rs.getString(3);
                boolean reminder = rs.getBoolean(4);
                return new Post(text, day, reminder);
            }
        } catch (SQLException ex) {
            ex.printStackTrace();
        }
        return null;
    }

    public int addPost(Post post) {
        String text = post.getText();
        String day = post.getDay();
        boolean reminder = post.isReminder();
        String sql = String.format("INSERT INTO todoschema.todotable (text, day, reminder) VALUES ('%s','%s', %s)",text, day, reminder);
        return postDAO.insertOrUpdate(sql);
    }

    public int updatePost(int id, Post post) {
        String text = post.getText();
        String day = post.getDay();
        boolean reminder = post.isReminder();
        String sql = String.format("UPDATE todoschema.todotable SET text='%s', day='%s', reminder=%s WHERE id=%d;",text, day, reminder, id);
        return postDAO.insertOrUpdate(sql);
    }
}
