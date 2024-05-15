package com.dailype.task.services.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.List;
import java.util.UUID;
import java.util.stream.Collectors;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import com.dailype.task.dtos.UserDto;
import com.dailype.task.entities.Manager;
import com.dailype.task.entities.User;
import com.dailype.task.exceptions.ResourceNotFoundException;
import com.dailype.task.repositories.ManagerRepository;
import com.dailype.task.repositories.UserRepository;
import com.dailype.task.services.UserService;



@Service
public class UserServiceImpl implements UserService {
	
	@Autowired
	public ModelMapper modelMapper;
//	@Autowired
//    private PasswordEncoder passwordEncoder;
	@Autowired
    private UserRepository userRepository;
	 @Autowired
	 private ManagerRepository managerRepository;
	
	
	    
	
	
	public UserDto createUser(UserDto userDto) 
	{	
	     //generate unique id in string format
		  User user = modelMapper.map(userDto, User.class);
          String userId = UUID.randomUUID().toString();
          user.setUserId(userId);		     
          user.setCreatedAt(LocalDateTime.now());
          user.setUpdatedAt(LocalDateTime.now());
          user.setActive(true);
          User savedUser = userRepository.save(user);
          return modelMapper.map(savedUser, UserDto.class);
          
	}
	
	
	
	  
	    public UserDto createWithManager(UserDto userDto, String managerId) {
	        //fetch the Manager from db:
//  	     Manager manager = managerRepository.findById(managerId).orElseThrow("Manager with Id  not found !!"));       
	        Manager manager  = managerRepository.findByManagerIdAndIsActiveTrue(managerId).orElseThrow(() -> new ResourceNotFoundException("Manager with ID " + managerId + " not found or inactive"));
	          User user = modelMapper.map(userDto, User.class);
	          String userId = UUID.randomUUID().toString();
	          user.setUserId(userId);		     
	          user.setCreatedAt(LocalDateTime.now());
	          user.setUpdatedAt(LocalDateTime.now());
	          user.setActive(true);
	          user.setManager(manager);
	          User savedUser = userRepository.save(user);	      
	          return modelMapper.map(savedUser, UserDto.class);

	    }
	    
	    
	    //get all users 
		public List<UserDto> getAllUsers()
		{
			List<User> users=userRepository.findAll();
			List<UserDto> userDtos=users.stream()
            .map(user -> modelMapper.map(user, UserDto.class))
            .collect(Collectors.toList());
			return userDtos;
			
		}
		
		//get user by mobile number 
	    public UserDto getUserByMobNo(String userMobNum) {
	        User user = userRepository.findByUserMobNum(userMobNum)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found with mobile number: " + userMobNum));
	        return modelMapper.map(user, UserDto.class);
	    }
	    
	    
		//get by user id 
	    public UserDto getUserById(String userId) {
	        User user = userRepository.findById(userId)
	            .orElseThrow(() -> new ResourceNotFoundException("User not found with mobile number: " + userId));
	        return modelMapper.map(user, UserDto.class);
	    }
	    
	    
		//get user based on manager id 
		
		public List<UserDto> getAllUserOfManager(String managerId) {
	        Manager manager = managerRepository.findById(managerId).orElseThrow(() -> new ResourceNotFoundException("Manager of given id not found !!"));
	        
	        List<User> users = userRepository.findByManager(manager);
	        
	        return users.stream()
	                .map(user -> modelMapper.map(user, UserDto.class))
	                .collect(Collectors.toList());

	    }
		
		
		//delete Mapping 
		public void delete(String userId) 
		{
			 User user = userRepository.findById(userId).orElseThrow(() -> new ResourceNotFoundException("User not found of given Id !!"));
			 userRepository.delete(user);
			    
		}


}
