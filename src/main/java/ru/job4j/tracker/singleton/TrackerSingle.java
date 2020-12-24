package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.Arrays;

public enum TrackerSingle {
    INSTANCE;

    private Tracker instance;

    public Tracker getInstance() {
        return instance;
    }
}
