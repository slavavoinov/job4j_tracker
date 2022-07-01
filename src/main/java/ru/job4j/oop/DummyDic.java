package ru.job4j.oop;

public class DummyDic {

    public String engToRus(String eng) {
        String text = "Неизвестное слово";
       return text + eng;
    }

    public static void main(String[] args) {
        DummyDic dummydic = new DummyDic();
        System.out.println(dummydic.engToRus(" car"));
    }
}
