package AirlineManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import AirlineManagement.RowMapper.AirportRowMapper;
import AirlineManagement.model.Airport;

@Repository
public class AirportDao {

	@Autowired
	private JdbcTemplate jdbcTemplate;
	
public int insert(Airport airport) {
		
		String query="insert into airport(city,countryCode,airportName,airportCode) values(?,?,?,?)";
		int result = this.jdbcTemplate.update(query,airport.getCity(),airport.getCountryCode(),airport.getAirportName(),airport.getAirportCode());
		return result;
	}

	public int update(Airport airport) {
		
		String query="update airport set city=? countryCode=? airportName=? airportCode=?  where id=?";
		int result = this.jdbcTemplate.update(query,airport.getCity(),airport.getCountryCode(),airport.getAirportName(),airport.getAirportCode(),airport.getId());
		return result;
	}
	
	
	public int delete(int id) {
			
			String query="delete from airport where id=?";
			int result = this.jdbcTemplate.update(query,id);
			return result;
		}
	
	public List<Airport> getAll()
	{
			RowMapper<Airport> rowMapper=new AirportRowMapper();
			String query="select * from airport order by city";
			List<Airport> airports=this.jdbcTemplate.query(query, rowMapper);
			return airports;
	}	
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}


}
