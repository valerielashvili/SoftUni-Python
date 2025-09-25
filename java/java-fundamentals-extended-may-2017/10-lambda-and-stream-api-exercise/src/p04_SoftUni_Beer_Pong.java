import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p04_SoftUni_Beer_Pong {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, LinkedHashMap<String, Integer>> tournamentData = new LinkedHashMap<>();

        while (!"stop the game".equals(inputLine)) {
            String[] tokens = inputLine.split("\\|");
            String playerName = tokens[0];
            String team = tokens[1];
            Integer score = Integer.parseInt(tokens[2]);

            if (!tournamentData.containsKey(team)) {
                tournamentData.put(team, new LinkedHashMap<>());
            }
            if (tournamentData.get(team).size() < 3) {
                tournamentData.get(team).put(playerName, score);
            }

            inputLine = scanner.nextLine();
        }

        LinkedHashMap<String, LinkedHashMap<String, Integer>> orderedTeams = tournamentData.entrySet().stream()
                .filter(a -> a.getValue().size() == 3)
                .sorted((a, b) -> {
                    int pointsTeamA = a.getValue().values().stream().mapToInt(Integer::valueOf).sum();
                    int pointsTeamB = b.getValue().values().stream().mapToInt(Integer::valueOf).sum();
                    return pointsTeamB - pointsTeamA;
                })
                .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

        int placeCounter = 1;

        for (Map.Entry<String, LinkedHashMap<String, Integer>> teamsEntry : orderedTeams.entrySet()) {
            String teamName = teamsEntry.getKey();
            LinkedHashMap<String, Integer> playersData = teamsEntry.getValue();
            
            LinkedHashMap<String, Integer> orderedPlayers = playersData.entrySet().stream()
                    .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                    .collect(Collectors.toMap(Map.Entry::getKey, Map.Entry::getValue, (a, b) -> a, LinkedHashMap::new));

            System.out.printf("%d. %s; Players:\n", placeCounter, teamName);

            for (Map.Entry<String, Integer> playerRecord : orderedPlayers.entrySet()) {
                System.out.printf("###%s: %d\n", playerRecord.getKey(), playerRecord.getValue());
            }
            placeCounter++;
        }
    }
}
