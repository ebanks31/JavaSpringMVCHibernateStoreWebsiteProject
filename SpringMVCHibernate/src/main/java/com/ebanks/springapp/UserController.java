package com.ebanks.springapp;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;

import com.ebanks.springapp.model.Person;
import com.ebanks.springapp.service.PersonService;

/**
 * The PersonController for handling REST request.
 */
@Controller
public class PersonController {
	private static final Logger logger = Logger.getLogger(PersonController.class);
	private static final String PERSON = "person";
	private static final String LIST_PERSON_MODEL = "listpersons";

	private PersonService personService;

	@Autowired(required = true)
	@Qualifier(value = "personService")
	public final void setPersonService(final PersonService personService) {
		this.personService = personService;
	}

	/**
	 * Shows the home page
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/", method = RequestMethod.GET)
	public String home(final Model model) {
		logger.info("Going to home page");
		return "home";
	}

	/**
	 * Retrieves a list of people.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/persons", method = RequestMethod.GET)
	public String listPersons(final Model model) {
		model.addAttribute(LIST_PERSON_MODEL,
				this.personService.listPersons());
		logger.info("Retrieving list of people");

		logger.info("list person: " + this.personService.listPersons());
		return PERSON;
	}

	/**
	 * Retrieves a list people by last name in ascending order.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/personsByLastNameASC", method = RequestMethod.GET)
	public String listPersonsByLastNameASC(final Model model) {
		model.addAttribute(LIST_PERSON_MODEL,
				this.personService.listPersonsOrderbyLastNameASC());
		return PERSON;
	}

	/**
	 * Adds a person.
	 *
	 * @param p
	 *            the p
	 * @return the string
	 */
	@RequestMapping(value = "/person/add", method = RequestMethod.POST)
	public String addPerson(@ModelAttribute("person") final Person p) {

		if (p.getId() == 0) {
			// new person, add it
			this.personService.addPerson(p);
		} else {
			// existing person, call update
			this.personService.updatePerson(p);
		}

		return "redirect:/persons";

	}

	/**
	 * Removes a person.
	 *
	 * @param id
	 *            the id
	 * @return the string
	 */
	@RequestMapping(value = "/remove/{id}", method = RequestMethod.GET)
	public String removePerson(@PathVariable("id") final int id) {

		this.personService.removePerson(id);
		return "redirect:/persons";
	}

	/**
	 * Edits a person.
	 *
	 * @param id
	 *            the id
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/edit/{id}", method = RequestMethod.GET)
	public String editPerson(@PathVariable("id") final int id, final Model model) {
		model.addAttribute(PERSON,
				this.personService.getPersonById(id));
		model.addAttribute(LIST_PERSON_MODEL,
				this.personService.listPersons());
		return PERSON;
	}

	/**
	 * Retrieves a list of people that are above the legal age (18).
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/personsAboveLegalAgeASC", method = RequestMethod.GET)
	public String listPersonsAboveLegalAgeASC(final Model model) {
		model.addAttribute(LIST_PERSON_MODEL,
				this.personService.listPersonsAboveOrEqualToLegalAge());
		return PERSON;
	}

	/**
	 * Retrieves a list of people that are owners.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/personsWithOwnership", method = RequestMethod.GET)
	public String listPersonsWithOwnerShip(final Model model) {
		model.addAttribute(LIST_PERSON_MODEL,
				this.personService.getPeopleByWithOwnership());
		return PERSON;
	}

	/**
	 * List persons.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/personsWithOutOwnership", method = RequestMethod.GET)
	public String listPersonsWithOutOwnerShip(final Model model) {
		model.addAttribute(LIST_PERSON_MODEL,
				this.personService.getPeopleByWithOutOwnership());
		return PERSON;
	}

	/**
	 * Retrieves a list of people by distinct address.
	 *
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/personsByDistinctAddress", method = RequestMethod.GET)
	public String listPersonsByDistinctAddress(final Model model) {
		model.addAttribute(PERSON, new Person());
		model.addAttribute(LIST_PERSON_MODEL,
				this.personService.getAllDistinctAddress());
		return PERSON;
	}

	/**
	 * Retrieves a list of people by a specified address.
	 *
	 * @param address
	 *            the address
	 * @param model
	 *            the model
	 * @return the string
	 */
	@RequestMapping(value = "/personsBySpecificAddress{address}", method = RequestMethod.GET)
	public String listPersonsBySpecificAddress(@PathVariable("address") final String address, final Model model) {
		model.addAttribute(LIST_PERSON_MODEL,
				this.personService.personsBySpecificAddress(address));
		return PERSON;
	}

	/**
	 * Simple.
	 *
	 * @return the string
	 */
	@RequestMapping("/simple")
	public @ResponseBody String simple() {
		return "Hello world!";
	}

}