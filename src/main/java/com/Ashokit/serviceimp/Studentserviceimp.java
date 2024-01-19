package com.Ashokit.serviceimp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.Ashokit.entity.Student;
import com.Ashokit.formbinding.Criteria;
import com.Ashokit.formbinding.Dashboard;
import com.Ashokit.repo.Studentrepo;
import com.Ashokit.service.Studentservice;


@Service
public class Studentserviceimp implements Studentservice {

	@Autowired
	private Studentrepo srepo;
	
	@Override
	public boolean saveStudent(Student s) {
		Student ss=srepo.save(s);
		return ss.getSid()!=null;
	}



	@Override
	public List<Student> showMyRecords(Integer cid) {
		List<Student>students=srepo.findByCid(cid);		
		return students;
	}
	
	@Override
	public List<Student> searchCriteria(Criteria cr,Integer cid) {
		List<Student>students=srepo.findByCid(cid);	
		
		if(cr!=null)
		{
		return	students.stream()
						.filter(e->e.getClassmode().isEmpty()||e.getClassmode().equals("online")||e.getClassmode().equals("offline"))
						.collect(Collectors.toList());
		
		}
		return null;
	}
}
