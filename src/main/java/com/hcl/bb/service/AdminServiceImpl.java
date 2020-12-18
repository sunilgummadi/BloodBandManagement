package com.hcl.bb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.controller.AdminController;
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
	
	private static final Logger logger= LogManager.getLogger(AdminServiceImpl.class);

	public boolean validateAdmin(Admin admin) throws ApplicationException {
		logger.info("Admin entered into validateAdmin method of AdminSeerviceImpl class");
		return adminDao.validateAdmin(admin);
	}

	@Transactional
	public List<RequestBlood> getRequestList() {
		logger.info("Admin entered in to getRequestList method of AdminServiceImpl class");
		return adminDao.getRequestList();
	}

	@Transactional
	public boolean acceptRequest(long patientId) {
		logger.info("Admin entered in to acceptRequest method of AdminServiceImpl class");
		return adminDao.acceptRequest(patientId);
	}

	@Transactional
	public boolean rejectRequest(long patientId) {
	    logger.info("Admin entered in to rejectRequest method of AdminServiceImpl class");
		return adminDao.rejectRequest(patientId);
	}

	@Transactional
	public List<DonateBlood> getDonarList() {
	
		logger.info("Admin entered in to getDonarList method of AdminServiceImpl class");
		return adminDao.getDonarList();
	}

	@Transactional
	public boolean acceptDonar(long patientId) {
		logger.info("Admin entered in to acceptDonar method of AdminServiceImpl class");
		return adminDao.acceptDonar(patientId);
	}

	@Transactional
	public boolean rejectDonar(long patientId) {
		logger.info("Admin entered in to rejectDonar method of AdminServiceImpl class");
		return adminDao.rejectDonar(patientId);
	}

}
