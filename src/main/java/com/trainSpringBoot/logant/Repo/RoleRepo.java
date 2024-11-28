package com.trainSpringBoot.logant.Repo;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainSpringBoot.logant.RoleMenu.Role;

@Repository
public interface RoleRepo extends JpaRepository<Role, UUID>{

}
