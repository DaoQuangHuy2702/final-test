package com.example.postbackend.service.mock;

import com.example.postbackend.api.model.Contact;
import com.example.postbackend.api.model.ContactRequest;
import com.example.postbackend.api.model.Contacts;
import com.example.postbackend.service.entity.ContactEntity;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.Arrays;
import java.util.List;

public class ContactData {
    public static final String CONTACT_ID = "2347edfd-c11c-4f59-69ee-600492f900f3";
    public static final String NAME = "Quang Huy";
    public static final String EMAIL = "huy@gmail.com";
    public static final String MESSAGE = "Contrary to popular belief, Lorem Ipsum is not simply random text. It has roots in a piece of classical Latin";
    public static final String CREATE_AT = "2022-07-01 08:57:44";

    public static Contact mockContact() {
        Contact contact = new Contact();

        contact.setId(CONTACT_ID);
        contact.setName(NAME);
        contact.setEmail(EMAIL);
        contact.setMessage(MESSAGE);
        contact.setCreateAt(CREATE_AT);

        return contact;
    }

    public static Contacts mockContacts() {
        Contacts contacts = new Contacts();
        contacts.add(mockContact());

        return contacts;
    }

    public static ContactRequest mockContactRequest() {
        ContactRequest contactRequest = new ContactRequest();

        contactRequest.setName(NAME);
        contactRequest.setEmail(EMAIL);
        contactRequest.setMessage(MESSAGE);

        return contactRequest;
    }

    public static ContactEntity mockContactEntity() {
        ContactEntity contactEntity = new ContactEntity();

        contactEntity.setId(CONTACT_ID);
        contactEntity.setName(NAME);
        contactEntity.setMessage(MESSAGE);
        contactEntity.setCreateAt(new Timestamp(Instant.now().toEpochMilli()));

        return contactEntity;
    }

    public static List<ContactEntity> mockContactEntities() {
        return Arrays.asList(mockContactEntity());
    }
}
