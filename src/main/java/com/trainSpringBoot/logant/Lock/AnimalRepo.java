package com.trainSpringBoot.logant.Lock;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Lock;
import org.springframework.stereotype.Repository;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import jakarta.persistence.LockModeType;
import lombok.Data;

@Entity
@Data
class Animal {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY) 
    private Long id;
    private String name;
    private String type;
}

@Repository
public interface AnimalRepo extends JpaRepository<Animal, Long> {

    @Lock(LockModeType.READ)
    List<Animal> findByType(String type);

    /*
     * PESSIMISTIC_READ 
     * prevents other transactions from writing
     * 
     * 
     * PESSIMISTIC_WRITE
     * prevents other transactions from reading or writing
     */
}

