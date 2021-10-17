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

public class FindByIdActionTest {
    @Test
    public void execute() {
        Output out = new StubOutput();
        Store tracker = new MemTracker();
        Item item = new Item("Item");
        tracker.add(item);
        UserAction rep = new FindByIdAction(out);

        Input input = mock(Input.class);

        when(input.askInt(any(String.class))).thenReturn(1);

        rep.execute(input, tracker);

        String ln = System.lineSeparator();
        assertThat(out.toString(), is("=== Find Item By Id ====" + ln + item + ln));
        assertThat(tracker.findById(1).getName(), is("Item"));
    }
}