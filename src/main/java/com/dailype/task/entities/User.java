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
import jakarta.persistence.JoinColumn;
import jakarta.persistence.ManyToOne;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Entity
@Table(name = "users")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class User {

	   @Id
//	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private String userId;
	    
	    @Column
	    private String userFullName;
	    
	    @Column( unique = true)
	    private String userEmail;
	    
	    @Column( unique = true)
	    private String userMobNum;
	    
	    @Column( unique = true)
	    private String userPanNum;
	    
	    
	    @Column( length = 500)
	    private String userPassword;
	    
	    @ManyToOne
	    @JoinColumn(name = "manager_id")
	    private Manager manager;
	    
	    @Column(nullable = false)
	    private LocalDateTime createdAt;
	    
	    @Column(nullable = true)
	    private LocalDateTime updatedAt;
	    
	    @Column(nullable = false)
	    private boolean isActive = true;
	
}
