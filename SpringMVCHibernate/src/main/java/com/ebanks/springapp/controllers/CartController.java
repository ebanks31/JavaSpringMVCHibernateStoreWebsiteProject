package com.ebanks.springapp.controllers;

import org.apache.log4j.Logger;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

/**
 * The HomeController for handling REST request from the home page.
 */
@Controller
public class CartController {
	private static final Logger CART_CONTROLLER_LOGGER = Logger.getLogger(CartController.class);
	private static final String CART = "cart";
	//TODO: Need to more REST End points for Cart Controller.

	/**
	 * Shows the user's cart
	 *
	 * @param model
	 *            the model
	 * @return the page view
	 */
	@RequestMapping(value = "/cart", method = RequestMethod.GET)
	public String home(final Model model) {
		CART_CONTROLLER_LOGGER.info("Going to cart page");

		return CART;
	}
}