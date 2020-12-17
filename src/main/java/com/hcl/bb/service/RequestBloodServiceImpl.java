package com.hcl.bb.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.dao.RequestBloodDao;
import com.hcl.bb.model.RequestBlood;
import com.hcl.bb.model.User;
/**
 * 
 * @author GummadiSunilKumar (51897413)
 *
 */
@Service("requestBloodService")
public class RequestBloodServiceImpl implements RequestBloodService{

	@Autowired
	private RequestBloodDao requestBloodDao;
	
	public boolean validateFields(RequestBlood requestBlood) throws ApplicationException {
		
		if(requestBlood.getContactName()==""||requestBlood.getBloodGroup()==""||requestBlood.getCity()==""||requestBlood.getDoctorName()==""||
		   requestBlood.getHospitalAddress()==""||requestBlood.getPatientName()==""||requestBlood.getContactNumber()==""||requestBlood.getContactEmail()==""
		   ||requestBlood.getWhen()=="")
		{
			throw new ApplicationException("All fields are mandatory");
		}
		else if(requestBlood.getPatientName().length()<3)
		{
			throw new ApplicationException("Please enter the full name of the patient");
		}
		else if(requestBlood.getHospitalAddress().length()>100)
		{
			throw new ApplicationException("Maximum  Characters Reached");
		}
		else if(requestBlood.getContactName().length()<3)
		{
			throw new ApplicationException("Please enter the full name of the contact person");
		}
		else if(requestBlood.getContactNumber().length()>10)
		{
			throw new ApplicationException("Please enter a valid contact number");
		}
		else
		{
			return true;
		}
		
	}

	@Transactional
	public boolean addRequest(RequestBlood requestBlood,User user) {

		return requestBloodDao.addRequest(requestBlood, user);
	}

}
