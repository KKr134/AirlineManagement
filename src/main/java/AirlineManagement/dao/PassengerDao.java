package AirlineManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import AirlineManagement.RowMapper.PassengerRowMapper;
import AirlineManagement.model.Passenger;

@Repository
public class PassengerDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}



	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}



	public int insert(Passenger passenger) {
		
		String query="insert into passenger(name,dob,gender,idType,gid,uid) values(?,?,?,?,?,?)";
		int result = this.jdbcTemplate.update(query,passenger.getName(),passenger.getDob(),passenger.getGender(),passenger.getIdType(),passenger.getGid(),passenger.getUid());
		return result;
	}

	
	
	public int delete(int id) {
			
			String query="delete from passenger where id=?";
			int result = this.jdbcTemplate.update(query,id);
			return result;
		}
		
	public Passenger getPassengerById(int passengerId)
	{
			RowMapper<Passenger> rowMapper=new PassengerRowMapper();
			String query="select * from passenger where id=?";
			Passenger passenger=this.jdbcTemplate.queryForObject(query, rowMapper,passengerId);
			return passenger;
	}
	
	public Passenger getPassengerByGid(String Gid)
	{
			RowMapper<Passenger> rowMapper=new PassengerRowMapper();
			String query="select * from passenger where gid=?";
			Passenger passenger=this.jdbcTemplate.queryForObject(query, rowMapper,Gid);
			return passenger;
	}



	public List<Passenger> getPassengerByUid(int id) {
		
		RowMapper<Passenger> rowMapper=new PassengerRowMapper();
		String query="select * from passenger where uid=?";
		List<Passenger> passengers=this.jdbcTemplate.query(query, rowMapper,id);
		return passengers;
	}
	

}
