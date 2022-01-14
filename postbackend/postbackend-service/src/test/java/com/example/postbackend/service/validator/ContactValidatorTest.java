package com.example.postbackend.service.validator;

import com.example.postbackend.api.model.ContactRequest;
import com.example.postbackend.service.exception.BadRequestException;
import com.example.postbackend.service.mock.ContactData;
import com.example.postbackend.service.repository.ContactRepository;
import org.junit.Rule;
import org.junit.Test;
import org.junit.rules.ExpectedException;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ContactValidatorTest {
    @InjectMocks
    ContactValidator validator;

    @Mock
    ContactRepository repository;

    @Rule
    public ExpectedException expected = ExpectedException.none();

    @Test
    public void validateAddContact() {
        validator.validateAddContact(ContactData.mockContactRequest());
    }

    @Test
    public void validateAddContactShowExceptionWhenNameFieldIsNull() {
        expected.expect(BadRequestException.class);
        expected.expectMessage("Contact name is required");

        ContactRequest contactRequest = ContactData.mockContactRequest();
        contactRequest.setName("");
        validator.validateAddContact(contactRequest);
    }

    @Test
    public void validateAddContactShowExceptionWhenEmailFieldIsNull() {
        expected.expect(BadRequestException.class);
        expected.expectMessage("Contact email is required");

        ContactRequest contactRequest = ContactData.mockContactRequest();
        contactRequest.setEmail("");
        validator.validateAddContact(contactRequest);
    }
}
