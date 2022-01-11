package com.example.postbackend.service.service;

import com.example.postbackend.api.model.Contact;
import com.example.postbackend.api.model.ContactRequest;
import com.example.postbackend.api.model.Contacts;
import com.example.postbackend.service.entity.ContactEntity;
import com.example.postbackend.service.mapper.ContactMapper;
import com.example.postbackend.service.repository.ContactRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class ContactServices {
    private final ContactRepository repo;
    private final ContactMapper mapper;

    @Autowired
    public ContactServices(ContactRepository repo, ContactMapper mapper) {
        this.repo = repo;
        this.mapper = mapper;
    }

    public Contacts getAllContacts() {
        return mapper.mapContactsFromContactEntities(repo.findAll());
    }

    public Contact addContact(ContactRequest contactReq) {
        ContactEntity contactEntity = mapper.mapContactEntityFromContactRequest(contactReq);
        ContactEntity saved = repo.save(contactEntity);

        return mapper.mapContactFromContactEntity(saved);
    }

    public void removeContactById(String id) {
        ContactEntity contactEntity = repo.getOne(id);
        repo.delete(contactEntity);
    }
}
