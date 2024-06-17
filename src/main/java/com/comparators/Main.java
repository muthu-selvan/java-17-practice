package com.comparators;

import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 04-02-2024, Sunday
 **/
public class Main {
    public static void main(String[] args) {
        List<Person> personList = new ArrayList<>(List.of(
                new Person("Muthu Selvan", 29, 100000.00, "M"),
                new Person("Muthu Raj", 27, 10000.00, "M"),
                new Person("Arul Lingam", 26, 1000.00, "M"),
                new Person("Skitty", 16, 0.00, "M")
        ));

        Comparator<Person> sortBySalary = Comparator.comparing(Person::getSalary);
        personList.sort(sortBySalary);

        personList.forEach(System.out::println);
    }
}
