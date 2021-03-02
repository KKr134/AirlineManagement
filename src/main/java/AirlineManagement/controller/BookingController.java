package AirlineManagement.controller;

import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.time.Period;
import java.util.Calendar;
import java.util.List;
import java.util.Date;  
import javax.servlet.http.HttpSession;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import AirlineManagement.model.Airport;
import AirlineManagement.model.Flight;
import AirlineManagement.model.Passenger;
import AirlineManagement.model.Plane;
import AirlineManagement.model.Ticket;
import AirlineManagement.model.User;
import AirlineManagement.model.Waitlist;
import AirlineManagement.services.FlightService;
import AirlineManagement.services.PassengerService;
import AirlineManagement.services.PlaneService;
import AirlineManagement.services.TicketService;
import AirlineManagement.services.WaitlistService;

@Controller
public class BookingController {
	
	@Autowired
	FlightService flightService;
	
	@Autowired
	PassengerService passengerService;
	
	@Autowired
	TicketService ticketService;
	
	@Autowired
	PlaneService planeService;
	
	@Autowired
	WaitlistService waitlistService;
	
	private int flightId;
	
	
	
	@RequestMapping({"/BookTicket","/CheckSeatAvailability"} )
	public String Check()
	{
		
		return "index";
	}
	
	@RequestMapping(path={"/BookTicket","/CheckSeatAvailability"}, method = RequestMethod.POST )
	public String CheckSeatAvailability(@RequestParam("source") String source, @RequestParam("dest") String dest, @RequestParam("date") java.sql.Date ddate, HttpSession session,Model model)
	{
		
	
		System.out.println(ddate);
		
		Calendar calendar = Calendar.getInstance();
        calendar.setTime(ddate);
        int day_=calendar.get(Calendar.DAY_OF_WEEK);
        
        String date_=ddate.toString();
        System.out.println(date_);
        // SDDN: S=Source D= Destination D=Day D=date)
        List<Flight>flightsOnSameDay= this.flightService.getFlightsBySDDN(source,dest,day_);
        
        
        List<Flight> allFlights= this.flightService.getFlightsBySDD(source,dest,day_);
        for(Flight f:flightsOnSameDay)
        {
        	int flag=0;
        	for(Flight F:allFlights)
        	{
        		if(f.getPlane_id()==F.getPlane_id() && f.getDtime().equals(F.getDtime()) && f.getAtime().equals(F.getAtime()) && F.getDate_().equals(date_))
        		{
        			flag=1;
        			break;
        		}
        	}
        	if(flag==0)
        	{
        		f.setDate_(date_);
        		this.flightService.CreateFlight(f);
        	}
        }
        
        List<Flight> finalFlights= this.flightService.getFlightsBySDDD(source,dest,day_,date_);
        
        System.out.println(flightsOnSameDay);
        System.out.println(allFlights);
        System.out.println(finalFlights);
        
        List<Plane> planes=this.planeService.getAllPlanes();
        
        int plane_count=planes.size();
        model.addAttribute("planes",planes);
        model.addAttribute("plane_count",plane_count);
        int count=finalFlights.size();
        model.addAttribute("flights",finalFlights);
        model.addAttribute("flight_count",count);
		return "user/CheckSeatAvailability";
	}
	
	
	@RequestMapping("/AddPass/{id}")	
	public String AddPass(@PathVariable("id") int id,Model model, HttpSession session)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "user/UserLogin";

		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		User user=(User) session.getAttribute("user");
		
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		this.flightId=id;
		System.out.println(this.flightId);
		List<Passenger> passengers= this.passengerService.getPassengerByUid(user.getId());
		model.addAttribute("passengers",passengers);
		
		int passenger_count=passengers.size();
		model.addAttribute("passenger_count",passenger_count);
		return "user/AddPassenger";
	}
	
	
	
	@RequestMapping("/AddPassenger")	
	public String AddPass(@ModelAttribute Passenger passenger, Model model, HttpSession session)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
//		session.setAttribute(", arg1);
		User user=(User) session.getAttribute("user");
		passenger.setUid(user.getId());
		
		if(passenger.getGender().equals("Male"))
			passenger.setGender("M");
		else if(passenger.getGender().equals("Female"))
			passenger.setGender("F");
		else
			passenger.setGender("O");
		int r=this.passengerService.CreatePassenger(passenger);
		System.out.println(r+" passengers added");
		
		List<Passenger> passengers= this.passengerService.getPassengerByUid(user.getId());
		
		model.addAttribute("passengers",passengers);
		
		int passenger_count=passengers.size();
		model.addAttribute("passenger_count",passenger_count);
		
		
		return "user/AddPassenger";
	}
	
	@RequestMapping("/BookedTickets")
	private String BookedTickets(HttpSession session, Model model) {
		
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		User user= (User) session.getAttribute("user");
		
		List<Ticket> tickets=this.ticketService.getTicketByUid(user.getId());
		
		
		List<Plane> planes=this.planeService.getAllPlanes();
	        
        int plane_count=planes.size();
        model.addAttribute("planes",planes);
        model.addAttribute("plane_count",plane_count);
	        
        List<Flight> flights=this.flightService.getAllFlights();
        
        int flight_count=flights.size();
        model.addAttribute("flights",flights);
        model.addAttribute("flight_count",flight_count);
        
		String cancelled="cancelled";
		model.addAttribute("cancelled",cancelled);
		
		String FlightCancelled="FlightCancelled";
		model.addAttribute("FlightCancelled",FlightCancelled);
		
		model.addAttribute("tickets",tickets);
		model.addAttribute("ticket_count",tickets.size()-1);
		return "user/BookedTickets";
	}
	
	@RequestMapping("/deletePass/{id}")
	public String DeletePass(@PathVariable("id") int id,HttpSession session, Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		
		int r=this.passengerService.Delete(id);
		System.out.println(r+" passengers removed");
		User user=(User) session.getAttribute("user");
		List<Passenger> passengers= this.passengerService.getPassengerByUid(user.getId());
		model.addAttribute("passengers",passengers);
		
		int passenger_count=passengers.size();
		model.addAttribute("passenger_count",passenger_count);
		return "user/AddPassenger";
	}
	
	@RequestMapping("/BookAll")
	public String BookAll(HttpSession session, Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		User user=(User) session.getAttribute("user");
		List<Passenger> passengers= this.passengerService.getPassengerByUid(user.getId());
		
		int r=0;
		int userId=user.getId();
		int fid=this.flightId;
		Flight flight=this.flightService.getFlightbyId(fid);
		
		int availableSeats=flight.getAvailableSeats();
		
		Ticket ticket=new Ticket();
		ticket.setFid(fid);
		ticket.setUid(userId);

		SimpleDateFormat formatter = new SimpleDateFormat("dd/MM/yyyy HH:mm:ss");  
	    Date today = new Date();  
	    String issued=formatter.format(today);  
	    
		ticket.setIssued(issued);
		
		List<Plane> planes=this.planeService.getAllPlanes();
        
        int plane_count=planes.size();
        model.addAttribute("planes",planes);
        model.addAttribute("plane_count",plane_count);
	        
        List<Flight> flights=this.flightService.getAllFlights();
        
        int flight_count=flights.size();
        model.addAttribute("flights",flights);
        model.addAttribute("flight_count",flight_count);
		
		List<Waitlist> waitlists=this.waitlistService.getbyFid(fid);
		
		int lastrank=0;
		if(waitlists.size()!=0 )
			lastrank=this.waitlistService.getLastRank(fid);
		
		for(Passenger p:passengers)
		{
			LocalDate dob = LocalDate.parse(p.getDob());
			LocalDate tday = LocalDate.now();   
			Period pr = Period.between(dob, tday);
			int age=pr.getYears();
			
			ticket.setPname(p.getName());
			ticket.setAge(age);
			
			String status="waitlist";
			
			
			if(availableSeats>0)
			{
				status="confirmed";
				int r1=this.flightService.DecrementAvailability(flight.getId()); r1=r1*0;
				availableSeats--;
				ticket.setStatus(status);
				int tid=this.ticketService.Generate(ticket);
				tid=tid*0;
			}
			
			else {
			ticket.setStatus(status);
			int r2=this.ticketService.Generate(ticket);
			r2=r2*0;
			int tid=this.ticketService.maxid();
			Waitlist person= new Waitlist();
			
			person.setTicketId(tid);
			
			
			lastrank++;
			person.setWaitRank(lastrank);
			int res=this.waitlistService.insert(person);
			res=res*0;
			
			}
			
			r++;
		}
		
		System.out.println(r+" tickets booked.");
		return BookedTickets(session,model);
	}
	
	@RequestMapping("/deleteTicket/{id}")
	public String DeleteTicket(@PathVariable("id") int id,HttpSession session, Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		List<Plane> planes=this.planeService.getAllPlanes();
        
        int plane_count=planes.size();
        model.addAttribute("planes",planes);
        model.addAttribute("plane_count",plane_count);
	        
        List<Flight> flights=this.flightService.getAllFlights();
        
        int flight_count=flights.size();
        model.addAttribute("flights",flights);
        model.addAttribute("flight_count",flight_count);
        
		int r=this.ticketService.delete(id);
		System.out.println(r+" ticket deleted");
		return BookedTickets(session,model);
	}
	
	@RequestMapping("/cancelTicket/{id}")
	public String CancelTicket(@PathVariable("id") int id,HttpSession session, Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		Ticket ticket=this.ticketService.getTicketById(id);
		if(ticket.getStatus().equals("confirmed"))
		{
			int fid=ticket.getFid();
			List<Waitlist> waitlists=this.waitlistService.getbyFid(fid);
			int r;
			if(waitlists.size()==0)
				{
				r=this.flightService.IncrementAvailability(fid);
				System.out.println("Availability of Flight id "+fid+" increased by "+r);
				}
			else
			{
				for( Waitlist p:waitlists)
				{
					int tid=p.getTicketId();
					
					String status="confirmed";
					int d=this.ticketService.UpdateStatus(tid,status);
					
					d=d+this.waitlistService.remove(tid);
					break;
				}
			}
			
		}
		else
		{
			int ri=this.waitlistService.remove(id); ri=ri*0;
		}
		
		List<Plane> planes=this.planeService.getAllPlanes();
        
        int plane_count=planes.size();
        model.addAttribute("planes",planes);
        model.addAttribute("plane_count",plane_count);
	        
        List<Flight> flights=this.flightService.getAllFlights();
        
        int flight_count=flights.size();
        model.addAttribute("flights",flights);
        model.addAttribute("flight_count",flight_count);
        
		int r=this.ticketService.cancel(id);
		System.out.println(r+" ticket cancelled");
		return BookedTickets(session, model);
	}
	
	@RequestMapping("/cancelledTickets")
	public String Cancelled(HttpSession session, Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		List<Plane> planes=this.planeService.getAllPlanes();
        
        int plane_count=planes.size();
        model.addAttribute("planes",planes);
        model.addAttribute("plane_count",plane_count);
	        
        List<Flight> flights=this.flightService.getAllFlights();
        
        int flight_count=flights.size();
        model.addAttribute("flights",flights);
        model.addAttribute("flight_count",flight_count);
        
		User user= (User) session.getAttribute("user");
		List<Ticket> tickets=this.ticketService.getCancelledTicketByUid(user.getId());
		int ticket_count=tickets.size()-1;
		model.addAttribute("ticket_count", ticket_count);
		model.addAttribute("tickets", tickets);
		
		return "user/CancelledTickets";
	}
	
	@RequestMapping("/checkStatus")
	public String checkStatus(@RequestParam("id") int id ,HttpSession session, Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null)
			return "airline/AirlineDashboard";
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		
		List<Plane> planes=this.planeService.getAllPlanes();
        
        int plane_count=planes.size();
        model.addAttribute("planes",planes);
        model.addAttribute("plane_count",plane_count);
	        
        List<Flight> flights=this.flightService.getAllFlights();
        
        int flight_count=flights.size();
        model.addAttribute("flights",flights);
        model.addAttribute("flight_count",flight_count);
        
		List<Ticket> tickets=this.ticketService.getAllTickets();
		
		for(Ticket ticket:tickets) {
			if(ticket.getId()==id)
			{
				if(ticket.getStatus().equals("waitlist"))
				{
					int waitrank=this.waitlistService.getWaitRank(ticket.getId());
					model.addAttribute("waitrank",waitrank);
				}
				
				String waitlist="waitlist";
				model.addAttribute("waitlist",waitlist);
				
				String FlightCancelled="FlightCancelled";
				model.addAttribute("FlightCancelled",FlightCancelled);
				
				model.addAttribute("ticket", ticket);
				return "user/CheckStatus";
			}
		}
		Ticket ticket=null;
		model.addAttribute("ticket", ticket);
		return "user/CheckStatus";
		
	}

	

}
