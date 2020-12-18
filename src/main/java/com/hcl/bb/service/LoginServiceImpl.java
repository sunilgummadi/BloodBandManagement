package com.hcl.bb.service;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.dao.LoginDao;
import com.hcl.bb.model.User;
/**
 * 
 * 
 * @author HanumanSaiLakamsani (51897508)
 *
 */

@Service("loginService")
public class LoginServiceImpl implements LoginService {

	@Autowired
	private LoginDao loginDao;
	
	private static final Logger logger= LogManager.getLogger(LoginServiceImpl.class);

	public boolean validateUserLogin(User user) throws ApplicationException {
	  
		logger.info(user.getUserName()+" entered in to validateUserLogin method of LoginServiceImpl class");
		
		if(user.getUserName()==""||user.getPassword()=="")
		{
			throw new ApplicationException("All fields are mandatory");
		}
		else if(user.getUserName().length()<6 || user.getUserName().length()>25)
		{
			throw new ApplicationException("Username length should be in between 6-25");
		}
		else
		{
			return true;
		}	
		
	}

	@Transactional
	public User validateUser(User user) throws ApplicationException {
		
		logger.info(user.getUserName()+" entered in to validateUser method of LoginServiceImpl class");
		return loginDao.validateUser(user);
	}


}
