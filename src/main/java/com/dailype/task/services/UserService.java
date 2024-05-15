package com.dailype.task.services;

import com.dailype.task.dtos.UserDto;
import com.dailype.task.entities.User;

public interface UserService {
	UserDto createUser(UserDto userDto);
	UserDto createWithManager(UserDto userDto, String managerId);
}
