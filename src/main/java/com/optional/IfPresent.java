package com.optional;

import java.util.Optional;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 24-12-2023, Sunday
 **/
public class IfPresent {

    void IfPresent() {
        System.out.println("tes");
    }
    private static Optional<Double> getOptionalValue() {
        return Optional.of(Math.random());
    }

    public static void main(String[] args) {
        Optional<Double> doubleOptional = getOptionalValue();

        doubleOptional.ifPresent(IfPresent::printValue);
    }

    private static void printValue(Double value) {
        System.out.println("value = " + value);
    }
}
