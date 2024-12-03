package com.trainSpringBoot.logant.Utils;

import java.time.LocalDateTime;
import java.util.Random;

public class General {

    static String chars = "abcdefghijklmnopqrstuvwxyzABCDEFGHIJKLMNOPQRSTUVWXYZ";
    
     public static String generateRandomUsername(int length) {
        Random random = new Random();
        StringBuilder username = new StringBuilder();

        for (int i = 0; i < length; i++) {
            int index = random.nextInt(chars.length());
            username.append(chars.charAt(index));
        }

        return username.toString();
    }


     public static LocalDateTime generateRandomDateTime() {
        Random random = new Random();

        // Generate random year within a reasonable range (e.g., last 30 years)
        int year = LocalDateTime.now().getYear() - random.nextInt(30);
        // Generate random month, day, hour, minute, and second
        int month = random.nextInt(12) + 1;
        int day = random.nextInt(month == 2 ? 28 : 31) + 1; // Handle basic month lengths
        int hour = random.nextInt(24);
        int minute = random.nextInt(60);
        int second = random.nextInt(60);

        // Build and return the random LocalDateTime
        return LocalDateTime.of(year, month, Math.min(day, LocalDateTime.now().withMonth(month).toLocalDate().lengthOfMonth()), hour, minute, second);
    }


}
