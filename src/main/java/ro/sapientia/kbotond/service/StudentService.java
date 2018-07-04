package ro.sapientia.kbotond.service;

import ro.sapientia.kbotond.pojo.StudentPojo;

import java.util.List;

public interface StudentService {
	
	public List<StudentPojo> getStudentByName();

	public static List<StudentPojo> findByName() {
		// TODO Auto-generated method stub
		return null;
	}
}
