package com.ebanks.springapp.service;

import java.util.List;

import com.ebanks.springapp.model.Product;
/**
 * The Interface PersonService.
 */
public interface ProductService {

	/**
	 * Adds the product.
	 *
	 * @param product the product
	 */
	void addProduct(Product product);

	/**
	 * Update product.
	 *
	 * @param product the product
	 */
	void updateProduct(Product product);

	/**
	 * List products.
	 *
	 * @return the list
	 */
	List<Product> listProducts();

	/**
	 * Gets the product by id.
	 *
	 * @param id the id
	 * @return the product by id
	 */
	Product getProductById(int id);

	/**
	 * Removes the product.
	 *
	 * @param id the id
	 */
	void removeProduct(int id);

}
