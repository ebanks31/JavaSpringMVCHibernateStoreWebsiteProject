package com.ebanks.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.ebanks.springapp.dao.ProductDAO;
import com.ebanks.springapp.model.Product;
import com.ebanks.springapp.model.User;

/**
 * The Class productServiceImpl.
 */
@Service
public class ProductServiceImpl implements ProductService {
	@Autowired
    private ProductDAO productDAO;

    /**
     * Sets the product DAO.
     *
     * @param productDAO the new product dao
     */
    public void setProductDAO(final ProductDAO productDAO) {
        this.productDAO = productDAO;
    }

    /**
     * {@inheritDoc}
     *
     * @param product the product
     */
    @Override
    @Transactional
    public void addProduct(final Product product) {
        this.productDAO.addProduct(product);
    }

    /**
     * {@inheritDoc}
     *
     * @param id the id
     */
    @Override
    @Transactional
    public void removeProduct(final int id) {
        this.productDAO.removeProduct(id);
    }

    /**
     * {@inheritDoc}
     *
     * @param product the product
     */
    @Override
    @Transactional
    public void updateProduct(final Product product) {
        this.productDAO.updateProduct(product);
    }

    /**
     * {@inheritDoc}
     *
     * @param id the id
     */
    @Override
    @Transactional
    public Product getProductById(final int id) {
        return this.productDAO.getProductById(id);
    }


    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<Product> listProducts() {
        return this.productDAO.listProducts();
    }
}
