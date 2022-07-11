package ru.job4j.pojo;

public class Library {
    public static void main(String[] args) {
        Book kashtanka = new Book("Kashtanka", 5);
        Book cleancode = new Book("Clean code", 10);
        Book bookvar = new Book("Bookvar", 20);
        Book java = new Book("Java", 30);
        Book[] books = new Book[4];
        books[0] = kashtanka;
        books[1] = cleancode;
        books[2] = bookvar;
        books[3] = java;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        System.out.println("Zamena 0 na 3");
        Book temp = books[0];
        books[0] = books[3];
        books[3] = temp;
        for (Book bk : books) {
            System.out.println(bk.getName() + " - " + bk.getCount());
        }
        for (int i = 0; i < books.length; i++) {
            if (books[i].getName().equals("Clean code")) {
                System.out.println("Kniga pod nomerom " + i + " is Clean code");
            }
        }
    }
}
