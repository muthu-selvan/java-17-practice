package com.files.nio;

import java.io.File;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Objects;
import java.util.Optional;
import java.util.Scanner;
import java.util.regex.Pattern;
import java.util.stream.Stream;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 24-05-2024, Friday
 **/
public class ReadLargeFile {
    public static void main(String[] args) {
        try (Stream<String> lines = Files.lines(Path.of("file.txt"))) {
            long count = lines.count();
            System.out.println("count = " + count);
        } catch (IOException e) {
            e.printStackTrace();
        }

        readSalaryDetails();
    }

    private static void readSalaryDetails() {
        final String fileName = "SalaryEmployeeDetails.txt";
        try (final Scanner scanner = new Scanner(new File(fileName))) {
            Pattern pattern = Pattern.compile("(.{14})(.{3})(.{8})(.{7})(.{2}).*");
            String[] array = scanner.findAll(pattern)
                    .skip(1)
                    .map(matchResult -> matchResult.group(5).trim())
                    .distinct()
                    .sorted()
                    .toArray(String[]::new);
            System.out.println("array = " + Arrays.toString(array));
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
