package com.ebanks.springapp.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.SequenceGenerator;
import javax.persistence.Table;

// TODO: Auto-generated Javadoc
/**
 * Entity bean with JPA annotations for Person table.
 * Hibernate provides JPA implementation
 * @author ebanks
 *
 */
//@Entity
@Table(name="PRODUCT")
public class Product {

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

    /** The name. */
    private String name;

    /** The category. */
    private String category;

    /** The weight. */
    private double weight;

    /** The height. */
    private String height;

    /** The length. */
    private String length;

    /** The color. */
    private String color;

    /** The type. */
    private String type;

    /** The brand. */
    private String brand;

    /** The cost. */
    private double cost;

    /** The quantity. */
    private long quantity;

	/**
	 * Gets the brand.
	 *
	 * @return the brand
	 */
	public String getBrand() {
		return brand;
	}

	/**
	 * Sets the brand.
	 *
	 * @param brand the new brand
	 */
	public void setBrand(String brand) {
		this.brand = brand;
	}

	/**
	 * Gets the cost.
	 *
	 * @return the cost
	 */
	public double getCost() {
		return cost;
	}

	/**
	 * Sets the cost.
	 *
	 * @param cost the new cost
	 */
	public void setCost(double cost) {
		this.cost = cost;
	}

	/**
	 * Gets the name.
	 *
	 * @return the name
	 */
	public String getName() {
		return name;
	}

	/**
	 * Gets the category.
	 *
	 * @return the category
	 */
	public String getCategory() {
		return category;
	}

	/**
	 * Gets the weight.
	 *
	 * @return the weight
	 */
	public double getWeight() {
		return weight;
	}

	/**
	 * Gets the height.
	 *
	 * @return the height
	 */
	public String getHeight() {
		return height;
	}

	/**
	 * Gets the length.
	 *
	 * @return the length
	 */
	public String getLength() {
		return length;
	}

	/**
	 * Gets the color.
	 *
	 * @return the color
	 */
	public String getColor() {
		return color;
	}

	/**
	 * Gets the type.
	 *
	 * @return the type
	 */
	public String getType() {
		return type;
	}

	/**
     * Gets the quantity.
     *
     * @return the quantity
     */
    public long getQuantity() {
		return quantity;
	}

	/**
	 * Sets the quantity.
	 *
	 * @param quantity the new quantity
	 */
	public void setQuantity(long quantity) {
		this.quantity = quantity;
	}

	/**
	 * Sets the name.
	 *
	 * @param name the new name
	 */
	public void setName(String name) {
		this.name = name;
	}

	/**
	 * Sets the category.
	 *
	 * @param category the new category
	 */
	public void setCategory(String category) {
		this.category = category;
	}

	/**
	 * Sets the weight.
	 *
	 * @param weight the new weight
	 */
	public void setWeight(double weight) {
		this.weight = weight;
	}

	/**
	 * Sets the height.
	 *
	 * @param height the new height
	 */
	public void setHeight(String height) {
		this.height = height;
	}

	/**
	 * Sets the length.
	 *
	 * @param length the new length
	 */
	public void setLength(String length) {
		this.length = length;
	}

	/**
	 * Sets the color.
	 *
	 * @param color the new color
	 */
	public void setColor(String color) {
		this.color = color;
	}

	/**
	 * Sets the type.
	 *
	 * @param type the new type
	 */
	public void setType(String type) {
		this.type = type;
	}

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
    public void setId(final int id) {
        this.id = id;
    }


	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public final String toString(){
        return "id=" + id+", name=" + name + " brand = " + brand;
    }
}