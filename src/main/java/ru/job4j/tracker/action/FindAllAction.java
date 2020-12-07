package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class FindAllAction implements UserAction {
    @Override
    public String name() {
        return "=== Show All Items ====";
    }

    /**
     * Выводим в консоль все item
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        for (Item item : tracker.findAll()) {
            System.out.println(item);
        }
        return true;
    }
}
