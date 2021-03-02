package AirlineManagement.RowMapper;

import java.sql.ResultSet;
import java.sql.SQLException;

import org.springframework.jdbc.core.RowMapper;

import AirlineManagement.model.Ticket;

public class TicketRowMapper implements RowMapper<Ticket>{

	public Ticket mapRow(ResultSet rs, int rowNum) throws SQLException {
		// TODO Auto-generated method stub
		Ticket ticket=new Ticket();
		ticket.setId(rs.getInt(1));
		ticket.setAge(rs.getInt(2));
		ticket.setUid(rs.getInt(3));
		ticket.setPname(rs.getString(4));
		ticket.setIssued(rs.getString(5));
		ticket.setStatus(rs.getString(6));
		ticket.setFid(rs.getInt(7));
		return ticket;
	}
	

}
