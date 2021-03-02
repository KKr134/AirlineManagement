package AirlineManagement.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import AirlineManagement.model.Admin;

public class AdminRowMapper implements RowMapper<Admin>{

	public Admin mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Admin admin=new Admin();
		admin.setUsername(rs.getString(1));
		admin.setPassword(rs.getString(2));
		return admin;
		
	}
	

}
