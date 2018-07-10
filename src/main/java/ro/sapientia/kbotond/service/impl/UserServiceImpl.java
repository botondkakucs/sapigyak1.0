package ro.sapientia.kbotond.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import ro.sapientia.kbotond.dao.UserDao;
import ro.sapientia.kbotond.service.UserService;
import ro.sapientia.kbotond.pojo.UserPojo;

@Service("UserService")
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserPojo> getUserByUserame() {
		List<UserPojo> userList = UserService.findByName();
		return userList;
	}

	@Override
	public List<UserPojo> findAll() {
		return userDao.findAll();
	}

	@Override
	public UserPojo creatUser(UserPojo user) {
		return userDao.save(user);
	}

	@Override
	public UserPojo findUserById(Integer userId) {
		return userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("No user with this id"));
	}

	@Override
	public void updateUser(Integer userId,UserPojo userDetails) {
		UserPojo user = userDao.findById(userId)
	    		.orElseThrow(() -> new ResourceNotFoundException("No user with this id"));
		
		user.setUsername(userDetails.getUsername());
		user.setPassword(userDetails.getPassword());
		
	    userDao.save(user);
		
	}

	@Override
	public void deleteById(Integer userId) {
		userDao.deleteById(userId);
		
	}
}
