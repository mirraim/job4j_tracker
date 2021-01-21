package ru.job4j.lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class FilterInt {

    public static void main(String[] args) {
        List<Integer> numbers = Arrays.asList(-1, 3, 5, -12, 8, -3);
        List<Integer> positive = numbers.stream()
                .filter(num -> num > 0)
                .collect(Collectors.toList());
        positive.forEach(System.out :: println);
    }
}
