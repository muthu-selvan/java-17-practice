package com.localDate;


import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.Month;
import java.time.Period;
import java.time.temporal.ChronoUnit;
import java.time.temporal.TemporalUnit;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 11-03-2024, Monday
 **/
public class Main {
    public static void main(String[] args) {

        LocalDate localDate = LocalDate.of(1994, Month.SEPTEMBER, 29);
//        LocalDateTime localDateTime = localDate.atTime(1, 100);
//        System.out.println("localDateTime = " + localDateTime);

        localDate = localDate.plus(6, ChronoUnit.YEARS);
        localDate = localDate.plus(5, ChronoUnit.MONTHS);
        localDate = localDate.plus(12, ChronoUnit.DAYS);

        localDate = localDate.plus(19, ChronoUnit.YEARS);

        localDate = localDate.plus(2, ChronoUnit.YEARS);
        localDate = localDate.plus(4, ChronoUnit.MONTHS);
        localDate = localDate.plus(27, ChronoUnit.DAYS);

        localDate = localDate.plus(11, ChronoUnit.MONTHS);
        localDate = localDate.plus(27, ChronoUnit.DAYS);

        System.out.println(localDate.getYear() +" "+localDate.getMonth()+" "+localDate.getDayOfMonth());

    }
}
