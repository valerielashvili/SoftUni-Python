import java.util.*;

public class p05_Points_Counter {
    public static void main(String[] args) {
        try {
            Scanner scanner = new Scanner(System.in);
            String inputLine = scanner.nextLine();

            LinkedHashMap<String, LinkedHashSet<Player>> playersData = new LinkedHashMap<>();
            String forbiddenSymbols = "[@%$*]";

            while (!"Result".equals(inputLine)) {
                Player player;
                String[] tokens = inputLine.split("\\|");
                tokens = Arrays.stream(tokens)
                        .map(e -> e = e.replaceAll(forbiddenSymbols, ""))
                        .toArray(String[]::new);

                boolean isTeam = isTeamName(tokens[0]);
                int score = Integer.parseInt(tokens[2]);

                if (isTeam) {
                    player = new Player(tokens[1], tokens[0], score);
                } else {
                    player = new Player(tokens[0], tokens[1], score);
                }

                playersData.putIfAbsent(player.getTeam(), new LinkedHashSet<>());

                // Using .peek() intermediate operation to avoid NoSuchElementException
                // while adding a large number of players amd removing duplicates of them
                playersData.values()
                        .stream().peek(e -> e.removeIf(p -> p.getName().equals(player.getName())))
                        .forEach(entry -> playersData.get(player.getTeam()).add(player));

                playersData.get(player.getTeam()).add(player);

                inputLine = scanner.nextLine();
            }

            // Sorting and printing the data
            playersData.entrySet()
                    .stream()
                    .sorted((t1, t2) -> {
                        long scoreSecondTeam = t2.getValue().stream().mapToInt(Player::getScore).sum();
                        long scoreFirstTeam = t1.getValue().stream().mapToInt(Player::getScore).sum();
                        int maxScoreSecond = t2.getValue().stream().mapToInt(Player::getScore).max().orElse(0);
                        int maxScoreFirst = t1.getValue().stream().mapToInt(Player::getScore).max().orElse(0);

                        if (scoreFirstTeam == scoreSecondTeam) {
                            return maxScoreSecond - maxScoreFirst;
                        }
                        return Long.compare(scoreSecondTeam, scoreFirstTeam);
                    })
                    .forEach(e -> {
                        System.out.printf("%s => %d\n", e.getKey(), e.getValue()
                                .stream()
                                .mapToLong(Player::getScore)
                                .sum());

                        Optional<Player> optionalName = e.getValue()
                                .stream()
                                .max((p1, p2) -> Integer.compare(p1.getScore(), p2.getScore()));

                        String nameToPrint = "";
                        if (optionalName.isPresent()) {
                            nameToPrint = optionalName.get().getName();
                        }
                        System.out.printf("Most points scored by %s\n", nameToPrint);
                    });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    public static boolean isTeamName(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (Character.isLowerCase(str.charAt(i))) {
                // The token is not a team name
                return false;
            }
        }
        return true;
    }
}

class Player {
    private String name;
    private String team;
    private int score = 0;

    public Player(String name, String team, int score) {
        this.name = name;
        this.team = team;
        this.score = score;
    }

    public String getName() {
        return name;
    }

    public String getTeam() {
        return team;
    }

    public int getScore() {
        return score;
    }
    public void setScore(int score) {
        this.score = score;
    }
}
