package com.example.postbackend.service.it.steps;

import com.example.postbackend.client.api.PostsApi;
import com.example.postbackend.client.model.Post;
import com.example.postbackend.client.model.PostRequest;
import cucumber.api.java.Before;
import cucumber.api.java.en.Given;
import cucumber.api.java.en.Then;
import cucumber.api.java.en.When;

import org.springframework.web.client.RestClientException;

import static org.hamcrest.CoreMatchers.is;
import static org.junit.Assert.assertThat;


public class PostSteps extends CommonStepConfiguration{
    protected PostsApi postApi;
    private RestClientException restClientException;
    private PostRequest postRequest;
    private Post post;

    private final String API_KEY = "2347edfd-c55c-4f59-96ee-600492f904f3";

    @Before
    public void setup() {
        super.setup();
        postApi = new PostsApi(baseApiClient);
    }

    @Given("^user request to add post with \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\" \"([^\"]*)\"$")
    public void userRequestToAddPostWith(String title, String image, String content, String category) {
        postRequest = createPostRequest(title, image, content, category);
    }

    @When("^user do action add post$")
    public void userDoActionAddPost() {
        try{
            post = postApi.addPost(API_KEY, postRequest);
        } catch(RestClientException e) {
            restClientException = e;
        }
    }

    @Then("^user action create post successful with \"([^\"]*)\"$")
    public void userActionIsSuccessfulWith(String code) {
        assertThat(postApi.getApiClient().getStatusCode().value(), is(Integer.valueOf(code)));
    }

    @Then("^user action create post failed with \"([^\"]*)\"$")
    public void userActionIsFailedWith(String code) {
        assertThat(getExceptionStatusCode(restClientException), is(code));
    }

    private PostRequest createPostRequest(String title, String image, String content, String category) {
        PostRequest postRequest = new PostRequest();

        postRequest.setTitle(title);
        postRequest.setImage(image);
        postRequest.setContent(content);
        postRequest.setCategory(PostRequest.CategoryEnum.fromValue(category));
        postRequest.setContent(content);

        return postRequest;
    }

}
