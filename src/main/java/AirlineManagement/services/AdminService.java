package AirlineManagement.services;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AirlineManagement.dao.AdminDao;
import AirlineManagement.model.Admin;

@Service
public class AdminService {
	
	@Autowired
	private AdminDao adminDao;
	public int updatePassword(String username,String password)
	{
		return this.adminDao.updatePassword(password, username);
	}
	public Admin getAdmin(String username) {
		
		return this.adminDao.getAdmin(username);
	}
}
