package com.ebanks.springapp.service;

import java.util.List;

import com.ebanks.springapp.model.User;

// TODO: Auto-generated Javadoc
/**
 * The Interface UserService.
 */
public interface AdminUserService {

	/**
	 * Adds the user.
	 *
	 * @param user
	 *            the user
	 */
	void addUser(User user);

	/**
	 * Update user.
	 *
	 * @param user
	 *            the user
	 */
	void updateUser(User user);

	/**
	 * List users.
	 *
	 * @return the list
	 */
	List<User> listUsers();

	/**
	 * Gets the user by id.
	 *
	 * @param id
	 *            the id
	 * @return the user by id
	 */
	User getUserById(int id);

	/**
	 * Removes the user.
	 *
	 * @param id
	 *            the id
	 */
	void removeUser(int id);

	/**
	 * Gets the people by address.
	 *
	 * @param address
	 *            the address
	 * @return the people by address
	 */
	List<User> getUsersByAddress(String address);

	/**
	 * Gets the people by with ownership.
	 *
	 * @return the people by with ownership
	 */
	List<User> getUsersByOwnership();

	/**
	 * Gets the people by with out ownership.
	 *
	 * @return the people by with out ownership
	 */
	List<User> getUsersByWithOutOwnership();

	/**
	 * Gets the address list.
	 *
	 * @param addressList
	 *            the address list
	 * @return the address list
	 */
	List<Object[]> getUsersByAddressListByGivenParameters(List<String> addressList);

	/**
	 * Gets the all distinct address.
	 *
	 * @return the all distinct address
	 */
	List<User> getUsersByDistinctAddress();

	/**
	 * List users order by last name asc.
	 *
	 * @return the list
	 */
	List<User> listUsersOrderbyLastNameASC();

	/**
	 * List users orderby last name desc.
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
	 * Gets the user list average min max age.
	 *
	 * @return the user list average min max age
	 */
	List<User> getUsersByAverageMinMaxAge();

	/**
	 * Users by specific address.
	 *
	 * @param address
	 *            the address
	 * @return the list
	 */
	List<User> getUsersBySpecificAddress(String address);

	/**
	 * Gets the user by user name.
	 *
	 * @param email
	 *            the email
	 * @return the user by user name
	 */
	User getUserByUserName(String email);
}
