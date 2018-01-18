package com.ebanks.springapp.model;

import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;
import javax.validation.constraints.NotEmpty;
import javax.validation.constraints.NotNull;

import com.ebanks.springapp.validators.PasswordMatches;
//import com.ebanks.springapp.validators.ValidEmail;

/**
 * Entity bean with JPA annotations for User table. Hibernate provides JPA
 * implementation
 *
 * @author ebanks
 *
 */
@Entity
@PasswordMatches
@Table(name = "USER")
public class User {

	/** The id. */
	// Auto increment ID when a user is added.
	@Id
	@Column(name = "id")
	@GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "person_seq")
	@SequenceGenerator(name = "person_seq", sequenceName = "person_seq", allocationSize = 20)

	// Declaring columns of User table for usage with Hibernate
	private int id;

	/** The first name. */
	@Column(name = "firstname")
	private String firstName;

	/** The last name. */
	@Column(name = "lastname")
	private String lastName;

	/** The age. */
	private int age;

	/** The email. */
	private String email;
	// TODO: Username is email. Will keep email field here for now and decide if I
	// separate the username from the email.

	/** The address. */
	private String address;

	/** The phone number. */
	@Column(name = "phonenumber")
	private String phoneNumber;

	/** The ownership. */
	private String ownership;

	/** The username. */
	@NotNull
	@NotEmpty
	// @ValidEmail
	private String username;

	/** The password. */
	@NotNull
	@NotEmpty
	private String password;

	/** The matching password. */
	@NotNull
	@NotEmpty
	private String matchingPassword;

	/** The boolean indicating whether a user is active. */
	@Column(name = "Active")
	private boolean active;

	/** The display name. */
	private String displayName;

	/*
	 * The roles of the user (ROLE_USER, ROLE_ADMIN)
	 */
	private List<String> roles;

	/**
	 * Gets the roles.
	 *
	 * @return the roles
	 */
	public List<String> getRoles() {
		return roles;
	}

	/**
	 * Sets the roles.
	 *
	 * @param list
	 *            the new roles
	 */
	public void setRoles(List<String> roles) {
		this.roles = roles;
	}

	/**
	 * Gets the matching password.
	 *
	 * @return the matching password
	 */
	public String getMatchingPassword() {
		return matchingPassword;
	}

	/**
	 * Sets the matching password.
	 *
	 * @param matchingPassword
	 *            the new matching password
	 */
	public void setMatchingPassword(String matchingPassword) {
		this.matchingPassword = matchingPassword;
	}

	/**
	 * Gets the display name.
	 *
	 * @return the display name
	 */
	public String getDisplayName() {
		return displayName;
	}

	/**
	 * Sets the display name.
	 *
	 * @param displayName
	 *            the new display name
	 */
	public void setDisplayName(String displayName) {
		this.displayName = displayName;
	}

	/**
	 * Checks if the user is active.
	 *
	 * @return true, if is active
	 */
	public boolean isActive() {
		return active;
	}

	/**
	 * Sets the user to be active or not.
	 *
	 * @param active
	 *            the new active
	 */
	public void setActive(boolean active) {
		this.active = active;
	}

	/**
	 * Gets the username.
	 *
	 * @return the username
	 */
	public String getUsername() {
		return username;
	}

	/**
	 * Sets the username.
	 *
	 * @param username
	 *            the new username
	 */
	public void setUsername(String username) {
		this.username = username;
	}

	/**
	 * Gets the password.
	 *
	 * @return the password
	 */
	public String getPassword() {
		return password;
	}

	/**
	 * Sets the password.
	 *
	 * @param password
	 *            the password
	 */
	public void setPassword(String password) {
		this.password = password;
	}

	/**
	 * Gets the age.
	 *
	 * @return the age
	 */
	public int getAge() {
		return age;
	}

	/**
	 * Sets the age.
	 *
	 * @param age
	 *            the new age
	 */
	public void setAge(final int age) {
		this.age = age;
	}

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id
	 *            the new id
	 */
	public void setId(final int id) {
		this.id = id;
	}

	/**
	 * Gets the first name.
	 *
	 * @return the first name
	 */
	public String getFirstName() {
		return firstName;
	}

	/**
	 * Sets the first name.
	 *
	 * @param firstName
	 *            the new first name
	 */
	public void setFirstName(final String firstName) {
		this.firstName = firstName;
	}

	/**
	 * Gets the last name.
	 *
	 * @return the last name
	 */
	public String getLastName() {
		return lastName;
	}

	/**
	 * Sets the last name.
	 *
	 * @param lastName
	 *            the new last name
	 */
	public void setLastName(final String lastName) {
		this.lastName = lastName;
	}

	/**
	 * Gets the email.
	 *
	 * @return the email
	 */
	public String getEmail() {
		return email;
	}

	/**
	 * Sets the email.
	 *
	 * @param email
	 *            the new email
	 */
	public void setEmail(final String email) {
		this.email = email;
	}

	/**
	 * Gets the address.
	 *
	 * @return the address
	 */
	public String getAddress() {
		return address;
	}

	/**
	 * Sets the address.
	 *
	 * @param address
	 *            the new address
	 */
	public void setAddress(final String address) {
		this.address = address;
	}

	/**
	 * Gets the phone number.
	 *
	 * @return the phone number
	 */
	public String getPhoneNumber() {
		return phoneNumber;
	}

	/**
	 * Sets the phone number.
	 *
	 * @param phoneNumber
	 *            the new phone number
	 */
	public void setPhoneNumber(final String phoneNumber) {
		this.phoneNumber = phoneNumber;
	}

	/**
	 * Gets the ownership.
	 *
	 * @return the ownership
	 */
	public String getOwnership() {
		return ownership;
	}

	/**
	 * Sets the ownership.
	 *
	 * @param ownership
	 *            the new ownership
	 */
	public void setOwnership(final String ownership) {
		this.ownership = ownership;
	}

	/*
	 * (non-Javadoc)
	 *
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		return "id=" + id + ", name=" + firstName + " " + lastName + " age = " + age;
	}
}