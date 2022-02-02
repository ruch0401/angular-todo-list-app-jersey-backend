package com.example.controllers;

import com.example.model.Post;
import com.example.service.PostService;

import javax.ws.rs.GET;
import javax.ws.rs.Path;
import javax.ws.rs.PathParam;
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

    @GET
    @Path("{id}")
    @Produces(MediaType.APPLICATION_JSON)
    public Post getPost(@PathParam("id") String id) {
        return postService.getPost(Integer.parseInt(id));
    }
}
