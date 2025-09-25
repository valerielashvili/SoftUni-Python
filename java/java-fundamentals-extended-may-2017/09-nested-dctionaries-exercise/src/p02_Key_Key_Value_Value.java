import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p02_Key_Key_Value_Value {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        String keyToSearch = scanner.nextLine();
        String valueToSearch = scanner.nextLine();
        int n = Integer.parseInt(scanner.nextLine());

        LinkedHashMap<String, ArrayList<String>> map = new LinkedHashMap<>();

        for (int i = 0; i < n; i++) {
            String inputLine = scanner.nextLine();
            String[] tokens = inputLine.split(" => |;");
            String key = tokens[0];

            if (key.contains(keyToSearch)) {
                map.put(key, new ArrayList<>());

                for (int j = 0; j < tokens.length; j++) {
                    if (tokens[j].contains(valueToSearch)) {
                        map.get(key).add(tokens[j]);
                    }
                }
            }
        }

        for (Map.Entry<String, ArrayList<String>> mapEntry : map.entrySet()) {
            String mapKey = mapEntry.getKey();
            ArrayList<String> mapValue = mapEntry.getValue();

            System.out.printf("%s:\n", mapKey);

            for (String valueToPrint : mapValue) {
                System.out.printf("-%s\n", valueToPrint);
            }
        }
    }
}
