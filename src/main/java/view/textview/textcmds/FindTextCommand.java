package view.textview.textcmds;

import controller.ITripController;
import model.trip.Trip;
import view.textview.TextView;

import java.util.Objects;

public class FindTextCommand extends TextCommand{
    private final ITripController tripController;

    public FindTextCommand(TextView textView, ITripController tripController) {
        super(textView);
        this.tripController = tripController;
    }

    @Override
    public void execute(String... arguments) {
        parseArguments(arguments);
    }

    @Override
    protected String getDescription() {
        return "Use model to find information about the given target.";
    }

    @Override
    protected String getArgumentSummary() {
        return """
            trip [source] [destination] - Find the best trip going from source to destination using given metrics.""";
    }

    private void parseArguments(String[] arguments) {
        if (arguments.length == 0)
            printFullDescription();

        else if (Objects.equals(arguments[0], "trip"))
            parseTripArguments(arguments);

        else
            printUnrecognizedArguments(arguments);
    }

    private void parseTripArguments(String... arguments) {
        switch (arguments.length) {
            case 1 -> printFullDescription();
            case 2 -> printMessage("Need to specify destination.");
            case 3 -> {
                String source = arguments[1];
                String destination = arguments[2];
                findAndPrintTrip(source, destination);
            }
            default -> printMessage("Too many arguments.");
        }
    }

    private void findAndPrintTrip(String source, String destination) {
        Trip trip = tripController.findTrip(source, destination);
        if (trip == null)
            printMessage("No trip found from %s to %s".formatted(source, destination));
        else
            printTrip(trip);
    }

    private void printTrip(Trip trip) {
        System.out.println(trip);
    }
}
