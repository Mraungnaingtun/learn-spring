package com.trainSpringBoot.logant.QueryByExample;

import java.time.LocalDateTime;

import org.springframework.data.annotation.LastModifiedDate;

import jakarta.persistence.Entity;
import jakarta.persistence.GeneratedValue;
import jakarta.persistence.GenerationType;
import jakarta.persistence.Id;
import lombok.Data;


@Entity
@Data
public class Note {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String title;
    private String content;
    private LocalDateTime createdAt;
    private String category;

    @LastModifiedDate
    private LocalDateTime updatedAt;
}
