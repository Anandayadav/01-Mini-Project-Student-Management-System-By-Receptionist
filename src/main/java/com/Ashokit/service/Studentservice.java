package com.Ashokit.service;

import java.util.List;

import com.Ashokit.entity.Student;
import com.Ashokit.formbinding.Criteria;

public interface Studentservice {

	
	public boolean saveStudent(Student s);
	
	public List<Student> searchCriteria(Criteria cr,Integer cid);
	
	public List<Student> showMyRecords(Integer cid );
	
}
