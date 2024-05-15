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
	    @GeneratedValue(strategy = GenerationType.AUTO)
	    private UUID userId;
	    
	    @Column(nullable = false)
	    private String fullName;
	    
	    @Column(nullable = false, unique = true)
	    private String mobNum;
	    
	    @Column(nullable = false, unique = true)
	    private String panNum;
	    
	    @Column( length = 500)
	    private String password;
	    
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
