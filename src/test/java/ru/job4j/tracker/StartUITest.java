package ru.job4j.tracker;

import org.junit.Test;
import static org.hamcrest.Matchers.is;
import static org.hamcrest.Matchers.nullValue;
import static org.junit.Assert.assertThat;
import ru.job4j.tracker.action.*;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.input.StubInput;
import ru.job4j.tracker.output.ConsoleOutput;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;


public class StartUITest{
   @Test
    public void whenCreateItem() {
        Input in = new StubInput(
                new String[] {"0", "Item name", "1"}
        );
        Tracker tracker = new Tracker();
        Output out = new ConsoleOutput();
        UserAction[] actions = {
                new CreateAction(out),
                new ExitAction()
        };
        new StartUI(out).init(in, tracker, actions);
        assertThat(tracker.findAll()[0].getName(), is("Item name"));
    }

    @Test
    public void whenReplaceItem() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Item item = tracker.add(new Item("Replaced item"));
        String replacedName = "New item name";
        Input in = new StubInput(
                new String[] {"0" , String.valueOf(item.getId()), replacedName, "1"}
        );
        UserAction[] actions = {
                new ReplaceAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()).getName(), is(replacedName));
    }

    @Test
    public void whenDeleteItem() {
        Tracker tracker = new Tracker();
        Output output = new ConsoleOutput();
        Item item = tracker.add(new Item("Deleted item"));
        Input in = new StubInput(
                new String[] {"0" , String.valueOf(item.getId()), "1"}
        );
        UserAction[] actions = {
                new DeleteAction(output),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        assertThat(tracker.findById(item.getId()), is(nullValue()));
    }

    @Test
    public void whenFindAllItems() {
       Tracker tracker = new Tracker();
       Item item = tracker.add(new Item("New Item"));
       Input in = new StubInput(new String[]{"0", "1"});
       Output output = new ConsoleOutput();
       Output out = new StubOutput();
       UserAction[] actions = {
                    new FindAllAction(out),
                    new ExitAction()
       };
       new StartUI(output).init(in, tracker, actions);
       String expected = actions[0].name() + System.lineSeparator() + item.toString() + System.lineSeparator();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenFindItemByName() {
        Tracker tracker = new Tracker();
        Item item = tracker.add(new Item("New Item"));
        Input in = new StubInput(new String[]{"0", "New Item", "1"});
        Output output = new ConsoleOutput();
        Output out = new StubOutput();
        UserAction[] actions = {
                new FindByNameAction(out),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String expected = actions[0].name() + System.lineSeparator() + item.toString() + System.lineSeparator();
        assertThat(out.toString(), is(expected));
    }

    @Test
    public void whenFindItemById() {
        Tracker tracker = new Tracker();
        Item first = tracker.add(new Item("New Item"));
        Item second = tracker.add(new Item("One more Item"));
        Input in = new StubInput(new String[]{"0", "2", "1"});
        Output output = new ConsoleOutput();
        Output out = new StubOutput();
        UserAction[] actions = {
                new FindByIdAction(out),
                new ExitAction()
        };
        new StartUI(output).init(in, tracker, actions);
        String expected = actions[0].name() + System.lineSeparator() + second.toString() + System.lineSeparator();
        assertThat(out.toString(), is(expected));
    }
}