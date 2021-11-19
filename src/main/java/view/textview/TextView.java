package view.textview;

import model.timetable.TimeTable;
import view.BaseView;
import view.textview.textcommands.TextCommandManager;

import java.util.Locale;
import java.util.Scanner;

public class TextView extends BaseView {
    Scanner inputScanner;
    TimeTable timeTable;
    TextCommandManager textCommandManager;
    private boolean isRunning;

    public TextView(TimeTable timeTable)  {
        super(timeTable);
    }

    @Override
    protected void setup() {
        isRunning = true;
        inputScanner = new Scanner(System.in);
        textCommandManager = new TextCommandManager(this);
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

    public void stopRunning() {
        isRunning = false;
    }

    private void awaitAndExecuteCommand() {
        String input = getUserInput();
        String[] words = cleanInput(input);
        textCommandManager.executeCommand(words);
    }

    private String getUserInput() {
        System.out.println("Give a command. Enter 'help' for a list of commands.");
        return inputScanner.nextLine();
    }

    private String[] cleanInput(String input) {
        return input.strip().toLowerCase(Locale.ROOT).split(" ");
    }
}
