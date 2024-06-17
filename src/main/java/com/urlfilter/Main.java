package com.urlfilter;

import java.util.*;
import java.util.function.BiPredicate;
import java.util.stream.Collectors;
import java.util.stream.Stream;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 16-02-2024, Friday
 **/
abstract interface X { }
public class Main {

    private static BiPredicate<String, List<String>> byPassUrlPredicate = (url, bypassUrlList) -> {
        return bypassUrlList.stream()
                .anyMatch(url::endsWith);
    };

    public static void main(String[] args) {
        int y = 4;
        var x = switch (y % 3) {
                 case 0 -> 6;
                 case 1 -> {yield 7;}
                 case 2 -> 8;
                 default -> 9;
             };

        final String byPassUrlString = "/dwr/call/plaincall/ETBBean.saveOrUpdateCustomMnemonicsAndLog.dwr,/dwr/call/plaincall/ETBBean.testFormula.dwr,/dwr/call/plaincall/ETBBean.saveFormulaInstance.dwr";
//        final String byPassUrlString = null;
        final List<String> securityByPassUrls = Arrays.stream(Optional.of(byPassUrlString).orElse("").split(","))
                        .map(String::trim)
                        .collect(Collectors.toList());

        List<String> inputs = List.of("/dwr/call/plaincall/ETBBean.saveOrUpdateCustomMnemonicsAndLog.dwr",
                "/dwr/call/plaincall/ETBBean.testFormula.dwr",
                "/dwr/call/plaincall/ETBBean.saveFormulaInstance.dwr",
                "http://bhgizjjsm3aiyhd.ent.bhicorp.com:8080/rtoportal/dwr/call/plaincall/ETBBean.saveFormulaInstance.dwr",
                "http://bhgizjjsm3aiyhd.ent.bhicorp.com:8080/rtoportal/dwr/call/plaincall/ETBBean.getCustomMnemonicsMap.dwr");

        inputs.forEach(eachInput ->
                System.out.println("eachInput = " + eachInput+" result : "+byPassUrlPredicate.test(eachInput,securityByPassUrls)));

    }
}
