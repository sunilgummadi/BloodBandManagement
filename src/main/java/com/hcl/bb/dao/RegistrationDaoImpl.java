package com.hcl.bb.dao;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.model.User;
import com.hcl.bb.service.RegistrationServiceImpl;
/**
 * 
 * 
 * @author HanumanSaiLakamsani (51897508)
 *
 */

@Repository("registrationDao")
public class RegistrationDaoImpl implements RegistrationDao {

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger= LogManager.getLogger(RegistrationDaoImpl.class);

	public boolean doesUserExists(User user) throws ApplicationException {
		
		Long user_count;
		String sql="SELECT COUNT(userId)  FROM User user WHERE user.userName=:username";
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(sql);
		query.setString("username",user.getUserName());
		user_count=(Long) query.uniqueResult();
		logger.info(user.getUserName()+" entered in to doesUserExists method of RegistrationDaoImpl class");
		if(user_count==1)
		{
			throw new ApplicationException("User Name already in use. Please select a different User Name");
		}
		else
		{
			return false;
		}
	}

	public boolean addUser(User user) {
		logger.info(user.getUserName()+" entered into addUser method of RegistrationDaoImpl class");
		Session session=sessionFactory.getCurrentSession();
    	session.save(user);
    	return true;
	}	
}
