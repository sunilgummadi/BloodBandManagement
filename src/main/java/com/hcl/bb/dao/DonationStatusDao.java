package com.hcl.bb.dao;

import java.util.List;

import com.hcl.bb.model.DonateBlood;
import com.hcl.bb.model.User;
/**
 * 
 * @author KanumuriSaketh (51897445)
 *
 */
public interface DonationStatusDao {
	public List<DonateBlood> getDonationList(User user);
}
