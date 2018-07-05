package ro.sapientia.kbotond.service;

import java.util.List;

import ro.sapientia.kbotond.pojo.UserPojo;

public interface UserService {

	public List<UserPojo> getUserByUserame();

	public static List<UserPojo> findByName() {
		// TODO Auto-generated method stub
		return null;
	}
}
