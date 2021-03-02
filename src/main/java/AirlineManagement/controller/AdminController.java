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
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import AirlineManagement.model.Admin;
import AirlineManagement.model.Airport;
import AirlineManagement.model.Flight;
import AirlineManagement.model.Plane;
import AirlineManagement.model.Ticket;
import AirlineManagement.services.AdminService;
import AirlineManagement.services.AirportService;
import AirlineManagement.services.FlightService;
import AirlineManagement.services.PlaneService;
import AirlineManagement.services.TicketService;

@Controller
public class AdminController {
	
	@Autowired
	private AdminService adminService;
	
	@Autowired
	private AirportService airportService;
	@Autowired
	private PlaneService planeService;
	@Autowired
	private FlightService flightService;
	
	@Autowired
	private TicketService ticketService;
	
	@RequestMapping("/AdminLogin")
	public String adminLogin(HttpSession session)
	{
		if(session.getAttribute("admin")!=null)
			return "admin/AdminDashboard";
		if(session.getAttribute("airline")!=null )
			return "airline/AirlineDashboard";
		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		
		return "admin/AdminLogin";
	}
	

	@RequestMapping("/AdminLogout")
	public String adminLogout(HttpSession session, Model model)
	{
		List<Airport> airports=this.airportService.getAll();
		int count=airports.size();
		model.addAttribute("airports",airports);
		model.addAttribute("airport_count",count);
		session.removeAttribute("admin");
		return "index";
	}
	
	@RequestMapping("/AdminDashboard")
	public String dash(HttpSession session,Model model)
	{

		Admin admin=(Admin) session.getAttribute("admin");
		if(admin==null)
			return "index";
		model.addAttribute("admin",admin);
		return "admin/AdminDashboard";
	}
	
	@RequestMapping(path="/AdminDashboard",method = RequestMethod.POST)
	public String adminDashboard(HttpSession session, @RequestParam("username") String username , @RequestParam("password") String password, Model model )
	{
		Admin admin=this.adminService.getAdmin(username);
		if(admin==null)
		{
			String message="No admin credential found with this username & password";
			model.addAttribute("message", message);
			return "admin/AdminLogin";
		}
		System.out.println(admin);
			if(password.equals(admin.getPassword()))
		{
			session.setAttribute("admin", admin);
			model.addAttribute("admin",admin);
			
			
			return "admin/AdminDashboard";
		}
		else
		{
			String message="No admin credential found with this username & password";
			model.addAttribute("message", message);
			return "admin/AdminLogin";
		}
		
	}
	
	@RequestMapping("/AddAirport")
	public String addAirport(Model model, HttpSession session)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null )
			return "airline/AirlineDashboard";
		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		
		String[] countries= {"Afghanistan,AFG","Albania,ALB","Algeria,DZA","American Samoa,ASM","Andorra,AND","Angola,AGO","Anguilla,AIA","Antarctica,ATA","Antigua and Barbuda,ATG","Argentina,ARG","Armenia,ARM","Aruba,ABW","Australia,AUS","Austria,AUT","Azerbaijan,AZE","Bahamas ,BHS","Bahrain,BHR","Bangladesh,BGD","Barbados,BRB","Belarus,BLR","Belgium,BEL","Belize,BLZ","Benin,BEN","Bermuda,BMU","Bhutan,BTN","Bolivia (Plurinational State of),BOL","Bonaire, Sint Eustatius and Saba,BES","Bosnia and Herzegovina,BIH","Botswana,BWA","Bouvet Island,BVT","Brazil,BRA","British Indian Ocean Territory ,IOT","Brunei Darussalam,BRN","Bulgaria,BGR","Burkina Faso,BFA","Burundi,BDI","Cabo Verde,CPV","Cambodia,KHM","Cameroon,CMR","Canada,CAN","Cayman Islands ,CYM","Central African Republic ,CAF","Chad,TCD","Chile,CHL","China,CHN","Christmas Island,CXR","Cocos (Keeling) Islands ,CCK","Colombia,COL","Comoros ,COM","Congo (the Democratic Republic of the),COD","Congo ,COG","Cook Islands ,COK","Costa Rica,CRI","Croatia,HRV","Cuba,CUB","Curaçao,CUW","Cyprus,CYP","Czechia,CZE","Côte d'Ivoire,CIV","Denmark,DNK","Djibouti,DJI","Dominica,DMA","Dominican Republic ,DOM","Ecuador,ECU","Egypt,EGY","El Salvador,SLV","Equatorial Guinea,GNQ","Eritrea,ERI","Estonia,EST","Eswatini,SWZ","Ethiopia,ETH","Falkland Islands  [Malvinas],FLK","Faroe Islands ,FRO","Fiji,FJI","Finland,FIN","France,FRA","French Guiana,GUF","French Polynesia,PYF","French Southern Territories ,ATF","Gabon,GAB","Gambia ,GMB","Georgia,GEO","Germany,DEU","Ghana,GHA","Gibraltar,GIB","Greece,GRC","Greenland,GRL","Grenada,GRD","Guadeloupe,GLP","Guam,GUM","Guatemala,GTM","Guernsey,GGY","Guinea,GIN","Guinea-Bissau,GNB","Guyana,GUY","Haiti,HTI","Heard Island and McDonald Islands,HMD","Holy See ,VAT","Honduras,HND","Hong Kong,HKG","Hungary,HUN","Iceland,ISL","India,IND","Indonesia,IDN","Iran (Islamic Republic of),IRN","Iraq,IRQ","Ireland,IRL","Isle of Man,IMN","Israel,ISR","Italy,ITA","Jamaica,JAM","Japan,JPN","Jersey,JEY","Jordan,JOR","Kazakhstan,KAZ","Kenya,KEN","Kiribati,KIR","Korea (the Democratic People's Republic of),PRK","Korea (the Republic of),KOR","Kuwait,KWT","Kyrgyzstan,KGZ","Lao People's Democratic Republic ,LAO","Latvia,LVA","Lebanon,LBN","Lesotho,LSO","Liberia,LBR","Libya,LBY","Liechtenstein,LIE","Lithuania,LTU","Luxembourg,LUX","Macao,MAC","Madagascar,MDG","Malawi,MWI","Malaysia,MYS","Maldives,MDV","Mali,MLI","Malta,MLT","Marshall Islands ,MHL","Martinique,MTQ","Mauritania,MRT","Mauritius,MUS","Mayotte,MYT","Mexico,MEX","Micronesia (Federated States of),FSM","Moldova (the Republic of),MDA","Monaco,MCO","Mongolia,MNG","Montenegro,MNE","Montserrat,MSR","Morocco,MAR","Mozambique,MOZ","Myanmar,MMR","Namibia,NAM","Nauru,NRU","Nepal,NPL","Netherlands ,NLD","New Caledonia,NCL","New Zealand,NZL","Nicaragua,NIC","Niger ,NER","Nigeria,NGA","Niue,NIU","Norfolk Island,NFK","Northern Mariana Islands ,MNP","Norway,NOR","Oman,OMN","Pakistan,PAK","Palau,PLW","Palestine, State of,PSE","Panama,PAN","Papua New Guinea,PNG","Paraguay,PRY","Peru,PER","Philippines ,PHL","Pitcairn,PCN","Poland,POL","Portugal,PRT","Puerto Rico,PRI","Qatar,QAT","Republic of North Macedonia,MKD","Romania,ROU","Russian Federation ,RUS","Rwanda,RWA","Réunion,REU","Saint Barthélemy,BLM","Saint Helena, Ascension and Tristan da Cunha,SHN","Saint Kitts and Nevis,KNA","Saint Lucia,LCA","Saint Martin (French part),MAF","Saint Pierre and Miquelon,SPM","Saint Vincent and the Grenadines,VCT","Samoa,WSM","San Marino,SMR","Sao Tome and Principe,STP","Saudi Arabia,SAU","Senegal,SEN","Serbia,SRB","Seychelles,SYC","Sierra Leone,SLE","Singapore,SGP","Sint Maarten (Dutch part),SXM","Slovakia,SVK","Slovenia,SVN","Solomon Islands,SLB","Somalia,SOM","South Africa,ZAF","South Georgia and the South Sandwich Islands,SGS","South Sudan,SSD","Spain,ESP","Sri Lanka,LKA","Sudan ,SDN","Suriname,SUR","Svalbard and Jan Mayen,SJM","Sweden,SWE","Switzerland,CHE","Syrian Arab Republic,SYR","Taiwan (Province of China),TWN","Tajikistan,TJK","Tanzania, United Republic of,TZA","Thailand,THA","Timor-Leste,TLS","Togo,TGO","Tokelau,TKL","Tonga,TON","Trinidad and Tobago,TTO","Tunisia,TUN","Turkey,TUR","Turkmenistan,TKM","Turks and Caicos Islands ,TCA","Tuvalu,TUV","Uganda,UGA","Ukraine,UKR","United Arab Emirates ,ARE","United Kingdom of Great Britain and Northern Ireland ,GBR","United States Minor Outlying Islands ,UMI","United States of America ,USA","Uruguay,URY","Uzbekistan,UZB","Vanuatu,VUT","Venezuela (Bolivarian Republic of),VEN","Viet Nam,VNM","Virgin Islands (British),VGB","Virgin Islands (U.S.),VIR","Wallis and Futuna,WLF","Western Sahara,ESH","Yemen,YEM","Zambia,ZMB","Zimbabwe,ZWE","Åland Islands,ALA","Web Tools"};
		int count=countries.length;
		model.addAttribute("countries",countries);
		model.addAttribute("country_count",count);
		return "admin/AddAirport";
	}
	
	@RequestMapping("/AddNewAirport")
	public String addNewAirport(@RequestParam("country") String country,Model model,@ModelAttribute Airport airport,HttpSession session)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null )
			return "airline/AirlineDashboard";
		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		
		int x=country.length();
		String CC=country.substring(x-3);
		airport.setCountryCode(CC);
		int r=this.airportService.insert(airport);
		System.out.println(r+" airport added");
		return update(session,model);
	}
	
	@RequestMapping({"/UpdateAirport" , "/RemoveAirport"})
	public String update(HttpSession session , Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null )
			return "airline/AirlineDashboard";
		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		
		
		List<Airport> airports=this.airportService.getAll();
		int count=airports.size();
		
		model.addAttribute("airports",airports);
		model.addAttribute("airport_count",count);
		
		List<Plane> planes=this.planeService.getAllPlanes();
	        
        int plane_count=planes.size();
        model.addAttribute("planes",planes);
        model.addAttribute("plane_count",plane_count);
	        
        List<Flight> flights=this.flightService.getAllFlights();
        
        int flight_count=flights.size();
        model.addAttribute("flights",flights);
        model.addAttribute("flight_count",flight_count);
		return "admin/UpdateAirport";
	}
	
	@RequestMapping("/updateairportdetail/{id}")
	public String updatedetail(@PathVariable("id") int id, HttpSession session , Model model)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("airline")!=null )
			return "airline/AirlineDashboard";
		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		
		
		Airport airport_=this.airportService.getAirport(id);
		model.addAttribute("airport_",airport_);
		
		
		List<Plane> planes=this.planeService.getAllPlanes();
	        
        int plane_count=planes.size();
        model.addAttribute("planes",planes);
        model.addAttribute("plane_count",plane_count);
	        
        List<Flight> flights=this.flightService.getAllFlights();
        
        int flight_count=flights.size();
        model.addAttribute("flights",flights);
        model.addAttribute("flight_count",flight_count);
        
        String [] countries= {"Afghanistan,AFG","Albania,ALB","Algeria,DZA","American Samoa,ASM","Andorra,AND","Angola,AGO","Anguilla,AIA","Antarctica,ATA","Antigua and Barbuda,ATG","Argentina,ARG","Armenia,ARM","Aruba,ABW","Australia,AUS","Austria,AUT","Azerbaijan,AZE","Bahamas ,BHS","Bahrain,BHR","Bangladesh,BGD","Barbados,BRB","Belarus,BLR","Belgium,BEL","Belize,BLZ","Benin,BEN","Bermuda,BMU","Bhutan,BTN","Bolivia (Plurinational State of),BOL","Bonaire, Sint Eustatius and Saba,BES","Bosnia and Herzegovina,BIH","Botswana,BWA","Bouvet Island,BVT","Brazil,BRA","British Indian Ocean Territory ,IOT","Brunei Darussalam,BRN","Bulgaria,BGR","Burkina Faso,BFA","Burundi,BDI","Cabo Verde,CPV","Cambodia,KHM","Cameroon,CMR","Canada,CAN","Cayman Islands ,CYM","Central African Republic ,CAF","Chad,TCD","Chile,CHL","China,CHN","Christmas Island,CXR","Cocos (Keeling) Islands ,CCK","Colombia,COL","Comoros ,COM","Congo (the Democratic Republic of the),COD","Congo ,COG","Cook Islands ,COK","Costa Rica,CRI","Croatia,HRV","Cuba,CUB","Curaçao,CUW","Cyprus,CYP","Czechia,CZE","Côte d'Ivoire,CIV","Denmark,DNK","Djibouti,DJI","Dominica,DMA","Dominican Republic ,DOM","Ecuador,ECU","Egypt,EGY","El Salvador,SLV","Equatorial Guinea,GNQ","Eritrea,ERI","Estonia,EST","Eswatini,SWZ","Ethiopia,ETH","Falkland Islands  [Malvinas],FLK","Faroe Islands ,FRO","Fiji,FJI","Finland,FIN","France,FRA","French Guiana,GUF","French Polynesia,PYF","French Southern Territories ,ATF","Gabon,GAB","Gambia ,GMB","Georgia,GEO","Germany,DEU","Ghana,GHA","Gibraltar,GIB","Greece,GRC","Greenland,GRL","Grenada,GRD","Guadeloupe,GLP","Guam,GUM","Guatemala,GTM","Guernsey,GGY","Guinea,GIN","Guinea-Bissau,GNB","Guyana,GUY","Haiti,HTI","Heard Island and McDonald Islands,HMD","Holy See ,VAT","Honduras,HND","Hong Kong,HKG","Hungary,HUN","Iceland,ISL","India,IND","Indonesia,IDN","Iran (Islamic Republic of),IRN","Iraq,IRQ","Ireland,IRL","Isle of Man,IMN","Israel,ISR","Italy,ITA","Jamaica,JAM","Japan,JPN","Jersey,JEY","Jordan,JOR","Kazakhstan,KAZ","Kenya,KEN","Kiribati,KIR","Korea (the Democratic People's Republic of),PRK","Korea (the Republic of),KOR","Kuwait,KWT","Kyrgyzstan,KGZ","Lao People's Democratic Republic ,LAO","Latvia,LVA","Lebanon,LBN","Lesotho,LSO","Liberia,LBR","Libya,LBY","Liechtenstein,LIE","Lithuania,LTU","Luxembourg,LUX","Macao,MAC","Madagascar,MDG","Malawi,MWI","Malaysia,MYS","Maldives,MDV","Mali,MLI","Malta,MLT","Marshall Islands ,MHL","Martinique,MTQ","Mauritania,MRT","Mauritius,MUS","Mayotte,MYT","Mexico,MEX","Micronesia (Federated States of),FSM","Moldova (the Republic of),MDA","Monaco,MCO","Mongolia,MNG","Montenegro,MNE","Montserrat,MSR","Morocco,MAR","Mozambique,MOZ","Myanmar,MMR","Namibia,NAM","Nauru,NRU","Nepal,NPL","Netherlands ,NLD","New Caledonia,NCL","New Zealand,NZL","Nicaragua,NIC","Niger ,NER","Nigeria,NGA","Niue,NIU","Norfolk Island,NFK","Northern Mariana Islands ,MNP","Norway,NOR","Oman,OMN","Pakistan,PAK","Palau,PLW","Palestine, State of,PSE","Panama,PAN","Papua New Guinea,PNG","Paraguay,PRY","Peru,PER","Philippines ,PHL","Pitcairn,PCN","Poland,POL","Portugal,PRT","Puerto Rico,PRI","Qatar,QAT","Republic of North Macedonia,MKD","Romania,ROU","Russian Federation ,RUS","Rwanda,RWA","Réunion,REU","Saint Barthélemy,BLM","Saint Helena, Ascension and Tristan da Cunha,SHN","Saint Kitts and Nevis,KNA","Saint Lucia,LCA","Saint Martin (French part),MAF","Saint Pierre and Miquelon,SPM","Saint Vincent and the Grenadines,VCT","Samoa,WSM","San Marino,SMR","Sao Tome and Principe,STP","Saudi Arabia,SAU","Senegal,SEN","Serbia,SRB","Seychelles,SYC","Sierra Leone,SLE","Singapore,SGP","Sint Maarten (Dutch part),SXM","Slovakia,SVK","Slovenia,SVN","Solomon Islands,SLB","Somalia,SOM","South Africa,ZAF","South Georgia and the South Sandwich Islands,SGS","South Sudan,SSD","Spain,ESP","Sri Lanka,LKA","Sudan ,SDN","Suriname,SUR","Svalbard and Jan Mayen,SJM","Sweden,SWE","Switzerland,CHE","Syrian Arab Republic,SYR","Taiwan (Province of China),TWN","Tajikistan,TJK","Tanzania, United Republic of,TZA","Thailand,THA","Timor-Leste,TLS","Togo,TGO","Tokelau,TKL","Tonga,TON","Trinidad and Tobago,TTO","Tunisia,TUN","Turkey,TUR","Turkmenistan,TKM","Turks and Caicos Islands ,TCA","Tuvalu,TUV","Uganda,UGA","Ukraine,UKR","United Arab Emirates ,ARE","United Kingdom of Great Britain and Northern Ireland ,GBR","United States Minor Outlying Islands ,UMI","United States of America ,USA","Uruguay,URY","Uzbekistan,UZB","Vanuatu,VUT","Venezuela (Bolivarian Republic of),VEN","Viet Nam,VNM","Virgin Islands (British),VGB","Virgin Islands (U.S.),VIR","Wallis and Futuna,WLF","Western Sahara,ESH","Yemen,YEM","Zambia,ZMB","Zimbabwe,ZWE","Åland Islands,ALA","Web Tools"};
		int count=countries.length;
		model.addAttribute("countries",countries);
		model.addAttribute("country_count",count);
		return "admin/UpdateAirportDetail";
	}
	

	@RequestMapping("/viewflight")
	public String ViewFlight(Model model, HttpSession session)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("airline")!=null)
			return "admin/AirlineDashboard";
		
		List<Airport> airports=this.airportService.getAll();
		int count=airports.size();
		model.addAttribute("airports",airports);
		model.addAttribute("airport_count",count);
		
		List<Plane> planes=this.planeService.getAllPlanes();
	        
        int plane_count=planes.size();
        model.addAttribute("planes",planes);
        model.addAttribute("plane_count",plane_count);
	        
        List<Flight> flights=this.flightService.getAllFlights();
        
        int flight_count=flights.size();
        model.addAttribute("flights",flights);
        model.addAttribute("flight_count",flight_count);

		return "admin/ViewFlight";
	}
	
	@RequestMapping("/deleteflight/{id}")
	public String deleteFlight(@PathVariable("id") int id, Model model, HttpSession session)
	{
		if(session.getAttribute("user")==null && session.getAttribute("airline")==null && session.getAttribute("admin")==null)
			return "index";

		if(session.getAttribute("user")!=null)
			return "user/UserDashboard";
		if(session.getAttribute("airline")!=null)
			return "admin/AirlineDashboard";
		
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
		return ViewFlight(model, session);
	}
	
	@RequestMapping("/updateflightdetail/{id}")
	
	public String UpdateFlightDetail(@PathVariable("id") int id, Model model, HttpSession session)
	{
		Flight flight=this.flightService.getFlightbyId(id);
		model.addAttribute("flight",flight);
		
		List<Airport> airports=this.airportService.getAll();
		int count=airports.size();
		model.addAttribute("airports",airports);
		model.addAttribute("airport_count",count);
		
		List<Plane> planes=this.planeService.getAllPlanes();
	        
        int plane_count=planes.size();
        model.addAttribute("planes",planes);
        model.addAttribute("plane_count",plane_count);
	        
        List<Flight> flights=this.flightService.getAllFlights();
        
        int flight_count=flights.size();
        model.addAttribute("flights",flights);
        model.addAttribute("flight_count",flight_count);
        
		return "admin/UpdateFlightDetail";
	}
	
	@RequestMapping("/updateflightschedule/{id}")
	public String UpdateFlightSchedule(@PathVariable("id") int id,@RequestParam("plane") String pname, Model model, HttpSession session, @ModelAttribute Flight flight)
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
		return ViewFlight(model, session);
	}
	
	
}
