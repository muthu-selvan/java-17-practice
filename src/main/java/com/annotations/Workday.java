package com.annotations;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 04-01-2024, Thursday
 **/

enum Shift {
    DAY_SHIFT,
    NIGHT_SHIFT
}
public @interface Workday {
    int workHours() default 9;

    Shift shift() default Shift.DAY_SHIFT;
}
