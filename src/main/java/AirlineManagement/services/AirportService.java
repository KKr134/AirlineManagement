package AirlineManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AirlineManagement.dao.AirportDao;
import AirlineManagement.model.Airport;

@Service
public class AirportService {

	@Autowired
	private AirportDao airportDao;
	
	public int insert(Airport airport) {
		
		return this.airportDao.insert(airport);
	}
	
	public List<Airport> getAll() {
			
			return this.airportDao.getAll();
		}

	public Airport getAirport(int id) {
		return this.getAirport(id);
	}
}
