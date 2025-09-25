import java.text.Collator;
import java.util.*;
import java.util.stream.Collectors;

public class p02_Command_Interpreter {
    static String[] stringsArray;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        stringsArray = scanner.nextLine().split("\\s+");

        String command = "";

        while (!"end".equals(command = scanner.nextLine())) {
            String[] tokens = command.split(" ");
            int start = 0;
            int count = 0;

            if ("reverse".equals(tokens[0])) {
                start = Integer.parseInt(tokens[2]);
                count = Integer.parseInt(tokens[4]);
                reverse(start, count);

            } else if ("sort".equals(tokens[0])) {
                start = Integer.parseInt(tokens[2]);
                count = Integer.parseInt(tokens[4]);
                sort(start, count);

            } else if ("rollLeft".equals(tokens[0])) {
                count = Integer.parseInt(tokens[1]);
                rollLeft(count);

            } else if ("rollRight".equals(tokens[0])) {
                count = Integer.parseInt(tokens[1]);
                rollRight(count);
            }
        }

        System.out.println(Arrays.toString(stringsArray));
    }

    private static boolean isValid(int start, int count) {
        boolean isInRange = start >= 0 && start < stringsArray.length;
        boolean isValidCount = count >= 0 && (start + count) <= stringsArray.length;

        if (isInRange && isValidCount) return true;
        else {
            System.out.println("Invalid input parameters.");
        }
        return false;
    }

    private static void reverse(int start, int count) {
        if (isValid(start, count)) {
            List<String> temp = Arrays.stream(stringsArray)
                    .skip(start)
                    .limit(count)
                    .collect(Collectors.toList());
            Collections.reverse(temp);
            System.arraycopy(temp.toArray(), 0, stringsArray, start, count);
        }
    }

    private static void sort(int start, int count) {
        if (isValid(start, count)) {
            Collator collator = Collator.getInstance(Locale.ENGLISH);

            if (isValid(start, count)) {
                String[] temp = Arrays.stream(stringsArray)
                        .skip(start)
                        .limit(count)
                        .sorted((a, b) -> collator.compare(a, b))
                        .toArray(String[]::new);
                System.arraycopy(temp, 0, stringsArray, start, count);
            }
        }
    }

    private static void rollLeft(int count) {
        if (count >= 0) {
            List<String> tempList = Arrays.asList(stringsArray);
            Collections.rotate(tempList, count * -1);
            stringsArray = tempList.stream().map(Object::toString).toArray(String[]::new);
        } else {
            System.out.println("Invalid input parameters.");
        }
    }

    private static void rollRight(int count) {
        if (count >= 0) {
            List<String> tempList = Arrays.asList(stringsArray);
            Collections.rotate(tempList, count);
            stringsArray = tempList.stream().map(Object::toString).toArray(String[]::new);
        } else {
            System.out.println("Invalid input parameters.");
        }
    }
}
