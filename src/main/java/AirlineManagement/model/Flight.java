package AirlineManagement.model;



import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;

public class Flight {
	
	@Id
	@GeneratedValue(strategy = GenerationType.AUTO)
	private int id;
	private int plane_id;
	private String from_;
	private String to_;
	private String dtime;
	private String atime;
	private int day_;
	private int availableSeats;
	private int fare;
	private String date_;
	
	@Override
	public String toString() {
		return "Flight [id=" + id + ", plane_id=" + plane_id + ", from_=" + from_ + ", to_=" + to_ + ", dtime=" + dtime
				+ ", atime=" + atime + ", day_=" + day_ + ", availableSeats=" + availableSeats + ", fare=" + fare
				+ ", date_=" + date_ + "]";
	}
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public int getPlane_id() {
		return plane_id;
	}
	public void setPlane_id(int plane_id) {
		this.plane_id = plane_id;
	}
	public String getFrom_() {
		return from_;
	}
	public void setFrom_(String from_) {
		this.from_ = from_;
	}
	public String getTo_() {
		return to_;
	}
	public void setTo_(String to_) {
		this.to_ = to_;
	}
	public String getDtime() {
		return dtime;
	}
	public void setDtime(String dtime) {
		this.dtime = dtime;
	}
	public String getAtime() {
		return atime;
	}
	public void setAtime(String atime) {
		this.atime = atime;
	}
	public int getDay_() {
		return day_;
	}
	public void setDay_(int day_) {
		this.day_ = day_;
	}
	public int getAvailableSeats() {
		return availableSeats;
	}
	public void setAvailableSeats(int availableSeats) {
		this.availableSeats = availableSeats;
	}
	public int getFare() {
		return fare;
	}
	public void setFare(int fare) {
		this.fare = fare;
	}
	public String getDate_() {
		return date_;
	}
	public void setDate_(String date_) {
		this.date_ = date_;
	}
	
	
	
	
	
	
	
	
	


}
