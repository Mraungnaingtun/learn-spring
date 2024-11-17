package com.trainSpringBoot.logant.Base;

import java.util.List;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.NoRepositoryBean;

@NoRepositoryBean
public interface MyBaseRepository<T, ID> extends JpaRepository<T, ID> {
    List<T> findByRecordStatusNot(int recordStatus);
}