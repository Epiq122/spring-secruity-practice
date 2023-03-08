package com.gleasondev.contacts.service;

import com.gleasondev.contacts.pojo.Contact;

import java.util.List;

public interface ContactService {
    Contact getContactById(String id);
    void saveContact(Contact contact);
    List<Contact> getContacts();
    void deleteContact(String id);

}
