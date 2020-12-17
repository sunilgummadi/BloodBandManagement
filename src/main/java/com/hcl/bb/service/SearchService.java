package com.hcl.bb.service;
import java.util.List;

import com.hcl.bb.model.DonateBlood;

public interface SearchService {

	public List<DonateBlood> getSearchResults(String searchQuery);
}
