package com.streams;

import java.util.Map;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 23-12-2023, Saturday
 **/
public class TerminalExample {
    public static void main(String[] args) {
        Map<Integer, String> collect = Stream.of("cake", "biscuits", "tart")
                .collect(Collectors.toMap(String::length,
                        s -> s,
                        (s1, s2) -> s1 + "," + s2));
        System.out.println("collect = " + collect);
    }
}
