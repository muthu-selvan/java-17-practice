package com.annotations;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 04-01-2024, Thursday
 **/

public class WorkdayExample {
    public static void main(String[] args) {

        @Workday(shift = Shift.NIGHT_SHIFT)
        Shift shift;

//        System.out.println("shift = " + shift.);
    }
}
