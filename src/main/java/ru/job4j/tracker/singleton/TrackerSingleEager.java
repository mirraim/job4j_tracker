package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.Arrays;

public class TrackerSingleEager {
    private static final TrackerSingleEager INSTANCE = new TrackerSingleEager(new Tracker());
    private Tracker tracker;

    private TrackerSingleEager(Tracker tracker) {
        this.tracker = tracker;
    }

    public static TrackerSingleEager getInstance() {
        return INSTANCE;
    }

    public Tracker getTracker() {
        return tracker;
    }
}
