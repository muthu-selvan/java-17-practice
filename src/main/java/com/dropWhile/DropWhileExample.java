package com.dropWhile;


import java.util.List;
import java.util.stream.Stream;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 09-04-2024, Tuesday
 **/
public class DropWhileExample {
    public static void main(String[] args) {
        List<Integer> list = Stream.of(1,2, 4,6,8,10,11).dropWhile(i -> i%2 == 0)
                .toList();
        System.out.println("dropWhile list = " + list);

        list = Stream.of(1,2, 4,6,8,10,11).takeWhile(i -> i%2 == 0)
                .toList();
        System.out.println("takeWhile list = " + list);
    }
}
