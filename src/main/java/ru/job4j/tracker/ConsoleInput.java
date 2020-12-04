package ru.job4j.tracker;

import java.util.Scanner;

public class ConsoleInput implements Input {
    private static Scanner scanner = new Scanner(System.in);

    @Override
    public String askStr(String question) {
        System.out.println(question);
        return scanner.nextLine();
    }

    @Override
    public int askInt(String question) {
        System.out.println(question);
        return Integer.valueOf(scanner.nextLine());
    }
}
