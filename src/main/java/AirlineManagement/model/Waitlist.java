package AirlineManagement.model;

import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Waitlist {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int ticketId;
	private int waitRank;
	
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getTicketId() {
		return ticketId;
	}
	public void setTicketId(int ticketId) {
		this.ticketId = ticketId;
	}
	public int getWaitRank() {
		return waitRank;
	}
	public void setWaitRank(int waitRank) {
		this.waitRank = waitRank;
	}
	@Override
	public String toString() {
		return "Waitlist [id=" + id + ", ticketId=" + ticketId + ", waitRank=" + waitRank
				+ "]";
	}
	
	

}
