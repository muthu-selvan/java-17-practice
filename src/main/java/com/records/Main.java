package com.records;

import java.util.List;
import java.util.stream.Collectors;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 02-03-2024, Saturday
 **/
public class Main {
    public static void main(String[] args) {
        List<Employee> employees = List.of(
                new Employee("Muthu","Selvan",100000.00),
                new Employee("Muthu","Raj",90000.00),
                new Employee("Arul","Lingam",80000.00),
                new Employee("Muthu","Prabu",70000.00)
        );

        List<Employee> collect = employees.stream()
                .filter(eachEmployee -> eachEmployee.salary() > 80000.00)
                .toList();
        System.out.println("collect = " + collect);
    }
}
