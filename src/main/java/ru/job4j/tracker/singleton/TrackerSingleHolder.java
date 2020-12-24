package ru.job4j.tracker.singleton;

import ru.job4j.tracker.Item;
import ru.job4j.tracker.Tracker;

import java.util.Arrays;

public class TrackerSingleHolder {
   private Tracker tracker;

    private TrackerSingleHolder(Tracker tracker) {
        this.tracker = tracker;
    }

    public static TrackerSingleHolder getInstance() {
        return Holder.INSTANCE;
    }

    public Tracker getTracker() {
        return tracker;
    }

    private static final class Holder {
        private static final TrackerSingleHolder INSTANCE = new TrackerSingleHolder(new Tracker());
    }

    public static void main(String[] args) {
        TrackerSingleHolder tracker = TrackerSingleHolder.getInstance();
    }
}
