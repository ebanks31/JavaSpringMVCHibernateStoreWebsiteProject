package com.ebanks.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebanks.springapp.dao.OrderDAO;
import com.ebanks.springapp.dao.ProductDAO;
import com.ebanks.springapp.model.Order;

/**
 * The implementation of the order service interface.
 */
@Service
public class OrderServiceImpl implements OrderService {

	/** The order DAO. */
	@Autowired
    private OrderDAO orderDAO;

	/**
	 * {@inheritDoc}
	 *
	 * @param orderId
	 *            the orderId
	 */
	@Override
	public Order getOrderById(int orderId) {
		return orderDAO.getOrderById(orderId);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	public List<Order> getAllOrders() {
		return orderDAO.getAllOrders();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param orderId
	 *            the orderId
	 */
	@Override
	public void removeOrder(int orderId) {
		orderDAO.removeOrder(orderId);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param order
	 *            the Order object
	 */
	@Override
	public void updateOrder(Order order) {
		orderDAO.updateOrder(order);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param order
	 *            the Order object
	 */
	@Override
	public void addOrder(Order order) {
		orderDAO.addOrder(order);
	}
}
