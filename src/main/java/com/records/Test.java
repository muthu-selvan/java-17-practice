package com.records;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 02-03-2024, Saturday
 **/
public record Test(String a, String b) {

    public String getvel() {
        return a+"and";
    }
    public void someMethod() {}

    static {
        System.out.println("true = " + true);
    }


    record b() {}
}
