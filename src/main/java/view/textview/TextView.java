package view;

import model.timetable.TimeTable;
import org.jgrapht.alg.util.Pair;
import view.inputcommands.InputCommand;
import view.inputcommands.InputCommandFactory;

import java.util.Arrays;
import java.util.Locale;
import java.util.Scanner;

public class TextView extends BaseView {
    Scanner inputScanner;
    TimeTable timeTable;
    InputCommandFactory inputCommandFactory;
    private boolean isRunning;

    public TextView(TimeTable timeTable)  {
        super(timeTable);
    }

    @Override
    protected void setup() {
        isRunning = true;
        inputScanner = new Scanner(System.in);
        inputCommandFactory = new InputCommandFactory(this);
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
        String input = awaitInput();
        InputCommand command = parseInput(input);
        executeCommand(command);
    }

    private String awaitInput() {
        System.out.println("Give a command. Enter 'help' for a list of commands.");
        return inputScanner.nextLine();
    }

    private InputCommand parseInput(String input) {
        // TODO Handle arguments
        // TODO Handle empty message

        input = cleanInput(input);
        String[] words = input.split(" ");
        Pair<String, String[]> commandArguments = splitCommandAndArguments(words);

        return getCommand(commandArguments.getFirst(), commandArguments.getSecond());
    }

    private Pair<String, String[]> splitCommandAndArguments(String[] words) {
        String command;
        String[] arguments;

        command = words.length == 0 ? null : words[0];
        arguments = words.length < 2 ? new String[0] : Arrays.copyOfRange(words, 1, words.length);

        return new Pair<>(command, arguments);
    }

    private String cleanInput(String input) {
        return input.strip().toLowerCase(Locale.ROOT);
    }

    private void executeCommand(InputCommand command) {
        command.execute();
    }

    private InputCommand getCommand(String commandString, String[] arguments) {
        return inputCommandFactory.createCommand(commandString, arguments);
    }

}
