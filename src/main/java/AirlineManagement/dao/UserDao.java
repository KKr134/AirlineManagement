package AirlineManagement.dao;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.jdbc.core.JdbcTemplate;
import org.springframework.jdbc.core.RowMapper;
import org.springframework.stereotype.Repository;

import AirlineManagement.RowMapper.UserRowMapper;
import AirlineManagement.model.User;

@Repository
public class UserDao{
	
	@Autowired
	private JdbcTemplate jdbcTemplate;
	

	public int insert(User user) {
		
		String query="insert into user(name,email,address,mobile,password) values(?,?,?,?,?)";
		int result = this.jdbcTemplate.update(query,user.getName(),user.getEmail(),user.getAddress(),user.getMobile(),user.getPassword());
		return result;
	}

	public int update(User user) {
		
		String query="update user set name=?,email=?,address=?,mobile=?,password=? where id=?";
		int result = this.jdbcTemplate.update(query,user.getName(),user.getEmail(),user.getAddress(),user.getMobile(),user.getPassword(),user.getId());
		return result;
	}
	
	
	public int delete(User user) {
			
			String query="delete from user where id=?";
			int result = this.jdbcTemplate.update(query,user.getId());
			return result;
		}
		
	public User getUserById(int userId)
	{
			RowMapper<User> rowMapper=new UserRowMapper();
			String query="select * from user where id=?";
			User user=this.jdbcTemplate.queryForObject(query, rowMapper,userId);
			return user;
	}
	public User getUserByEmail(String email)
	{
		RowMapper<User> rowMapper=new UserRowMapper();
		String query="select * from user";
		List<User> users = (List<User>) this.jdbcTemplate.query(query, rowMapper);
		for( User user:users)
		{
			if(user.getEmail().equals(email))
			{
				return user;
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
//	public int SaveUser (User user)
//	{
//		int id= (Integer) this.jdbcTemplate.save(user);
//		return id;
//		
//	}

}
