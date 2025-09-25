import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashSet;
import java.util.stream.Collectors;

public class p04_Parking_Lot {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();
        HashSet<String> parkingLot = new HashSet<>();

        while (!"END".equals(inputLine)) {
            String[] tokens = inputLine.split(",\\s");
            if ("IN".equals(tokens[0])) {
                parkingLot.add(tokens[1]);
            } else if ("OUT".equals(tokens[0])) {
                parkingLot.remove(tokens[1]);
            }
            inputLine = reader.readLine();
        }
        if (!parkingLot.isEmpty()) {
            System.out.println(parkingLot.stream().collect(Collectors.joining("\n")));
        } else {
            System.out.println("Parking Lot is Empty");
        }
    }
}
