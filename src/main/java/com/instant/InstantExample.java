package com.instant;

import java.time.*;
import java.time.format.DateTimeFormatter;
import java.time.format.FormatStyle;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 28-04-2024, Sunday
 **/
public class InstantExample {
    public static void main(String[] args) {
        Instant instant = Instant.now();
        System.out.println("instant = " + instant);

        LocalDateTime localDateTime = LocalDateTime.ofInstant(instant, ZoneId.systemDefault());
        DateTimeFormatter dateTimeFormatter = DateTimeFormatter.ofPattern("yyyy-MM-dd hh:mm:ss");

        System.out.println("Formatted LocalDateTime : "+localDateTime.format(dateTimeFormatter));

        System.out.println("********************************************************************");

        LocalDate localDate = LocalDate.now();
        Period between = Period.between(localDate, localDate.plusDays(10));
        System.out.println("between = " + between.getYears());
    }
}
