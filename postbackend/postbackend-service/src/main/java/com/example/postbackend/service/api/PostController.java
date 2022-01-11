package com.example.postbackend.service.api;

import com.example.postbackend.api.PostsApi;
import com.example.postbackend.api.model.Post;
import com.example.postbackend.api.model.PostRequest;
import com.example.postbackend.api.model.Posts;
import com.example.postbackend.service.service.PostServices;
import com.example.postbackend.service.validator.PostValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post/backend/v1")
@CrossOrigin
public class PostController implements PostsApi {
    private final PostServices service;
    private final PostValidator validator;

    @Autowired
    public PostController(PostServices service, PostValidator validator) {
        this.service = service;
        this.validator = validator;
    }

    @Override
    public ResponseEntity<Posts> getAllPosts(String apikey, Integer page, Integer limit) {
        Posts response = service.getAllPosts(page, limit);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Post> addPost(String apikey, PostRequest request) {
        validator.validateAddPost(request);
        Post response = service.addPost(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Post> getPostById(String apikey, String postId) {
        Post response = service.getPostById(postId);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Post> updatePostById(String apikey, String postId, PostRequest request) {
        validator.validateUpdatePost(postId, request);
        Post response = service.updatePostById(postId, request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> removePostById(String apikey, String postId) {
        service.removePostById(postId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
