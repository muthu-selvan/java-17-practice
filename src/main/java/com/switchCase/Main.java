package com.switchCase;

import java.util.Vector;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 12-03-2024, Tuesday
 **/
interface Test {
    public default String test() {
        return "Helk";
    }
}
public class Main {

    @Override
    public int hashCode() {
        return super.hashCode();
    }

    private static void test(Object o) {


    }

    public static void main(String[] args) {
        var v = new Vector();
//        int i=5;
//        float f = 5.5f;
//        double d = 3.8;
//        char c = 'a';
//
//        if(i==f) c++;
//
//        if(((int) (f+d)) == ((int) f + (int) d)) c +=2;
//
//        System.out.println(c);
        test(new Object());
    }
}
