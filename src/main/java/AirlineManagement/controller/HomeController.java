package AirlineManagement.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import AirlineManagement.model.Airport;
import AirlineManagement.services.AirportService;

@Controller
public class HomeController {
	
	@Autowired	
	private AirportService airportService;
	
	
	@RequestMapping("/")
	public String index(Model model,HttpSession session)
	{
		
		List<Airport> airports=this.airportService.getAll();
		int count=airports.size();
		session.setAttribute("airports",airports);
		session.setAttribute("airport_count",count);
		System.out.println("HomeController ");
		return "index";
				
	}
	
	@RequestMapping("/home")
	public String Home(Model model, HttpSession session)
	{
		List<Airport> airports=this.airportService.getAll();
		int count=airports.size();
		session.setAttribute("airports",airports);
		session.setAttribute("airport_count",count);
		System.out.println("HomeController ");
		return "index";
				
	}
	
	
	@RequestMapping("/about")
	public String about()
	{
		System.out.println("aboutController ");
		return "about";
				
	}
	@RequestMapping("/UserRegistration")
	public String UserReg(HttpSession session, Model model)
	{
		
		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		
		String message="Enter your personal details below.";
		model.addAttribute("message", message);
		System.out.println("UserRegistration");
		return "user/UserRegistration";
				
	}
	
	@RequestMapping("/UserLogin")
	public String UserLogin(HttpSession session, Model model)
	{
		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		
		System.out.println("UserLogin");
		String message="Enter your email & password below.";
		model.addAttribute("message", message);
		return "user/UserLogin";
				
	}
	
	@RequestMapping("/AirlineRegistration")
	public String AirlineReg(HttpSession session, Model model)
	{
		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		
		String message="Enter company details below.";
		model.addAttribute("message", message);
		System.out.println("AirlineRegistration");
		return "airline/AirlineRegistration";
				
	}
	
	@RequestMapping("/AirlineLogin")
	public String AirlineLogin(HttpSession session, Model model)
	{
		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		
		System.out.println("AirlineLogin");
		String message="Enter your email & password below.";
		model.addAttribute("message", message);
		return "airline/AirlineLogin";
				
	}
	
	

	

}
