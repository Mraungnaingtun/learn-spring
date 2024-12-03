package com.trainSpringBoot.logant.DateTime;

import java.time.LocalDateTime;
import java.util.List;
import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DateTimeRepo  extends JpaRepository<DateTimeTest,UUID>{
    List<DateTimeTest> findByDateBetween(LocalDateTime from,LocalDateTime to);
}
