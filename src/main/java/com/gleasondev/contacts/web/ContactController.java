package com.gleasondev.contacts.web;

import com.gleasondev.contacts.pojo.Contact;
import com.gleasondev.contacts.service.ContactService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;
import java.util.List;

@RestController
public class ContactController {
    
    @Autowired
    private ContactService contactService;

    @GetMapping(value = "/contacts")
    public ResponseEntity<List<Contact>> getContacts() {
        List<Contact> contacts = contactService.getContacts();
        return new ResponseEntity<>(contacts, HttpStatus.OK);
    }

    @GetMapping(value = "/contact/{id}")
    public ResponseEntity<Contact> getContact(@PathVariable String id) {
        Contact contact = contactService.getContactById(id);
        return new ResponseEntity<>(contact, HttpStatus.OK);
    }

    @PostMapping(value = "/contact")
    public ResponseEntity<Contact> createContact(@Valid @RequestBody Contact contact) {
        contactService.saveContact(contact);
        return new ResponseEntity<>(contact, HttpStatus.CREATED);
    }

    @DeleteMapping("/delete/{id}/contact") // path was changed to demo ant matachers
    public ResponseEntity<HttpStatus> deleteContact(@PathVariable String id) {
        contactService.deleteContact(id);
        return new ResponseEntity<>(HttpStatus.NO_CONTENT);
    }

    

}
