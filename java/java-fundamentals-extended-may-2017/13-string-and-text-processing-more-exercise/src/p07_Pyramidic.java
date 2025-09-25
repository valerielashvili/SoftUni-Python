import java.util.ArrayList;
import java.util.Comparator;
import java.util.LinkedHashMap;
import java.util.Scanner;

public class p07_Pyramidic {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        ArrayList<String> inputStrings = new ArrayList<>();
        LinkedHashMap<String, ArrayList<String>> pyramids = new LinkedHashMap<>();

        Character singleChar = null;
        int nameCounter = 1;

        for (int i = 0; i < n; i++) {
            inputStrings.add(scanner.nextLine());
        }

        for (int i = 0; i < inputStrings.size(); i++) {
            String currentString = inputStrings.get(i);

            for (int j = 0; j < currentString.length(); j++) {
                singleChar = currentString.charAt(j);
                int charCount = 1;

                for (int k = i; k < inputStrings.size(); k++) {
                    String charsToCompare = new String(new char[charCount]).replace('\0', singleChar);
                    String pyramidName = "p" + nameCounter;

                    if (inputStrings.get(k).contains(charsToCompare)) {
                        pyramids.putIfAbsent(pyramidName, new ArrayList<>());
                        pyramids.get(pyramidName).add(charsToCompare);
                    } else {
                        break;
                    }
                    charCount += 2;
                }
                nameCounter++;
            }
        }
        pyramids.entrySet()
                .stream()
                .max(Comparator.comparing(entry -> entry.getValue().size())).get().getValue()
                .forEach(v -> System.out.println(v));
    }
}
