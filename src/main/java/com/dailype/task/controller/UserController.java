package com.dailype.task.controller;

import java.util.List;

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
import com.dailype.task.dtos.UserDto;
import com.dailype.task.services.ManagerService;
import com.dailype.task.services.UserService;

@RestController
@RequestMapping("/users")
public class UserController {
	
	  @Autowired
	    private UserService userService;
	  
	    //post mapping 
	    @PostMapping
		 public ResponseEntity<UserDto> createUser( @RequestBody UserDto userDto) {
		        UserDto createdUser = userService.createUser(userDto);
		        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		   }

	    //create user with manager 
	    @PostMapping("/{managerId}")
	    public ResponseEntity<UserDto> createUserWithManager(
	            @PathVariable("managerId") String managerId,
	            @RequestBody UserDto userDto
	    ) {
	        UserDto productWithCategory = userService.createWithManager(userDto, managerId);
	        return new ResponseEntity<>(productWithCategory, HttpStatus.CREATED);
	    }
	    
	    
	    //get mapping 
	    
	    // get all users 
	    @GetMapping
	   public ResponseEntity<List<UserDto>> getAllUsers(){
		   List<UserDto> allDtos = userService.getAllUsers();
		 return  new ResponseEntity<>(allDtos, HttpStatus.OK);
		   
	   }
	   
	   //get all by manager id 
	   
	    @GetMapping("/ofManager/{managerId}")
	    public ResponseEntity<List<UserDto>> getAllUsersOfManager(
	            @PathVariable("managerId") String managerId      
	    ) {
	        List<UserDto> users = userService.getAllUserOfManager(managerId);
	        return new ResponseEntity<>(users, HttpStatus.OK);
	    }
	    
	    //get User  by user id 
	    
	    @GetMapping("/userId/{userId}")
	    public ResponseEntity<UserDto> getUserById(
	            @PathVariable("userId") String userId      
	    ) {
	        UserDto user = userService.getUserById(userId);
	        return  new ResponseEntity<>(user, HttpStatus.OK);
	    }
	   
	   //get user by mobile number
	    
	    @GetMapping("/userMobNum/{mobNum}")
	    public ResponseEntity<UserDto> getUserByMobNo(
	            @PathVariable("mobNum") String mobNum     
	    ) {
	        UserDto user = userService.getUserByMobNo(mobNum);
	        return  new ResponseEntity<>(user, HttpStatus.OK);
	    }
	    
	    
	    //delete Mapping 
	    @DeleteMapping("/{userId}")
	    public ResponseEntity<ApiResponseMessage> delete(@PathVariable String userId) 
	    {
	        userService.delete(userId);
	        ApiResponseMessage responseMessage = ApiResponseMessage.builder().message("User is deleted successfully !!").status(HttpStatus.OK).success(true).build();
	        return new ResponseEntity<>(responseMessage, HttpStatus.OK);

	    }

	    
}
