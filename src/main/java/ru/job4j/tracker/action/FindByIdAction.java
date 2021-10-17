package ru.job4j.tracker.action;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

import java.util.Objects;

public class FindByIdAction implements UserAction {
    private final Output out;

    public FindByIdAction(Output out) {
        this.out = out;
    }

    @Override
    public String name() {
        return "=== Find Item By Id ====";
    }

    /**
     * Запрашиваем id
     * выводим в консоль item или сообщение, что id не найден
     */
    @Override
    public boolean execute(Input input, Store tracker) {
        out.println(name());
        int id = input.askInt("Enter id: ");
        Item item = tracker.findById(id);
        out.println(Objects.requireNonNullElse(item, "Id is not found"));
        return true;
    }
}
