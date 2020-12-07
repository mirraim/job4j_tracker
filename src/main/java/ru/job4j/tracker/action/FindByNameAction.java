package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class FindByNameAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item By Name ====";
    }

    /**
     * Запрашиваем name
     * выводим в консоль список item или сообщение, что name не найдено
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        String name = input.askStr("Enter name: ");
        Item[] items = tracker.findByName(name);
        if (items.length > 0) {
            for (Item item : items) {
                System.out.println(item);
            }
        } else {
            System.out.println("Name is not found");
        }
        return true;
    }
}
