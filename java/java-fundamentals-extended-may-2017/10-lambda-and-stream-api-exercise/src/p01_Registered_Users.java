import java.time.LocalDate;
import java.time.format.DateTimeFormatter;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class p01_Registered_Users {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, LocalDate> registeredUsers = new LinkedHashMap<>();

        while (!"end".equals(inputLine)) {
            String[] tokens = inputLine.split(" -> ");
            String name = tokens[0];
            LocalDate parsedDate = parseDate(tokens[1]);

            registeredUsers.put(name, parsedDate);

            inputLine = scanner.nextLine();
        }

        registeredUsers.entrySet().stream()
                .sorted((a, b) -> {
                    if (a.getValue().compareTo(b.getValue()) == 0) {
                        return -1;
                    }
                    return a.getValue().compareTo(b.getValue());
                })
                .limit(5)
                .sorted((a, b) -> b.getValue().compareTo(a.getValue()))
                .forEach(e -> {
                    System.out.println(e.getKey());
                });
    }

    private static LocalDate parseDate(String dateInput) {
        // Creating DateTimeFormatter to parse a date from a string using our custom pattern.
        DateTimeFormatter formatter = DateTimeFormatter.ofPattern("dd/MM/yyy");
        LocalDate date = LocalDate.parse(dateInput, formatter);

        return date;
    }
}
