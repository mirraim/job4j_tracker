package ru.job4j.tracker.singleton;

import ru.job4j.tracker.MemTracker;

public enum TrackerSingle {
    INSTANCE;

    private MemTracker instance;

    public MemTracker getInstance() {
        return instance;
    }
}
