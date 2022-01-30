package com.example.controllers;

import com.example.model.Post;
import com.example.service.PostService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.Produces;
import javax.ws.rs.core.MediaType;
import java.util.List;

@Path("posts")
public class PostResource {

    PostService postService = new PostService();

    @GET
    @Produces(MediaType.APPLICATION_JSON)
    public List<Post> getPosts() {
        return postService.getPosts();
    }
}
