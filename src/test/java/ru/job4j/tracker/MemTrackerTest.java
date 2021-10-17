package ru.job4j.tracker;

import org.junit.Test;
import ru.job4j.tracker.store.MemTracker;

import java.util.ArrayList;
import java.util.List;

import static org.hamcrest.Matchers.is;
import static org.junit.Assert.assertThat;

public class MemTrackerTest {

    @Test
    public void whenAddNewItemThenTrackerHasSameItem() {
        MemTracker tracker = new MemTracker();
        Item item = new Item();
        item.setName("test1");
        tracker.add(item);
        Item result = tracker.findById(item.getId());
        assertThat(result.getName(), is(item.getName()));
    }

    @Test
    public void findItemWhenSomeID() {
        MemTracker tracker = new MemTracker();
        Item item1 = new Item(1, "one");
        Item item2 = new Item(2, "two");
        Item item3 = new Item(3, "three");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        Item result = tracker.findById(2);
        assertThat(result, is(item2));
    }

    @Test
    public void findAllTest() {
        MemTracker tracker = new MemTracker();
        Item item1 = new Item(1, "one");
        Item item2 = new Item(2, "two");
        Item item3 = new Item(3, "three");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = tracker.findAll();
        List<Item> expected = new ArrayList<>();
        expected.add(item1);
        expected.add(item2);
        expected.add(item3);
        assertThat(result, is(expected));
    }

    @Test
    public void findByNameTest() {
        MemTracker tracker = new MemTracker();
        Item item1 = new Item(1, "one");
        Item item2 = new Item(2, "two");
        Item item3 = new Item(3, "three");
        tracker.add(item1);
        tracker.add(item2);
        tracker.add(item3);
        List<Item> result = tracker.findByName("three");
        List<Item> expected = new ArrayList<>();
        expected.add(item3);
        assertThat(result, is(expected));
    }

    @Test
    public void whenReplace() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        Item bugWithDesc = new Item();
        bugWithDesc.setName("Bug with description");
        tracker.replace(id, bugWithDesc);
        assertThat(tracker.findById(id).getName(), is("Bug with description"));
    }

    @Test
    public void whenDelete() {
        MemTracker tracker = new MemTracker();
        Item bug = new Item();
        bug.setName("Bug");
        tracker.add(bug);
        int id = bug.getId();
        tracker.delete(id);
        Integer expected = null;
        assertThat(tracker.findById(id), is(expected));
    }
}