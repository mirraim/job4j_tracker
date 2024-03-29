package ru.job4j.tracker;

import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.ConsoleInput;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.ValidateInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.store.SqlTracker;
import ru.job4j.tracker.store.Store;

import java.util.ArrayList;
import java.util.List;

public class StartUI {
    private final Output out;

    public StartUI(Output out) {
        this.out = out;
    }

    /**
     * Инициализируем выбор пользователя
     *
     * @param input   input
     * @param tracker tracker
     */
    public void init(Input input, Store tracker, List<UserAction> actions) {
        boolean run = true;
        while (run) {
            this.showMenu(actions);
            int select = input.askInt("Select: ");
            if (select < 0 || select >= actions.size()) {
                out.println("Wrong input, you can select: 0 .. " + (actions.size() - 1));
                continue;
            }
            UserAction action = actions.get(select);
            run = action.execute(input, tracker);
        }
    }

    /**
     * Выводим меню в консоль
     */
    private void showMenu(List<UserAction> actions) {
        out.println("Menu.");
        for (UserAction action : actions) {
            out.println(actions.indexOf(action) + ". " + action.name());
        }
    }

    public static void main(String[] args) {
        Output output = new ConsoleOutput();
        Input validate = new ValidateInput(new ConsoleInput(), output);
        try (Store tracker = new SqlTracker()) {
            List<UserAction> actions = new ArrayList<>();
            actions.add(new CreateAction(output));
            actions.add(new FindAllAction(output));
            actions.add(new ReplaceAction(output));
            actions.add(new DeleteAction(output));
            actions.add(new FindByIdAction(output));
            actions.add(new FindByNameAction(output));
            actions.add(new ExitAction());
            new StartUI(output).init(validate, tracker, actions);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
