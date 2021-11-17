package userinterface;

import timetable.TimeTable;

public class CommandLineInterface extends UserInterface {
    TimeTable timeTable;

    public CommandLineInterface(TimeTable timeTable)  {
        this.timeTable = timeTable;
    }

    @Override
    public void start() {
        System.out.println("Hello World!");
    }
}
