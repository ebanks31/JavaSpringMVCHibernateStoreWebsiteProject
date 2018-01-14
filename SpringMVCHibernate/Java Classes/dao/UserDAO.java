package com.ebanks.springapp.dao;

import java.util.List;

import com.ebanks.springapp.model.User;

// TODO: Auto-generated Javadoc
/**
 * The interface class for the UserDAO.
 */
public interface UserDAO {

    /**
     * Adds a user.
     *
     * @param user the user
     */
    void addUser(User user);

    /**
     * Update a user.
     *
     * @param user the user
     */
    void updateUser(User user);

    /**
     * Retrieve list of users.
     *
     * @return the list
     */
    List<User> listUsers();

    /**
     * Gets a person by id.
     *
     * @param id the id
     * @return the user by id
     */
    User getUserById(int id);

    /**
     * Removes a user.
     *
     * @param id the id
     */
    void removeUser(int id);


    /**
     * Gets users by address.
     *
     * @param address the address
     * @return the users by address
     */
    List<User> getUsersByAddress(String address);



    /**
     * Gets a people by with ownership.
     *
     * @return the people by ownership
     */
    List<User> getUsersByOwnership();


    /**
     * Gets a people by with out ownership.
     *
     * @return the people by with out ownership
     */
    List<User> getUsersByWithOutOwnership();

	/**
	 * Gets the address list.
	 *
	 * @param addressList the address list
	 * @return the address list
	 */
	List<Object[]> getUsersByAddressListByGivenParameters(List<String> addressList);

	/**
	 * Gets users by distinct address.
	 *
	 * @return the users by distinct address
	 */
	List<User> getUsersByDistinctAddress();

	/**
	 * Get users that are ordered by last name ASC.
	 *
	 * @return the list
	 */
	List<User> listUsersOrderbyLastNameASC();

	/**
	 * Get users that are ordered by last name DESC.
	 *
	 * @return the list
	 */
	List<User> listUsersOrderbyLastNameDESC();

	/**
	 * List users above or equal to legal age.
	 *
	 * @return the list
	 */
	List<User> listUsersAboveOrEqualToLegalAge();

	/**
	 * List users less than legal age.
	 *
	 * @return the list
	 */
	List<User> listUsersLessThanLegalAge();

	/**
	 * Gets the users by average min max age.
	 *
	 * @return the users by average min max age
	 */
	List<User> getUsersByAverageMinMaxAge();

	/**
	 * Persons by specific address.
	 *
	 * @param address the address
	 * @return the list
	 */
	List<User> getUsersBySpecificAddress(String address);

	/**
	 * Gets the user by user name.
	 *
	 * @param email the email
	 * @return the user by user name (email)
	 */
	User getUserByUserName(String email);


}