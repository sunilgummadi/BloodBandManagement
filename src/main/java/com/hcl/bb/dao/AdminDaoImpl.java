package com.hcl.bb.dao;

import java.util.List;

import org.apache.log4j.LogManager;
import org.apache.log4j.Logger;
import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.model.Admin;
import com.hcl.bb.model.DonateBlood;
import com.hcl.bb.model.RequestBlood;
import com.hcl.bb.service.AdminServiceImpl;
/**
 * MokaSaiSuryaPrakash (51897451)
 */
@Repository("adminDao")
public class AdminDaoImpl implements AdminDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	private static final Logger logger= LogManager.getLogger(AdminDaoImpl.class);


	public boolean validateAdmin(Admin admin) throws ApplicationException {
		
		logger.info("Admin entered into validateAdmin method of AdminDaoImpl class");

		if(admin.getUserName().equals("Admin") && admin.getPassword().equals("Admin@765"))
		{
			return true;
		}
	    
		else
		{
			throw new ApplicationException("Invalid Credentials");
		}
	}

	public List<RequestBlood> getRequestList() {
		
		logger.info("Admin entered in to getRequestList method of AdminDaoImpl class");
		String hql="FROM RequestBlood";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);

		return query.getResultList();

	}

	public boolean acceptRequest(long patientId) {
		
		logger.info("Admin entered in to acceptRequest method of AdminDaoImpl class");
		Session session = sessionFactory.getCurrentSession();
		RequestBlood requestBlood=session.get(RequestBlood.class,patientId);
		requestBlood.setRequestStatus("Approved");
		session.update(requestBlood);

		return true;
	}

	public boolean rejectRequest(long patientId) {
	    logger.info("Admin entered in to rejectRequest method of AdminDaoImpl class");
		Session session = sessionFactory.getCurrentSession();
		RequestBlood requestBlood=session.get(RequestBlood.class,patientId);
		requestBlood.setRequestStatus("Rejected");
		session.update(requestBlood);
		return true;
	}

	public List<DonateBlood> getDonarList() {
		
		logger.info("Admin entered in to getDonarList method of AdminDaoImpl class");
		String hql="FROM DonateBlood";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		
		return query.getResultList();

	}

	public boolean acceptDonar(long patientId) {
		
		logger.info("Admin entered in to acceptDonar method of AdminDaoImpl class");
		Session session = sessionFactory.getCurrentSession();
		DonateBlood donateBlood=session.get(DonateBlood.class,patientId);
		donateBlood.setDonationStatus("Approved");
		session.update(donateBlood);
		return true;
	}

	public boolean rejectDonar(long patientId) {
		
		logger.info("Admin entered in to rejectDonar method of AdminDaoImpl class");
		Session session = sessionFactory.getCurrentSession();
		DonateBlood donateBlood=session.get(DonateBlood.class,patientId);
		donateBlood.setDonationStatus("Rejected");
		session.update(donateBlood);
		return true;

	}
	}
