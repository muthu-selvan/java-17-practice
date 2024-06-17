package com.interfaces;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 17-12-2023, Sunday
 **/

interface Evaluate<T> {
    boolean isNegative(T t);
}
public class TestPredicate {
    public static void main(String[] args) {
        Evaluate<Integer> lambda = i -> i < 0;
        System.out.println("Evaluate : "+lambda.isNegative(-1));
    }
}
