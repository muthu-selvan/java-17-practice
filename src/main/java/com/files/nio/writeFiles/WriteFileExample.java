package com.files.nio.writeFiles;

import java.io.BufferedWriter;
import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.function.Supplier;
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
public class WriteFileExample {
    private static final Pattern pattern = Pattern.compile("(.{14})(.{3})(.{8})(.{7})(.{2}).*");
    private static final Supplier<Stream<Matcher>> fileStreamSupplier = () -> {
        try  {
            Stream<String> lines = Files.lines(Path.of("SalaryEmployeeDetails.txt"));
            return lines.skip(1)
                    .map(pattern::matcher)
                    .filter(Matcher::matches);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    };
    private static List<String> getFileContent(final int groupNum) {
        return fileStreamSupplier.get()
                .map(matchResult -> matchResult.group(groupNum).trim())
                .distinct()
                .sorted()
                .collect(Collectors.toList());
    }

    private static List<String> getHeaders() {
        try (Stream<String> lines = Files.lines(Path.of("SalaryEmployeeDetails.txt"))) {
            return lines.limit(1)
                    .map(s -> Arrays.asList(s.split("//s+")))
                    .flatMap(Collection::stream)
                    .collect(Collectors.toList());
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }
    public static void main(String[] args) {
        final List<String> headers = getHeaders();
        final List<String> employeeNames = getFileContent(1);
        final List<String> ages = getFileContent(2);

        writeIntoNewFile(headers, employeeNames, ages);
        System.out.printf(" headers : %s, employeeNames: %s, ages : %s" , headers, employeeNames, ages);
    }


    private static void writeIntoNewFile(List<String> headers, List<String> employeeNames, List<String> ages)  {
        Path newFile = Path.of("newFile.txt");

        try (BufferedWriter bufferedWriter = Files.newBufferedWriter(newFile)) {
            bufferedWriter.write(headers.toString());
            bufferedWriter.newLine();

            employeeNames.forEach(eachEmployee -> {
                try {
                    bufferedWriter.write(eachEmployee);
                    bufferedWriter.newLine();
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            });
        } catch (IOException e) {
            throw new RuntimeException(e);
        }


    }
}
