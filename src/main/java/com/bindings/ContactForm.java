package com.bindings;

import java.time.LocalDate;

import lombok.Data;

@Data
public class ContactForm {

	private int contactId;
	private String contactName;
	private String contactEmail;
	private long contactNumber;
	private String activeSw;
	private LocalDate createDate;
	private LocalDate updateDate;
	
}
