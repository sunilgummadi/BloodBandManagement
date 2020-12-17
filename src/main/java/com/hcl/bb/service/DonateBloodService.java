package com.hcl.bb.service;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.model.DonateBlood;
import com.hcl.bb.model.User;
/**
 * 
 * @author KanumuriSaketh (51897445)
 *
 */
public interface DonateBloodService {

	public boolean validateDetails(DonateBlood donateBlood) throws ApplicationException;
	public boolean addDonar(DonateBlood donateBlood,User user);
	
}
