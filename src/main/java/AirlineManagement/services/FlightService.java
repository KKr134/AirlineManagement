package AirlineManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AirlineManagement.dao.FlightDao;
import AirlineManagement.model.Flight;

@Service
public class FlightService {
	
	@Autowired
	private FlightDao flightDao;
	public int CreateFlight(Flight flight)
	{
		
		int id=this.flightDao.insert(flight);
		return id;
	}
	
	
	
	public int DeleteFlight(int id)
	{
		return this.flightDao.delete(id);
	}
	
	public Flight getFlightbyId(int flightId)
	{
		return this.flightDao.getFlightById(flightId);
	}




	public List<Flight> getAllFlights() {
		
		return this.flightDao.getAllFlights();
	}
	
	public List<Flight> getAllFlightsByAirline(String airLineName)
	{
		return this.flightDao.getAllFlightsByAirline(airLineName);
		
	}


	public List<Flight> getFlightsBySDD(String source, String dest, int day_) {

		return this.flightDao.getFlightsBySDD(source,dest,day_);
	}



	public List<Flight> getFlightsBySDDD(String source, String dest, int day_, String date_) {
		
		return this.flightDao.getFlightsBySDDD(source, dest, day_, date_);
	}
	
	public List<Flight> getFlightsBySDDN(String source, String dest, int day_) {
		
		return this.flightDao.getFlightsBySDDN(source, dest, day_);
	}



	public int DecrementAvailability(int id) {
		
		return this.flightDao.DecrementAvailability(id);
	}



	public int IncrementAvailability(int fid) {
		
		return this.flightDao.IncrementAvailability(fid);
	}



	public List<Flight> getAllFlightsByPlane(int plane) {
		
		return this.flightDao.getAllFlightsByPlane(plane);
	}



	public int Update(Flight flight) {
		
		return this.flightDao.update(flight);
	}	




}
