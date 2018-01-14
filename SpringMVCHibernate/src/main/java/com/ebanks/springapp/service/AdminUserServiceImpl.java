package com.ebanks.springapp.service;

import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ebanks.springapp.dao.UserDAO;
import com.ebanks.springapp.model.User;

/**
 * The Class PersonServiceImpl.
 */
@Service
public class AdminUserServiceImpl implements AdminUserService {

	@Autowired
    private UserDAO userDAO;

    /**
     * Sets the person dao.
     *
     * @param personDAO the new person dao
     */
    public void setUserDAO(final UserDAO userDAO) {
        this.userDAO = userDAO;
    }

    /**
     * {@inheritDoc}
     *
     * @param person the person
     */
    @Override
    @Transactional
    public void addPerson(final User person) {
        this.userDAO.addPerson(person);
    }

    /**
     * {@inheritDoc}
     *
     * @param person the person
     */
    @Override
    @Transactional
    public void updatePerson(final User person) {
        this.userDAO.updatePerson(person);
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public List<User> listPersons() {
        return this.userDAO.listPersons();
    }

    /**
     * {@inheritDoc}
     */
    @Override
    @Transactional
    public User getPersonById(final int id) {
        return this.userDAO.getPersonById(id);
    }

    /**
     * {@inheritDoc}
     *
     * @param id the id
     */
    @Override
    @Transactional
    public void removePerson(final int id) {
        this.userDAO.removePerson(id);
    }

    /**
     * {@inheritDoc}
     */
    @Override
	@Transactional
	public final List<User> getPeopleByWithOwnership() {
		return this.userDAO.getPeopleByWithOwnership();
	}

    /**
     * {@inheritDoc}
     */
    @Override
	@Transactional
	public final List<User> getPeopleByWithOutOwnership() {
		return this.userDAO.getPeopleByWithOutOwnership();
	}

    /**
     * {@inheritDoc}
     *
     * @param address the address
     */
    @Override
	@Transactional
	public final List<User> getPeopleByAddress(final String address) {
		return this.userDAO.getPeopleByAddress(address);
	}

    /**
     * {@inheritDoc}
     */
    @Override
	@Transactional
	public final List<Object[]> getAddressListByGivenParameters(
			final List<String> addressList) {
		return this.userDAO.getAddressListByGivenParameters(addressList);
	}

	/**
	 * {@inheritDoc}
	 */
    @Override
	@Transactional
	public final List<User> getAllDistinctAddress() {
		return this.userDAO.getAllDistinctAddress();
	}

    /**
     * {@inheritDoc}
     */
    @Override
	@Transactional
	public final List<User> listPersonsOrderbyLastNameASC() {
		return this.userDAO.listPersonsOrderbyLastNameASC();
	}

    /**
     * {@inheritDoc}
     */
    @Override
	@Transactional
	public final List<User> listPersonsOrderbyLastNameDESC() {
		return this.userDAO.listPersonsOrderbyLastNameDESC();
	}

    /**
     * {@inheritDoc}
     */
    @Override
	@Transactional
	public final List<User> listPersonsAboveOrEqualToLegalAge() {
		return this.userDAO.listPersonsAboveOrEqualToLegalAge();
	}

    /**
     * {@inheritDoc}
     */
    @Override
	@Transactional
	public final List<User> listPersonsLessThanLegalAge() {
		return this.userDAO.listPersonsLessThanLegalAge();
	}

    /**
     * {@inheritDoc}
     */
    @Override
	@Transactional
	public final List<User> getPersonListAverageMinMaxAge() {
		return this.userDAO.getPersonListAverageMinMaxAge();
	}

    /**
     * {@inheritDoc}
     *
     * @param address the address
     */
	@Override
	public final List<User> personsBySpecificAddress(final String address) {
		return this.userDAO.personsBySpecificAddress(address);
	}
}
