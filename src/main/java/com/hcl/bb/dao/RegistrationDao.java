package com.hcl.bb.dao;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.model.User;
/**
 * 
 * 
 * @author HanumanSaiLakamsani (51897508)
 *
 */

public interface RegistrationDao {
	public boolean doesUserExists(User user) throws ApplicationException;
	public boolean addUser(User user);
}
