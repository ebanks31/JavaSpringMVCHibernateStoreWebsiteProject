package com.ebanks.springapp.service;

import java.util.List;
import com.ebanks.springapp.model.User;

/**
 * The Interface PersonService.
 */
public interface AdminUserService {

    /**
     * Adds the person.
     *
     * @param p the p
     */
    void addPerson(User person);

    /**
     * Update person.
     *
     * @param p the p
     */
    void updatePerson(User person);

    /**
     * List persons.
     *
     * @return the list
     */
    List<User> listPersons();

    /**
     * Gets the person by id.
     *
     * @param id the id
     * @return the person by id
     */
    User getPersonById(int id);

    /**
     * Removes the person.
     *
     * @param id the id
     */
    void removePerson(int id);

    /**
     * Gets the people by address.
     *
     * @param idList the id list
     * @return the people by address
     */
    List<User> getPeopleByAddress(String address);

    /**
     * Gets the people by with ownership.
     *
     * @param idList the id list
     * @return the people by with ownership
     */
    List<User> getPeopleByWithOwnership();

    /**
     * Gets the people by with out ownership.
     *
     * @param idList the id list
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
	 * Gets the all distinct address.
	 *
	 * @return the all distinct address
	 */
	List<User> getAllDistinctAddress();

	/**
	 * List persons order by last name asc.
	 *
	 * @return the list
	 */
	List<User> listPersonsOrderbyLastNameASC();

	/**
	 * List persons orderby last name desc.
	 *
	 * @return the list
	 */
	List<User> listPersonsOrderbyLastNameDESC();

	/**
	 * List persons above or equal to legal age.
	 *
	 * @return the list
	 */
	List<User> listPersonsAboveOrEqualToLegalAge();


	/**
	 * List persons less than legal age.
	 *
	 * @return the list
	 */
	List<User> listPersonsLessThanLegalAge();

	/**
	 * Gets the person list average min max age.
	 *
	 * @return the person list average min max age
	 */
	List<User> getPersonListAverageMinMaxAge();

	/**
	 * Persons by specific address.
	 *
	 * @param address the address
	 * @return the list
	 */
	List<User> personsBySpecificAddress(String address);
}
