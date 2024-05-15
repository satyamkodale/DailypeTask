package com.dailype.task.dtos;

import java.time.LocalDateTime;
import java.util.UUID;

import com.dailype.task.entities.Manager;

import jakarta.persistence.Column;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
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
public class UserDto {
	 
	    private String fullName;
	    private String mobNum;
	    private String panNum;
	    private String password;
	    private Manager manager;
	   
}
