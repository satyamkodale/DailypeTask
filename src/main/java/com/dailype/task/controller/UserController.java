package com.dailype.task.controller;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailype.task.dtos.ApiResponseMessage;
import com.dailype.task.dtos.ManagerDto;
import com.dailype.task.dtos.UpdateUserData;
import com.dailype.task.dtos.UserDto;
import com.dailype.task.exceptions.GlobalExceptionHandler;
import com.dailype.task.services.ManagerService;
import com.dailype.task.services.UserService;

import jakarta.validation.Valid;

@RestController
@RequestMapping("/users")
public class UserController {
	
    private Logger logger = LoggerFactory.getLogger(UserController.class);
   

	
	  @Autowired
	    private UserService userService;
	  
	    //post mapping create user without manager id 
	    @PostMapping("/create_user")
		 public ResponseEntity<UserDto> createUser(@Valid @RequestBody UserDto userDto) {
	    	
		        UserDto createdUser = userService.createUser(userDto);
		        logger.info("User Created  !!");
		        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		        
		   }

	    //create user with manager id 
	    @PostMapping("/create_user/{managerId}")
	    public ResponseEntity<UserDto> createUserWithManager(
	            @PathVariable("managerId") String managerId,
	            @RequestBody UserDto userDto
	    ) {
	        UserDto productWithCategory = userService.createWithManager(userDto, managerId);
	        logger.info("User Created with manager Id  !!");
	        return new ResponseEntity<>(productWithCategory, HttpStatus.CREATED);
	    }
	    
	    
	    //get mapping 
	    
	    // get all users 
	    @GetMapping("/get_users")
	   public ResponseEntity<List<UserDto>> getAllUsers(){
		   List<UserDto> allDtos = userService.getAllUsers();
		   logger.info("Got all Users   !!");
		 return  new ResponseEntity<>(allDtos, HttpStatus.OK);
		   
	   }
	   
	   //get all by manager id 
	   
	    @GetMapping("get_users/ofManager/{managerId}")
	    public ResponseEntity<List<UserDto>> getAllUsersOfManager(
	            @PathVariable("managerId") String managerId      
	    ) {
	        List<UserDto> users = userService.getAllUserOfManager(managerId);
	     
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }
	    
	    //get User  by user id 
	    
	    @GetMapping("get_users/userId/{userId}")
	    public ResponseEntity<UserDto> getUserById(
	            @PathVariable("userId") String userId      
	    ) {
	        UserDto user = userService.getUserById(userId);
	        return  new ResponseEntity<>(user, HttpStatus.OK);
	    }
	   
	   //get user by mobile number
	    
	    @GetMapping("get_users/userMobNum/{mobNum}")
	    public ResponseEntity<UserDto> getUserByMobNo(
	            @PathVariable("mobNum") String mobNum     
	    ) {
	        UserDto user = userService.getUserByMobNo(mobNum);
	        return  new ResponseEntity<>(user, HttpStatus.OK);
	    }
	    
	    
	    //delete Mapping user based on userId 
	    @DeleteMapping("delete_user/{userId}")
	    public ResponseEntity<ApiResponseMessage> delete(@PathVariable String userId) 
	    {
	        userService.delete(userId);
	        ApiResponseMessage responseMessage = ApiResponseMessage.builder().message("User is deleted successfully !!").status(HttpStatus.OK).success(true).build();
	        return new ResponseEntity<>(responseMessage, HttpStatus.OK);

	    }
	    
	    //bulk update user 
	    @PostMapping("/update_user")
	    public ResponseEntity<ApiResponseMessage> updateUser(@RequestBody UpdateUserData userData) {
	        String message = userService.updateUsers(userData);
	        ApiResponseMessage responseMessage = ApiResponseMessage.builder().message(message).status(HttpStatus.OK).success(true).build();
	        return new ResponseEntity<>(responseMessage, HttpStatus.OK);
	        
	    }
	    
	    

	    
}
