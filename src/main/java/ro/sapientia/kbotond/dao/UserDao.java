package ro.sapientia.kbotond.dao;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import ro.sapientia.kbotond.pojo.UserPojo;

@Repository
public interface UserDao extends JpaRepository<UserPojo,Integer>{

}
