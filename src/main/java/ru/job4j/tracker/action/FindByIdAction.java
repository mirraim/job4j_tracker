package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class FindByIdAction implements UserAction {
    @Override
    public String name() {
        return "=== Find Item By Id ====";
    }

    /**
     * Запрашиваем id
     * выводим в консоль item или сообщение, что id не найден
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        if (item != null) {
            System.out.println(item);
        } else {
            System.out.println("Id is not found");
        }
        return true;
    }
}
