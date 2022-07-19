package ru.job4j.io;

import java.util.Scanner;

public class Matches {
    public static void main(String[] args) {
        Scanner input = new Scanner(System.in);
        System.out.println("Game 11.");
        boolean turn = true;
        int count = 11;
        while (count > 0) {
            String player = turn ? "First player" : "Second player";
            System.out.println(player + " enter 1,2 or 3:");
            int matches = Integer.parseInt(input.nextLine());
            boolean rsl = matches > 0 && matches <= Math.min(count, 3);
            if (rsl) {
                count -= matches;
                System.out.println(count + " matches left on the table");
                turn = !turn;
            } else {
                System.out.println("Error. Enter 1,2 или 3");
            }
        }
        if (!turn) {
            System.out.println("First player wins");
        } else {
            System.out.println("Second player wins");
        }
    }
}
