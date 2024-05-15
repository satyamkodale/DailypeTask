package com.dailype.task.services.impl;

import java.time.LocalDateTime;
import java.util.Date;
import java.util.UUID;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import com.dailype.task.dtos.ManagerDto;
import com.dailype.task.entities.Manager;
import com.dailype.task.exceptions.ResourceNotFoundException;
import com.dailype.task.repositories.ManagerRepository;
import com.dailype.task.repositories.UserRepository;
import com.dailype.task.services.ManagerService;


import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;

import java.time.LocalDateTime;

@Service
public class ManagerServiceImpl  implements ManagerService{
	@Autowired
	public ModelMapper modelMapper;
//	@Autowired
//    private PasswordEncoder passwordEncoder;
	@Autowired
    private ManagerRepository managerRepository;
	
	public ManagerDto createManager(ManagerDto managerDto) 
	{
		
		Manager manager = modelMapper.map(managerDto, Manager.class);
		 //generate unique id in string format
        String managerId = UUID.randomUUID().toString();
        manager.setManagerId(managerId);
		manager.setCreatedAt(LocalDateTime.now());
		manager.setManagerEmail(managerDto.getManagerEmail());
		manager.setUpdatedAt(LocalDateTime.now());
		manager.setActive(true);
//		manager.setPassword(passwordEncoder.encode(managerDto.getPassword()));
		manager.setManagerPassword(managerDto.getManagerPassword());
		Manager savedManager = managerRepository.save(manager);
		return modelMapper.map(savedManager, ManagerDto.class);
		

	}
	
	public ManagerDto updateManager(ManagerDto managerDto,String managerId) 
	{
		
		 Manager manager = managerRepository.findById(managerId).orElseThrow(() -> new ResourceNotFoundException("Manager not found with given id !!"));
	      manager.setActive(managerDto.isActive());
          manager.setUpdatedAt(LocalDateTime.now());
          Manager savedManager=managerRepository.save(manager);
          return modelMapper.map(savedManager, ManagerDto.class);

	}


}
