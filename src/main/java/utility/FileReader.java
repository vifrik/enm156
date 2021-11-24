package utility;

import model.graph.TravelData;

import java.io.File;
import java.io.IOException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Scanner;

public class FileReader extends File {
    private final ArrayList<TravelData> travelData = new ArrayList<>();

    public FileReader(String pathname) {
        super(pathname);
        try {
            Scanner scanner = new Scanner(Path.of(pathname));
            while (scanner.hasNextLine()) {
                String line = scanner.nextLine();
                String[] parts = line.split(",");
                TravelData td = new TravelData(parts[0], parts[1], Double.parseDouble(parts[2]), Integer.parseInt(parts[3]));
                travelData.add(td);
            }
            scanner.close();
        } catch (IOException e) {
            System.err.println("No bueno!");
            e.printStackTrace();
        }
    }

    public ArrayList<TravelData> getTravelData() {
        return travelData;
    }
}
