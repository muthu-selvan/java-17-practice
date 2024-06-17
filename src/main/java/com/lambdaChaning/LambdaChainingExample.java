package com.lambdaChaning;

import java.util.function.Function;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 16-04-2024, Tuesday
 **/
public class LambdaChainingExample {

    private static final Function<String, String> upperFunction = String::toUpperCase;
    private static final Function<String, String> concatFunction = s -> s.concat(" testing");


    public static void main(String[] args) {
        Function<String, String> stringStringFunction = upperFunction.compose(concatFunction);
        System.out.println("Result : "+stringStringFunction.apply("Hello"));
    }
}
