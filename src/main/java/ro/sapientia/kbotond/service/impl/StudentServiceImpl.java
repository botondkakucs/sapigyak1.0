package ro.sapientia.kbotond.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import ro.sapientia.kbotond.pojo.StudentPojo;
import ro.sapientia.kbotond.service.StudentService;
import ro.sapientia.kbotond.dao.StudentDao;

@Service
public class StudentServiceImpl implements StudentService{
	@Autowired
	private StudentDao studentsDao;
	
	@Override
	public List<StudentPojo> getStudentByName() {
		List<StudentPojo> studentList = StudentService.findByName();
		return studentList;
	}
}
