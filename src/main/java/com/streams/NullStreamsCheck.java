package com.streams;

import java.util.List;
import java.util.Map;
import java.util.Objects;
import java.util.Optional;
import java.util.stream.Collectors;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 26-03-2024, Tuesday
 **/
public class NullStreamsCheck {
    public static void main(String[] args) {
        assert getMap() != null;
        List<String> collect = getMap().values().parallelStream()
                .filter(Objects::nonNull)
                .map(String.class::cast)
                .toList();
        System.out.println("collect = " + collect);

    }

    private static Map<Object,Object> getMap() {
        return null;
    }
}
