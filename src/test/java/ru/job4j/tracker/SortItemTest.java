package ru.job4j.tracker;

import org.junit.Test;

import java.util.Collections;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class SortItemTest {

    @Test
    public void compare() {
        Item item = new Item(2, "item");
        Item anotherItem = new Item(5, "anotherItem");
        MemTracker tracker = new MemTracker();
        tracker.add(item);
        tracker.add(anotherItem);
        Collections.sort(tracker.findAll(), new SortItem());
        assertThat(tracker.findAll().get(0).getName(), is("item"));
    }
}