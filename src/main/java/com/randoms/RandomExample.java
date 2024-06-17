package com.randoms;

import java.util.Random;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 24-04-2024, Wednesday
 **/
public class RandomExample {
    public static void main(String[] args) {
        Random random = new Random();
        int i = random.nextInt(-10, 10);
        System.out.println("Random Values i = " + i);
        System.out.println("-------------------------------------");

        random.ints()
                .limit(10)
                .forEach(System.out::println);
    }
}
