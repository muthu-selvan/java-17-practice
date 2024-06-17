package com.files.nio;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.StandardOpenOption;
import java.util.Iterator;
import java.util.Map;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 20-05-2024, Monday
 **/
public class Main {
    public static void main(String[] args) {
        processFile("C:\\Muthu\\Backend\\java17Practice\\src\\main\\java\\com\\files\\nio\\streams\\test.txt");
        printFileHierarchy("C:\\Muthu\\Backend\\java17Practice\\src\\main\\java\\com\\files\\nio\\streams\\test.txt");
        readAttributes("C:\\Muthu\\Backend\\java17Practice\\src\\main\\java\\com\\files\\nio\\streams\\test.txt");
    }

    private static void readAttributes(String s) {
        try {
            Map<String, Object> stringObjectMap = Files.readAttributes(Path.of(s), "*");
            stringObjectMap.entrySet().forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static void printFileHierarchy(String filePath) {
        Path path = Path.of(filePath);

        var iterator = path.toAbsolutePath().iterator();
        int i=0;

        while(iterator.hasNext()) {
            System.out.println(".".repeat(i++)+iterator.next());
        }

    }

    private static void processFile(String name) {
        Path path = Path.of(name);
        System.out.println(path.toAbsolutePath());
        boolean exists = Files.exists(path);

        System.out.printf("File '%s' %s%n",name, exists ? "exists." : "doesn't exist.");

        if (exists) {
            System.out.println("Deleting fileName : "+name);
            try {
                exists = !Files.deleteIfExists(path);
            } catch (IOException e) {
                throw new RuntimeException(e);
            }
        }

        if(!exists) {
            try {
                Files.createFile(path);
                exists = true;
            } catch (IOException e) {
                e.printStackTrace();
            }

            if (Files.isWritable(path)) {
                System.out.println("File is writable");

                try {
                    Files.writeString(path, """
                            abc
                            abccdfddsds
                            ieernfhswjfj!
                            """, StandardOpenOption.CREATE,
                            StandardOpenOption.APPEND);
                } catch (IOException e) {
                    throw new RuntimeException(e);
                }
            }
        }


    }
}
