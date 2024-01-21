package com.Ashokit.controller;



import java.util.List;
import java.util.stream.Collectors;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.Ashokit.entity.Student;
import com.Ashokit.formbinding.Criteria;
import com.Ashokit.serviceimp.Studentserviceimp;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;

@Controller
public class Studentcontroller {
	
	@Autowired
	private Studentserviceimp sservice;
	
	
	@GetMapping("/addstudent")
	public String addstudent(Student s,Model model)
	{
		model.addAttribute("enq", new Student());
		return "Addstudent";
	}

	
	@PostMapping("/savestudent")
	public String saveStudent(Student s,HttpServletRequest req ,Model model)
	{
		model.addAttribute("enq", new Student());
		
		HttpSession session=req.getSession(false);
		Object obj=session.getAttribute("CID");
		
		
		int cid=(Integer)obj;
		s.setCid(cid);
		
		boolean ss=sservice.saveStudent(s);
		
		
		
		if(ss)
		{
		model.addAttribute("msg", "Enquiry Added.");
		}
		else
		{
			model.addAttribute("msg", "Invalid input...");
		}
		
		return "Addstudent";
	}
	
	@GetMapping("/viewstudents")
	public String viewallStudets(HttpServletRequest req,Model model)
	{
		
		model.addAttribute("cr", new Criteria());
		
		HttpSession session=req.getSession();
		Integer cid=(Integer) session.getAttribute("CID");
		
		if(cid==null)
		{
			return "redirect:/";
		}
	
		List<Student>students=sservice.showMyRecords(cid);
		
		model.addAttribute("students", students);

		
		return "viewmystudents";
		
	}
	
	
	@PostMapping("/filter-enquiries")
	public String filterStudets(@ModelAttribute("cr") Criteria cr,HttpServletRequest req,Model model)
	{
		
	
		
		HttpSession session=req.getSession();
		Integer cid=(Integer) session.getAttribute("CID");
		
		if(cid==null)
		{
			return "redirect:/";
		}
		
		List<Student>students=sservice.searchCriteria(cr,cid);
		

		/*
			List<Student>fstudents=students.stream()
					.filter(e->e.getCourse().equals(cr.getCourse()))
					.filter(e->e.getClassmode().equals(cr.getCoursemode()))
					.filter(e->e.getEnqstatus().equals(cr.getEnqstatus()))
					.collect(Collectors.toList());
			model.addAttribute("students", fstudents);
		 */
			
		model.addAttribute("students", students);
		return "filterenqview";
		
	}
}
