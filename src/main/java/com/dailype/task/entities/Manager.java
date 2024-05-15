package com.dailype.task.entities;

import java.time.LocalDateTime;
import java.util.List;
import java.util.Set;
import java.util.UUID;



import jakarta.persistence.Column;
import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "managers")
@Getter
@NoArgsConstructor
@Setter
@AllArgsConstructor 
@Builder
public class Manager {

	@Id
//    @GeneratedValue(strategy = GenerationType.AUTO)
    private String managerId;
    
    @Column
    private String managerName;
    @Column( unique = true)
    private String managerEmail;
    
    
    @Column
    private LocalDateTime createdAt;
    

    @Column( length = 500)
    private String managerPassword;

    @Column
    private LocalDateTime updatedAt;
    
    @Column
    private boolean isActive ;
    
}
