package com.Ashokit.service;

import com.Ashokit.entity.Counsellor;
import com.Ashokit.formbinding.Dashboard;

public interface Cousellorservice {
	
	public String saveCouncellor(Counsellor c);
	
	public Counsellor login(String email,String password);
	
	public String fogotPassword(String email);
	
	public Dashboard showDashboard(Integer cid);
	
	

}
