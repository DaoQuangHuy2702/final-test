package com.example.postbackend.service.validator;

import com.example.postbackend.api.model.ContactRequest;
import com.example.postbackend.service.exception.BadRequestException;
import com.example.postbackend.service.exception.EntityNotFoundException;
import com.example.postbackend.service.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class ContactValidator {
    private static final String CONTACT_DOES_NOT_EXIST = "Contact does not exist";
    private static final String NAME_REQUEST = "Contact name is required";
    private static final String EMAIL_REQUEST = "Contact email is required";
    private final ContactRepository repo;

    @Autowired
    public ContactValidator(ContactRepository repo) {
        this.repo = repo;
    }

    private void checkRequiredField(String value, String msgError) {
        if(value == null || value.trim().isEmpty()) {
            throw new BadRequestException(msgError);
        }
    }

    public void validateAddContact(ContactRequest request) {
        checkRequiredField(request.getName(), NAME_REQUEST);
        checkRequiredField(request.getEmail(), EMAIL_REQUEST);
    }
}
