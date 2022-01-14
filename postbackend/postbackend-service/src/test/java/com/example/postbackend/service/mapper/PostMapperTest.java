package com.example.postbackend.service.mapper;

import com.example.postbackend.api.model.Post;
import com.example.postbackend.api.model.PostRequest;
import com.example.postbackend.api.model.Posts;
import com.example.postbackend.service.entity.PostEntity;
import com.example.postbackend.service.mock.PostData;
import com.example.postbackend.service.repository.PostRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;
import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostMapperTest {
    @InjectMocks
    PostMapper mapper;

    @Mock
    PostRepository repository;

    @Test
    public void ensureMapPostEntityFromPostRequestForAdd() {
        PostRequest postRequest = PostData.mockPostRequest();

        PostEntity postEntity = mapper.mapPostEntityFromPostRequest(postRequest);

        assertThat(postEntity.getId() != null, is(true));
        assertThat(postEntity.getTitle(), is(postRequest.getTitle()));
        assertThat(postEntity.getImage(), is(postRequest.getImage()));
        assertThat(postEntity.getContent(), is(postRequest.getContent()));
        assertThat(postEntity.getCategory(), is(postRequest.getCategory().name()));
        assertThat(postEntity.getCreateAt() != null, is(true));
        assertThat(postEntity.getUpdateAt() != null, is(true));
    }

    @Test
    public void ensureMapPostEntityFromPostRequestForUpdate() {
        PostEntity entity = PostData.mockPostEntity();

        when(repository.getOne(PostData.POST_ID)).thenReturn(entity);

        PostRequest postRequest = PostData.mockPostRequest();
        PostEntity postEntity = mapper.mapPostEntityFromPostRequest(PostData.POST_ID, postRequest);

        assertThat(postEntity.getId(), is(entity.getId()));
        assertThat(postEntity.getTitle(), is(postRequest.getTitle()));
        assertThat(postEntity.getImage(), is(postRequest.getImage()));
        assertThat(postEntity.getContent(), is(postRequest.getContent()));
        assertThat(postEntity.getCategory(), is(postRequest.getCategory().name()));
        assertThat(postEntity.getCreateAt() != null, is(true));
        assertThat(postEntity.getUpdateAt() != null, is(true));
    }

    @Test
    public void ensureMapPostFromPostEntity() {
        PostEntity postEntity = PostData.mockPostEntity();
        Post post = mapper.mapPostFromPostEntity(postEntity);

        assertPost(post, postEntity);
    }

    @Test
    public void ensureMapPostsFromPostsEntity() {
        List<PostEntity> postEntities = PostData.mockPostEntities();
        Posts posts = mapper.mapPostsFromPostEntities(postEntities);

        assertPosts(posts, postEntities);
    }

    private void assertPost(Post actual, PostEntity input) {
        assertThat(actual.getId(), is(input.getId()));
        assertThat(actual.getTitle(), is(input.getTitle()));
        assertThat(actual.getImage(), is(input.getImage()));
        assertThat(actual.getContent(), is(input.getContent()));
        assertThat(actual.getCategory().name(), is(input.getCategory()));
        assertThat(actual.getCreateAt(), is(input.getCreateAt().toLocalDateTime().toString()));
        assertThat(actual.getUpdateAt(), is(input.getUpdateAt().toLocalDateTime().toString()));
    }

    private void assertPosts(Posts actual, List<PostEntity> input) {
        assertPost(actual.get(0), input.get(0));
    }
}
