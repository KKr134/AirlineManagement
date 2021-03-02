package AirlineManagement.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import AirlineManagement.model.Plane;

public class PlaneRowMapper implements RowMapper<Plane>{

	public Plane mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Plane plane=new Plane();
		plane.setId(rs.getInt(1));
		plane.setName(rs.getString(2));
		plane.setAirline(rs.getString(3));
		plane.setCapacity(rs.getInt(4));
		return plane;
	}
	

}
