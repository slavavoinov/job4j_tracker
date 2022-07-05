package ru.job4j.oop;

public class Calculator {

    private static int x = 5;

    public static int sum(int y) {
        return x + y;
    }

    public int multiply(int a) {
        return x * a;
    }

    public static int minus(int w) {
        return w - x;
    }

    public int divide(int d) {
        return d / x;
    }

    public int sumAllOperation(int s) {
        return sum(10) + multiply(2) + minus(10) + divide(15);
    }

    public static void main(String[] args) {
        int result = sum(10);
        System.out.println(result);
        int result1 = minus(10);
        System.out.println(result1);
        Calculator calculator = new Calculator();
        int rsl = calculator.multiply(2);
        System.out.println(rsl);
        int rsl1 = calculator.divide(15);
        System.out.println(rsl1);
        int rsl2 = calculator.sumAllOperation(5);
        System.out.println(rsl2);
    }
}