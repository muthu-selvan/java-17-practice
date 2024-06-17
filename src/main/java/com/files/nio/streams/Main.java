package com.files.nio.streams;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;
import java.nio.file.attribute.FileTime;
import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.stream.Stream;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 21-05-2024, Tuesday
 **/
public class Main {
    public static void main(String[] args) {
        Path path = Path.of("C:\\Muthu\\Backend\\java17Practice\\src\\main\\java\\com");
        System.out.println("pwd = "+path.toAbsolutePath());

        try (Stream<Path> lines = Files.find(path,Integer.MAX_VALUE,
                (p,attribute) -> attribute.isRegularFile() && attribute.size() > 1000)) {
            lines
                    .map(Main::listDir)
                    .forEach(System.out::println);
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

        System.out.println("======================================================");

        try(var dirs = Files.newDirectoryStream(path, "*.java")) {
            dirs.forEach(d ->
                    System.out.println(Main.listDir(d)));
        } catch (IOException e) {
            throw new RuntimeException(e);
        }
    }

    private static String listDir(Path path) {
        try {
            boolean directory = Files.isDirectory(path);
            FileTime lastModifiedTime = Files.getLastModifiedTime(path);
            LocalDateTime localDateTime = LocalDateTime.ofInstant(lastModifiedTime.toInstant(), ZoneId.systemDefault());

            return "%tD %tT %-5s %12s %s"
                    .formatted(localDateTime, localDateTime, (directory ? "<DIR>" : ""), (directory ? "" : Files.size(path)),path);
        } catch (Exception e) {
            throw new RuntimeException(e);
        }
    }
}
