package com.example.postbackend.service.validator;

import com.example.postbackend.service.exception.BadRequestException;
import org.springframework.stereotype.Component;

@Component
public class PostSearchValidator {
    private static final int MIN_LENGTH = 3;
    private static final int MAX_LENGTH = 100;

    private static final String TERM_INPUT_INVALID_MSG = "Term input is invalid";

    public void validateTermSearch(String term) {

        if (term.length() >= MIN_LENGTH && term.length() <= MAX_LENGTH) {
            return;
        }

        throw new BadRequestException(TERM_INPUT_INVALID_MSG);
    }
}
