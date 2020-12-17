package com.hcl.bb.dao;

import com.hcl.bb.model.DonateBlood;
import com.hcl.bb.model.User;
/**
 * 
 * @author KanumuriSaketh (51897445)
 *
 */
public interface DonateBloodDao {

	public boolean addDonar(DonateBlood donateBlood,User user);
}
