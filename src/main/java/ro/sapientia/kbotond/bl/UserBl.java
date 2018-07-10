package ro.sapientia.kbotond.bl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.sapientia.kbotond.pojo.UserPojo;
import ro.sapientia.kbotond.service.UserService;

@Service
public class UserBl {
	
	@Autowired
	public UserService userService;
	
	public List<UserPojo> findAll() {
		return userService.findAll();
	}

	public UserPojo createUser(UserPojo user) throws Exception {
		if (user == null) throw new Exception("Empty user found!");
		if(user.getUsername() == null || user.getPassword() == null) throw new Exception("Empty user found!");
		return userService.creatUser(user);
		
	}

	public UserPojo findUserById(Integer userId) {
		return userService.findUserById(userId);
	}

	public void updateUser(Integer userId,UserPojo userDetails) throws Exception {
		if (userService.findUserById(userId)==null) throw new Exception("No student with this id!");
		if (userDetails == null) throw new Exception("Empty student found!");	
		if(userDetails.getUsername() == null || userDetails.getPassword() == null) throw new Exception("Empty user found!");
		userService.updateUser(userId,userDetails);
		
	}

	public void deleteById(Integer userId) throws Exception {
		if (userService.findUserById(userId)==null) throw new Exception("No student with this id!");
		userService.deleteById(userId);
		
	}
}
