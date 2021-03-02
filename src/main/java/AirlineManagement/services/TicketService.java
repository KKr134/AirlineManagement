package AirlineManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AirlineManagement.dao.TicketDao;
import AirlineManagement.model.Ticket;

@Service
public class TicketService {
	
	@Autowired
	private TicketDao ticketDao;
		
	public int Generate(Ticket ticket) {
				
		return this.ticketDao.insert(ticket);
	}

	public int cancel(int id) {
		
		return this.ticketDao.cancel(id);
		
		
	}
	
	
	public int delete(int id) {
			
		return this.ticketDao.delete(id);
	}
		
	public Ticket getTicketById(int ticketId)
	{
		return this.ticketDao.getTicketById(ticketId);
	}
	
	public List<Ticket> getTicketByUid(int Uid)
	{
		return this.ticketDao. getTicketByUid(Uid);
	}

	public List<Ticket> getCancelledTicketByUid(int id) {
		
		return this.ticketDao.getCancelledTicketByUid( id);
	}

	public List<Ticket> getAllTickets() {
		return this.ticketDao.getAllTickets();
	}
	
	public int maxid()
	{
		return this.ticketDao.maxid();
	}

	public int UpdateStatus(int tid, String status) {
		return this.ticketDao.UpdateStatus(tid,status);
	}

}
