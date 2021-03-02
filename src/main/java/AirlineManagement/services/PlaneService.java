package AirlineManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AirlineManagement.dao.PlaneDao;
import AirlineManagement.model.Plane;

@Service
public class PlaneService {
	
	@Autowired
	private PlaneDao planeDao;
	public int CreatePlane(Plane plane)
	{
		
		int id=this.planeDao.insert(plane);
		return id;
	}
	
	
	
	public int DeletePlane(int id)
	{
		return this.planeDao.delete(id);
	}
	
	public Plane getPlane(int planeId)
	{
		return this.planeDao.getPlane(planeId);
	}

	public List<Plane> getAllPlanes() {
		
		return this.planeDao.getAllPlanes();
	}

	public List<Plane> getPlanesByAirline(String airlineName) {

		return this.planeDao.getPlanesByAirline(airlineName);
	}

	public int UpdatePlane(int id, String name, String capacity) {
	
		return this.planeDao.update(id,name,capacity);
	}



	public Plane getPlaneByName(String plane) {
		// TODO Auto-generated method stub
		return this.planeDao.getPlaneByName(plane);
	}



	public List<Plane> getAllPlanesByName(String pname) {
		return this.planeDao.getAllPlanesByName(pname);
	}

}
