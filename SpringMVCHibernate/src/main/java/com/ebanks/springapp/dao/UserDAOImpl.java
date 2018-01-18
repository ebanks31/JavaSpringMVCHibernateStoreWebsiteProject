package com.ebanks.springapp.dao;

import java.util.List;

import org.hibernate.Criteria;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.criterion.Order;
import org.hibernate.criterion.ProjectionList;
import org.hibernate.criterion.Projections;
import org.hibernate.criterion.Restrictions;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Repository;
import org.springframework.util.CollectionUtils;

import com.ebanks.springapp.model.User;

/**
 * The Class UserDAOImpl.
 */
@SuppressWarnings("unchecked")
@Repository
public class UserDAOImpl implements UserDAO {

	private static final Logger USER_LOGGER = LoggerFactory.getLogger(UserDAOImpl.class);

	private SessionFactory sessionFactory;
	private static final int LEGAL_AGE = 18;
	private static final String FROM_USER_TABLE = "from User";
	private static final String ADDRESS = "address";
	private static final String AGE = "age";
	private static final String LASTNAME = "lastname";
	private static final String OWNERSHIP = "ownership";
	private static final String NONOWNERSHIP = "non-owner";

	/**
	 * Sets the session factory.
	 *
	 * @param sessionFactory the new session factory
	 */
	public void setSessionFactory(final SessionFactory sessionFactory) {
		this.sessionFactory = sessionFactory;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param user the user
	 */
	@Override
	public void addUser(final User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.persist(user);
		USER_LOGGER.info(String.format("User saved successfully, User Details = %s", user));
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param user the user
	 */
	@Override
	public final void updateUser(final User user) {
		Session session = this.sessionFactory.getCurrentSession();
		session.update(user);
		USER_LOGGER.info(String.format("User updated successfully, User Details = %s", user));
	}


	/**
	 * {@inheritDoc}
	 *
	 * @param id the id
	 */
	@Override
	public void removeUser(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(id));

		if (user != null) {
			session.delete(user);
		}
		USER_LOGGER.info(String.format("User deleted successfully, user details = %s", user));
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsers() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery(FROM_USER_TABLE).list();
		for (User user : usersList) {
			USER_LOGGER.info(String.format("User List::%s", user));
			USER_LOGGER.info("user.getId: " + user.getId());
			USER_LOGGER.info("user.getFirstName: " + user.getFirstName());
			USER_LOGGER.info("user.getLastName: " + user.getLastName());
			USER_LOGGER.info("user.getAge: " + user.getAge());
		}

		USER_LOGGER.info("usersList: " + usersList);

		return usersList;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsersOrderbyLastNameASC() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery(FROM_USER_TABLE).list();
		Criteria criteria = session.createCriteria(User.class)
				.addOrder(Order.asc(LASTNAME));
		List<User> countList = criteria.list();
		for (User user : usersList) {
			USER_LOGGER.info(String.format("User List:: %s", user));
		}
		return countList;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsersOrderbyLastNameDESC() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery(FROM_USER_TABLE).list();
		Criteria criteria = session.createCriteria(User.class)
				.addOrder(Order.asc(LASTNAME));
		List<User> countList = criteria.list();
		for (User user : usersList) {
			USER_LOGGER.info(String.format("User List:: %s", user));
		}
		return countList;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsersAboveOrEqualToLegalAge() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery(FROM_USER_TABLE).list();
		Criteria criteria = session.createCriteria(User.class)
				.addOrder(Order.asc(AGE));

		criteria.add(Restrictions.ge(AGE, LEGAL_AGE));

		List<User> countList = criteria.list();
		for (User user : usersList) {
			USER_LOGGER.info(String.format("User List:: %s", user));
		}
		return countList;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> listUsersLessThanLegalAge() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery(FROM_USER_TABLE).list();
		Criteria criteria = session.createCriteria(User.class).addOrder(Order.asc(AGE));

		criteria.add(Restrictions.lt(AGE, LEGAL_AGE));
		List<User> countList = criteria.list();
		for (User user : usersList) {
			USER_LOGGER.info(String.format("User List:: %s", user));
		}
		return countList;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersByAverageMinMaxAge() {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria criteria = session.createCriteria(User.class);

		ProjectionList projectionList = Projections.projectionList();
		projectionList.add(Projections.min(AGE));
		projectionList.add(Projections.max(AGE));
		projectionList.add(Projections.avg(AGE));
		criteria.setProjection(projectionList);
		return criteria.list();
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param id the id
	 */
	@Override
	public User getUserById(final int id) {
		Session session = this.sessionFactory.getCurrentSession();
		User user = (User) session.load(User.class, new Integer(id));
		USER_LOGGER.info(String.format("User loaded successfully, User details = %s", user));
		return user;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param username the username
	 */
	@Override
	public User getUserByUserName(final String username) {
		Session session = this.sessionFactory.getCurrentSession();
		Criteria crit = session.createCriteria(User.class);
		crit.add(Restrictions.eq("username", username));
		crit.setMaxResults(1);

		User user = (User) crit.uniqueResult();

		USER_LOGGER.info("product.getFirstName: " + user.getEmail());

		return (User) crit.uniqueResult();
	}


	/**
	 * {@inheritDoc}
	 *
	 * @param address the address
	 */
	@SuppressWarnings("unchecked")
	@Override
	public final List<User> getUsersByAddress(final String address) {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery(FROM_USER_TABLE).list();

		Criteria criteria = session.createCriteria(User.class).add(Restrictions.eq(ADDRESS, address));

		// ProjectionList columns = Projections.projectionList()
		// .add(Projections.property(ADDRESS));
		// criteria.setProjection(columns);

		List<User> usersCriteriaList = criteria.list();

		for (User user : usersList) {
			USER_LOGGER.info(String.format("User List:: %s", user));
		}
		return usersCriteriaList;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public final List<User> getUsersByOwnership() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery(FROM_USER_TABLE).list();

		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.eq(OWNERSHIP, NONOWNERSHIP));
		List<User> usersCriteriaList = criteria.list();

		for (User user : usersList) {
			USER_LOGGER.info(String.format("User List:: %s", user));
		}
		return usersCriteriaList;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public final List<User> getUsersByWithOutOwnership() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery(FROM_USER_TABLE).list();

		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.eq(OWNERSHIP, NONOWNERSHIP));
		List<User> usersCriteriaList = criteria.list();

		for (User user : usersList) {
			USER_LOGGER.info(String.format("User List:: %s", user));
		}
		return usersCriteriaList;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param addressList the address list
	 */
	@Override
	public final List<Object[]> getUsersByAddressListByGivenParameters(final List<String> addressList) {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery(FROM_USER_TABLE).list();
		// Gets address by ArrayList of Strings passed in.
		// Criteria criteria = session.createCriteria(User.class);

		Criteria criteria = session.createCriteria(User.class);
		// .createAlias("courses", "course")
		// .createAlias("course.group", "student")
		// .add(Restrictions.eq("course.name", "Math"))
		// .add(Restrictions.eq("student.name", "John"));

		int index = 0;

		if (!CollectionUtils.isEmpty(addressList)) {
			for (int i = 1; i < addressList.size(); i++) {
				criteria.add(Restrictions.or(Restrictions.eq(ADDRESS, addressList.get(index)),
						Restrictions.eq(ADDRESS, addressList.get(i))));
				i++;
				index++;
			}
		}

		ProjectionList columns = Projections.projectionList()
				.add(Projections.property(ADDRESS));
		criteria.setProjection(Projections.distinct(columns));

		List<Object[]> usersCriteriaList = criteria.list();

		for (User user : usersList) {
			USER_LOGGER.info(String.format("User List:: %s", user));
		}

		return usersCriteriaList;
	}

	/**
	 * {@inheritDoc}
	 */
	@SuppressWarnings("unchecked")
	@Override
	public List<User> getUsersByDistinctAddress() {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery(FROM_USER_TABLE).list();

		Criteria criteria = session.createCriteria(User.class);
		ProjectionList columns = Projections.projectionList()
				.add(Projections.property(ADDRESS));
		criteria.setProjection(Projections.distinct(columns));

		List<User> usersCriteriaList = criteria.list();

		for (User user : usersList) {
			USER_LOGGER.info(String.format("User List:: %s",user));
		}
		return usersCriteriaList;
	}

	/**
	 * {@inheritDoc}
	 *
	 * @param address the address
	 */
	@Override
	public List<User> getUsersBySpecificAddress(final String address) {
		Session session = this.sessionFactory.getCurrentSession();
		List<User> usersList = session.createQuery(FROM_USER_TABLE).list();

		Criteria criteria = session.createCriteria(User.class)
				.add(Restrictions.eq(ADDRESS, ADDRESS));

		List<User> usersCriteriaList = criteria.list();

		for (User user : usersList) {
			USER_LOGGER.info(String.format("User List:: %s ", user));
		}

		return usersCriteriaList;
	}

}