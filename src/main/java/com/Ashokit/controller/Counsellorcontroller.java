package com.Ashokit.controller;

import java.net.http.HttpClient.Redirect;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.Ashokit.entity.Counsellor;
import com.Ashokit.formbinding.Dashboard;
import com.Ashokit.serviceimp.Counsellorserviceimp;
import com.Ashokit.serviceimp.Studentserviceimp;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpSession;



@Controller
public class Counsellorcontroller {

	
	@Autowired
	private Counsellorserviceimp cservice;
	
	@Autowired
	private Studentserviceimp sservice;
	
	
	@GetMapping("/")
	public String login(Model model)
	{
		model.addAttribute("Counsellor", new Counsellor());
		return "login";
	}
	
	
	@GetMapping("/Newregister")
	public String newCouncellorPage(Model model)
	{
		model.addAttribute("Counsellor", new Counsellor());
		
		return "Councellorregister";
	}
	
	
	@GetMapping("/Forgotpswrd")
	public String forgotPasswordPage(Model model)
	{
		
		model.addAttribute("Counsellor", new Counsellor());
		return "Forgotpassword";
	}
	
	@PostMapping("/register")
	public String saveCounsellor(Counsellor c, Model model)
	{
		model.addAttribute("Counsellor", new Counsellor());
		String msg=cservice.saveCouncellor(c);
		if(msg!=null)
		{
			model.addAttribute("MSG", msg);
		}
		else {
		model.addAttribute("MSG", "please chage the Email Id");
		}
		
		return "Councellorregister";
		
	}
	
	@PostMapping("/do-Login")
	public String doLogin(Counsellor c,HttpServletRequest req, Model model)
	{
		model.addAttribute("Counsellor",new Counsellor());
		
		
		
		Counsellor cl=cservice.login(c.getEmail(),c.getPassword());
		
		
		
		if(cl!=null)
		{
			HttpSession session=req.getSession(true);
			session.setAttribute("CID", cl.getCid());
			return "redirect:/dashboard";
		}
		else {
		model.addAttribute("ErrMsg", "Invalid login credintials.");
		}
		return "login";
	}
	
	
	@PostMapping("/recover-pwd")
	public String recoverPassword(@RequestParam String email,Model model)
	{
		String msg=cservice.fogotPassword(email);
		if(msg!=null)
		{
			model.addAttribute("msg", msg);
		}
		else
		{
			model.addAttribute("msg", "Invalid Email Address.....");
		}
		
		
		return "Forgotpassword";
	}
	
	
	@GetMapping("/dashboard")
	public String showDashboard(HttpServletRequest req,Model model)
	{
		HttpSession session=req.getSession();
		Integer cid=(Integer) session.getAttribute("CID");
		
		if(cid==null)
		{
			return "redirect:/";
		}
		
		Dashboard dbs=cservice.showDashboard(cid);
		
		model.addAttribute("TotalStudents", dbs.getTotequiries());
		model.addAttribute("Enrolledstudents", dbs.getEnrolled());
		model.addAttribute("Loststudents", dbs.getLost());
		
		return "showmyperformance";
		
	}
	
	
	@GetMapping("/Logout")
	public String logout(HttpServletRequest req,Model model)
	{
		HttpSession session=req.getSession(false);
		session.invalidate();
		
		return "redirect:/";
		
	}
	
	
	
	
}
