package ru.job4j.tracker.action;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.store.MemTracker;
import ru.job4j.tracker.store.Store;
import ru.job4j.tracker.input.Input;
import ru.job4j.tracker.output.Output;
import ru.job4j.tracker.output.StubOutput;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;
import static org.mockito.ArgumentMatchers.any;
import static org.mockito.Mockito.mock;
import static org.mockito.Mockito.when;

public class FindByNameActionTest {
    @Test
    public void execute() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String name = "Item";
        Item item = new Item(name);
        tracker.add(item);
        UserAction rep = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(name);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find Item By Name ====" + ln + item + ln));
        assertThat(tracker.findByName(name).get(0).getId(), is(item.getId()));
    }

    @Test
    public void executeWhenThreeNames() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        String name = "Item";
        Item item = new Item(name);
        tracker.add(item);
        tracker.add(new Item("Another item"));
        tracker.add(new Item("Item"));
        UserAction rep = new FindByNameAction(out);

        Input input = mock(Input.class);

        when(input.askStr(any(String.class))).thenReturn(name);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(tracker.findByName(name).size(), is(2));
    }
}