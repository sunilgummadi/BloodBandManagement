package com.hcl.bb.service;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.model.User;
/**
 * 
 * 
 * @author HanumanSaiLakamsani (51897508)
 *
 */

public interface LoginService {

	public boolean validateUserLogin(User user) throws ApplicationException;
	public User validateUser(User user) throws ApplicationException;
}
