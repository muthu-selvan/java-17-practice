package com.optional;

import java.util.List;
import java.util.Optional;
import java.util.OptionalDouble;
import java.util.stream.Stream;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 02-03-2024, Saturday
 **/
public class IntStream {
    void test() {


    }
    public static void main(String[] args) {
        var stream = Stream.of("muthu","selvan");
        Optional<String> min = stream.min((s1, s2) -> Integer.compare(s1.length(), s2.length()));
        System.out.println("min = " + min.orElse("test"));
    }
}
