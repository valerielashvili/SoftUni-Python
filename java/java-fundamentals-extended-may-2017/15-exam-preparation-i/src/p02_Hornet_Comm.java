import java.util.ArrayList;
import java.util.Scanner;

public class p02_Hornet_Comm {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        ArrayList<String> privateMessages = new ArrayList<>();
        ArrayList<String> broadcasts = new ArrayList<>();

        while (!"Hornet is Green".equals(inputLine)) {
            if (inputLine.contains(" <-> ")) {
                String[] tokens = inputLine.split(" <-> ");
                String message = "";

                if (tokens.length == 2) {
                    if (isNumeric(tokens[0]) && isAlphanumeric(tokens[1])) {
                        // The input data is a private message
                        StringBuilder recipientsCode = new StringBuilder(tokens[0]);
                        recipientsCode.reverse();
                        message = tokens[1];
                        privateMessages.add(recipientsCode + " -> " + message);
                    } else if (!isNumeric(tokens[0]) && isAlphanumeric(tokens[1])) {
                        // The input data is a broadcast
                        message = tokens[0];
                        String frequency = tokens[1];

                        frequency = changeLetters(frequency);

                        broadcasts.add(frequency + " -> " + message);
                    }
                }
            }
            inputLine = scanner.nextLine();
        }

        System.out.println("Broadcasts:");
        if (broadcasts.size() != 0) {
            for (int i = 0; i < broadcasts.size(); i++) {
                System.out.println(broadcasts.get(i));
            }
        } else {
            System.out.println("None");
        }

        System.out.println("Messages:");
        if (privateMessages.size() != 0) {
            for (int i = 0; i < privateMessages.size(); i++) {
                System.out.println(privateMessages.get(i));
            }
        } else {
            System.out.println("None");
        }
    }

    public static boolean isNumeric(String input) {
        //boolean isDigit = false;
        for (int i = 0; i < input.length(); i++) {
            if (!Character.isDigit(input.charAt(i))) {
                return false;
            }
        }
        return true;
    }
    public static boolean isAlphanumeric(String input) {
        boolean digitOrLetter = false;
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i)) || Character.isLetter(input.charAt(i))) {
                digitOrLetter = true;
            } else {
                digitOrLetter = false;
                break;
            }
        }
        return digitOrLetter;
    }
    public static String changeLetters(String input) {
        char[] chars = input.toCharArray();
        for (int i = 0; i < chars.length; i++) {
            if (!Character.isUpperCase(chars[i])) {
                if (Character.isDigit(input.charAt(i))) {
                    continue;
                }
                chars[i] = Character.toUpperCase(chars[i]);
            } else {
                chars[i] = Character.toLowerCase(chars[i]);
            }
        }
        return new String(chars);
    }
}
