package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingleLasy {
    private static Tracker instance;

    private TrackerSingleLasy() {
    }

    public static Tracker getInstance() {
        if (instance == null) {
            instance = new Tracker();
        }
        return instance;
    }
}
