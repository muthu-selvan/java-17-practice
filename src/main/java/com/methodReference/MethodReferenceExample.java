package com.methodReference;

import java.util.function.Function;
import java.util.function.Predicate;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 19-01-2024, Friday
 **/
public class MethodReferenceExample {

    public static void main(String[] args) {
        String name = "Muthu Selvan";

        Predicate<String> predicate = name::startsWith;
    }
}
