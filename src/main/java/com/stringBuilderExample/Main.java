package com.stringBuilderExample;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 26-02-2024, Monday
 **/
public class Main {
int y;
    public Main(int y) {
        this.y = this.y;
    }
    public static void main(String[] args) {
        StringBuilder stringBuilder = new StringBuilder("ab");
        stringBuilder.append("c").append("d").append("e");

        stringBuilder = stringBuilder.append("f");
        System.out.println(stringBuilder.substring(1));
    }
}
