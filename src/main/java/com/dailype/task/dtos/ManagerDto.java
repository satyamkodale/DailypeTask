package com.dailype.task.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class ManagerDto {
 
	private String managerId;
	
    private String managerName;
    private String managerEmail;
    private String managerPassword;
    private LocalDateTime createdAt;
    private LocalDateTime updatedAt;
    private boolean isActive ;

    
}
