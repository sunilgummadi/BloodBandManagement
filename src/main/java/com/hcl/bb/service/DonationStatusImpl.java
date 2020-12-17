package com.hcl.bb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bb.dao.DonationStatusDao;
import com.hcl.bb.model.DonateBlood;
import com.hcl.bb.model.User;
/**
 * 
 * @author KanumuriSaketh (51897445)
 *
 */
@Service("donationStatus")
public class DonationStatusImpl implements DonationStatus {

	@Autowired
	private DonationStatusDao donationStatusDao;
	
	@Transactional
	public List<DonateBlood> getDonationList(User user) {

		return donationStatusDao.getDonationList(user);
	}

}
