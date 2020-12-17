package com.hcl.bb.service;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.hcl.bb.dao.SearchDao;
import com.hcl.bb.model.DonateBlood;

@Service("searchService")
public class SearchServiceImpl implements SearchService{

	@Autowired
	private SearchDao searchDao;
	
	@Transactional
	public List<DonateBlood> getSearchResults(String searchQuery) {
		
		return searchDao.getSearchResults(searchQuery);
	}

}
