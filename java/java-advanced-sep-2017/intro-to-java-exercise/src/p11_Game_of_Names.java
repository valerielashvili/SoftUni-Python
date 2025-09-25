import java.util.LinkedHashMap;
import java.util.Scanner;

public class p11_Game_of_Names {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        LinkedHashMap<String, Integer> players = new LinkedHashMap<>();

        while (n * 2 > 0) {
            String name = scanner.nextLine();
            int score = Integer.parseInt(scanner.nextLine());

            players.putIfAbsent(name, score);
            n--;
        }

        players.entrySet().forEach(p -> {
            int finalScore = p.getValue();
            for (int i = 0; i < p.getKey().length(); i++) {
                int charValue = p.getKey().charAt(i);
                if (charValue % 2 == 0) {
                    finalScore += charValue;
                } else {
                    finalScore -= charValue;
                }
            }
            players.replace(p.getKey(), p.getValue(), finalScore);
        });

        players.entrySet()
                .stream()
                .sorted((p1, p2) -> p2.getValue().compareTo(p1.getValue()))
                .limit(1)
                .forEach(e -> System.out.printf("The winner is %s - %d points", e.getKey(), e.getValue()));
    }
}
