package com.patternMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 10-04-2024, Wednesday
 **/
public class PatternMatchingExample {
    public static void main(String[] args) {
        final Pattern pattern = Pattern.compile(".*\\<[^>]+>.*");
        Matcher matcher = pattern.matcher("memo test [test]");
        boolean matches = matcher.matches();
        System.out.println("matches = " + matches);
    }
}
