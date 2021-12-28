package com.service;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.bindings.ContactForm;
import com.entities.Contact;
import com.repository.ContactRepository;

@Service
public class ContactServiceImpl implements ContactService {

	@Autowired
	private ContactRepository contactRepo;

	@Override
	public String saveContact(ContactForm form) {
		Contact entity = new Contact();
		BeanUtils.copyProperties(form, entity);
		entity = contactRepo.save(entity);
		if (entity.getContactId() != null) {
			return "SUCCESSFULL";
		}
		return "FAILED";
	}

	@Override
	public List<ContactForm> viewContacts() {
		List<Contact> allContacts = contactRepo.findAll();
		List<ContactForm> contactList=new ArrayList<>();
		for (Contact contact : allContacts) {
			ContactForm contactForm = new ContactForm();
			BeanUtils.copyProperties(contact, contactForm);
			contactList.add(contactForm);
		}
		return contactList;
	}

	@Override
	public ContactForm editContact(Integer contacId) {
		Contact contact = contactRepo.getById(contacId);
		ContactForm contactForm= new ContactForm();
		BeanUtils.copyProperties(contact, contactForm);
		return contactForm;
	}

	@Override
	public List<ContactForm> deleteContact(Integer contacId) {
		contactRepo.deleteById(contacId);
		List<Contact> allContacts = contactRepo.findAll();
		List<ContactForm> contactList=new ArrayList<>();
		for (Contact contact : allContacts) {
			ContactForm contactForm = new ContactForm();
			BeanUtils.copyProperties(contact, contactForm);
			contactList.add(contactForm);
		}
		return contactList;
	}

}
