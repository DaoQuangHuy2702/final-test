package com.example.postbackend.service.api;

import com.example.postbackend.api.ContactsApi;
import com.example.postbackend.api.model.Contact;
import com.example.postbackend.api.model.ContactRequest;
import com.example.postbackend.api.model.Contacts;
import com.example.postbackend.service.service.ContactServices;
import com.example.postbackend.service.validator.ContactValidator;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("post/backend/v1")
@CrossOrigin
public class ContactController implements ContactsApi {
    private final ContactServices service;
    private final ContactValidator validator;

    @Autowired
    public ContactController(ContactServices service, ContactValidator validator) {
        this.service = service;
        this.validator = validator;
    }

    @Override
    public ResponseEntity<Contacts> getAllContacts(String apikey) {
        Contacts response = service.getAllContacts();

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Contact> addContact(String apikey, ContactRequest request) {
        validator.validateAddContact(request);
        Contact response = service.addContact(request);

        return new ResponseEntity<>(response, HttpStatus.OK);
    }

    @Override
    public ResponseEntity<Void> removeContactById(String apikey, String contactId) {
        service.removeContactById(contactId);

        return new ResponseEntity<>(HttpStatus.OK);
    }
}
