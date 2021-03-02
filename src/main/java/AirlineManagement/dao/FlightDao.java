package AirlineManagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import AirlineManagement.RowMapper.FlightRowMapper;
import AirlineManagement.model.Flight;
import AirlineManagement.model.Plane;
import AirlineManagement.services.PlaneService;

@Repository
public class FlightDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	private PlaneService planeService;

	public int insert(Flight flight) {
		
		String query="insert into flight(plane_id,from_,to_,dtime,atime,day_,availableSeats,fare,date_) values(?,?,?,?,?,?,?,?,?)";
		int result = this.jdbcTemplate.update(query,flight.getPlane_id(),flight.getFrom_(),flight.getTo_(),flight.getDtime(),flight.getAtime(),flight.getDay_(),flight.getAvailableSeats(),flight.getFare(),flight.getDate_());
		return result;
	}

	public int update(Flight flight) {
		
		String query="update flight set dtime=?,atime=?,fare=? where id=?";
		int result = this.jdbcTemplate.update(query,flight.getDtime(),flight.getAtime(),flight.getFare(),flight.getId());
		return result;
	}
	
	
	public int delete(int id) {
			
			String query="delete from flight where id=?";
			int result = this.jdbcTemplate.update(query,id);
			return result;
		}
		
	public Flight getFlightById(int flightId)
	{
			RowMapper<Flight> rowMapper=new FlightRowMapper();
			String query="select * from flight where id=?";
			Flight flight=this.jdbcTemplate.queryForObject(query, rowMapper,flightId);
			return flight;
	}

	public List<Flight> getAllFlights() {
		
		RowMapper<Flight> rowMapper=new FlightRowMapper();
		String query="select * from flight order by id DESC";
		List<Flight> flights=this.jdbcTemplate.query(query, rowMapper);
		return flights;
	}
	
	public List<Flight> getAllFlightsByAirline(String airlineName) {
		
		RowMapper<Flight> rowMapper=new FlightRowMapper();
		String query="select * from flight order by id DESC";
		List<Flight> flights=this.jdbcTemplate.query(query, rowMapper);
		
		List<Flight> fl=new ArrayList<Flight>();
		for(Flight f:flights)
		{
			int id=f.getPlane_id();
			Plane plane= this.planeService.getPlane(id);
			if(plane.getAirline().equals(airlineName))
			{
				fl.add(f);
			}
		}
		return fl;
	}
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public List<Flight> getFlightsBySDD(String source, String dest, int day_) {

		RowMapper<Flight> rowMapper=new FlightRowMapper();
		String query="select * from flight where from_=? and to_=? and day_=? and date_ is NOT NULL order by dtime";
		List<Flight> flights=this.jdbcTemplate.query(query, rowMapper, source,dest,day_);
		return flights;
	}

	public List<Flight> getFlightsBySDDN(String source, String dest, int day_) {
	
		RowMapper<Flight> rowMapper=new FlightRowMapper();
		String query="select * from flight where from_=? and to_=? and day_=? and date_ is NULL order by dtime";
		List<Flight> flights=this.jdbcTemplate.query(query, rowMapper, source,dest,day_);
		return flights;
	}
	
	public List<Flight> getFlightsBySDDD(String source, String dest, int day_, String date_) {
		
		RowMapper<Flight> rowMapper=new FlightRowMapper();
		String query="select * from flight where from_=? and to_=? and day_=? and date_=? order by dtime";
		List<Flight> flights=this.jdbcTemplate.query(query, rowMapper, source,dest,day_,date_);
		return flights;
	}

	public int DecrementAvailability(int id) {

		String query="update flight set availableSeats=availableSeats-1 where id=?";
		int result = this.jdbcTemplate.update(query,id);
		return result;
	}

	public int IncrementAvailability(int fid) {

		String query="update flight set availableSeats=availableSeats+1 where id=?";
		int result = this.jdbcTemplate.update(query,fid);
		return result;
	}

	public List<Flight> getAllFlightsByPlane(int plane_id) {
		
		RowMapper<Flight> rowMapper=new FlightRowMapper();
		String query="select * from flight where plane_id=?";
		List<Flight> flights=this.jdbcTemplate.query(query, rowMapper,plane_id);
		return flights;
	}

	

	


}
