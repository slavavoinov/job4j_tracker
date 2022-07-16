package ru.job4j.io;

import java.util.Scanner;
import java.util.Random;

public class MagicBall {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.print("I am Great Oracle. What do want to know? ");
        String name = input.nextLine();
        int answer = new Random().nextInt(3);
        String mark = switch (answer) {
            case 0 -> "Yes";
            case 1 -> "No";
            default -> "Maybe";
        };
        System.out.println(mark);
    }
}