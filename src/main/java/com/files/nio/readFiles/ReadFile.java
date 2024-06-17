package com.files.nio.readFiles;

import java.io.IOException;
import java.nio.charset.Charset;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Set;
import java.util.TreeSet;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 25-05-2024, Saturday
 **/
public class ReadFile {
    public static void main(String[] args) {
        Path path = Path.of("SalaryEmployeeDetails.txt");
        Pattern pattern = Pattern.compile("(.{14})(.{3})(.{8})(.{7})(.{2}).*");

        try (Stream<String> lines = Files.lines(path)) {
            Set<String> collect = lines.skip(1)
                    .map(pattern::matcher)
                    .filter(Matcher::matches)
                    .map(matcher -> matcher.group(4).trim())
                    .collect(Collectors.toCollection(TreeSet::new));
            System.out.println("collect = " + collect);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
}
