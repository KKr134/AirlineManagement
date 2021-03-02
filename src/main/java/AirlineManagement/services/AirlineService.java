package AirlineManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AirlineManagement.dao.AirlineDao;
import AirlineManagement.model.Airline;

@Service
public class AirlineService {

	@Autowired
	private AirlineDao airlineDao;
	public int CreateAirline(Airline airline)
	{
		
		int id=this.airlineDao.insert(airline);
		return id;
	}
	
	public int UpdateAirline(Airline airline)
	{
		return this.airlineDao.update(airline);
	}
	
	public int DeleteAirline(Airline airline)
	{
		return this.airlineDao.delete(airline);
	}
	
	public Airline getAirlineById(int airlineId)
	{
		return this.airlineDao.getAirlineById(airlineId);
	}
	public Airline getAirlineByEmail(String email)
	{
		return this.airlineDao.getAirlineByEmail(email);
	}
}
