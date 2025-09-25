import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p05_Dict_Ref_Advanced {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, ArrayList<Integer>> dictRef = new LinkedHashMap<>();

        while (!"end".equals(inputLine)) {
            String[] tokens = inputLine.split(" -> |, ");
            String name = tokens[0];

            if (isNumber(tokens[1])) {
                if (!dictRef.containsKey(name)) {
                    dictRef.put(name, new ArrayList<>());
                }
                for (int i = 1; i < tokens.length; i++) {
                    dictRef.get(name).add(Integer.parseInt(tokens[i]));
                }
            } else {
                if (dictRef.containsKey(tokens[1])) {
                    dictRef.put(name, new ArrayList<>(dictRef.get(tokens[1])));
                }
            }
            inputLine = scanner.nextLine();
        }

        for (Map.Entry<String, ArrayList<Integer>> dictRefEntry : dictRef.entrySet()) {
            String nameToPrint = dictRefEntry.getKey();
            ArrayList<Integer> valueToPrint = dictRefEntry.getValue();

            System.out.printf("%s === %s\n", nameToPrint, valueToPrint.toString()
                    .replace("[", "")
                    .replace("]", ""));
        }
    }

    private static boolean isNumber(String token) {
        for (int i = 0; i < token.length(); i++) {
            if (!Character.isDigit(token.charAt(i))) {
                return false;
            }
        }
        return true;
    }
}
