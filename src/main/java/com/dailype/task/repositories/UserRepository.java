package com.dailype.task.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.dailype.task.entities.User;

public interface UserRepository extends JpaRepository<User, UUID> {

}
