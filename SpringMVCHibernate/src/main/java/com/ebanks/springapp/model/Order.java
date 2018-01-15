package com.ebanks.springapp.model;

import java.sql.Date;
import java.util.List;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

/**
 * Entity bean with JPA annotations for Order table.
 * Hibernate provides JPA implementation
 * @author ebanks
 *
 */
@Entity
@Table(name="ORDER")
public class Order {

    /** The id. */
    @Id
    @Column(name="id")
    @GeneratedValue(strategy=GenerationType.SEQUENCE, generator="person_seq")
    @SequenceGenerator(
        name="person_seq",
        sequenceName="person_seq",
        allocationSize=20
    )

    // Declaring columns of Person table for usage with Hibernate
    private int id;

    /** The user id. */
    private int userId;

    /** The product id. */
    private int productId;

    /** The lastmodified. */
    private Date lastmodified;

	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public int getId() {
		return id;
	}

	/**
	 * Sets the id.
	 *
	 * @param id the new id
	 */
	public void setId(int id) {
		this.id = id;
	}

	/**
	 * Gets the user id.
	 *
	 * @return the user id
	 */
	public int getUserId() {
		return userId;
	}

	/**
	 * Sets the user id.
	 *
	 * @param userId the new user id
	 */
	public void setUserId(int userId) {
		this.userId = userId;
	}

	/**
	 * Gets the product id.
	 *
	 * @return the product id
	 */
	public int getProductId() {
		return productId;
	}

	/**
	 * Sets the product id.
	 *
	 * @param productId the new product id
	 */
	public void setProductId(int productId) {
		this.productId = productId;
	}

	/**
	 * Gets the lastmodified.
	 *
	 * @return the lastmodified
	 */
	public Date getLastmodified() {
		return lastmodified;
	}

	/**
	 * Sets the lastmodified.
	 *
	 * @param lastmodified the new lastmodified
	 */
	public void setLastmodified(Date lastmodified) {
		this.lastmodified = lastmodified;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public final String toString(){
		return null;
        //return "id=" + id+", name=" + firstName+ " " + lastName + " age = " + age;
    }
}