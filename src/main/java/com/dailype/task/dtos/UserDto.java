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
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Pattern;
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

       private String userId;

      @NotBlank(message = "Full name must not be empty")
        private String userFullName;

        @NotBlank(message = "Email must not be empty")
       // Add Email validation logic here if needed
         private String userEmail;

       @NotBlank(message = "Mobile number must not be empty")
	    @Pattern(regexp = "^(0|\\+91)?\\d{10}$", message = "Invalid mobile number")
        private String userMobNum;

        @NotBlank(message = "PAN number must not be empty")
        @Pattern(regexp = "^[A-Z]{5}[0-9]{4}[A-Z]$", message = "Invalid PAN number")
        private String userPanNum;

        @NotBlank(message = "Password must not be empty")
        private String userPassword;

        private LocalDateTime createdAt;

        private LocalDateTime updatedAt;

        private boolean isActive;
 
        private Manager manager;
//
//	    // Getters and setters
}
