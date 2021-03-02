package AirlineManagement.model;

public class Airport {
	private int id;
	private String city;
	private String countryCode;
	private String airportName;
	private String airportCode;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getCity() {
		return city;
	}
	public void setCity(String city) {
		this.city = city;
	}
	public String getCountryCode() {
		return countryCode;
	}
	public void setCountryCode(String countryCode) {
		this.countryCode = countryCode;
	}
	public String getAirportName() {
		return airportName;
	}
	public void setAirportName(String airportName) {
		this.airportName = airportName;
	}
	public String getAirportCode() {
		return airportCode;
	}
	public void setAirportCode(String airportCode) {
		this.airportCode = airportCode;
	}
	@Override
	public String toString() {
		return "Airport [id=" + id + ", city=" + city + ", countryCode=" + countryCode + ", airportName=" + airportName
				+ ", airportCode=" + airportCode + "]";
	}
	
	

}
