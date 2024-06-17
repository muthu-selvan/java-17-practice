package com.inheritance;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 16-03-2024, Saturday
 **/
class Person {
    public void visit() {
        System.out.println("Person visits");
    }
}

class Employer extends Person {
    public void visit() {
        super.visit();
    }
}
public class MyExamCloud {
    static int y = 15;
    static int x = y;



    {
        z = 100;
    }

    static {
        x++;
    }



    MyExamCloud() {
        x = 12;
    }
    public static void main(String[] args) {
//        Person p = new Employer();
//        p.visit();

        MyExamCloud myExamCloud = new MyExamCloud();
        System.out.println("X : "+x);
        System.out.println("Z : "+myExamCloud.z);

    }

    int z = 50;
}
