import java.util.LinkedHashMap;
import java.util.Scanner;

public class p05_Lambada_Expressions {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LinkedHashMap<String, String> lambada = new LinkedHashMap<>();

        String[] tokens = scanner.nextLine().split(" => ");
        while (!"lambada".equals(tokens[0])) {

            if ("dance".equals(tokens[0])) {
                lambada.entrySet().forEach(e -> {
                    lambada.put(e.getKey(), e.getKey() + "." + e.getValue());
                });

                tokens = scanner.nextLine().split(" => ");
                continue;
            }

            lambada.put(tokens[0], tokens[1]);
            tokens = scanner.nextLine().split(" => ");
        }

        lambada.entrySet().forEach(e -> {
            System.out.printf("%s => %s\n", e.getKey(), e.getValue());
        });
    }
}
