import java.util.LinkedHashMap;
import java.util.Scanner;

public class p05_User_Logins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, String> userRecords = new LinkedHashMap<>();

        String[] inputTokens = new String[2];
        String username = "";
        String password = "";
        int counter = 0;

        while (!"login".equals(inputLine)) {
            inputTokens = inputLine.split(" -> ");
            username = inputTokens[0];
            password = inputTokens[1];

            if (!userRecords.containsKey(username)) {
                userRecords.put(username, password);
            } else {
                userRecords.put(username, password);
            }

            inputLine = scanner.nextLine();
        }

        inputLine = scanner.nextLine();

        while (!"end".equals(inputLine)) {
            inputTokens = inputLine.split(" -> ");
            username = inputTokens[0];
            password = inputTokens[1];

            if (userRecords.containsKey(username) && userRecords.containsValue(password)) {
                System.out.printf("%s: logged in successfully%n", username);
            } else if (!userRecords.containsKey(username) || !userRecords.containsValue(password)) {
                System.out.printf("%s: login failed%n", username);
                counter++;
            }

            inputLine = scanner.nextLine();
        }
        System.out.printf("unsuccessful login attempts: %d%n", counter);
    }
}
