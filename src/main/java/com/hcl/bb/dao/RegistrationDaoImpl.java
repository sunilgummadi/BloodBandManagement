package com.hcl.bb.dao;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.model.User;
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
	
	public boolean doesUserExists(User user) throws ApplicationException {
		
		Long user_count;
		String sql="SELECT COUNT(userId)  FROM User user WHERE user.userName=:username";
		
		Session session=sessionFactory.getCurrentSession();
		Query query=session.createQuery(sql);
		query.setString("username",user.getUserName());
		user_count=(Long) query.uniqueResult();
		
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
		Session session=sessionFactory.getCurrentSession();
    	session.save(user);
    	return true;
	}

	
}
