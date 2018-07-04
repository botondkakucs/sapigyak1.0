package ro.sapientia.kbotond.dao;

import org.springframework.stereotype.Repository;

import ro.sapientia.kbotond.pojo.StudentPojo;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;

@Repository
public interface StudentDao extends JpaRepository<StudentPojo,Integer> {
	
	
}
