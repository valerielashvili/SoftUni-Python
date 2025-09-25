package p06_Football_Team_Generator;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        HashMap<String, Team> teams = new HashMap<>();

        while (!"END".equals(inputLine)) {
            String[] tokens = inputLine.split(";");
            String playerName;
            String teamName;

            try {
                if ("team".equalsIgnoreCase(tokens[0])) {
                    Team team = new Team(tokens[1]);
                    teams.put(tokens[1], team);
                } else if ("add".equalsIgnoreCase(tokens[0])) {
                    playerName = tokens[2];
                    teamName = tokens[1];

                    if (!teams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.\n", teamName);
                    } else {
                        double endurance = Double.parseDouble(tokens[3]);
                        double sprint = Double.parseDouble(tokens[4]);
                        double dribble = Double.parseDouble(tokens[5]);
                        double passing = Double.parseDouble(tokens[6]);
                        double shooting = Double.parseDouble(tokens[7]);
                        Player player = new Player(playerName, endurance, sprint, dribble, passing, shooting);
                        teams.get(teamName).addPlayer(player);
                    }
                } else if ("remove".equalsIgnoreCase(tokens[0])) {
                    playerName = tokens[2];
                    teamName = tokens[1];
                    if (!teams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.\n", teamName);
                    } else {
                        teams.get(teamName).removePlayer(playerName);
                    }
                } else if ("rating".equalsIgnoreCase(tokens[0])) {
                    teamName = tokens[1];
                    if (!teams.containsKey(teamName)) {
                        System.out.printf("Team %s does not exist.\n", teamName);
                    } else {
                        teams.get(teamName).calculateTeamRating();
                        System.out.printf("%s - %.0f\n", teamName, teams.get(teamName).getRating());
                    }
                }
            } catch (IllegalArgumentException iae) {
                System.out.println(iae.getMessage());
            }

            inputLine = reader.readLine();
        }
    }
}
