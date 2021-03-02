package AirlineManagement.controller;

import java.util.List;

import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import AirlineManagement.model.Airline;
import AirlineManagement.model.Plane;
import AirlineManagement.services.PlaneService;

@Controller
public class PlaneController {

	@Autowired
	private PlaneService planeService;
	
	@RequestMapping("/AddPlane")
	public String AddPlane(HttpSession session,Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		
		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		return "airline/plane/AddPlane";
	}
	
	
	
	@RequestMapping("/AddNewPlane")
	public String AddPlane(HttpSession session ,@ModelAttribute("plane") Plane plane,Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		Airline airline=(Airline) session.getAttribute("airline");
		plane.setAirline(airline.getName());
		
		String pname=plane.getName();
		
		List<Plane> pplane=this.planeService.getAllPlanesByName(pname);
		
		if(pplane.size()!=0)
		{
			String message= "A plane with this name already exists.";
			model.addAttribute("message",message);
			return AddPlane(session,model);
		}
		
		
		int r=this.planeService.CreatePlane(plane);
		System.out.println(r+" planes added");
		System.out.println(plane);
		
		return RemovePlane(session,model);
	}
	
	@RequestMapping("/RemovePlane")
	public String RemovePlane(HttpSession session, Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		Airline airline=(Airline) session.getAttribute("airline");
		String airlineName=airline.getName();
		System.out.println(airlineName);
		List<Plane> planes=this.planeService.getPlanesByAirline(airlineName);
		
		model.addAttribute("planes", planes);
		int plane_count=planes.size();
		model.addAttribute("plane_count",plane_count);
		return "airline/plane/ViewPlane";
	}
	
	@RequestMapping("/deletePlane/{id}")
	public String DeletePlane(@PathVariable("id") int id,HttpSession session, Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		int r=this.planeService.DeletePlane(id);
		Airline airline=(Airline) session.getAttribute("airline");
		String airlineName=airline.getName();
		System.out.println(airlineName);
		List<Plane> planes=this.planeService.getPlanesByAirline(airlineName);
		
		model.addAttribute("planes", planes);
		int plane_count=planes.size();
		model.addAttribute("plane_count",plane_count);
		
		System.out.println(r+" planes deleted");
		
		
		return "airline/plane/ViewPlane";
		
	}
	@RequestMapping("/UpdatePlane")
	public String UpdatePlane(HttpSession session,Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		Airline airline=(Airline) session.getAttribute("airline");
		String airlineName=airline.getName();
		System.out.println(airlineName);
		List<Plane> planes=this.planeService.getPlanesByAirline(airlineName);
		
		model.addAttribute("planes", planes);
		int plane_count=planes.size();
		model.addAttribute("plane_count",plane_count);
		
		return "airline/plane/ViewPlane";
	}
	
	@RequestMapping("/UpdatePlaneDetail/{id}")
	public String UpdatePlane(@PathVariable("id") int id, Model model,HttpSession session)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		Plane plane=this.planeService.getPlane(id);
		model.addAttribute("plane", plane);
	
		return "airline/plane/UpdatePlane";
		
	}
	
	@RequestMapping("/Update/{id}")
	public String Update(@PathVariable("id") int id, @RequestParam("name") String name, @RequestParam("capacity") String capacity, Model model,HttpSession session)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		
		
		Plane planee=this.planeService.getPlane(id);
		
		if(planee.getName().equals(name))
		{
			int r=this.planeService.UpdatePlane(id,name,capacity);
		}
		
		else {
		List<Plane> pplane=this.planeService.getAllPlanesByName(name);
		
		if(pplane.size()!=0)
		{
			String message= "A plane with this name already exists.";
			model.addAttribute("message",message);
			
			Plane plane=this.planeService.getPlane(id);
			model.addAttribute("plane", plane);
			return "airline/plane/UpdatePlane";
		}
		}
		
		int r=this.planeService.UpdatePlane(id,name,capacity);
		Airline airline=(Airline) session.getAttribute("airline");
		String airlineName=airline.getName();
		System.out.println(airlineName);
		List<Plane> planes=this.planeService.getPlanesByAirline(airlineName);
		
		model.addAttribute("planes", planes);
		int plane_count=planes.size();
		model.addAttribute("plane_count",plane_count);
		
		System.out.println(r+" planes updated");
		return "airline/plane/ViewPlane";
		
	}
	
}
