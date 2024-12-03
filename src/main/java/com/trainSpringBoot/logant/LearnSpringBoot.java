package com.trainSpringBoot.logant;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication
public class LearnSpringBoot {

	public static void main(String[] args) {
		SpringApplication.run(LearnSpringBoot.class, args);
	}

	// @Bean
	// public CommandLineRunner demo(DateTimeRepo repo) {
	// 	return (args) -> {
	// 		for(int i = 0;i<100;i++){
	// 			DateTimeTest dt = new DateTimeTest();
	// 			dt.setDate(General.generateRandomDateTime());
	// 			dt.setName(General.generateRandomUsername(10));
	// 			repo.save(dt);
	// 		}
	// 	};
	// }
}
