package com.example.controllers;

import com.example.model.Post;
import com.example.service.PostService;

import javax.ws.rs.*;
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

    @POST
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public int addPost(Post post) {
        return postService.addPost(post);
    }

    @PUT
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public int updatePost(@PathParam("id") String id, Post post) {
        return postService.updatePost(Integer.parseInt(id), post);
    }

    @DELETE
    @Path("{id}")
    @Consumes(MediaType.APPLICATION_JSON)
    @Produces(MediaType.TEXT_PLAIN)
    public int deletePost(@PathParam("id") String id) {
        return postService.deletePost(Integer.parseInt(id));
    }
}
