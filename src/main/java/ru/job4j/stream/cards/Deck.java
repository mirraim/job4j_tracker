package ru.job4j.stream.cards;

import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Deck {
    public List<String> generate() {
        Suit[] suits = Suit.values();
        Value[] values = Value.values();
        return Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                        .map(value -> suit + " " + value))
                .collect(Collectors.toList());
    }

    public static void main(String[] args) {
        Stream.of(Suit.values())
                .flatMap(suit -> Stream.of(Value.values())
                .map(value -> suit + " " + value))
                .forEach(System.out::println);
    }
}
