package ro.sapientia.kbotond.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.sapientia.kbotond.pojo.StudentPojo;

@Repository
public interface StudentDao extends JpaRepository<StudentPojo, Integer> {
		
	
}
