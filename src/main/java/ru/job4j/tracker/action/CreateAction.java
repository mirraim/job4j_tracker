package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.MemTracker;
import ru.job4j.tracker.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class CreateAction implements UserAction {
    private final Output out;

    public CreateAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Create a new Item ====";
    }

    /**
     * запрашиваем имя
     * Создаем новый Item
     * записываем в items
     */
    @Override
    public boolean execute(Input input, Store tracker) {
        out.println(name());
        String name = input.askStr("Enter name: ");
        Item item = new Item(name);
        tracker.add(item);
        return true;
    }
}
