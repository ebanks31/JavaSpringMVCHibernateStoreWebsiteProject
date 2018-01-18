package com.ebanks.springapp.controllers;

import javax.validation.Valid;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.Errors;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.context.request.WebRequest;
import org.springframework.web.servlet.ModelAndView;

import com.ebanks.springapp.model.User;
import com.ebanks.springapp.service.UserService;

/**
 * The PersonController for handling REST request.
 */
@Controller
public class RegisterController {
	private static final Logger REGISTER_CONTROLLER_LOGGER = Logger.getLogger(RegisterController.class);
	private static final String REGISTRATION = "registration";

	private UserService userService;

	/**
	 * Retrieves a list of people.
	 *
	 * @param model
	 *            the model
	 * @return the page view
	 */
	@RequestMapping(value = "/user/register", method = RequestMethod.GET)
	public String register(Model model) {
		User user = new User();
		model.addAttribute("user", user);
		REGISTER_CONTROLLER_LOGGER.info("User has entered registration page");

		return REGISTRATION;
	}

	@RequestMapping(value = "/user/registration", method = RequestMethod.POST)
	public ModelAndView registerUserAccount(@ModelAttribute("user") @Valid User user, BindingResult result,
			WebRequest request, Errors errors) {

		if (!result.hasErrors()) {
			createUserAccount(user, result);
		}

		if (result.hasErrors()) {
			return new ModelAndView(REGISTRATION, "user", user);
		} else {
			return new ModelAndView("home", "user", user);
		}
	}

	private void createUserAccount(User user, BindingResult result) {
		try {
			userService.addUser(user);
		} // catch (SQLException e) {
			// REGISTER_CONTROLLER_LOGGER.info(String.format("An SQL exception has occurred:
			// %s", e));}
		catch (Exception e) {
			// TODO: Need to split into separate specific exception
			REGISTER_CONTROLLER_LOGGER.info(String.format("An exception has occurred: %s", e));
		}
	}

}