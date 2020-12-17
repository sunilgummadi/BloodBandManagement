package com.hcl.bb.dao;

import java.util.List;

import com.hcl.bb.model.RequestBlood;
import com.hcl.bb.model.User;
/**
 * 
 * @author GummadiSunilKumar (51897413)
 *
 */
public interface RequestStatusDao {

	public List<RequestBlood> getRequestList(User user);
}
