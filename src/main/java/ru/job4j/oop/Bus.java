package ru.job4j.oop;

public class Bus implements Vehicle {
    public void move() {
        System.out.println(getClass().getSimpleName() + " rides on road.");
    }
}
