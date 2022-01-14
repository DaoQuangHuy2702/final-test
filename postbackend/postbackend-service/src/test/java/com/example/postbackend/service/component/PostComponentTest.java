package com.example.postbackend.service.component;


import com.example.postbackend.client.api.PostsApi;
import com.example.postbackend.client.handler.ApiClient;
import com.example.postbackend.client.model.Post;
import com.example.postbackend.client.model.PostRequest;
import org.junit.Before;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.TestPropertySource;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.web.client.HttpClientErrorException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;

@RunWith(SpringRunner.class)
@TestPropertySource("/application-test.properties")
@SpringBootTest(webEnvironment = SpringBootTest.WebEnvironment.RANDOM_PORT)
public class PostComponentTest {
    private static final String API_KEY = "2347edfd-c55c-4f59-96ee-600492f904f3";
    private static final String HTTP_LOCALHOST = "http://localhost:";
    private static final String BASE_PATH = "/post/backend/v1";

    public static final String POST_ID = "2347edfd-c11c-4f59-96ee-600492f933f3";
    public static final String TITLE = "ReactJS Become a professional in web app development";
    public static final String IMAGE = "https://images-na.ssl-images-amazon.com/images/I/41ith8XYqwS._SX331_BO1,204,203,200_.jpg";
    public static final String CONTENT = "industrys standard dummy texter since the 1500s, when an unknown printer took a galley of type and scrambled";
    public static final String CATEGORY = "ART";

    private PostsApi api;

    @Rule
    public ExpectedException thrown = ExpectedException.none();

    @LocalServerPort
    private int port;

    @Before
    public void setup() {
        String url = HTTP_LOCALHOST + port + BASE_PATH;
        ApiClient client = new ApiClient();
        client.setBasePath(url);
        api = new PostsApi(client);
    }

    @Test
    public void ensurePostAdded() {
        Post post = api.addPost(API_KEY, mockPostRequest());
    }

    @Test
    public void ensurePostAddThrowExceptionWhenTitleFieldNotPass() {
        thrown.expect(HttpClientErrorException.class);
        PostRequest bookRequest = mockPostRequest();
        bookRequest.setTitle("");

        api.addPost(API_KEY, bookRequest);
    }

    @Test
    public void ensurePostUpdated() {
        Post post = api.updatePostById(API_KEY, POST_ID, mockPostRequest());
        assertPost(post);
    }

    @Test
    public void ensurePostUpdateThrowExceptionWhenWrongPassed() {
        thrown.expect(HttpClientErrorException.class);

        PostRequest postRequest = mockPostRequest();
        postRequest.setTitle("");
        api.updatePostById(API_KEY, POST_ID + "FAKE", postRequest);
    }

    private void assertPost(Post actual) {
        assertThat(actual.getId() != null, is(true));
        assertThat(actual.getTitle(), is(TITLE));
        assertThat(actual.getImage(), is(IMAGE));
        assertThat(actual.getContent(), is(CONTENT));
        assertThat(actual.getCategory().getValue(), is(CATEGORY));
        assertThat(actual.getCreateAt() != null, is(true));
        assertThat(actual.getUpdateAt() != null, is(true));
    }

    private PostRequest mockPostRequest() {
        PostRequest postRequest = new PostRequest();

        postRequest.setTitle(TITLE);
        postRequest.setImage(IMAGE);
        postRequest.setContent(CONTENT);
        postRequest.setCategory(PostRequest.CategoryEnum.fromValue(CATEGORY));

        return postRequest;
    }
}
