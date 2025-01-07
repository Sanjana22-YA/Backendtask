package com.emotorad.restapi.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emotorad.restapi.dto.Contact;
import com.emotorad.restapi.dto.LinkPrecedence;
import com.emotorad.restapi.repository.ContactRepo;

/**
 * Service class to manage contact identification and linking logic.
 * This class contains the business logic for creating, updating, and identifying contacts.
 */

@Service
public class ContactService {

    @Autowired
    private ContactRepo contactRepo;
    /**
     * Identifies a contact based on the provided email or phone number.
     *
     * @param email       The email address to match.
     * @param phoneNumber The phone number to match.
     * @return A map containing consolidated contact details.
     */
    public Map<String, Object> identifyContact(String email, String phoneNumber) {
    	 // Search for an existing contact matching the email or phone number
        Contact matchingContact = contactRepo.findByEmailOrPhoneNumber(email, phoneNumber);

        if (matchingContact==null) {
        	 // No match found: create a new primary contact
         
            Contact newContact = new Contact();
            newContact.setEmail(email);
            newContact.setPhoneNumber(phoneNumber);
            newContact.setLinkPrecedence(LinkPrecedence.PRIMARY);
            contactRepo.save(newContact);
            // Format and return the response for the new contact
            return formatResponse(newContact);
        }

        
        else {
        	 // Match found: update the contact to secondary precedence
        	 matchingContact.setLinkPrecedence(LinkPrecedence.SECONDARY);
        	 contactRepo.save(matchingContact);
        	 // Format and return the response for the updated contact
        	 return formatResponse(matchingContact);
        }
    }
    /**
     * Formats the contact details into a response map.
     *
     * @param contact The contact to include in the response.
     * @return A map containing contact details, including ID, emails, phone numbers, and link precedence.
     */
    private Map<String, Object> formatResponse(Contact primaryContact) {
        Map<String, Object> response = new HashMap();
        response.put("primaryContactId", primaryContact.getId());
        response.put("emails", List.of(primaryContact.getEmail()));
        response.put("phoneNumbers", List.of(primaryContact.getPhoneNumber()));
        response.put("LinkedPrecedence", primaryContact.getLinkPrecedence());// Corrected key naming for consistency
        
        return response;
    }
}