import java.util.ArrayList;
import java.util.Collections;
import java.util.Scanner;

public class p02_Entertrain {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int locomotivesPower = Integer.parseInt(scanner.nextLine());
        String inputLine = scanner.nextLine();

        ArrayList<Integer> wagons = new ArrayList<>();

        while (!"All ofboard!".equals(inputLine)) {
            int wagon = 0;

            boolean isDigit = checkDigit(inputLine);
            if (isDigit) {
                wagon = Integer.parseInt(inputLine);
            }
            wagons.add(wagon);

            int wagonsSum = wagons.stream().map(Integer::valueOf).reduce(0, (a, b) -> a+b);
            int average = (int) wagons.stream().mapToDouble(Double::valueOf).average().getAsDouble();

            int closest = 0;
            if (wagonsSum > locomotivesPower) {
                closest = closestValue(average, wagons);
            }
            for (int i = 0; i < wagons.size(); i++) {
                if (closest == wagons.get(i)) {
                    wagons.remove(i);
                }
            }

            inputLine = scanner.nextLine();
        }

        Collections.reverse(wagons);
        wagons.add(locomotivesPower);

        for (int i = 0; i < wagons.size(); i++) {
            int wagonToPring = wagons.get(i);
            System.out.printf("%d ", wagonToPring);
        }
    }

    private static boolean checkDigit(String inputLine) {
        for (int i = 0; i < inputLine.length(); i++) {
            if (Character.isDigit(inputLine.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    public static int closestValue(double average, ArrayList<Integer> wagonsValues) {
        int myNumber = (int) average;
        int distance = Math.abs(wagonsValues.get(0) - myNumber);
        int idx = 0;
        for(int c = 1; c < wagonsValues.size(); c++){
            int cdistance = Math.abs(wagonsValues.get(c) - myNumber);
            if(cdistance < distance){
                idx = c;
                distance = cdistance;
            }
        }
        return wagonsValues.get(idx);
    }
}
