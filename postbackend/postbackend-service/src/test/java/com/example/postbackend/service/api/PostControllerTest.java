package com.example.postbackend.service.api;

import com.example.postbackend.api.model.Post;
import com.example.postbackend.api.model.PostRequest;
import com.example.postbackend.api.model.Posts;
import com.example.postbackend.service.mock.PostData;
import com.example.postbackend.service.service.PostServices;
import com.example.postbackend.service.validator.PostSearchValidator;
import com.example.postbackend.service.validator.PostValidator;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.*;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostControllerTest {
    private final String API_KEY = "MOCK_API_KEY";

    @InjectMocks
    PostController controller;

    @Mock
    PostServices service;

    @Mock
    PostValidator validator;

    @Mock
    PostSearchValidator searchValidator;

    @Test
    public void testEndpointGetAllPosts() {
        when(service.getAllPosts(anyInt(), anyInt())).thenReturn(PostData.mockPosts());

        ResponseEntity<Posts> responseEntity = controller.getAllPosts(API_KEY, 1, 4);
        assertStatus200(responseEntity.getStatusCode());
        assertPosts(responseEntity.getBody());
    }

    @Test
    public void testEndpointGetPostById() {
        when(service.getPostById(anyString())).thenReturn(PostData.mockPost());

        ResponseEntity<Post> responseEntity = controller.getPostById(API_KEY, PostData.POST_ID);
        assertStatus200(responseEntity.getStatusCode());
        assertPost(responseEntity.getBody());
    }

    @Test
    public void testEndpointAddPost() {
        when(service.addPost(any(PostRequest.class))).thenReturn(PostData.mockPost());

        ResponseEntity<Post> responseEntity = controller.addPost(API_KEY, PostData.mockPostRequest());
        assertStatus200(responseEntity.getStatusCode());
        assertPost(responseEntity.getBody());
    }

    @Test
    public void testEndpointUpdatePostById() {
        when(service.updatePostById(anyString(), any(PostRequest.class))).thenReturn(PostData.mockPost());
        ResponseEntity<Post> responseEntity = controller.updatePostById(API_KEY, PostData.POST_ID, PostData.mockPostRequest());

        assertStatus200(responseEntity.getStatusCode());
        assertPost(responseEntity.getBody());
    }

    @Test
    public void testEndpointRemovePostById() {
        ResponseEntity<Void> responseEntity = controller.removePostById(API_KEY, PostData.POST_ID);
        assertStatus200(responseEntity.getStatusCode());
    }

    @Test
    public void testEndpointSearchPost() {
        when(service.searchPost(anyString())).thenReturn(PostData.mockPosts());
        ResponseEntity<Posts> responseEntity = controller.searchPost(API_KEY, "MOCK_TERM");
        assertStatus200(responseEntity.getStatusCode());
        assertPosts(responseEntity.getBody());
    }

    private void assertPost(Post actual) {
        assertThat(actual.getId(), is(PostData.POST_ID));
        assertThat(actual.getTitle(), is(PostData.TITLE));
        assertThat(actual.getImage(), is(PostData.IMAGE));
        assertThat(actual.getContent(), is(PostData.CONTENT));
        assertThat(actual.getCategory().name(), is(PostData.CATEGORY));
        assertThat(actual.getCreateAt(), is(PostData.CREATE_AT));
        assertThat(actual.getUpdateAt(), is(PostData.UPDATE_AT));
    }

    private void assertPosts(Posts actual) {
        assertPost(actual.get(0));
    }


    private void assertStatus200(HttpStatus actual) {
        assertThat(actual, is(HttpStatus.OK));
    }
}
