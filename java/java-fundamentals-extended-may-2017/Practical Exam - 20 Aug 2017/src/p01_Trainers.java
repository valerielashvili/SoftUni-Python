import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p01_Trainers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, ArrayList<Double>> teamsIncome = new LinkedHashMap<>();

        while (n-- > 0) {
            String distanceToCheck = scanner.nextLine();
            String cargoToCheck = scanner.nextLine();

            boolean distIsDigit = checkDigit(distanceToCheck);
            boolean cargoIsDigit = checkDigit(cargoToCheck);

            long distance = 0;
            Double cargo = 0.0;
            if (distIsDigit && cargoIsDigit) {
                distance = Integer.parseInt(distanceToCheck);
                cargo = Double.parseDouble(cargoToCheck);
            }
            String team = scanner.nextLine();

            long distanceInMeters = distance * 1600;
            Double cargoInKilograms = cargo * 1000;

            Double fuelExpenses = 0.7 * distanceInMeters * 2.5;
            Double cargoPrice = cargoInKilograms * 1.5;
            Double participantEarnedMoney = cargoPrice - fuelExpenses;

            teamsIncome.putIfAbsent(team, new ArrayList<>());
            teamsIncome.get(team).add(participantEarnedMoney);
        }

        LinkedHashMap<String, Double> winnerTeam = new LinkedHashMap<>();

        for (Map.Entry<String, ArrayList<Double>> teamIncome : teamsIncome.entrySet()) {
            String teamName = teamIncome.getKey();
            ArrayList<Double> teamEarned = teamIncome.getValue();
            Double teamTotalEarned = 0.0;

            for (int i = 0; i < teamEarned.size(); i++) {
                teamTotalEarned += teamEarned.get(i);
            }
            winnerTeam.putIfAbsent(teamName, teamTotalEarned);
        }

        System.out.printf("The %s Trainers win with $%.3f.",
                winnerTeam.entrySet()
                .stream()
                .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                .get()
                .getKey(),

                winnerTeam.entrySet()
                        .stream()
                        .max((entry1, entry2) -> entry1.getValue() > entry2.getValue() ? 1 : -1)
                        .get()
                        .getValue());
    }

    private static boolean checkDigit(String inputLine) {
        for (int i = 0; i < inputLine.length(); i++) {
            if (Character.isDigit(inputLine.charAt(i))) {
                return true;
            }
        }
        return false;
    }
}
