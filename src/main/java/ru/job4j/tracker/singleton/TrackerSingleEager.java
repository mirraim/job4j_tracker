package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.Arrays;

public class TrackerSingleEager {
    private static final Tracker INSTANCE = new Tracker();

    private TrackerSingleEager() {
    }

    public static Tracker getInstance() {
        return INSTANCE;
    }

}
