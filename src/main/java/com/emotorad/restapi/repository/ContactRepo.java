package com.emotorad.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emotorad.restapi.dto.Contact;



public interface ContactRepo extends JpaRepository<Contact, Integer> {
	Contact findByEmailOrPhoneNumber(String email, String phoneNumber);
}