package com.hcl.bb.service;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.dao.DonateBloodDao;
import com.hcl.bb.model.DonateBlood;
import com.hcl.bb.model.User;
/**
 * 
 * @author KanumuriSaketh (51897445)
 *
 */
@Service("donateBloodService")
public class DonateBloodServiceImpl implements DonateBloodService {

	@Autowired
	private DonateBloodDao donateBloodDao;
	
	public boolean validateDetails(DonateBlood donateBlood) throws ApplicationException {
		
		if(donateBlood.getDonarName()==""||donateBlood.getBloodGroup()==""||donateBlood.getCity()==""||donateBlood.getGlucoseLevel()==""||
		   donateBlood.getTime()=="")
		{
			throw new ApplicationException("All fields are mandatory");
		}
		else if(donateBlood.getDonarName().length()<4)
		{
			throw new ApplicationException("Please enter the full name of the donar");
		}
		else if(donateBlood.getTime().length()!=5)
		{
			throw new ApplicationException("Please enter the time in valid format (HH:mm)");
		}
		else
		{
			return true;
		}
	}

	@Transactional
	public boolean addDonar(DonateBlood donateBlood,User user) {
	
		return donateBloodDao.addDonar(donateBlood, user);
	}
	

}
