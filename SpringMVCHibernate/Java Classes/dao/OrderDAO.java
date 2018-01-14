package com.ebanks.springapp.dao;

import java.util.List;

import com.ebanks.springapp.model.Order;

/**
 * The Interface OrderDAO.
 */
public interface OrderDAO {

	/**
	 * Gets the order by id.
	 *
	 * @param orderId the order id
	 * @return the order by id
	 */
	Order getOrderById(int orderId);

	/**
	 * Gets the all orders.
	 *
	 * @return the all orders
	 */
	List<Order> getAllOrders();

	/**
	 * Removes the order.
	 *
	 * @param id the id
	 */
	void removeOrder(int id);

	/**
	 * Update order.
	 *
	 * @param order the order
	 */
	void updateOrder(Order order);

	/**
	 * Adds the order.
	 *
	 * @param order the order
	 */
	void addOrder(Order order);

}