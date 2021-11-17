package view;

import model.timetable.TimeTable;

public abstract class BaseView {
    TimeTable timeTable;

    public BaseView(TimeTable timeTable) {
        this.timeTable = timeTable;
    }

    public void start() {
        setup();
        run();
        cleanup();
    }

    protected abstract void setup();

    protected abstract void run();

    protected abstract void cleanup();
}
