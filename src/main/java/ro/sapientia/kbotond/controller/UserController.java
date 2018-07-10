package ro.sapientia.kbotond.controller;


import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.sapientia.kbotond.bl.UserBl;
import ro.sapientia.kbotond.pojo.UserPojo;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserBl userBl;
	
	@GetMapping("/user")
	public List<UserPojo> getAllUsers(){
		return userBl.findAll();
	}
	
	// Create a new Student
		@PostMapping("/user")
		public UserPojo createUser(@RequestBody UserPojo user) {
			try {
				return userBl.createUser(user);
			} catch (Exception e) {
				e.printStackTrace();
				return null;
			}
		}
	
	@GetMapping("/user/{id}")
	public UserPojo getUserById(@PathVariable(value = "id") Integer userId) {
			return userBl.findUserById(userId);

	}
	
	@PutMapping("/user/{id}")
	public UserPojo updateUser(@PathVariable(value = "id") Integer userId,
            @Valid @RequestBody UserPojo usertDetails) {
		try {
			userBl.updateUser(userId,usertDetails);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;
	}
	
	@DeleteMapping("/user/{id}")
	public UserPojo deleteStudentById(@PathVariable(value = "id") Integer userId) {
		try {
			userBl.deleteById(userId);
		} catch (Exception e) {
			e.printStackTrace();
			return null;
		}
		return null;

		
	}
}
