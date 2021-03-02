package AirlineManagement.dao;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import AirlineManagement.RowMapper.AdminRowMapper;
import AirlineManagement.model.Admin;


@Repository
public class AdminDao {
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public int updatePassword( String password,String username) {
		
		String query="update admin set password=? where username=?";
		int result = this.jdbcTemplate.update(query,password,username);
		return result;
	}

	public JdbcTemplate getJdbcTemplate() {
		return jdbcTemplate;
	}

	public void setJdbcTemplate(JdbcTemplate jdbcTemplate) {
		this.jdbcTemplate = jdbcTemplate;
	}

	public Admin getAdmin(String username) {
		
		RowMapper<Admin> rowMapper=new AdminRowMapper();
		String query="select * from admin";
		List<Admin> admins = (List<Admin>) this.jdbcTemplate.query(query, rowMapper);
		for( Admin admin:admins)
		{
			if(admin.getUsername().equals(username))
			{
				return admin;
			}
		}
		return null;
	}
	

}
