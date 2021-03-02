package AirlineManagement.dao;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import AirlineManagement.RowMapper.WaitlistRowMapper;
import AirlineManagement.model.Ticket;
import AirlineManagement.model.Waitlist;
import AirlineManagement.services.TicketService;

@Repository
public class WaitlistDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
	@Autowired
	TicketService ticketService;
	
	public int getLastRank(int fid) {


		RowMapper<Waitlist> rowMapper=new WaitlistRowMapper();
		String query="select* from waitlist ";
		List<Waitlist> waitlists= this.jdbcTemplate.query(query, rowMapper);
		
		int rank=0;
		for (Waitlist w:waitlists)
		{
			Ticket ticket=this.ticketService.getTicketById(w.getTicketId());
			
			if(ticket.getFid()==fid)
			{
				if(rank<=w.getWaitRank())
					rank=w.getWaitRank();
			}
		}
		return rank;
	}

	public List<Waitlist> getbyFid(int fid) {



		RowMapper<Waitlist> rowMapper=new WaitlistRowMapper();
		String query="select* from waitlist ";
		List<Waitlist> waitlists= this.jdbcTemplate.query(query, rowMapper);
		
		List<Waitlist> L= new ArrayList<Waitlist>();
		for (Waitlist w:waitlists)
		{
			Ticket ticket=this.ticketService.getTicketById(w.getTicketId());
			
			if(ticket.getFid()==fid)
			{
				L.add(w);
			}
		}
		return L;
	}
	
	public Object getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate =  jdbcTemplate;
	}

	public int insert(Waitlist person) {
		
		String query="insert into waitlist (ticketId,waitRank) values(?,?)";
		int result = this.jdbcTemplate.update(query,person.getTicketId(),person.getWaitRank());
		return result;
		
	}

	public int remove(int id) {
		
		String query="delete from waitlist where ticketId=?";
		int result = this.jdbcTemplate.update(query,id);
		return result;
	}

	public int getWaitRank(int id) {

		RowMapper<Waitlist> rowMapper=new WaitlistRowMapper();
		String query="select* from waitlist where ticketId=? ";
		Waitlist waitlist= this.jdbcTemplate.queryForObject(query, rowMapper,id);
		int rank=waitlist.getWaitRank();
		return rank;
	}

}
