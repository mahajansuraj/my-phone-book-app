package com.entities;

import java.time.LocalDate;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;
import javax.persistence.Table;

import org.hibernate.annotations.CreationTimestamp;
import org.hibernate.annotations.UpdateTimestamp;

import lombok.Data;

@Entity
@Table(name = "CANTACT_DTLS")
@Data
public class Contact {

	@Id
	@GeneratedValue
	@Column(name="CONTACT_ID")
	private Integer contactId;
	
	@Column(name="CONTACT_NAME")
	private String contactName;
	@Column(name = "CONTACT_EMAIL")
	private String contactEmail;
	@Column(name = "CONTACT_NUMBER")
	private Long contactNumber;
	
	@Column(name = "ACTIVE_SW")
	private String activeSw;
	
	@CreationTimestamp
	@Column(name = "CREATED_DATE")
	private LocalDate createDDate;
	@UpdateTimestamp
	@Column(name = "UPDATED_DATE")
	private LocalDate updateDDate;
}
