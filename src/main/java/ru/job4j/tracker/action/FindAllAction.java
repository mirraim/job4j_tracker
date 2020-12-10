package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class FindAllAction implements UserAction {
    private final Output out;

    public FindAllAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Show All Items ====";
    }

    /**
     * Выводим в консоль все item
     */
    @Override
    public boolean execute(Input input, Tracker tracker) {
        out.println(name());
        for (Item item : tracker.findAll()) {
            out.println(item);
        }
        return true;
    }
}
