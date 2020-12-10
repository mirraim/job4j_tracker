package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class ReplaceAction implements UserAction {
    private final Output out;

    public ReplaceAction(Output out) {
        this.out = out;
    }

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
        out.println(name());
        int id = input.askInt("Enter id: ");
        String name = input.askStr("Enter name: ");
        if (tracker.replace(id, new Item(name))) {
            out.println("Edit is successful");
        } else {
            out.println("incorrect id");
        }
        return true;
    }
}
