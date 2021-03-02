package AirlineManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AirlineManagement.dao.PassengerDao;
import AirlineManagement.model.Passenger;

@Service
public class PassengerService {
	
	@Autowired
	private PassengerDao passengerDao;
	
	public int CreatePassenger(Passenger passenger)
	{
		
		int id=this.passengerDao.insert(passenger);
		return id;
	}
	
	
	
	public PassengerDao getPassengerDao() {
		return passengerDao;
	}



	public void setPassengerDao(PassengerDao passengerDao) {
		this.passengerDao = passengerDao;
	}



	public int Delete(int id)
	{
		return this.passengerDao.delete(id);
	}
	
	public Passenger getPassengerById(int passengerId)
	{
		return this.passengerDao.getPassengerById(passengerId);
	}
	
	public Passenger getPassengerByGid(String gid)
	{
		return this.passengerDao.getPassengerByGid(gid);
	}



	public List<Passenger> getPassengerByUid(int id) {
		
		return this.passengerDao.getPassengerByUid(id);
	}

}
