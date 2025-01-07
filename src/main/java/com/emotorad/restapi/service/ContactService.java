package com.emotorad.restapi.service;

import java.time.LocalDateTime;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.emotorad.restapi.dto.Contact;
import com.emotorad.restapi.dto.LinkPrecedence;
import com.emotorad.restapi.repository.ContactRepo;



@Service
public class ContactService {

    @Autowired
    private ContactRepo contactRepo;

    public Map<String, Object> identifyContact(String email, String phoneNumber) {
        Contact matchingContact = contactRepo.findByEmailOrPhoneNumber(email, phoneNumber);

        if (matchingContact==null) {
            // Create a new primary contact
            Contact newContact = new Contact();
            newContact.setEmail(email);
            newContact.setPhoneNumber(phoneNumber);
            newContact.setLinkPrecedence(LinkPrecedence.PRIMARY);
            contactRepo.save(newContact);

            return formatResponse(newContact);
        }

        
        else {
        	 matchingContact.setLinkPrecedence(LinkPrecedence.SECONDARY);
        	 contactRepo.save(matchingContact);
        	 return formatResponse(matchingContact);
        }
    }

    private Map<String, Object> formatResponse(Contact primaryContact) {
        Map<String, Object> response = new HashMap();
        response.put("primaryContactId", primaryContact.getId());
        response.put("emails", List.of(primaryContact.getEmail()));
        response.put("phoneNumbers", List.of(primaryContact.getPhoneNumber()));
        response.put("LinkedPrecedence", primaryContact.getLinkPrecedence());
        
        return response;
    }
}