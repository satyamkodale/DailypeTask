package com.dailype.task.services.impl;

import java.util.UUID;

import org.springframework.stereotype.Service;

import com.dailype.task.dtos.UserDto;
import com.dailype.task.entities.User;
import com.dailype.task.services.UserService;

@Service
public class UserServiceImpl implements UserService {
	
	public UserDto createUser(UserDto userDto) 
	{
		
	
		
		
//		//generate unique id in string format
//        String userId = UUID.randomUUID().toString();
//        userDto.setUserId(userId);
//      //encoding password
//        userDto.setPassword(passwordEncoder.encode(userDto.getPassword()));
//        // dto->entity
//        User user = dtoToEntity(userDto);
//      //fetch role of normal and set it to user
//        Role role = roleRepository.findById(normalRoleId).get();
//        user.getRoles().add(role);
//        User savedUser = userRepository.save(user);
//        //entity -> dto
//        UserDto newDto = entityToDto(savedUser);
//       return newDto;
		return null;
	}

}
