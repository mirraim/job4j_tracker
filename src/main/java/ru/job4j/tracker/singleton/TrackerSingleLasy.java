package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Tracker;

public class TrackerSingleLasy {
    private static TrackerSingleLasy instance;
    private Tracker tracker;

    private TrackerSingleLasy(Tracker tracker) {
        this.tracker = tracker;
    }

    public static TrackerSingleLasy getInstance() {
        if (instance == null) {
            instance = new TrackerSingleLasy(new Tracker());
        }
        return instance;
    }

    public Tracker getTracker() {
        return tracker;
    }
}
