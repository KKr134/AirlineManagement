package AirlineManagement.controller;


import java.util.ArrayList;
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
import AirlineManagement.model.Airport;
import AirlineManagement.model.Flight;
import AirlineManagement.model.Plane;
import AirlineManagement.model.Ticket;
import AirlineManagement.services.AirportService;
import AirlineManagement.services.FlightService;
import AirlineManagement.services.PlaneService;
import AirlineManagement.services.TicketService;

@Controller
public class FlightController {
	
	@Autowired
	private PlaneService planeService;
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private AirportService airportService;
	
	@Autowired
	private TicketService ticketService;
	
	public void AddPackages(HttpSession session, Model model)
	{
		
		Airline airline=(Airline) session.getAttribute("airline");
		String airlineName=airline.getName();
		System.out.println(airlineName);
		List<Plane> planes=this.planeService.getPlanesByAirline(airlineName);
		
		model.addAttribute("planes", planes);
		int plane_count=planes.size();
		model.addAttribute("plane_count",plane_count);
	}
	
	@RequestMapping("/AddFlight")
	public String AddFlight(HttpSession session, Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		List<Airport> airports=this.airportService.getAll();
		int count=airports.size();
		model.addAttribute("airports",airports);
		model.addAttribute("airport_count",count);
		AddPackages(session, model);		
		return "airline/flight/AddFlight";
	}
	
	@RequestMapping("/AddNewFlight")
	public String AddNewFlight( @ModelAttribute Flight flight,@RequestParam("weekDay") String Day,@RequestParam("plane") String pname, HttpSession session, Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		if(flight.getFrom_().equals(flight.getTo_()))
		{
			String message="Source and destination cannot be same";
			model.addAttribute("message",message);
			return AddFlight(session, model);
		}
		
		int day=(int )(Day.charAt(0)-'0');
		flight.setDay_(day);
		
		String s=flight.getDtime();
		int dtime=(s.charAt(0)-'0')*1000+(s.charAt(1)-'0')*100+(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
		
		s=flight.getAtime();
		int atime=(s.charAt(0)-'0')*1000+(s.charAt(1)-'0')*100+(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
		
		
		int Dtime=(s.charAt(0)-'0')*1000+(s.charAt(1)-'0')*100+(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
		int Atime=(s.charAt(0)-'0')*1000+(s.charAt(1)-'0')*100+(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
		
		
		Plane plane=this.planeService.getPlaneByName(pname);
		
		int plane_id=plane.getId();
		
		List<Flight> Flights=this.flightService.getAllFlightsByPlane(plane_id);
		
		for(Flight f:Flights)
		{
			
			s=f.getDtime();
			Dtime=(s.charAt(0)-'0')*1000+(s.charAt(1)-'0')*100+(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
			
			s=f.getAtime();
			Atime=(s.charAt(0)-'0')*1000+(s.charAt(1)-'0')*100+(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
			
			
			if(f.getDay_()==day){
				
				 
				 		if( ((dtime<=Dtime && atime>=Dtime) || (dtime<=Atime && atime>=Atime)))
						{
							String message="This Plane has already a flight scheduled on this schedule.";
							model.addAttribute("message",message);
							return AddFlight(session, model);
						}

			}

			 
			 
		}
		
		
		
		flight.setPlane_id(plane.getId());
		
		
		flight.setAvailableSeats(plane.getCapacity());
		
		int r=this.flightService.CreateFlight(flight);
		System.out.println(r+" flights added");
		System.out.println(flight);
		
		Airline airline=(Airline) session.getAttribute("airline");
		
		List<Flight> flights=this.flightService.getAllFlightsByAirline(airline.getName());
		model.addAttribute("flights", flights);
		int flight_count=flights.size();
		model.addAttribute("flight_count",flight_count);
//		
		List<Plane> planes=this.planeService.getPlanesByAirline(airline.getName());
		model.addAttribute("planes", planes);
		int plane_count=planes.size();
		model.addAttribute("plane_count",plane_count);
		
		return "airline/flight/UpdateFlight";
	}
	
	
	
	@RequestMapping("/UpdateFlight")
	public String UpdateFlight(Model model, HttpSession session)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		Airline airline=(Airline) session.getAttribute("airline");
		String airlineName=airline.getName();
		List<Flight> flights=this.flightService.getAllFlightsByAirline(airlineName);
		model.addAttribute("flights", flights);
		int flight_count=flights.size();
		model.addAttribute("flight_count",flight_count);

		List<Plane> planes=this.planeService.getPlanesByAirline(airlineName);
		model.addAttribute("planes", planes);
		int plane_count=planes.size();
		model.addAttribute("plane_count",plane_count);
		return "airline/flight/UpdateFlight";
	}
	
	@RequestMapping("/deleteFlight/{id}")
	public String deleteFlight(@PathVariable("id") int id, Model model, HttpSession session)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		Flight fl=this.flightService.getFlightbyId(id);
		List<Flight> Flights=this.flightService.getAllFlightsByPlane(fl.getPlane_id());
		
		
		
		List<Integer> fids=  new ArrayList<Integer>();
		for(Flight ftemp:Flights)
		{

			 if(fl.getFrom_().equals(ftemp.getFrom_()) && fl.getTo_().equals(ftemp.getTo_()) && fl.getAtime().equals(ftemp.getAtime()) && fl.getDtime().equals(ftemp.getDtime()) && fl.getDay_()==ftemp.getDay_())
			 {
				 fids.add(ftemp.getId());
					
			 }
				 		
		}
		
		List<Ticket> tickets=this.ticketService.getAllTickets();
		
		for(Ticket t:tickets)
		{
			for(int fid:fids)
			{
				if(t.getFid()==fid)
					{
						String status="FlightCancelled";
						int d=this.ticketService.UpdateStatus(t.getId(), status);
						d=d+0;
						break;
					}
					
			}
		}

		
		int r=this.flightService.DeleteFlight(id);
		System.out.println(r+" flights deleted");
		return UpdateFlight(model, session);
	}
	
	@RequestMapping("/UpdateFlightDetail/{id}")
	
	public String UpdateFlightDetail(@PathVariable("id") int id, Model model, HttpSession session)
	{
		Flight flight=this.flightService.getFlightbyId(id);
		model.addAttribute("flight",flight);
		
		Airline airline =(Airline) session.getAttribute("airline");
		String airlineName=airline.getName();
		List<Plane> planes=this.planeService.getPlanesByAirline(airlineName);
		model.addAttribute("planes", planes);
		int plane_count=planes.size();
		model.addAttribute("plane_count",plane_count);
		return "airline/flight/UpdateFlightDetail";
	}
	
	@RequestMapping("/UpdateFlightSchedule/{id}")
	public String UpdateFlightSchedule(@PathVariable("id") int id, Model model, HttpSession session, @ModelAttribute Flight flight,@RequestParam("plane") String pname)
	{
		flight.setId(id);
		
		String s=flight.getDtime();
		int dtime=(s.charAt(0)-'0')*1000+(s.charAt(1)-'0')*100+(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
		
		s=flight.getAtime();
		int atime=(s.charAt(0)-'0')*1000+(s.charAt(1)-'0')*100+(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
		
		
		int Dtime=(s.charAt(0)-'0')*1000+(s.charAt(1)-'0')*100+(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
		int Atime=(s.charAt(0)-'0')*1000+(s.charAt(1)-'0')*100+(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
		
		Plane plane=this.planeService.getPlaneByName(pname);
		
		int plane_id=plane.getId();
		
		List<Flight> Flights=this.flightService.getAllFlightsByPlane(plane_id);
		
		Flight fl=this.flightService.getFlightbyId(id);
		for(Flight f:Flights)
		{
			if(f.getId()==flight.getId())
				continue;
			s=f.getDtime();
			Dtime=(s.charAt(0)-'0')*1000+(s.charAt(1)-'0')*100+(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
			
			s=f.getAtime();
			Atime=(s.charAt(0)-'0')*1000+(s.charAt(1)-'0')*100+(s.charAt(3)-'0')*10+(s.charAt(4)-'0');
			
			if(f.getDay_()==flight.getDay_()){
				
				 
				 		if( ((dtime<=Dtime && atime>=Dtime) || (dtime<=Atime && atime>=Atime)) && !(dtime==Dtime && atime==Atime))
						{
							String message="This Plane has already a flight scheduled on this schedule.";
							model.addAttribute("message",message);
							return UpdateFlightDetail(id, model, session);
						}
				 		
			}
		}
		
		int r=0;
		for(Flight ftemp:Flights)
		{

			 if(fl.getFrom_().equals(ftemp.getFrom_()) && fl.getTo_().equals(ftemp.getTo_()) && fl.getAtime().equals(ftemp.getAtime()) && fl.getDtime().equals(ftemp.getDtime()) && fl.getDay_()==ftemp.getDay_())
			 {
				 ftemp.setAtime(flight.getAtime());
				 ftemp.setDtime(flight.getDtime());
				 ftemp.setFare(flight.getFare());
				 r=r+this.flightService.Update(ftemp);
					
			 }
				 		
			}

			 
			 
		System.out.println(r+ " flights updated");
		
		
		return UpdateFlight(model, session);
	}
	
}
