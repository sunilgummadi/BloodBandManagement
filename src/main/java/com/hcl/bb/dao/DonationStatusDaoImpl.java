package com.hcl.bb.dao;

import java.util.List;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.query.Query;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.hcl.bb.model.DonateBlood;
import com.hcl.bb.model.User;
/**
 * 
 * @author KanumuriSaketh (51897445)
 *
 */
@Repository("donationStatusDao")
public class DonationStatusDaoImpl implements DonationStatusDao{

	@Autowired
	private SessionFactory sessionFactory;
	
	public List<DonateBlood> getDonationList(User user) {

		String hql="FROM DonateBlood donateBlood WHERE donateBlood.accountId=:accountId";
		Session session = sessionFactory.getCurrentSession();
		Query query = session.createQuery(hql);
		query.setParameter("accountId",user.getUserId());
		
		return query.getResultList(); 
	}

}
