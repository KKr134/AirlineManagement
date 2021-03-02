package AirlineManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import AirlineManagement.RowMapper.AirlineRowMapper;
import AirlineManagement.model.Airline;


@Repository
public class AirlineDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public int insert(Airline airline) {
		
		String query="insert into airline(name,email,manager,contact,password) values(?,?,?,?,?)";
		int result = this.jdbcTemplate.update(query,airline.getName(),airline.getEmail(),airline.getManager(),airline.getContact(),airline.getPassword());
		return result;
	}

	public int update(Airline airline) {
		
		String query="update airline set name=?,manager=?,contact=?,password=? where id=?";
		int result = this.jdbcTemplate.update(query,airline.getName(),airline.getManager(),airline.getContact(),airline.getPassword(),airline.getId());
		return result;
	}
	
	
	public int delete(Airline airline) {
			
			String query="delete from airline where id=?";
			int result = this.jdbcTemplate.update(query,airline.getId());
			return result;
		}
		
	public Airline getAirlineById(int airlineId)
	{
			RowMapper<Airline> rowMapper=new AirlineRowMapper();
			String query="select * from airline where id=?";
			Airline airline=this.jdbcTemplate.queryForObject(query, rowMapper,airlineId);
			return airline;
	}
	public Airline getAirlineByEmail(String email)
	{
			RowMapper<Airline> rowMapper=new AirlineRowMapper();
			String query="select * from airline";
			List<Airline> airlines = (List<Airline>) this.jdbcTemplate.query(query, rowMapper);
			for( Airline airline:airlines)
			{
				if(airline.getEmail().equals(email))
				{
					return airline;
				}
			}
			return null;
			
	}
	
	
	
	
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	
	
	
	
//	
//	public int SaveAirline (Airline airline)
//	{
//		int id= (Integer) this.jdbcTemplate.save(airline);
//		return id;
//		
//	}

}
