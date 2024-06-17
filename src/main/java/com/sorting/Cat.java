package com.sorting;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 25-12-2023, Monday
 **/
public record Cat(String name, int age) {
    @Override
    public String toString() {
        return "Cat{" +
                "name='" + name + '\'' +
                ", age=" + age +
                '}';
    }
}
