package com.example.postbackend.service.validator;

import com.example.postbackend.api.model.PostRequest;
import com.example.postbackend.service.exception.BadRequestException;
import com.example.postbackend.service.exception.EntityNotFoundException;
import com.example.postbackend.service.mock.PostData;
import com.example.postbackend.service.repository.PostRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import static org.mockito.Mockito.when;

@RunWith(MockitoJUnitRunner.class)
public class PostValidatorTest {
    @InjectMocks
    PostValidator validator;

    @Mock
    PostRepository repository;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void validateUpdatePost() {
        when(repository.existsById(PostData.POST_ID)).thenReturn(true);
        validator.validateUpdatePost(PostData.POST_ID, PostData.mockPostRequest());
    }

    @Test
    public void validateUpdatePostShowExceptionWhenWrongId() {
        expected.expect(EntityNotFoundException.class);
        expected.expectMessage("Post does not exist");

        when(repository.existsById(PostData.POST_ID)).thenReturn(false);
        validator.validateUpdatePost(PostData.POST_ID, PostData.mockPostRequest());
    }

    @Test
    public void validateAddPost() {
        validator.validateAddPost(PostData.mockPostRequest());
    }

    @Test
    public void validateAddPostShowExceptionWhenTitleFieldIsNull() {
        expected.expect(BadRequestException.class);
        expected.expectMessage("Post title is required");

        PostRequest postRequest = PostData.mockPostRequest();
        postRequest.setTitle("");
        validator.validateAddPost(postRequest);
    }
}
