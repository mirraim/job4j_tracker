package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;

public class ReplaceAction implements UserAction {
    @Override
    public String name() {
        return "=== Edit an Item ====";
    }

    /**
     * Запрашиваем у пользователя Id и новое name
     * редактируем id
     * если id  не найден, сообщаем об этом
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        if (tracker.replace(id, new Item(name))) {
            System.out.println("Edit is successful");
        } else {
            System.out.println("incorrect id");
        }
        return true;
    }
}
