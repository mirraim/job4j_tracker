package ru.job4j.tracker.action;

import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;

public class DeleteAction implements UserAction {
    private final Output out;

    public DeleteAction(Output out) {
        this.out = out;
    }

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
    public boolean execute(Input input, Store tracker) {
        out.println(name());
        int id = input.askInt("Enter id: ");
        if (tracker.delete(id)) {
            out.println("Deleted");
        } else {
            out.println("incorrect id");
        }
        return true;
    }
}
