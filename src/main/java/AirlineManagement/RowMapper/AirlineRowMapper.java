package AirlineManagement.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import AirlineManagement.model.Airline;

public class AirlineRowMapper implements RowMapper<Airline>{

	public Airline mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Airline airline=new Airline();
		airline.setId(rs.getInt(1));
		airline.setName(rs.getString(2));
		airline.setEmail(rs.getString(3));
		airline.setPassword(rs.getString(4));
		airline.setManager(rs.getString(5));
		airline.setContact(rs.getString(6));
		return airline;
	}
	

}
