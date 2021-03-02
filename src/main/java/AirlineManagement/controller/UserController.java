package AirlineManagement.controller;



import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import AirlineManagement.model.Airport;
import AirlineManagement.model.Flight;
import AirlineManagement.model.Plane;
import AirlineManagement.model.User;
import AirlineManagement.services.AirportService;
import AirlineManagement.services.FlightService;
import AirlineManagement.services.PlaneService;
import AirlineManagement.services.UserService;

@Controller
public class UserController {
	
	@Autowired
	private UserService userService;
	
	@Autowired
	private FlightService flightService;
	@Autowired
	private PlaneService planeService;
	@Autowired
	private AirportService airportService;
	@RequestMapping(path="/registerUser" , method =RequestMethod.POST)
	public String registerUser(@ModelAttribute User user ,Model model,@RequestParam("confirmPass") String confirmpass)
	{
		if(!(user.getPassword().equals(confirmpass)))
		{
			String message="Passwords do not match.";
			model.addAttribute("message",message);
			model.addAttribute("user",user);
			return "user/UserRegistration";
		}
		int id=this.userService.CreateUser(user); 
		System.out.println("UserRegistered");
		System.out.println("affected user"+id);
		System.out.println(user);	
		
		return "user/RegSuccess";	
	}
		
	@RequestMapping("/UserDashboard")
	public String UserLogin(HttpSession session, Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null )
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		if(session.getAttribute("user")!=null)
		{
			List<Airport> airports=this.airportService.getAll();
			int count=airports.size();
			model.addAttribute("airports",airports);
			model.addAttribute("airport_count",count);
			
			session.setAttribute("airports",airports);
			session.setAttribute("airport_count",count);
			return "user/UserDashboard";
		}
			
		
		
		return "user/UserLogin";
	}
	
	@RequestMapping(path="/UserDashboard",method=RequestMethod.POST)
	public String UserLogin(@ModelAttribute User user, Model model,HttpSession session)
	{
		
		String email=user.getEmail();
		String pass=user.getPassword();
		User _user=this.userService.getUserByEmail(email);
		if(_user==null)
		{
			String message="Email is incorrect";
			model.addAttribute("message", message);
			return "user/UserLogin";
		}
		System.out.println(_user);
//		System.out.println(pass);
			if(pass.equals(_user.getPassword()))
		{
			session.setAttribute("user", _user);
			model.addAttribute("user",_user);
			List<Airport> airports=this.airportService.getAll();
			int count=airports.size();
			model.addAttribute("airports",airports);
			model.addAttribute("airport_count",count);
			
			List<Plane> planes=this.planeService.getAllPlanes();
		        
	        int plane_count=planes.size();
	        session.setAttribute("planes",planes);
	        session.setAttribute("plane_count",plane_count);
		        
	        List<Flight> flights=this.flightService.getAllFlights();
	        
	        int flight_count=flights.size();
	        session.setAttribute("flights",flights);
	        session.setAttribute("flight_count",flight_count);
			return "user/UserDashboard";
		}
		else
		{
			String message="Password is incorrect";
			model.addAttribute("message", message);
			return "user/UserLogin";
		}
		
	}
	
	@RequestMapping("/UserLogout")
	public String UserLogout(HttpSession session, Model model)
	{
		
		session.removeAttribute("user");
		List<Airport> airports=this.airportService.getAll();
		int count=airports.size();
		model.addAttribute("airports",airports);
		model.addAttribute("airport_count",count);
		System.out.println("HomeController ");
		return "index";
	}
	
	
	//User DashBoard//
		@RequestMapping("/EditUserProfile")
		public String EditUser(HttpSession session, Model model)
		{
			if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
				return "index";

			if(session.getAttribute("airline")!=null )
				return "airline/AirlineDashboard";
			if(session.getAttribute("admin")!=null)
				return "admin/AdminDashboard";
			
			
			String message="Note: You cannot change your email.";
			model.addAttribute("message",message);
			User user=(User) session.getAttribute("user");
			model.addAttribute("user",user);
			return "user/EditUserProfile";
		}
		
		@RequestMapping("/UpdateUser")
		public String UpdateUser(@RequestParam("ConfirmPassword") String confpass,@ModelAttribute User user,HttpSession session, Model model)
		{

			if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
				return "index";

			if(session.getAttribute("airline")!=null )
				return "airline/AirlineDashboard";
			if(session.getAttribute("admin")!=null)
				return "admin/AdminDashboard";
			
			
			User _user=(User) session.getAttribute("user");
			
			if(confpass.equals(user.getPassword())==false)
			{
				String message="Passwords do not match, please try again.";
				model.addAttribute("message",message);
				return "user/EditUserProfile";
			}
			user.setId(_user.getId());
			int result= this.userService.UpdateUser(user);
			System.out.println(result+ "Rows affected ");
			User updatedUser=this.userService.getUserById(_user.getId());
			session.setAttribute("user", updatedUser);
			System.out.println(updatedUser);
			return "user/UserDashboard";
		}
		
		
		@RequestMapping("/UserT&C")
		public String TandC()
		{
			return "user/UserT&C";
		}
		

}
