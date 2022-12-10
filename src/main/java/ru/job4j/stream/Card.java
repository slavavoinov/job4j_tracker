package ru.job4j.stream;

import com.sun.jdi.Value;

import java.util.stream.Stream;

public class Card {
        private Suit suit;
        private Value value;

        public Card(Suit suit, Value value) {
            this.suit = suit;
            this.value = value;
        }

        public static void main(String[] args) {
            Stream.of(Suit.values())
                    .flatMap(suit -> Stream.of(ru.job4j.stream.Value.values())
                    .map(value -> suit + " " + value))
            .forEach(System.out::println);
        }
}



