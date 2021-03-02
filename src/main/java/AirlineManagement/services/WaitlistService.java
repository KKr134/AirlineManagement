package AirlineManagement.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import AirlineManagement.dao.WaitlistDao;
import AirlineManagement.model.Waitlist;

@Service
public class WaitlistService {

	@Autowired
	private WaitlistDao waitlistDao;
	
	public int getLastRank(int fid) {
		return this.waitlistDao.getLastRank(fid);
	}
	
	public List<Waitlist> getbyFid(int fid) {
		
		return this.waitlistDao.getbyFid(fid);
	}

	public int insert(Waitlist person) {
		return this.waitlistDao.insert(person);
	}

	public int remove(int id) {
		return this.waitlistDao.remove(id);
	}

	public int getWaitRank(int id) {
		return this.waitlistDao.getWaitRank(id);
	}

}
