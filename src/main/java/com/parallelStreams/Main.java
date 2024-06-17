package com.parallelStreams;

import java.util.Comparator;
import java.util.Random;
import java.util.stream.Stream;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 15-05-2024, Wednesday
 **/
record Person(String firstName, String lastName, int age) {
    private static String[] firstNames = {"Apple","Ball","Cat","Doll","Egg"};
    private static String[] lastNames = {"Nadar","Rai","Thevar","Pallar","Pillai"};

    private static Random random = new Random();

    public Person() {
        this(
                firstNames[random.nextInt(firstNames.length)]  ,
                lastNames[random.nextInt(lastNames.length)],
                random.nextInt(18,100)
        );
    }

    @Override
    public String toString() {
        return "%s, %s (%d)".formatted(firstName,lastName,age);
    }
}
public class Main {
    public static void main(String[] args) {
        Stream.generate(Person::new)
                .limit(100)
                .sorted(Comparator.comparing(Person::lastName))
                .forEach(System.out::println);
    }
}
