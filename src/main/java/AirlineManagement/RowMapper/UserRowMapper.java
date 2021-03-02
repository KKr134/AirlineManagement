package AirlineManagement.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import AirlineManagement.model.User;

public class UserRowMapper implements RowMapper<User>{

	public User mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		User user=new User();
		user.setId(rs.getInt(1));
		user.setName(rs.getString(2));
		user.setEmail(rs.getString(3));
		user.setPassword(rs.getString(4));
		user.setMobile(rs.getString(6));
		user.setAddress(rs.getString(5));
		return user;
	}
	

}
