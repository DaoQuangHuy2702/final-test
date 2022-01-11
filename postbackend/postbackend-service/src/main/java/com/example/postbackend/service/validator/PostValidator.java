package com.example.postbackend.service.validator;

import com.example.postbackend.api.model.PostRequest;
import com.example.postbackend.service.exception.BadRequestException;
import com.example.postbackend.service.exception.EntityNotFoundException;
import com.example.postbackend.service.repository.PostRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class PostValidator {
    private static final String POST_DOES_NOT_EXIST = "Post does not exist";
    private static final String TITLE_REQUEST = "Post title is required";
    private static final String CATEGORY_REQUEST = "Post category is required";
    private final PostRepository repo;

    @Autowired
    public PostValidator(PostRepository repo) {
        this.repo = repo;
    }

    private void validatePostExist(String id) {
        if(repo.existsById(id)) {
            return;
        }
        throw new EntityNotFoundException(POST_DOES_NOT_EXIST);
    }

    private void checkRequiredField(String value, String msgError) {
        if(value == null || value.trim().isEmpty()) {
            throw new BadRequestException(msgError);
        }
    }

    public void validateAddPost(PostRequest request) {
        checkRequiredField(request.getTitle(), TITLE_REQUEST);
        checkRequiredField(request.getCategory().name(), CATEGORY_REQUEST);
    }

    public void validateUpdatePost(String id, PostRequest request) {
        validatePostExist(id);
        checkRequiredField(request.getTitle(), TITLE_REQUEST);
        checkRequiredField(request.getCategory().name(), CATEGORY_REQUEST);
    }

}
