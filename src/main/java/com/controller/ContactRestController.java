package com.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bindings.ContactForm;
import com.service.ContactService;

@CrossOrigin(origins = "http://localhost:4200/")
@RestController
public class ContactRestController {

	@Autowired
	private ContactService service;
	
	@PostMapping("/save")
	public String saveContact(@RequestBody ContactForm form) {
		return service.saveContact(form);
	}
	
	@GetMapping("/view")
	public List<ContactForm> viewContacts() {
		
		return service.viewContacts();
	}
	
	@GetMapping("/edit/{contactId}")
	public ContactForm editContact(@PathVariable Integer contactId) {
		return service.editContact(contactId);
	}
	
	@DeleteMapping("/delete/{contactId}")
	public List<ContactForm> deleteContact(@PathVariable Integer contactId) {
		return service.deleteContact(contactId);
	}
}
