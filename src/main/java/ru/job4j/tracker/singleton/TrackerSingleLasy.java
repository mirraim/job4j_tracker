package ru.job4j.tracker.singleton;

import ru.job4j.tracker.MemTracker;

public class TrackerSingleLasy {
    private static MemTracker instance;

    private TrackerSingleLasy() {
    }

    public static MemTracker getInstance() {
        if (instance == null) {
            instance = new MemTracker();
        }
        return instance;
    }
}
