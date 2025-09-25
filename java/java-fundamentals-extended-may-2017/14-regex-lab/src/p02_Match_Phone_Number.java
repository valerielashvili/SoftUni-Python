import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;
import java.util.stream.Collectors;

public class p02_Match_Phone_Number {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        List<String> phoneNumbers = new ArrayList<>();

        Pattern pattern = Pattern.compile("\\+359(\\s|-)2\\1\\d{3}\\1\\d{4}\\b");
        Matcher matcher = pattern.matcher(inputLine);

        while (matcher.find()) {
            phoneNumbers.add(matcher.group());
        }
        System.out.println(phoneNumbers.stream().collect(Collectors.joining(", ")));
    }
}
