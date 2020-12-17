package com.hcl.bb.dao;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.model.User;
/**
 * 
 * @author LakamsaniHanumanSai(51897508)
 *
 */

public interface LoginDao {

	public User validateUser(User user) throws ApplicationException;
}
