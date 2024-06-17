package com.patternMatching;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 01-05-2024, Wednesday
 **/
public class HtmlPatternMatching {

    public static void main(String[] args) {
        Pattern pattern = Pattern.compile("<[hH]\\d>(.*)</[hH]\\d>");
        final String snippet = """
                <html>
                  <h1>Header 1</h1>
                  <p>This is Paragraph</p>
                  <h2>Sub Header</h2>
                  <p>Sub Paragraph</p>
                </html>
                """;

        final Matcher matcher = pattern.matcher(snippet);

        while (matcher.find()) {
            System.out.println(matcher.group(1));
        }
        matcher.reset();
    }
}
