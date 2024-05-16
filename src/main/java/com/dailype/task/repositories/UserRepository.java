package com.dailype.task.repositories;



import java.util.List;
import java.util.Optional;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailype.task.entities.Manager;
import com.dailype.task.entities.User;

public interface UserRepository extends JpaRepository<User, String> {
	
	 List<User> findByManager(Manager manager);
	 Optional<User> findByUserMobNum(String userMobNum);
	 List<User> findByUserIdIn(List<String> userIds);
}
