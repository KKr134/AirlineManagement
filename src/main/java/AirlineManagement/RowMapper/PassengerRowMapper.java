package AirlineManagement.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import AirlineManagement.model.Passenger;

public class PassengerRowMapper implements RowMapper<Passenger>{

	public Passenger mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Passenger passenger=new Passenger();
		passenger.setId(rs.getInt(1));
		passenger.setName(rs.getString(2));
		passenger.setDob(rs.getString(3));
		passenger.setGender(rs.getString(4));
		passenger.setIdType(rs.getString(5));
		passenger.setGid(rs.getString(6));
		return passenger;
	}
	

}
