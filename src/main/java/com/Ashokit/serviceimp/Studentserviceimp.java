package com.Ashokit.serviceimp;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Example;
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
		
		
		Student cs=new Student();
		
		cs.setCid(cid);
		
		if(cr.getCourse()!=null && !cr.getCourse().equals(""))
		{
			cs.setCourse(cr.getCourse());
			
		}
		
		if(cr.getCoursemode()!=null && !cr.getCoursemode().equals(""))
		{
			cs.setClassmode(cr.getCoursemode());
		}
		
		if(cr.getEnqstatus()!=null && !cr.getEnqstatus().equals(""))
		{
			cs.setEnqstatus(cr.getEnqstatus());
		}
			
		Example<Student>incrit=Example.of(cs);
		
		List<Student>filtstudents=srepo.findAll(incrit);
		
		return filtstudents;
		
	}
}
