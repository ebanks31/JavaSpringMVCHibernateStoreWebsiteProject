package com.ebanks.springapp.service;

import java.util.Arrays;
import java.util.List;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import com.ebanks.springapp.dao.UserDAO;
import com.ebanks.springapp.model.User;
import com.hazelcast.core.HazelcastInstance;

// TODO: Auto-generated Javadoc
/**
 * The Class PersonServiceImpl.
 */
@Service
public class UserServiceImpl implements UserService {
	private final Map<String, User> userList = null;

	/** The user DAO. */
	@Autowired
	private UserDAO userDAO;

	/** The instance. */
	@Autowired
	private HazelcastInstance hazelcastInstance;

    @Autowired
    public UserServiceImpl(HazelcastInstance hazelcastInstance) {
        this.hazelcastInstance = hazelcastInstance;
    }

	/**
	 * Sets the person DAO.
	 *
	 * @param userDAO the new user DAO
	 */
	public void setUserDAO(final UserDAO userDAO) {
		this.userDAO = userDAO;
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public List<User> listUsers() {
		List<User> userList = this.userDAO.listUsers();
		instance.
		//Storing userlist in Hazel in-memory cache under queue name userList
		instance.getQueue("usersList").offer(userList);
		instance.remove(username);

		return userList;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param person
	 *            the person
	 */
	@Override
	@Transactional
	public void addUser(final User user) {
		this.userDAO.addUser(user);
	}

	/**
	 * Register user.
	 *
	 * @param user the user
	 * @throws Exception the exception
	 */
	public void registerUser(final User user) throws Exception {

		// Checks if a user exist. Throws an exception if user is not found/
		// TODO: New to make customer exception instead of having regular Exception
		if (checkIfUserExists(user)) {
			throw new Exception("User is already found");
		}
		user.setRoles(Arrays.asList("ROLE_USER"));

		userDAO.addUser(user);

	}

	/**
	 * Check if user exists.
	 *
	 * @param user the user
	 * @return true, if successful
	 */
	private boolean checkIfUserExists(final User user) {
		boolean userFound = false;

		// Check if users already exist
		User foundUser = userDAO.getUserById(user.getId());

		if (foundUser.getId() != 0) {
			userFound = true;
		}

		return userFound;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param person
	 *            the person
	 */
	@Override
	@Transactional
	public void updateUser(final User user) {
		this.userDAO.updateUser(user);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param id
	 *            the id
	 */
	@Override
	@Transactional
	public void removeUser(final int id) {
		this.userDAO.removeUser(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public User getUserById(final int id) {
		return this.userDAO.getUserById(id);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final List<User> getUsersByOwnership() {
		return this.userDAO.getUsersByOwnership();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final List<User> getUsersByWithOutOwnership() {
		return this.userDAO.getUsersByWithOutOwnership();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param address
	 *            the address
	 */
	@Override
	@Transactional
	public final List<User> getUsersByAddress(final String address) {
		return this.userDAO.getUsersByAddress(address);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final List<Object[]> getUsersByAddressListByGivenParameters(final List<String> addressList) {
		return this.userDAO.getUsersByAddressListByGivenParameters(addressList);
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final List<User> getUsersByDistinctAddress() {
		return this.userDAO.getUsersByDistinctAddress();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final List<User> listUsersOrderbyLastNameASC() {
		return this.userDAO.listUsersOrderbyLastNameASC();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final List<User> listUsersOrderbyLastNameDESC() {
		return this.userDAO.listUsersOrderbyLastNameDESC();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final List<User> listUsersAboveOrEqualToLegalAge() {
		return this.userDAO.listUsersAboveOrEqualToLegalAge();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final List<User> listUsersLessThanLegalAge() {
		return this.userDAO.listUsersLessThanLegalAge();
	}

	/**
	 * {@inheritDoc}
	 */
	@Override
	@Transactional
	public final List<User> getUsersByAverageMinMaxAge() {
		return this.userDAO.getUsersByAverageMinMaxAge();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param address
	 *            the address
	 */
	@Override
	public final List<User> getUsersBySpecificAddress(final String address) {
		return this.userDAO.getUsersBySpecificAddress(address);
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param email
	 *            the email
	 */
	@Override
	public final User getUserByUserName(final String email) {
		return this.userDAO.getUserByUserName(email);
	}
}
