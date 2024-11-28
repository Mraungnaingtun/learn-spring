package com.trainSpringBoot.logant.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;

import com.trainSpringBoot.logant.RoleMenu.User;

public interface UserRepo extends JpaRepository<User,UUID>{

}
