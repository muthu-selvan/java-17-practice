package com.localDateTime;

import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 30-03-2024, Saturday
 **/
public class Example {
    public static void main(String[] args) {
        LocalDateTime localDateTime = LocalDateTime.now();
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("dd-MM-yyyy hh:mm:ss");

        String format = localDateTime.format(dateTimeFormatter);
        System.out.println("format = " + format);
        System.out.println(" minus 5:30 hour");

        LocalDateTime localDateTime1 = localDateTime.minusHours(5).minusMinutes(30);
        System.out.println( localDateTime1.format(dateTimeFormatter));
    }
}
