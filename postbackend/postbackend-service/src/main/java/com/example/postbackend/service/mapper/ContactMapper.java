package com.example.postbackend.service.mapper;

import com.example.postbackend.api.model.Contact;
import com.example.postbackend.api.model.ContactRequest;
import com.example.postbackend.api.model.Contacts;
import com.example.postbackend.service.entity.ContactEntity;
import com.example.postbackend.service.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.sql.Timestamp;
import java.time.Instant;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

@Service
public class ContactMapper {
    private final ContactRepository repo;

    @Autowired
    public ContactMapper(ContactRepository repo) {
        this.repo = repo;
    }

    public ContactEntity mapContactEntityFromContactRequest(ContactRequest from) {
        ContactEntity to = new ContactEntity();

        to.setId(UUID.randomUUID().toString());
        to.setName(from.getName());
        to.setEmail(from.getEmail());
        to.setMessage(from.getMessage());
        to.setCreateAt(new Timestamp(Instant.now().toEpochMilli()));

        return to;
    }


    public Contact mapContactFromContactEntity(ContactEntity from) {
        Contact to = new Contact();

        to.setId(from.getId());
        to.setName(from.getName());
        to.setEmail(from.getEmail());
        to.setMessage(from.getMessage());
        to.setCreateAt(from.getCreateAt().toLocalDateTime().toString());

        return to;
    }

    public Contacts mapContactsFromContactEntities(List<ContactEntity> from) {
        return from.stream().map(this::mapContactFromContactEntity).collect(Collectors.toCollection(Contacts::new));
    }
}
