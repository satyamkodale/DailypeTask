package com.dailype.task.services;

import java.util.List;

import com.dailype.task.dtos.UpdateUserData;
import com.dailype.task.dtos.UserDto;
import com.dailype.task.entities.User;

public interface UserService {
	UserDto createUser(UserDto userDto);
	UserDto createWithManager(UserDto userDto, String managerId);
	List<UserDto> getAllUsers();
	 UserDto getUserByMobNo(String userMobNum);
	UserDto getUserById(String userId);
	 List<UserDto> getAllUserOfManager(String managerId);
	  //delete
	  void delete(String userId);
	  String updateUsers(UpdateUserData userData);
}
