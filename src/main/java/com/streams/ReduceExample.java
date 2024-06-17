package com.streams;

import java.util.stream.IntStream;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 23-12-2023, Saturday
 **/
public class ReduceExample {

    public static void main(String[] args) {
        int reduce = IntStream.rangeClosed(1, 10)
                .reduce(0, Integer::sum);
        System.out.println("reduce = " + reduce);

        double naN = Double.NaN;

        int i = IntStream.rangeClosed(1, 10).min().orElse(Integer.MIN_VALUE);
    }
}
