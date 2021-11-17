package view;

import model.timetable.TimeTable;
import view.inputcommands.InputCommand;

import java.util.Scanner;

public class TextView extends BaseView {
    Scanner inputScanner;
    TimeTable timeTable;
    private boolean isRunning;

    public TextView(TimeTable timeTable)  {
        super(timeTable);
    }

    @Override
    protected void setup() {
        isRunning = true;
        inputScanner = new Scanner(System.in);
    }

    @Override
    protected void run() {
        while (isRunning) {
            awaitAndExecuteCommand();
        }
    }

    @Override
    protected void cleanup() {
        inputScanner.close();
    }

    private void awaitAndExecuteCommand() {
        String input = awaitInput();
        InputCommand command = parseInput(input);
        processCommand(command);
    }

    private String awaitInput() {
        System.out.println("Give a command. Enter 'help' for a list of commands.");
        return inputScanner.nextLine();
    }

    private InputCommand parseInput(String input) {
        // TODO
        return null;
    }

    private void processCommand(InputCommand command) {
        // TODO
    }
}
