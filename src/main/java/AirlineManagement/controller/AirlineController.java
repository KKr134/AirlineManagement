package AirlineManagement.controller;



import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import AirlineManagement.model.Airline;
import AirlineManagement.model.Airport;
import AirlineManagement.services.AirlineService;
import AirlineManagement.services.AirportService;


@Controller
public class AirlineController {
	
	@Autowired
	private AirlineService airlineService;
	@Autowired
	private AirportService airportService;

	@RequestMapping(path="/registerAirline" , method =RequestMethod.POST)
	public String registerAirline(@ModelAttribute Airline airline ,Model model,@RequestParam("confirmPass") String confirmpass, HttpSession session)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "airline/AirlineLogin";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		if(!(airline.getPassword().equals(confirmpass)))
		{
			String message="Passwords do not match.";
			model.addAttribute("message",message);
			model.addAttribute("airline",airline);
			return "airline/AirlineRegistration";
		}
		
		int id=this.airlineService.CreateAirline(airline); 
		System.out.println("AirlineRegistered");
		System.out.println("affected airline "+id);
		System.out.println(airline);
		
		return "airline/RegSuccess";	
	}
	
	@RequestMapping("/AirlineDashboard")
	public String AirlineLogin(HttpSession session)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null )
			return "airline/AirlineDashboard";
		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		
		return "user/AirlineLogin";
	}
	@RequestMapping(path="/AirlineDashboard",method=RequestMethod.POST)
	public String AirlineLogin(@ModelAttribute Airline airline, Model model,HttpSession session)
	{
		
		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		String email=airline.getEmail();
		String pass=airline.getPassword();
		Airline _airline=this.airlineService.getAirlineByEmail(email);
		if(_airline==null)
		{
			String message="Email is incorrect";
			model.addAttribute("message", message);
			return "airline/AirlineLogin";
		}
		System.out.println(_airline);
//		System.out.println(pass);
		
		if(pass.equals(_airline.getPassword()))
		{
			session.setAttribute("airline", _airline);
			List<Airport> airports=this.airportService.getAll();
			int count=airports.size();
			session.setAttribute("airports",airports);
			session.setAttribute("airport_count",count);
			model.addAttribute("airline",_airline);
			return "airline/AirlineDashboard";
		}
		else
		{
			String message="Password is incorrect";
			model.addAttribute("message", message);
			return "airline/AirlineLogin";
		}
			
		
		
	}
	
	@RequestMapping("/AirlineLogout")
	public String AirlineLogout(HttpSession session, Model model)
	{
		List<Airport> airports=this.airportService.getAll();
		int count=airports.size();
		model.addAttribute("airports",airports);
		model.addAttribute("airport_count",count);
		System.out.println("HomeController ");
		session.removeAttribute("airline");
		return "index";
	}

	//Airline DashBoard//
	
	
	@RequestMapping("/EditAirlineProfile")
	public String EditAirline(HttpSession session, Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		
		Airline airline=(Airline) session.getAttribute("airline");
		model.addAttribute("airline",airline);
		return "airline/EditAirlineProfile";
	}
	
	@RequestMapping("/UpdateAirline")
	public String UpdateAirline(@RequestParam("ConfirmPassword") String confpass, @ModelAttribute Airline airline,HttpSession session, Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		Airline _airline=(Airline) session.getAttribute("airline");
		if(confpass.equals(airline.getPassword())==false)
		{
			String message="Passwords do not match, please try again.";
			model.addAttribute("message",message);
			return EditAirline( session, model);
		}
		airline.setId(_airline.getId());
		
		int result= this.airlineService.UpdateAirline(airline);
		System.out.println(result+ "Rows affected ");
		Airline updatedAirline=this.airlineService.getAirlineById(_airline.getId());
		session.setAttribute("airline", updatedAirline);
		System.out.println(updatedAirline);
		return "airline/AirlineDashboard";
	}
	
	@RequestMapping("/airTnC")
	public String TandC()
	{
		return "airline/AirlineTnC";
	}

}
