package com.emotorad.restapi.dto;
/**
 * Enum representing the precedence of a contact.
 * Used to differentiate between primary and secondary contacts.
 */
public enum LinkPrecedence {
	/**
     * Represents a primary contact.
     * A primary contact is the main contact entity to which secondary contacts are linked.
     */
	 PRIMARY, 
	 /**
	     * Represents a secondary contact.
	     * A secondary contact is linked to a primary contact and provides additional or overlapping information.
	     */
	 SECONDARY
}
