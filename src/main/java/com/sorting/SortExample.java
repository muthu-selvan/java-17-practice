package com.sorting;

import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 25-12-2023, Monday
 **/
public class SortExample {
    public static void main(String[] args) {
        List<Cat> cats = new java.util.ArrayList<>(List.of(new Cat("Daizy", 8),
                new Cat("Alexa", 12),
                new Cat("Bethany", 1)));

        Comparator<Cat> catComparator = Comparator.comparing(Cat::name)
                .thenComparing(Cat::age);

        cats.sort(catComparator);
        System.out.println("cats = " + cats);

    }
}
