package com.trainSpringBoot.logant.DateTime;

import java.util.List;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import lombok.AllArgsConstructor;

@RestController
@AllArgsConstructor
@RequestMapping("/api/time")
@CrossOrigin(origins = "http://localhost:4200")
public class TimeController {

    private final DateTimeService dateTimeService;

    @PostMapping
    public ResponseEntity<List<DateTimeTest>> getMethodName(@RequestBody DateRequest dateRequest) {
        return ResponseEntity.ok(dateTimeService.getAllDateTime(dateRequest.getDate()));   
    }

}


