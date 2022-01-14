package com.example.postbackend.service.service;

import com.example.postbackend.service.mapper.ContactMapper;
import com.example.postbackend.service.mock.ContactData;
import com.example.postbackend.service.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

@RunWith(MockitoJUnitRunner.class)
public class ContactServiceTest {
    @InjectMocks
    ContactServices service;

    @Mock
    ContactRepository repository;

    @Mock
    ContactMapper mapper;

    @Test
    public void getAllContacts() {
        service.getAllContacts();
    }

    @Test
    public void addContact() {
        service.addContact(ContactData.mockContactRequest());
    }

    @Test
    public void removeContactById() {
        service.removeContactById(ContactData.CONTACT_ID);
    }
}
