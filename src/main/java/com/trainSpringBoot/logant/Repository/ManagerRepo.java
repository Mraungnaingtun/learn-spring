package com.trainSpringBoot.logant.Repository;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.trainSpringBoot.logant.Entity.Manager;

@Repository
public interface ManagerRepo extends JpaRepository<Manager,Long> {
    
}
