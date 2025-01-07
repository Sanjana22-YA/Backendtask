package com.emotorad.restapi.repository;

import org.springframework.data.jpa.repository.JpaRepository;

import com.emotorad.restapi.dto.Contact;

/**
 * Repository interface for managing Contact entities.
 * Extends JpaRepository to provide CRUD operations and custom query methods.
 */

public interface ContactRepo extends JpaRepository<Contact, Integer> {
	/**
     * Custom method to find a contact by either email or phone number.
     *
     * @param email       The email address to search for.
     * @param phoneNumber The phone number to search for.
     * @return A Contact entity if a matching email or phone number is found, otherwise null.
     */
	Contact findByEmailOrPhoneNumber(String email, String phoneNumber);
}