package com.ebanks.springapp.dao;

import java.util.List;

import com.ebanks.springapp.model.User;

/**
 * The Interface PersonDAO.
 */
public interface AdminUserDAO {
    /**
     * Adds a user.
     *
     * @param person the person
     */
    void addPerson(User person);

    /**
     * Update a user.
     *
     * @param person the person
     */
    void updatePerson(User person);

    /**
     * Retrieve list of users.
     *
     * @return the list
     */
    List<User> listPersons();

    /**
     * Gets a user by id.
     *
     * @param id the id
     * @return the person by id
     */
    User getPersonById(int id);

    /**
     * Removes a person.
     *
     * @param id the id
     */
    void removePerson(int id);


    /**
     * Gets all users by address.
     *
     * @param address the address
     * @return the people by address
     */
    List<User> getPeopleByAddress(String address);



    /**
     * Gets all users by with ownership.
     *
     * @return the people by with ownership
     */
    List<User> getPeopleByWithOwnership();


    /**
     * Gets all users by with out ownership.
     *
     * @return the people by with out ownership
     */
    List<User> getPeopleByWithOutOwnership();

	/**
	 * Gets the address list.
	 *
	 * @param addressList the address list
	 * @return the address list
	 */
	List<Object[]> getAddressListByGivenParameters(List<String> addressList);

	/**
	 * Gets the users based on distinct addresses.
	 *
	 * @return the all distinct address
	 */
	List<User> getAllDistinctAddress();

	/**
	 * List users that are ordered by last name asc.
	 *
	 * @return the list
	 */
	List<User> listPersonsOrderbyLastNameASC();

	/**
	 * List all users that are ordered by last name desc.
	 *
	 * @return the list
	 */
	List<User> listPersonsOrderbyLastNameDESC();

	/**
	 * List all users above or equal to legal age.
	 *
	 * @return the list
	 */
	List<User> listPersonsAboveOrEqualToLegalAge();

	/**
	 * List all users less than legal age.
	 *
	 * @return the list
	 */
	List<User> listPersonsLessThanLegalAge();

	/**
	 * Gets all users that are average min max age.
	 *
	 * @return the person list average min max age
	 */
	List<User> getPersonListAverageMinMaxAge();

	/**
	 * Get all users by a specific address.
	 *
	 * @param address the address
	 * @return the list
	 */
	List<User> personsBySpecificAddress(String address);


}