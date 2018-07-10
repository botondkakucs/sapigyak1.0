package ro.sapientia.kbotond.service;

import java.util.List;

import ro.sapientia.kbotond.pojo.UserPojo;

public interface UserService {

	public List<UserPojo> getUserByUserame();

	public static List<UserPojo> findByName() {
		return null;
	}

	public List<UserPojo> findAll();

	public UserPojo creatUser(UserPojo user);

	public UserPojo findUserById(Integer userId);

	public void updateUser(Integer userId, UserPojo userDetails);

	public void deleteById(Integer userId);
}
