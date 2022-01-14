package com.example.postbackend.service.service;

import com.example.postbackend.service.mapper.PostMapper;
import com.example.postbackend.service.mock.PostData;
import com.example.postbackend.service.repository.PostRepository;
import com.example.postbackend.service.search.PostSearch;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class PostServiceTest {
    @InjectMocks
    PostServices service;

    @Mock
    PostRepository repository;

    @Mock
    PostMapper mapper;

    @Mock
    PostSearch postSearch;

    @Test
    public void getAllPost() {
        service.getAllPosts(1, 4);
    }

    @Test
    public void getPostById() {
        service.getPostById(PostData.POST_ID);
    }

    @Test
    public void addPost() {
        service.addPost(PostData.mockPostRequest());
    }

    @Test
    public void updatePostById() {
        service.updatePostById(PostData.POST_ID, PostData.mockPostRequest());
    }

    @Test
    public void removePostById() {
        service.removePostById(PostData.POST_ID);
    }

    @Test
    public void searchPost() {
        service.searchPost("MOCK_TERM");
    }
}
