package AirlineManagement.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import AirlineManagement.model.Waitlist;

public class WaitlistRowMapper implements RowMapper<Waitlist>{

	public Waitlist mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Waitlist waitlist=new Waitlist();
		waitlist.setTicketId(rs.getInt(2));
		waitlist.setWaitRank(rs.getInt(3));
		
		return waitlist;
	}
	

}
