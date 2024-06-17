package com.comparators;

import java.util.stream.Stream;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 05-03-2024, Tuesday
 **/
public class StringCompare {
    public static void main(String[] args) {
        var stream = Stream.of("OCAJP","Java");
        System.out.println(stream.min((s1,s2) -> Integer.compare(s2.length(),s1.length())).orElse("No Min"));
    }
}
