package ro.sapientia.kbotond.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.sapientia.kbotond.dao.UserDao;
import ro.sapientia.kbotond.service.UserService;
import ro.sapientia.kbotond.pojo.UserPojo;

@Service
public class UserServiceImpl implements UserService{

	@Autowired
	private UserDao userDao;
	
	@Override
	public List<UserPojo> getUserByUserame() {
		List<UserPojo> userList = UserService.findByName();
		return userList;
	}
}
