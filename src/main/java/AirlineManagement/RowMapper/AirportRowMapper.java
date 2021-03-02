package AirlineManagement.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import AirlineManagement.model.Airport;

public class AirportRowMapper implements RowMapper<Airport> {

	public Airport mapRow(ResultSet rs, int rowNum) throws SQLException {
		Airport airport=new Airport();
		airport.setId(rs.getInt(1));
		airport.setCity(rs.getString(2));
		airport.setCountryCode(rs.getString(3));
		airport.setAirportName(rs.getString(4));
		airport.setAirportCode(rs.getString(5));
		return airport;
	}

}
