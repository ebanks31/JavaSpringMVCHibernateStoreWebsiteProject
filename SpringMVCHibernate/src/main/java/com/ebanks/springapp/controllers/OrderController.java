package com.ebanks.springapp.controllers;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.ebanks.springapp.filters.MetricService;
import com.ebanks.springapp.service.OrderService;

// TODO: Auto-generated Javadoc
/**
 * The HomeController for handling REST request from the home page.
 */
@Controller
public class OrderController {

	/** The Constant ORDER_CONTROLLER_LOGGER. */
	private static final Logger ORDER_CONTROLLER_LOGGER = Logger.getLogger(OrderController.class);

	/** The Constant ORDER. */
	private static final String ORDER = "order";

	/** The order service. */
	@Autowired
	OrderService orderService;

	//TODO: Need to more REST End points for Order Controller.

	/**
	 * Shows the user's order page.
	 *
	 * @param model            the model
	 * @return the page view
	 */
	@RequestMapping(value = "/orders", method = RequestMethod.GET)
	public String home(final Model model) {
		ORDER_CONTROLLER_LOGGER.info("Going to home page");

		return ORDER;
	}
}