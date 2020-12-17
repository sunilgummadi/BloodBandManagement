package com.hcl.bb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bb.dao.RequestStatusDao;
import com.hcl.bb.model.RequestBlood;
import com.hcl.bb.model.User;
/**
 * 
 * @author GummadiSunilKumar (51897413)
 *
 */
@Service("requestStatusService")
public class RequestStatusServiceImpl implements RequestStatusService{

	@Autowired
	private RequestStatusDao requestStatusDao;
	
	@Transactional
	public List<RequestBlood> getRequestList(User user) {
	
		return requestStatusDao.getRequestList(user);
	}

}
