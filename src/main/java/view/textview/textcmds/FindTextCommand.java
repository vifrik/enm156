package view.textview.textcmds;

import controller.ITripController;
import model.vasttrafik_api.response_classes.departure_board.DepartureBoardResponse;
import model.vasttrafik_api.response_classes.name.NameResponse;
import model.vasttrafik_api.response_classes.trip.TripResponse;
import view.textview.TextView;

import java.util.List;
import java.util.Objects;

public class FindTextCommand extends TextCommand {
    private final ITripController tripController;
    private TripResponse tripResponse;
    private String lastDestinationId;

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
    protected List<String> getArgumentList() {
        return List.of(
                "trip [source] [destination] - Find the best trip going from source to destination using given metrics.",
                "departures [source] - Find departures from source."
        );
    }

    private void parseArguments(String[] arguments) {
        if (arguments.length == 0)
            printFullDescription();

        else if (Objects.equals(arguments[0], "trip"))
            parseTripArguments(arguments);

        else if (Objects.equals(arguments[0], "departures"))
            parseDeparturesArgumnents(arguments);

        else if (Objects.equals(arguments[0], "cont"))
            parseContArgumnents(arguments);

        else
            printUnrecognizedArguments(arguments);
    }

    private void parseContArgumnents(String... arguments) {
        if (lastDestinationId == null || tripResponse == null) {
            printMessage("No last trip search found! See help");
            return;
        }
        switch (arguments.length) {
            case 1, 2 -> printMessage("Too few arguments.");
            case 3 -> {
                try {
                    int journeyIndex = Integer.parseInt(arguments[1]);
                    int fromStationIndex = Integer.parseInt(arguments[2]);

                    try {
                        findAndPrintTripId(
                                tripResponse.getTripList().getTrips().get(journeyIndex).getLeg()
                                        .get(fromStationIndex).getOrigin().getId(),
                                lastDestinationId
                        );
                    } catch (IllegalArgumentException e) {
                        printMessage(e.getMessage());
                    }

                } catch (NumberFormatException e) {
                    System.out.printf("Invalid input %s or %s%n", arguments[1], arguments[2]);
                }
            }
            default -> printMessage("Too many arguments.");
        }

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

    private void parseDeparturesArgumnents(String... arguments) {
        switch (arguments.length) {
            case 1 -> printFullDescription();
            case 2 -> {
                String station = arguments[1];
                findAndPrintDepartures(station);
            }
            default -> printMessage("Too many arguments.");
        }
    }

    private void findAndPrintTripId(String sourceId, String destinationId) throws IllegalArgumentException {
        TripResponse trip = tripController.findTrip(sourceId, destinationId);

        this.tripResponse = trip;
        this.lastDestinationId = destinationId;

        if (trip == null)
            throw new IllegalArgumentException("No trip found matching query");
        else
            printTrip(trip);
    }

    private void findAndPrintTrip(String source, String destination) {
        NameResponse nameResponseSource = tripController.findNames(source);
        NameResponse nameResponseDestination = tripController.findNames(destination);

        if (nameResponseSource.getLocationList() == null || nameResponseDestination.getLocationList() == null) {
            printMessage("No stations matching queries %s or %s".formatted(source, destination));
            return;
        }

        try {
            findAndPrintTripId(
                    nameResponseSource.getLocationList().getStopLocation().get(0).getId(),
                    nameResponseDestination.getLocationList().getStopLocation().get(0).getId()
            );
        } catch (IllegalArgumentException e) {
            printMessage(e.getMessage());
        }
    }

    private void printTrip(TripResponse trip) {
        System.out.println(trip);
    }

    private void findAndPrintDepartures(String station) {
        NameResponse nameResponseStation = tripController.findNames(station);

        if (nameResponseStation.getLocationList() == null) {
            printMessage("No station matching query %s".formatted(station));
            return;
        }

        DepartureBoardResponse departureBoardResponse = tripController.findDepartures(
                nameResponseStation.getLocationList().getStopLocation().get(0).getId()
        );

        printDepartures(departureBoardResponse);
    }

    private void printDepartures(DepartureBoardResponse departureBoardResponse) {
        System.out.println(departureBoardResponse);
    }
}
