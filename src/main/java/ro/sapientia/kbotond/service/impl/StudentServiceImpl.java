package ro.sapientia.kbotond.service.impl;

import java.sql.Timestamp;
import java.util.Date;
import java.util.List;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.rest.webmvc.ResourceNotFoundException;
import org.springframework.stereotype.Service;

import ro.sapientia.kbotond.pojo.StudentPojo;
import ro.sapientia.kbotond.service.StudentService;
import ro.sapientia.kbotond.dao.StudentDao;

@Service("StudentService")
public class StudentServiceImpl implements StudentService{
	
	@Autowired
	private StudentDao studentsDao;

	@Override
	public List<StudentPojo> getStudentByName() {
		return null;
	}

	@Override
	public List<StudentPojo> getAllStudents() {
		return studentsDao.findAll();
	}

	@Override
	public StudentPojo createStudent(StudentPojo student) {
		return studentsDao.save(student);
	}


//	@Override
//	public StudentPojo updateStudent(Integer studentId, StudentPojo studentDetails) {
//		// TODO Auto-generated method stub
//		return studentsDao.save(studentDetails);
//	}

	@Override
	public void deleteById(Integer studentId) {
		studentsDao.deleteById(studentId);
		
	}

	@Override
	public void updateStudent(Integer studentId,StudentPojo studentDetails) {
		StudentPojo student = studentsDao.findById(studentId)
	    		.orElseThrow(() -> new ResourceNotFoundException("Student"));
		
		student.setId(studentId);
	    student.setLastName(studentDetails.getLastName());
	    student.setFirstName(studentDetails.getFirstName());
	    student.setDepartment(studentDetails.getDepartment());
	    student.setYear(studentDetails.getYear());
	    
	    Timestamp stamp = new Timestamp(System.currentTimeMillis());
	    Date date = new Date(stamp.getTime());
	    student.setUpdated(date);
		
		studentsDao.save(student);
	}


	@Override
	public StudentPojo findStudentById(Integer studentId) {
		// TODO Auto-generated method stub
		return studentsDao.findById(studentId)
				.orElseThrow(() -> new ResourceNotFoundException("Student"));
	}



//	@Override
//	public StudentPojo updateStudent(Integer studentId, @Valid StudentPojo studentDetails) {
//		return studentsDao.
//	}

	
	
	
}
