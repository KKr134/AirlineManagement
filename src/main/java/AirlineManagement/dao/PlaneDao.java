package AirlineManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import AirlineManagement.RowMapper.PlaneRowMapper;
import AirlineManagement.model.Plane;

@Repository
public class PlaneDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public int insert(Plane plane) {
		
		String query="insert into plane(name,airline,capacity) values(?,?,?)";
		int result = this.jdbcTemplate.update(query,plane.getName(),plane.getAirline(),plane.getCapacity());
		return result;
	}

	public int update(int id, String name, String capacity) {
		
		String query="update plane set name=?,capacity=? where id=?";
		int result = this.jdbcTemplate.update(query,name,capacity,id);
		return result;
	}
	
	
	public int delete(int id) {
			
			String query="delete from plane where id=?";
			int result = this.jdbcTemplate.update(query,id);
			return result;
		}
		
	public Plane getPlane(int planeId)
	{
			RowMapper<Plane> rowMapper=new PlaneRowMapper();
			String query="select * from plane where id=?";
			Plane plane=this.jdbcTemplate.queryForObject(query, rowMapper,planeId);
			return plane;
	}
	
	public List<Plane> getAllPlanes()
	{
			RowMapper<Plane> rowMapper=new PlaneRowMapper();
			String query="select * from plane order by id ASC";
			List<Plane> planes=this.jdbcTemplate.query(query, rowMapper);
			return planes;
	}
	
	public List<Plane> getPlanesByAirline(String airlineName) {
		
		RowMapper<Plane> rowMapper=new PlaneRowMapper();
		String query="select * from plane where airline=? order by id ASC";
		List<Plane> planes=this.jdbcTemplate.query(query, rowMapper,airlineName);
		return planes;
	}
	
	public Plane getPlaneByName(String name) {
		RowMapper<Plane> rowMapper=new PlaneRowMapper();
		String query="select * from plane where name=?";
		Plane plane=this.jdbcTemplate.queryForObject(query, rowMapper,name);
		return plane;	}
	
	public List<Plane> getAllPlanesByName(String pname) {
		RowMapper<Plane> rowMapper=new PlaneRowMapper();
		String query="select * from plane where name=?";
		List<Plane> planes=this.jdbcTemplate.query(query, rowMapper,pname);
		return planes;
	}
	
	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	

	

	 
	


}
