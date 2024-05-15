package com.dailype.task.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailype.task.dtos.ManagerDto;
import com.dailype.task.dtos.UserDto;
import com.dailype.task.services.ManagerService;
import com.dailype.task.services.UserService;

@RestController
@RequestMapping("/user")
public class UserController {
	
	  @Autowired
	    private UserService userService;
	  
	    
	    @PostMapping("/create")
		 public ResponseEntity<UserDto> createUser( @RequestBody UserDto userDto) {
		        UserDto createdUser = userService.createUser(userDto);
		        return new ResponseEntity<>(createdUser, HttpStatus.CREATED);
		   }

	    //create product with category
	    @PostMapping("/create/{managerId}")
	    public ResponseEntity<UserDto> createUserWithManager(
	            @PathVariable("managerId") String managerId,
	            @RequestBody UserDto userDto
	    ) {
	        UserDto productWithCategory = userService.createWithManager(userDto, managerId);
	        return new ResponseEntity<>(productWithCategory, HttpStatus.CREATED);
	    }
}
