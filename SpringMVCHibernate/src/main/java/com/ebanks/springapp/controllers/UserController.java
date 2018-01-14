package com.ebanks.springapp.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebanks.springapp.model.User;
import com.ebanks.springapp.service.UserService;

/**
 * The UserController for handling REST request.
 */
@Controller
public class UserController {

	/** The Constant logger for user controller */
	private static final Logger USER_CONTROLLER_LOGGER = Logger.getLogger(UserController.class);

	/** The Constant PERSON. */
	private static final String USER = "user";

	/** The Constant LIST_USERS_MODEL. */
	private static final String LIST_USERS_MODEL = "listUser";

	/** The user service. */
	private UserService userService;

	/**
	 * Sets the user service.
	 *
	 * @param userService the new user service
	 */
	@Autowired(required = true)
	@Qualifier(value = "userService")
	public final void setUserService(final UserService userService) {
		this.userService = userService;
	}

	/**
	 * Retrieves a list of people.
	 *
	 * @param model
	 *            the model
	 * @return the page view
	 */
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(Model model) {
		model.addAttribute(LIST_USERS_MODEL,
				userService.listUsers());
		USER_CONTROLLER_LOGGER.info("Retrieving list of people");

		USER_CONTROLLER_LOGGER.info("list person: " + this.userService.listUsers());
		return USER;
	}

	/**
	 * Retrieves a list people by last name in ascending order.
	 *
	 * @param model
	 *            the model
	 * @return the page view
	 */
	@RequestMapping(value = "/personsByLastNameASC", method = RequestMethod.GET)
	public String listPersonsByLastNameASC(final Model model) {
		model.addAttribute(LIST_USERS_MODEL,
				this.userService.listUsersOrderbyLastNameASC());
		return "personByLastName";
	}

	/**
	 * Adds a person.
	 *
	 * @param person the person
	 *
	 * @return the page view
	 */
	@RequestMapping(value = "/user/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("personAttribute") User person) {
		USER_CONTROLLER_LOGGER.info("person Id: " + person.getId());

		if (person.getId() == 0) {
			// adds new person. Person Id starts at 0 for a new Person object.
			this.userService.addUser(person);
		} else {
			// Calls update method if person exists
			this.userService.updateUser(person);
		}

		//return "redirect:/persons";
		return "addPerson";

	}

	/**
	 * Removes a person.
	 *
	 * @param id
	 *            the id
	 * @return the page view
	 */
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String removePerson(@PathVariable("id") final int id) {

		this.userService.removeUser(id);
		return "redirect:/persons";
	}

	/**
	 * Edits a person.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the page view
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editPerson(@PathVariable("id") final int id, final Model model) {
		model.addAttribute(USER,
				this.userService.getUserById(id));
		model.addAttribute(LIST_USERS_MODEL,
				this.userService.listUsers());
		return USER;
	}

	/**
	 * Retrieves a list of people that are above the legal age (18).
	 *
	 * @param model
	 *            the model
	 * @return the page view
	 */
	@RequestMapping(value = "/personsAboveLegalAgeASC", method = RequestMethod.GET)
	public String listPersonsAboveLegalAgeASC(final Model model) {
		model.addAttribute(LIST_USERS_MODEL,
				this.userService.listUsersAboveOrEqualToLegalAge());
		return USER;
	}

	/**
	 * Retrieves a list of people that are owners.
	 *
	 * @param model
	 *            the model
	 * @return the page view
	 */
	@RequestMapping(value = "/personsWithOwnership", method = RequestMethod.GET)
	public String listPersonsWithOwnerShip(final Model model) {
		model.addAttribute(LIST_USERS_MODEL,
				this.userService.getUsersByOwnership());
		return USER;
	}

	/**
	 * List persons.
	 *
	 * @param model
	 *            the model
	 * @return the page view
	 */
	@RequestMapping(value = "/personsWithOutOwnership", method = RequestMethod.GET)
	public String listPersonsWithOutOwnerShip(final Model model) {
		model.addAttribute(LIST_USERS_MODEL,
				this.userService.getUsersByWithOutOwnership());
		return USER;
	}

	/**
	 * Retrieves a list of people by distinct address.
	 *
	 * @param model
	 *            the model
	 * @return the page view
	 */
	@RequestMapping(value = "/personsByDistinctAddress", method = RequestMethod.GET)
	public String listPersonsByDistinctAddress(final Model model) {
		model.addAttribute(USER, new User());
		model.addAttribute(LIST_USERS_MODEL,
				this.userService.getUsersByDistinctAddress());
		return USER;
	}

	/**
	 * Retrieves a list of people by a specified address.
	 *
	 * @param address
	 *            the address
	 * @param model
	 *            the model
	 * @return the page view
	 */
	@RequestMapping(value = "/personsBySpecificAddress{address}", method = RequestMethod.GET)
	public String listPersonsBySpecificAddress(@PathVariable("address") final String address,
			final Model model) {
		model.addAttribute(LIST_USERS_MODEL,
				this.userService.getUsersBySpecificAddress(address));
		return USER;
	}

}