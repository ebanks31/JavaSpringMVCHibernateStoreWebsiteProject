package com.ebanks.springapp.service;
 
import java.util.List;
 










import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
 









import com.ebanks.springapp.dao.PersonDAO;
import com.ebanks.springapp.model.Person;
 
/**
 * The Class PersonServiceImpl.
 */
@Service
public class PersonServiceImpl implements PersonService {
	 
	@Autowired
    private PersonDAO personDAO;
 
    /**
     * Sets the person dao.
     *
     * @param personDAO the new person dao
     */
    public void setPersonDAO(PersonDAO personDAO) {
        this.personDAO = personDAO;
    }
 
    /* (non-Javadoc)
     * @see com.ebanks.springapp.service.PersonService#addPerson(com.ebanks.springapp.model.Person)
     */
    @Override
    @Transactional
    public void addPerson(Person person) {
        this.personDAO.addPerson(person);
    }
 
    /* (non-Javadoc)
     * @see com.ebanks.springapp.service.PersonService#updatePerson(com.ebanks.springapp.model.Person)
     */
    @Override
    @Transactional
    public void updatePerson(Person person) {
        this.personDAO.updatePerson(person);
    }
 
    /* (non-Javadoc)
     * @see com.ebanks.springapp.service.PersonService#listPersons()
     */
    @Override
    @Transactional
    public List<Person> listPersons() {
        return this.personDAO.listPersons();
    }
 
    /* (non-Javadoc)
     * @see com.ebanks.springapp.service.PersonService#getPersonById(int)
     */
    @Override
    @Transactional
    public Person getPersonById(int id) {
        return this.personDAO.getPersonById(id);
    }
 
    /* (non-Javadoc)
     * @see com.ebanks.springapp.service.PersonService#removePerson(int)
     */
    @Override
    @Transactional
    public void removePerson(int id) {
        this.personDAO.removePerson(id);
    }

    
    @Override
    @Transactional
	public List<Person> getPeopleByWithOwnership() {
		return this.personDAO.getPeopleByWithOwnership();
	}

    @Override
    @Transactional
	public List<Person> getPeopleByWithOutOwnership() {
		return this.personDAO.getPeopleByWithOutOwnership();
	}

    @Override
    @Transactional
	public List<Person> getPeopleByAddress(String address) {
		return this.personDAO.getPeopleByAddress(address);
	}


    @Override
    @Transactional
	public List<Object[]> getAddressListByGivenParameters(
			List<String> addressList) {
		return this.personDAO.getAddressListByGivenParameters(addressList);
	}

    @Override
    @Transactional
	public List<Person> getAllDistinctAddress() {
		return this.personDAO.getAllDistinctAddress();
	}

    @Override
    @Transactional
	public List<Person> listPersonsOrderbyLastNameASC() {
		return this.personDAO.listPersonsOrderbyLastNameASC();
	}

    @Override
    @Transactional
	public List<Person> listPersonsOrderbyLastNameDESC() {
		return this.personDAO.listPersonsOrderbyLastNameDESC();
	}

    @Override
    @Transactional
	public List<Person> listPersonsAboveOrEqualToLegalAge() {
		return this.personDAO.listPersonsAboveOrEqualToLegalAge();
	}

    @Override
    @Transactional
	public List<Person> listPersonsLessThanLegalAge() {
		return this.personDAO.listPersonsLessThanLegalAge();
	}

    @Override
    @Transactional
	public List<Person> getPersonListAverageMinMaxAge() {
		return this.personDAO.getPersonListAverageMinMaxAge();
	}

	@Override
	public List<Person> personsBySpecificAddress(String address) {
		// TODO Auto-generated method stub
		return this.personDAO.personsBySpecificAddress(address);
	}

	

 
}