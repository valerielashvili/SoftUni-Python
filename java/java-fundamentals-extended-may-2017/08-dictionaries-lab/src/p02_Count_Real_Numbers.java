import java.text.DecimalFormat;
import java.util.Arrays;
import java.util.Map;
import java.util.Scanner;
import java.util.TreeMap;
import java.util.regex.Pattern;

public class p02_Count_Real_Numbers {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        Pattern spacePattern = Pattern.compile(" ");
        double[] numbersInput = Arrays.stream(spacePattern.split(scanner.nextLine()))
                .mapToDouble(Double::parseDouble).toArray();

        TreeMap<Double, Integer> realNumbers = new TreeMap<>();

        for (int i = 0; i < numbersInput.length; i++) {
            if (!realNumbers.containsKey(numbersInput[i])) {
                realNumbers.put(numbersInput[i], 0);
            }
            realNumbers.put(numbersInput[i], realNumbers.get(numbersInput[i]) + 1);
        }

        DecimalFormat df = new DecimalFormat("#.####");

        for (Map.Entry<Double, Integer> entry : realNumbers.entrySet()) {
            double key = entry.getKey();
            int value = entry.getValue();
            String formattedKey = df.format(key);

            System.out.printf("%s -> %d\n", formattedKey, value);
        }
    }
}
