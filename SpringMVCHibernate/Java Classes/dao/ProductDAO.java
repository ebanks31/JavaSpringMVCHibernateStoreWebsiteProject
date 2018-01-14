package com.ebanks.springapp.dao;

import java.util.List;

import org.hibernate.Session;

import com.ebanks.springapp.model.Product;
import com.ebanks.springapp.model.User;

/**
 * The Interface PersonDAO.
 */
public interface ProductDAO {

	/**
	 * Lists all products from the product table.
	 *
	 * @return the all products
	 */
	List<Product> listProducts();

	/**
	 * Gets all products by id.
	 *
	 * @param productId the product id
	 * @return the product based on id
	 */
	Product getProductById(int productId);

	/**
	 * Gets the products by cost.
	 *
	 * @param cost the cost
	 * @return the products by cost
	 */
	List<Product> getProductsByCost(String cost);

	/**
	 * Gets the products by brand.
	 *
	 * @param brand the brand
	 * @return the products by brand
	 */
	List<Product> getProductsByBrand(String brand);

	/**
	 * Gets the products by weight.
	 *
	 * @param weight the weight
	 * @return the products by weight
	 */
	List<Product> getProductsByWeight(double weight);

	/**
	 * Gets the product by name.
	 *
	 * @param name the name
	 * @return the product by name
	 */
	Product getProductByName(String name);

	/**
	 * Adds the person.
	 *
	 * @param product the product
	 */
	void addProduct(Product product);

	/**
	 * Removes the person.
	 *
	 * @param id the id
	 */
	void removeProduct(int id);

	/**
	 * Update person.
	 *
	 * @param product the product
	 */
	void updateProduct(Product product);
}