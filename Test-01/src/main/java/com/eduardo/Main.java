package com.eduardo;

import java.util.Map;

/*
Programming Problem*
For the numbers 1 to 100, print a string for each number as per the following rules:
If the number is divisible by 3, print ‘Foo’
If the number is divisible by 5, print ‘Bar’
If the number is divisible by 3 and 5, print ‘FooBar’
If the number is not divisible by 3 or 5, print the number

* */
public class Main {
    public static boolean isDivisible(int number, int value) {
        return (number % value == 0);
    }

    public static String validateNumber(int number, Map<Integer, String> rules) {
        String result = "";
        for (Map.Entry<Integer, String> validate : rules.entrySet()) {
            if (isDivisible(number, validate.getKey()))
                result += validate.getValue();
        }
        if (result.isEmpty()) result = String.valueOf(number);
        return result;
    }

    public static void main(String[] args) {
        Map<Integer, String> rules = Map.of(2, "Foo", 5, "Bar");
        for (int number = 1; number <= 100; number++)
            System.out.println(validateNumber(number, rules));
    }
}