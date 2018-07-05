package ro.sapientia.kbotond.controller;


import java.sql.Timestamp;
import java.util.Date;
import java.util.List;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import ro.sapientia.kbotond.dao.UserDao;
import ro.sapientia.kbotond.pojo.StudentPojo;
import ro.sapientia.kbotond.pojo.UserPojo;

@RestController
@RequestMapping("/api")
public class UserController {

	@Autowired
	UserDao userDao;
	
	@GetMapping("/user")
	public List<UserPojo> getAllUsers(){
		return userDao.findAll();
	}
	
	// Create a new User
	@PostMapping("/user")
	public UserPojo createUser(@Valid @RequestBody UserPojo user) {
	    return userDao.save(user);
	}
	
	// Get a Single User
	@GetMapping("/user/{id}")
	public UserPojo getUserById(@PathVariable(value = "id") Integer userId) {
		System.out.println(" ------------------"+userId);
		return userDao.findById(userId)
		    .orElseThrow(() -> new ResourceNotFoundException("User"));
	}
	
	// Update a User
	@PutMapping("/user/{id}")
	public UserPojo updateUsert(@PathVariable(value = "id") Integer userId,
	                                        @Valid @RequestBody UserPojo userDetails) {

		UserPojo user = userDao.findById(userId)
	    		.orElseThrow(() -> new ResourceNotFoundException("User"));

		user.setId(userDetails.getId());
	    

		UserPojo updatedUser = userDao.save(user);
	    return updatedUser;
	}
	
	@DeleteMapping("/user/{id}")
	public ResponseEntity<?> deleteUsert(@PathVariable(value = "id") Integer userId) {
		UserPojo user = userDao.findById(userId)
				.orElseThrow(() -> new ResourceNotFoundException("User"));

		userDao.delete(user);

	    return ResponseEntity.ok().build();
	}
	
}
