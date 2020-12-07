package ru.job4j.tracker.action;

import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class DeleteAction implements UserAction {
    @Override
    public String name() {
        return "=== Delete Item ====";
    }

    /**
     * Запрашиваем id
     * Удаляем item с указанным id
     * сообщаем о результате
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            System.out.println("Deleted");
        } else {
            System.out.println("incorrect id");
        }
        return true;
    }
}
