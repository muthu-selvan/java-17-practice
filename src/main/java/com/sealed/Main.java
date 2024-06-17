package com.sealed;

/**
 * Baker Hughes
 *
 * @author : Muthu Selvan
 * @created : 11-03-2024, Monday
 **/



public class Main {

    sealed class Account {}
    final class StandardAccount extends Account {}

    non-sealed class PremiumAccount extends Account {
        int monthRemaining() {
            return 10;
        }
    }

    public void test() {
       Account account = new StandardAccount();


    }

    public static void main(String[] args) {

    }

}
