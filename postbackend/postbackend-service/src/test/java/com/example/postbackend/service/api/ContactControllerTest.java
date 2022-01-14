package com.example.postbackend.service.api;

import com.example.postbackend.api.model.*;
import com.example.postbackend.service.mock.ContactData;
import com.example.postbackend.service.service.ContactServices;
import com.example.postbackend.service.validator.ContactValidator;
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
public class ContactControllerTest {
    private final String API_KEY = "MOCK_API_KEY";

    @InjectMocks
    ContactController controller;

    @Mock
    ContactServices service;

    @Mock
    ContactValidator validator;

    @Test
    public void testEndpointGetAllContacts() {
        when(service.getAllContacts()).thenReturn(ContactData.mockContacts());

        ResponseEntity<Contacts> responseEntity = controller.getAllContacts(API_KEY);
        assertStatus200(responseEntity.getStatusCode());
        assertContacts(responseEntity.getBody());
    }

    @Test
    public void testEndpointAddContact() {
        when(service.addContact(any(ContactRequest.class))).thenReturn(ContactData.mockContact());

        ResponseEntity<Contact> responseEntity = controller.addContact(API_KEY, ContactData.mockContactRequest());
        assertStatus200(responseEntity.getStatusCode());
        assertContact(responseEntity.getBody());
    }

    @Test
    public void testEndpointRemoveContactById() {
        ResponseEntity<Void> responseEntity = controller.removeContactById(API_KEY, ContactData.CONTACT_ID);
        assertStatus200(responseEntity.getStatusCode());
    }

    private void assertContact(Contact actual) {
        assertThat(actual.getId(), is(ContactData.CONTACT_ID));
        assertThat(actual.getName(), is(ContactData.NAME));
        assertThat(actual.getEmail(), is(ContactData.EMAIL));
        assertThat(actual.getMessage(), is(ContactData.MESSAGE));
        assertThat(actual.getCreateAt(), is(ContactData.CREATE_AT));
    }

    private void assertContacts(Contacts actual) {
        assertContact(actual.get(0));
    }

    private void assertStatus200(HttpStatus actual) {
        assertThat(actual, is(HttpStatus.OK));
    }
}
