package com.ebanks.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebanks.springapp.dao.OrderDAO;
import com.ebanks.springapp.dao.ProductDAO;
import com.ebanks.springapp.model.Order;


/**
 * The Class PersonServiceImpl.
 */
@Service
public class OrderServiceImpl implements OrderService {
	@Autowired
    private OrderDAO orderDAO;

	@Override
	public Order getOrderById(int orderId) {
		return orderDAO.getOrderById(orderId);
	}

	@Override
	public List<Order> getAllOrders() {
		return orderDAO.getAllOrders();
	}

	@Override
	public void removeOrder(int id) {
		orderDAO.removeOrder(id);
	}

	@Override
	public void updateOrder(Order order) {
		orderDAO.updateOrder(order);
	}

	@Override
	public void addOrder(Order order) {
		orderDAO.addOrder(order);
	}
}
