package ru.job4j.tracker.singleton;

import ru.job4j.tracker.MemTracker;

public class TrackerSingleEager {
    private static final MemTracker INSTANCE = new MemTracker();

    private TrackerSingleEager() {
    }

    public static MemTracker getInstance() {
        return INSTANCE;
    }

}
