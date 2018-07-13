package ro.sapientia.kbotond.service;

import ro.sapientia.kbotond.pojo.StudentPojo;

import java.util.List;

public interface StudentService {
	
	public List<StudentPojo> getStudentByName();

	public List<StudentPojo> getAllStudents();

	public StudentPojo createStudent(StudentPojo student);

	public void deleteById(Integer studentId);

	public void updateStudent(Integer studentId, StudentPojo studentDetails);

	public StudentPojo findStudentById(Integer studentId);

	


}
