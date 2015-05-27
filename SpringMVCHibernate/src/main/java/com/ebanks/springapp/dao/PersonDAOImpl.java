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
 














import com.ebanks.springapp.model.Person;
 
/**
 * The Class PersonDAOImpl.
 */
@SuppressWarnings("unchecked")
@Repository
public class PersonDAOImpl implements PersonDAO {
     
    private static final Logger logger = LoggerFactory.getLogger(PersonDAOImpl.class);
 
    private SessionFactory sessionFactory;
    public static final int legalAge = 18;
    /**
     * Sets the session factory.
     *
     * @param sf the new session factory
     */
    public void setSessionFactory(SessionFactory sessionFactory){
        this.sessionFactory = sessionFactory;
    }
 
    /* (non-Javadoc)
     * @see com.ebanks.springapp.dao.PersonDAO#addPerson(com.ebanks.springapp.model.Person)
     */
    @Override
    public void addPerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.persist(person);
        logger.info("Person saved successfully, Person Details=" + person);
    }
 
    @Override
    public void updatePerson(Person person) {
        Session session = this.sessionFactory.getCurrentSession();
        session.update(person);
        logger.info("Person updated successfully, Person Details=" + person);
    }
 
    /* (non-Javadoc)
     * @see com.ebanks.springapp.dao.PersonDAO#listPersons()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersons() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        for(Person person : personsList){
            logger.info("Person List::"+ person);
        }
        return personsList;
    }
 
    /* (non-Javadoc)
     * @see com.ebanks.springapp.dao.PersonDAO#listPersons()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersonsOrderbyLastNameASC() {
        Session session = this.sessionFactory.getCurrentSession();	
        List<Person> personsList = session.createQuery("from Person").list();
        Criteria criteria = session.createCriteria(Person.class)
        		.addOrder(Order.asc("lastName"));	
        List<Person> countList = criteria.list();
        for(Person person : personsList){
            logger.info("Person List::"+ person);
        }
        return countList;
    }
    
    /* (non-Javadoc)
     * @see com.ebanks.springapp.dao.PersonDAO#listPersons()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersonsOrderbyLastNameDESC() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();	
        Criteria criteria = session.createCriteria(Person.class)
        		.addOrder(Order.asc("lastName"));	
        List<Person> countList = criteria.list();
        for(Person person : personsList){
            logger.info("Person List::"+ person);
        }
        return countList;
    }
    
    
    /* (non-Javadoc)
     * @see com.ebanks.springapp.dao.PersonDAO#listPersons()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersonsAboveOrEqualToLegalAge() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        Criteria criteria = session.createCriteria(Person.class)
        		.addOrder(Order.asc("age"));		
        
        criteria.add(Restrictions.ge("age", legalAge));
    
        List<Person> countList = criteria.list();
        for(Person person : personsList){
            logger.info("Person List::"+ person);
        }
        return countList;
    }
    
    
    /* (non-Javadoc)
     * @see com.ebanks.springapp.dao.PersonDAO#listPersons()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> listPersonsLessThanLegalAge() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        Criteria criteria = session.createCriteria(Person.class)
        		.addOrder(Order.asc("age"));		
        
        criteria.add(Restrictions.lt("age", legalAge));
        List<Person> countList = criteria.list();
        for(Person person : personsList){
            logger.info("Person List::"+ person);
        }
        return countList;
    }
    
    /* (non-Javadoc)
     * @see com.ebanks.springapp.dao.PersonDAO#listPersons()
     */
    @SuppressWarnings("unchecked")
    @Override
    public List<Person> getPersonListAverageMinMaxAge() {
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        Criteria criteria = session.createCriteria(Person.class);		
        
        ProjectionList projectionList=Projections.projectionList();
        projectionList.add(Projections.min("age"));
        projectionList.add(Projections.max("age"));
        projectionList.add(Projections.avg("age"));
        criteria.setProjection(projectionList);
        List<Person> countList = criteria.list();
        
        return countList;
    }
    
    /* (non-Javadoc)
     * @see com.ebanks.springapp.dao.PersonDAO#getPersonById(int)
     */
    @Override
    public Person getPersonById(int id) {
        Session session = this.sessionFactory.getCurrentSession();      
        Person person = (Person) session.load(Person.class, new Integer(id));
        logger.info("Person loaded successfully, Person details="+person);
        return person;
    }
 
    /* (non-Javadoc)
     * @see com.ebanks.springapp.dao.PersonDAO#removePerson(int)
     */
    @Override
    public void removePerson(int id) {
        Session session = this.sessionFactory.getCurrentSession();
        Person person = (Person) session.load(Person.class, new Integer(id));
        if(null != person){
            session.delete(person);
        }
        logger.info("Person deleted successfully, person details=" + person);
    }

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getPeopleByAddress(List<Integer> idList, String address) {
		// TODO Auto-generated method stub
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        
        Criteria criteria = session.createCriteria(Person.class)
        .add(Restrictions.eq("address", address));
        
     //   ProjectionList columns = Projections.projectionList()
      //          .add(Projections.property("address"));
//criteria.setProjection(columns);

        List<Person> personsCriteriaList = criteria.list();
        
        for(Person person : personsList){
            logger.info("Person List::"+ person);
        }
        return personsCriteriaList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getPeopleByWithOwnership(List<Integer> idList) {
		// TODO Auto-generated method stub
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        
        Criteria criteria = session.createCriteria(Person.class)
        .add(Restrictions.eq("ownership", "non-owner"));
        List<Person> personsCriteriaList = criteria.list();
        
        
        for(Person person : personsList){
            logger.info("Person List::"+ person);
        }
        return personsCriteriaList;
	}

	@SuppressWarnings("unchecked")
	@Override
	public List<Person> getPeopleByWithOutOwnership(List<Integer> idList) {
		// TODO Auto-generated method stub
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        
        Criteria criteria = session.createCriteria(Person.class)
        .add(Restrictions.eq("ownership", "non-owner"));
        List<Person> personsCriteriaList = criteria.list();
        
        for(Person person : personsList){
            logger.info("Person List::"+ person);
        }
        return personsCriteriaList;
	}

	@Override
	public List<Object[]> getAddressListByGivenParameters(List<String> addressList) {
		// TODO Auto-generated method stub
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        // Gets address by ArrayList of Strings passed in.
        // Criteria criteria = session.createCriteria(Person.class);
        
        Criteria criteria = session.createCriteria(Person.class);
        	//    .createAlias("courses", "course")
        	//    .createAlias("course.group", "student")
        	 //   .add(Restrictions.eq("course.name", "Math"))
        	 //   .add(Restrictions.eq("student.name", "John"));
        
        int index = 0;
        
        if (addressList.size()!=0)
        {
        for (int i = 1; i<addressList.size(); i++)
        {
        	criteria.add(Restrictions.or(Restrictions.eq("address", addressList.get(index)),Restrictions.eq("address", addressList.get(i) )));
        	i++;
        	index++;
        }
        }
       
        ProjectionList columns = Projections.projectionList()
                .add(Projections.property("address"));
        criteria.setProjection(Projections.distinct(columns));
        
	List<Object[]> personsCriteriaList = criteria.list();
        
        for(Person person : personsList){
            logger.info("Person List::"+ person);
        }
        return personsCriteriaList;
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public List<Object[]> getAllDistinctAddress() {
		// TODO Auto-generated method stub
        Session session = this.sessionFactory.getCurrentSession();
        List<Person> personsList = session.createQuery("from Person").list();
        
        Criteria criteria = session.createCriteria(Person.class);
        ProjectionList columns = Projections.projectionList()
                .add(Projections.property("address"));
criteria.setProjection(Projections.distinct(columns));

        List<Object[]> personsCriteriaList = criteria.list();
        
        for(Person person : personsList){
            logger.info("Person List::"+ person);
        }
        return personsCriteriaList;
	}

 
}