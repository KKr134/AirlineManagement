package AirlineManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AirlineManagement.dao.UserDao;
import AirlineManagement.model.User;

@Service
public class UserService {

		@Autowired
		private UserDao userDao;
		public int CreateUser(User user)
		{
			
			int id=this.userDao.insert(user);
			return id;
		}
		
		public int UpdateUser(User user)
		{
			return this.userDao.update(user);
		}
		
		public int DeleteUser(User user)
		{
			return this.userDao.delete(user);
		}
		
		public User getUserById(int userId)
		{
			return this.userDao.getUserById(userId);
		}
		public User getUserByEmail(String email)
		{
			return this.userDao.getUserByEmail(email);
		}
}
