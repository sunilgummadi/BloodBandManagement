package com.hcl.bb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.dao.AdminDao;
import com.hcl.bb.model.Admin;
import com.hcl.bb.model.DonateBlood;
import com.hcl.bb.model.RequestBlood;
/**
 * MokaSaiSuryaPrakash (51897451)
 */
@Service("adminService")
public class AdminServiceImpl implements AdminService{

	@Autowired
	private AdminDao adminDao;
	
	public boolean validateAdmin(Admin admin) throws ApplicationException {
		return adminDao.validateAdmin(admin);
	}

	@Transactional
	public List<RequestBlood> getRequestList() {
		
		return adminDao.getRequestList();
	}

	@Transactional
	public boolean acceptRequest(long patientId) {
		return adminDao.acceptRequest(patientId);
	}

	@Transactional
	public boolean rejectRequest(long patientId) {
	
		return adminDao.rejectRequest(patientId);
	}

	@Transactional
	public List<DonateBlood> getDonarList() {
	
		return adminDao.getDonarList();
	}

	@Transactional
	public boolean acceptDonar(long patientId) {
		
		return adminDao.acceptDonar(patientId);
	}

	@Transactional
	public boolean rejectDonar(long patientId) {
		
		return adminDao.rejectDonar(patientId);
	}

}
