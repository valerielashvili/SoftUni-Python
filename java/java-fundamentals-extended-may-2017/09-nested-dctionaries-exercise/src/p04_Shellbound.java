import java.util.ArrayList;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p04_Shellbound {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, ArrayList<Integer>> shellData = new LinkedHashMap<>();

        String region = "";
        int shellCount = 0;

        while (!"Aggregate".equals(inputLine)) {
            String[] tokens = inputLine.split(" ");
            region = tokens[0];
            shellCount = Integer.parseInt(tokens[1]);

            if (!shellData.containsKey(region)) {
                shellData.put(region, new ArrayList<>());
            }
            if (!shellData.get(region).contains(shellCount)) {
                shellData.get(region).add(shellCount);
            }
            
            inputLine = scanner.nextLine();
        }

        for (Map.Entry<String, ArrayList<Integer>> shellDataEntry : shellData.entrySet()) {
            String regionName = shellDataEntry.getKey();
            ArrayList<Integer> shellSize = shellDataEntry.getValue();
            int giantShellSize = shellData.get(regionName).stream().mapToInt(a -> a.intValue()).sum()
                    - (int)shellData.get(regionName).stream().mapToDouble(s -> s.intValue()).average().getAsDouble();

            System.out.printf("%s -> %s (%d)\n", regionName,
                    shellSize.toString().replace("[", "").replace("]", ""),
                    giantShellSize);
        }
    }
}
