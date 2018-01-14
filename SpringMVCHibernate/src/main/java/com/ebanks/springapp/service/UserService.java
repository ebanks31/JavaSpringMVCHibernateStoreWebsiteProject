package com.ebanks.springapp.service;

import java.util.List;

import com.ebanks.springapp.model.User;

/**
 * The interface class for the UserService.
 */
public interface UserService {

    /**
     * Adds the person.
     *
     * @param p the p
     */
    void addUser(User person);

    /**
     * Update person.
     *
     * @param p the p
     */
    void updateUser(User person);

    /**
     * List persons.
     *
     * @return the list
     */
    List<User> listUsers();

    /**
     * Gets the person by id.
     *
     * @param id the id
     * @return the person by id
     */
    User getUserById(int id);

    /**
     * Removes the person.
     *
     * @param id the id
     */
    void removeUser(int id);

    /**
     * Gets the users by address.
     *
     * @param idList the id list
     * @return the people by address
     */
    List<User> getUsersByAddress(String address);

    /**
     * Gets the users by with ownership.
     *
     * @param idList the id list
     * @return the people by with ownership
     */
    List<User> getUsersByOwnership();

    /**
     * Gets the users by without ownership.
     *
     * @param idList the id list
     * @return the people by without ownership
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
	 * @return the distinct address by users
	 */
	List<User> getUsersByDistinctAddress();

	/**
	 * List users that are ordered by last name asc.
	 *
	 * @return the list
	 */
	List<User> listUsersOrderbyLastNameASC();

	/**
	 * List users that are ordered by last name desc.
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
	 * List users by less than legal age.
	 *
	 * @return the list
	 */
	List<User> listUsersLessThanLegalAge();

	/**
	 * Gets the users by average min max age.
	 *
	 * @return the person list average min max age
	 */
	List<User> getUsersByAverageMinMaxAge();

	/**
	 * Users by specific address.
	 *
	 * @param address the address
	 * @return the users by specific address
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
