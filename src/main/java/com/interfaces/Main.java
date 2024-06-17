package com.interfaces;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 16-03-2024, Saturday
 **/
interface Test {
    static int x = 10;
}
public class Main {
    public static void main(String[] args) {
        System.out.println(Test.x);
    }
}
