package com.dailype.task.controller;

import java.util.UUID;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.dailype.task.dtos.ManagerDto;
import com.dailype.task.services.ManagerService;



@RestController
@RequestMapping("/manager")
public class ManagerController {
	

    @Autowired
    private ManagerService managerService;
    
    @PostMapping("/create")
	 public ResponseEntity<ManagerDto> createUser( @RequestBody ManagerDto mangerDto) {
	        ManagerDto savedManager = managerService.createManager(mangerDto);
	        return new ResponseEntity<>(savedManager, HttpStatus.CREATED);
	    }
    
    //update
    @PutMapping("/update/{managerId}")
    public ResponseEntity<ManagerDto> updateUser(
            @PathVariable("managerId") String managerId,
            @RequestBody ManagerDto managerDto
    ) {
        ManagerDto updatedUserDto = managerService.updateManager(managerDto, managerId);
        return new ResponseEntity<>(updatedUserDto, HttpStatus.OK);
    }

      
}
