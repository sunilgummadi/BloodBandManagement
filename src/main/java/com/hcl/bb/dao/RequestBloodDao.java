package com.hcl.bb.dao;

import com.hcl.bb.model.RequestBlood;
import com.hcl.bb.model.User;
/**
 * 
 * @author GummadiSunilKumar (51897413)
 *
 */
public interface RequestBloodDao {

	public boolean addRequest(RequestBlood requestBlood,User user);
}
