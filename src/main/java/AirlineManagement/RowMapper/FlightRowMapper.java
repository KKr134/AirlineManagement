package AirlineManagement.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import AirlineManagement.model.Flight;

public class FlightRowMapper implements RowMapper<Flight>{

	public Flight mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Flight flight=new Flight();
		flight.setId(rs.getInt(1));
		flight.setPlane_id(rs.getInt(2));
		flight.setFrom_(rs.getString(3));
		flight.setTo_(rs.getString(4));
		flight.setDtime(rs.getString(5));
		flight.setAtime(rs.getString(6));
		flight.setDay_(rs.getInt(7));
		flight.setAvailableSeats(rs.getInt(8));
		flight.setFare(rs.getInt(9));
		flight.setDate_(rs.getString(10));
		return flight;
	}
	

}
