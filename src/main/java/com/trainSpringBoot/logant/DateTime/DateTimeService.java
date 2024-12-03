package com.trainSpringBoot.logant.DateTime;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.List;

import org.springframework.stereotype.Service;

import lombok.AllArgsConstructor;

@Service
@AllArgsConstructor
public class DateTimeService {

    private final DateTimeRepo dateTimeRepo;

    public List<DateTimeTest> getAllDateTime(LocalDate date) {
        if (date == null) {
            return dateTimeRepo.findAll();
        }
        LocalDateTime fromDateTime = date.atStartOfDay();
        LocalDateTime toDateTime = date.atStartOfDay().plusDays(1);
        
        return dateTimeRepo.findByDateBetween(fromDateTime, toDateTime);
    }
}
