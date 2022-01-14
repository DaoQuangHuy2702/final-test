package com.example.postbackend.service.mapper;


import com.example.postbackend.api.model.Contact;
import com.example.postbackend.api.model.ContactRequest;
import com.example.postbackend.api.model.Contacts;
import com.example.postbackend.service.entity.ContactEntity;
import com.example.postbackend.service.mock.ContactData;
import com.example.postbackend.service.repository.ContactRepository;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.Mock;
import org.mockito.junit.MockitoJUnitRunner;

import java.util.List;

import static org.junit.Assert.assertThat;
import static org.hamcrest.CoreMatchers.is;

@RunWith(MockitoJUnitRunner.class)
public class ContactMapperTest {
    @InjectMocks
    ContactMapper mapper;

    @Mock
    ContactRepository repository;

    @Test
    public void ensureMapContactEntityFromContactRequestForAdd() {
        ContactRequest contactRequest = ContactData.mockContactRequest();

        ContactEntity contactEntity = mapper.mapContactEntityFromContactRequest(contactRequest);

        assertThat(contactEntity.getId() != null, is(true));
        assertThat(contactEntity.getName(), is(contactRequest.getName()));
        assertThat(contactEntity.getEmail(), is(contactRequest.getEmail()));
        assertThat(contactEntity.getMessage(), is(contactRequest.getMessage()));
        assertThat(contactEntity.getCreateAt() != null, is(true));
    }

    @Test
    public void ensureMapContactFromContactEntity() {
        ContactEntity contactEntity = ContactData.mockContactEntity();
        Contact contact = mapper.mapContactFromContactEntity(contactEntity);

        assertContact(contact, contactEntity);
    }

    @Test
    public void ensureMapContactsFromContactsEntities() {
        List<ContactEntity> contactEntities = ContactData.mockContactEntities();
        Contacts contacts = mapper.mapContactsFromContactEntities(contactEntities);

        assertContacts(contacts, contactEntities);
    }

    private void assertContact(Contact actual, ContactEntity input) {
        assertThat(actual.getId(), is(input.getId()));
        assertThat(actual.getName(), is(input.getName()));
        assertThat(actual.getEmail(), is(input.getEmail()));
        assertThat(actual.getMessage(), is(input.getMessage()));
        assertThat(actual.getCreateAt(), is(input.getCreateAt().toLocalDateTime().toString()));
    }

    private void assertContacts(Contacts actual, List<ContactEntity> input) {
        assertContact(actual.get(0), input.get(0));
    }
}
