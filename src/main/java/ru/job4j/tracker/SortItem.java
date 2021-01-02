package ru.job4j.tracker;

import ru.job4j.tracker.Item;

import java.util.Comparator;

public class SortItem implements Comparator<Item> {
    @Override
    public int compare(Item item, Item anotherItem) {
        return item.compareTo(anotherItem);
    }
}
