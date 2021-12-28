package com.repository;

import java.io.Serializable;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.entities.Contact;

@Repository
public interface ContactRepository extends JpaRepository<Contact, Serializable>{

}
