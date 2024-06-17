package com.urlfilter;

import java.nio.file.Files;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Stream;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 18-02-2024, Sunday
 **/
public class Test {
    public static void main(String[] args) {
        double ceilValue = 234.46;
        System.out.println();
    }

    private static int methodWithTryCatch() {
        try {
            Optional<String> any = Files.readAllLines(Path.of("")).stream().findAny();

            any.ifPresent(x -> {
                System.out.println("x = " + x);
            });

            return 10;
        } catch (Exception e) {
            return 9;
        }

    }
}
