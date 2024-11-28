package com.trainSpringBoot.logant.Transactional;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.lang.NonNull;
import org.springframework.transaction.annotation.Transactional;

public interface AppUserRepo extends JpaRepository<AppUser, Long> {

    @Override
    @NonNull
    @Transactional(timeout = 10)
    public List<AppUser> findAll();
    
}
