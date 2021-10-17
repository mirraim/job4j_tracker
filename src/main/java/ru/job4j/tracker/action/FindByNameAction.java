package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

import java.util.List;

public class FindByNameAction implements UserAction {
    private final Output out;

    public FindByNameAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find Item By Name ====";
    }

    /**
     * Запрашиваем name
     * выводим в консоль список item или сообщение, что name не найдено
     */
    @Override
    public boolean execute(Input input, Store tracker) {
        out.println(name());
        String name = input.askStr("Enter name: ");
        List<Item> items = tracker.findByName(name);
        if (items.size() > 0) {
            for (Item item : items) {
                out.println(item);
            }
        } else {
            out.println("Name is not found");
        }
        return true;
    }
}
