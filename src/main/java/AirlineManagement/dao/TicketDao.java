package AirlineManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import AirlineManagement.RowMapper.TicketRowMapper;
import AirlineManagement.model.Ticket;

@Repository
public class TicketDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public int insert(Ticket ticket) {
		
		String query="insert into ticket(fid,age,uid,pname,issued,status) values(?,?,?,?,?,?)";
		int result = this.jdbcTemplate.update(query,ticket.getFid(),ticket.getAge(),ticket.getUid(),ticket.getPname(),ticket.getIssued(),ticket.getStatus());
		
		
		return result;
	}
	
	public int maxid()
	{
		RowMapper<Ticket> rowMapper=new TicketRowMapper();
		String query1="select * from ticket order by id DESC LIMIT 1";
		Ticket ticket1=this.jdbcTemplate.queryForObject(query1, rowMapper);
		int result=ticket1.getId();
		return result;
	}

	public int cancel(int id) {
		
		String query="update ticket set status=? where id=? ";
		int result = this.jdbcTemplate.update(query,"cancelled",id);
		return result;
	}
	
	
	public int delete(int id) {
			
			String query="delete from ticket where id=?";
			int result = this.jdbcTemplate.update(query,id);
			return result;
		}
		
	public Ticket getTicketById(int ticketId)
	{
			RowMapper<Ticket> rowMapper=new TicketRowMapper();
			String query="select * from ticket where id=?";
			Ticket ticket=this.jdbcTemplate.queryForObject(query, rowMapper,ticketId);
			return ticket;
	}
	
	public List<Ticket> getTicketByUid(int Uid)
	{
			RowMapper<Ticket> rowMapper=new TicketRowMapper();
			String query="select * from ticket where uid=? order by issued DESC, id DESC";
			List<Ticket> tickets=this.jdbcTemplate.query(query, rowMapper,Uid);
			return tickets;
	}
	
	public List<Ticket> getCancelledTicketByUid(int Uid) {
		
		RowMapper<Ticket> rowMapper=new TicketRowMapper();
		String query="select * from ticket where uid=? and status=? order by issued DESC ,id DESC";
		List<Ticket> tickets=this.jdbcTemplate.query(query, rowMapper,Uid,"cancelled");
		return tickets;

	}
	
	public List<Ticket> getAllTickets() {
		RowMapper<Ticket> rowMapper=new TicketRowMapper();
		String query="select * from ticket order by id ASC";
		List<Ticket> tickets=this.jdbcTemplate.query(query, rowMapper);
		return tickets;
	}
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public int UpdateStatus(int tid, String status) {

		String query="update ticket set status=? where id=? ";
		int result = this.jdbcTemplate.update(query,status,tid);
		return result;
	}

	

	


}
