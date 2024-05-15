package com.dailype.task.services;

import java.util.UUID;

import com.dailype.task.dtos.ManagerDto;
import com.dailype.task.entities.Manager;
import com.dailype.task.entities.User;

public interface ManagerService {
	
	ManagerDto createManager(ManagerDto managerDto);
	ManagerDto updateManager(ManagerDto managerDto,String managerId);

	
}
