package com.ebanks.springapp.dao;
 
import java.util.List;
 






import com.ebanks.springapp.model.Person;
 
/**
 * The Interface PersonDAO.
 */
public interface PersonDAO {
 
    /**
     * Adds the person.
     *
     * @param p the p
     */
    public void addPerson(Person person);
    
    /**
     * Update person.
     *
     * @param p the p
     */
    public void updatePerson(Person person);
    
    /**
     * List persons.
     *
     * @return the list
     */
    public List<Person> listPersons();
    
    /**
     * Gets the person by id.
     *
     * @param id the id
     * @return the person by id
     */
    public Person getPersonById(int id);
    
    /**
     * Removes the person.
     *
     * @param id the id
     */
    public void removePerson(int id);
    
    
    /**
     * Gets the people by address.
     *
     * @param idList the id list
     * @return the people by address
     */
    public List<Person> getPeopleByAddress(List<Integer> idList, String address);
    
    

    /**
     * Gets the people by with ownership.
     *
     * @param idList the id list
     * @return the people by with ownership
     */
    public List<Person> getPeopleByWithOwnership(List<Integer> idList);
    
    
    /**
     * Gets the people by with out ownership.
     *
     * @param idList the id list
     * @return the people by with out ownership
     */
    public List<Person> getPeopleByWithOutOwnership(List<Integer> idList);

	/**
	 * Gets the address list.
	 *
	 * @param addressList the address list
	 * @return the address list
	 */
	public List<Object[]> getAddressListByGivenParameters(List<String> addressList);

	/**
	 * Gets the all distinct address.
	 *
	 * @return the all distinct address
	 */
	List<Object[]> getAllDistinctAddress();

	/**
	 * List persons order by last name asc.
	 *
	 * @return the list
	 */
	List<Person> listPersonsOrderbyLastNameASC();
	
	/**
	 * List persons orderby last name desc.
	 *
	 * @return the list
	 */
	List<Person> listPersonsOrderbyLastNameDESC();

	/**
	 * List persons above or equal to legal age.
	 *
	 * @return the list
	 */
	List<Person> listPersonsAboveOrEqualToLegalAge();


	/**
	 * List persons less than legal age.
	 *
	 * @return the list
	 */
	List<Person> listPersonsLessThanLegalAge();

	/**
	 * Gets the person list average min max age.
	 *
	 * @return the person list average min max age
	 */
	List<Person> getPersonListAverageMinMaxAge();


}