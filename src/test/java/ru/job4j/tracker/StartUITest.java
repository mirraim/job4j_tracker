package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;

public class StartUITest {
    @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Store tracker = new SqlTracker();
        tracker.init();
        Output out = new ConsoleOutput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new CreateAction(out));
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        List<Item> rsl = tracker.findAll();
        assertThat(rsl.get(rsl.size() - 1).getName(), is("Item name"));
        tracker.delete(rsl.get(rsl.size() - 1).getId());
    }

    @Test
    public void whenReplaceItem() {
        Store tracker = new SqlTracker();
        tracker.init();
        Output output = new ConsoleOutput();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), replacedName, "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ReplaceAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        Item rsl = tracker.findById(item.getId());
        assertThat(rsl.getName(), is(replacedName));
        tracker.delete(rsl.getId());
    }

    @Test
    public void whenDeleteItem() {
        Store tracker = new SqlTracker();
        tracker.init();
        Output output = new ConsoleOutput();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0", String.valueOf(item.getId()), "1"}
        );
        List<UserAction> actions = new ArrayList<>();
        actions.add(new DeleteAction(output));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));

    }

    @Test
    public void whenFindAllItems() {
       Store tracker = new SqlTracker();
       tracker.init();
       Item item = tracker.add(new Item("New Item"));
       Input in = new StubInput(new String[]{"0", "1"});
       Output output = new ConsoleOutput();
       Output out = new StubOutput();
       List<UserAction> actions = new ArrayList<>();
       actions.add(new FindAllAction(out));
       actions.add(new ExitAction());
       new StartUI(output).init(in, tracker, actions);
       String expected = actions.get(0).name() + System.lineSeparator()
                        + item.toString() + System.lineSeparator();
        assertThat(out.toString(), is(expected));
        tracker.delete(item.getId());
    }

    @Test
    public void whenFindItemByName() {
        Store tracker = new SqlTracker();
        tracker.init();
        Item item = tracker.add(new Item("New Item"));
        Input in = new StubInput(new String[]{"0", "New Item", "1"});
        Output output = new ConsoleOutput();
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByNameAction(out));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        String expected = actions.get(0).name() + System.lineSeparator()
                            + item.toString() + System.lineSeparator();
        assertThat(out.toString(), is(expected));
        tracker.delete(item.getId());
    }

    @Test
    public void whenFindItemById() {
        Store tracker = new SqlTracker();
        tracker.init();
        Item first = tracker.add(new Item("New Item"));
        Item second = tracker.add(new Item("One more Item"));
        Input in = new StubInput(new String[]{"0", String.valueOf(second.getId()), "1"});
        Output output = new ConsoleOutput();
        Output out = new StubOutput();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new FindByIdAction(out));
        actions.add(new ExitAction());
        new StartUI(output).init(in, tracker, actions);
        String expected = actions.get(0).name() + System.lineSeparator()
                        + second.toString() + System.lineSeparator();
        assertThat(out.toString(), is(expected));
        tracker.delete(first.getId());
        tracker.delete(second.getId());
    }

    @Test
    public void whenInvalidExit() {
        Output out = new StubOutput();
        Input in = new StubInput(
                new String[] {"7", "0"}
        );
        Store tracker = new SqlTracker();
        tracker.init();
        List<UserAction> actions = new ArrayList<>();
        actions.add(new ExitAction());
        new StartUI(out).init(in, tracker, actions);
        assertThat(out.toString(), is(
                "Menu." + System.lineSeparator()
                        + "0. " + actions.get(0).name() + System.lineSeparator()
                        + "Wrong input, you can select: 0 .. 0" + System.lineSeparator()
                        + "Menu." + System.lineSeparator()
                        + "0. " + actions.get(0).name() + System.lineSeparator()
        ));
    }
}