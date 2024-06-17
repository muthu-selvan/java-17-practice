package com.streams;

import java.util.HashMap;
import java.util.Map;
import java.util.function.BiConsumer;
import java.util.function.Supplier;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 18-01-2024, Thursday
 **/
public class ConsumerExample {

    private static final Map<String,String> map = new HashMap<>();

    private static final BiConsumer<String,String> putMapCosumer = map::put;


    public static void main(String[] args) {
        putMapCosumer.accept("1","1");
    }
}
