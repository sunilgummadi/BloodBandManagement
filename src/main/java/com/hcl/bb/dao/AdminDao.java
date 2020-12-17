package com.hcl.bb.dao;

import java.util.List;

import com.hcl.bb.appexception.ApplicationException;
import com.hcl.bb.model.Admin;
import com.hcl.bb.model.DonateBlood;
import com.hcl.bb.model.RequestBlood;
/**
 * MokaSaiSuryaPrakash (51897451)
 */
public interface AdminDao 
{
	public boolean validateAdmin(Admin admin) throws ApplicationException;
	public List<RequestBlood> getRequestList();
    public boolean acceptRequest(long patientId);
    public boolean rejectRequest(long patientId);

    public List<DonateBlood> getDonarList();
    public boolean acceptDonar(long patientId);
    public boolean rejectDonar(long patientId);

	
}