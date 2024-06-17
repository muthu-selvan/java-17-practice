package com.switchCase;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 29-05-2024, Wednesday
 **/
public class CharacterCase {

    static void testScope(Object o) {
        if ((o instanceof String s) && s.length() > 3) {
            System.out.println(s.toUpperCase());
        } else {
//            s is not visible
        }
    }
//    static void test(Object o) {
//        switch (o) {
//            case Character c ->
//                System.out.println("Character");
//            case String s ->
//                System.out.println("String");
//            case Long l ->
//                System.out.println("Long");
//            default ->
//                System.out.println("Default");
//        }
//    }
//
//    public static void main(String[] args) {
//        test(new String());
//    }
}
