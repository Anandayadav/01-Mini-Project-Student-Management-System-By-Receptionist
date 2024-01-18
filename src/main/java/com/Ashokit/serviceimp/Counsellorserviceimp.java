package com.Ashokit.serviceimp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashokit.entity.Counsellor;
import com.Ashokit.entity.Student;
import com.Ashokit.formbinding.Dashboard;
import com.Ashokit.repo.Counsellorrepo;
import com.Ashokit.repo.Studentrepo;
import com.Ashokit.service.Cousellorservice;
import com.Ashokit.utilities.Emailutils;


@Service
public class Counsellorserviceimp implements Cousellorservice {

	@Autowired
	private Counsellorrepo crepo;
	
	@Autowired
	private Emailutils emailutils;
	
	@Autowired
	private Studentrepo srepo;
	
	
	
	@Override
	public String saveCouncellor(Counsellor c) {
		String email=c.getEmail();
		Counsellor cc=crepo.findByEmail(email);
		if(cc==null)
		{
			crepo.save(c);
			
			return "You have Registered successfully....";
		}
		return null;
		
	}

	@Override
	public Counsellor login(String email,String password) {
		Counsellor lc=crepo.findByEmailAndPassword(email,password);
		if(lc!=null)
		{
			return lc;
		}
		return null;
	}

	@Override
	public String fogotPassword(String email) {
		Counsellor fc=crepo.findByEmail(email);
		if(fc!=null)
		{
			
			
			String subject="Recover Email-Ananda";
			String body="<h1>Your Password: "+fc.getPassword() +"</h1>";
			
			emailutils.sendMail(subject, body, email);
			return "Password sent to mail...";
			
		}
		return null;
	}

	@Override
	public Dashboard showDashboard(Integer cid) {
			List<Student>students=srepo.findByCid(cid);
			Integer enrolledstu=students.stream()
								.filter(e->e.getEnqstatus().equals("Enrolled"))
								.collect(Collectors.toList())
								.size();
			
			
			
			Dashboard db=new Dashboard();
			db.setTotequiries(students.size());
			
			db.setEnrolled(enrolledstu);
			db.setLost(students.size()-enrolledstu);
			
		
		return db;
	}

}
