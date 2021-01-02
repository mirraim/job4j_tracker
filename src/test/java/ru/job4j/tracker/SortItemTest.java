package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.Item;
import ru.job4j.tracker.SortItem;
import ru.job4j.tracker.Tracker;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortItemTest {

    @Test
    public void compare() {
        Item item = new Item(2, "item");
        Item anotherItem = new Item(5, "anotherItem");
        Tracker tracker = new Tracker();
        tracker.add(item);
        tracker.add(anotherItem);
        Collections.sort(tracker.findAll(), new SortItem());
        assertThat(tracker.findAll().get(0).getName(), is("item"));
    }
}