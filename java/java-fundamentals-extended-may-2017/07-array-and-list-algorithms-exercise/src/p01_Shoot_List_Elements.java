import java.util.ArrayList;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p01_Shoot_List_Elements {
    static ArrayList<Integer> intList;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        intList = new ArrayList<>();
        int lastRemovedInt = 0;

        while (!"stop".equals(inputLine)) {
            boolean isDigit = checkDigit(inputLine);

            if (isDigit) {
                intList.add(0, Integer.parseInt(inputLine));
            } else {
                if ("bang".equals(inputLine)) {
                    if (intList.size() <= 0) {
                        System.out.printf("nobody left to shoot! last one was %d\n", lastRemovedInt);
                        return;
                    }
                    lastRemovedInt = removeElement();
                    System.out.printf("shot %d\n", lastRemovedInt);
                }
            }
            inputLine = scanner.nextLine();
        }

        if (intList.size() > 0) {
            System.out.printf("survivors: %s\n", intList
                    .stream()
                    .map(Object::toString)
                    .collect(Collectors.joining(" ")));
        } else {
            System.out.printf("you shot them all. last one was %d\n", lastRemovedInt);
        }
    }

    private static boolean checkDigit(String input) {
        for (int i = 0; i < input.length(); i++) {
            if (Character.isDigit(input.charAt(i))) {
                return true;
            }
        }
        return false;
    }

    private static double getAverage() {
        double average = 0;
        for (int i = 0; i < intList.size(); i++) {
            average += intList.get(i);
        }
        average /= intList.size();
        return average;
    }

    private static int removeElement() {
        int lastRemoved = 0;
        double average = getAverage();

        for (int i = 0; i < intList.size(); i++) {
            if (intList.get(i) <= average) {
                lastRemoved = intList.get(i);
                intList.remove(i);
                break;
            }
        }
        // Since Integer objects are immutable we can't increment the value in place.
        // Alternatively, we can use a mutable integer type, like AtomicInteger.
        for (int j = 0; j < intList.size(); j++) {
            int tmpInt = intList.get(j);
            tmpInt -= 1;
            intList.set(j, tmpInt);
        }
        return lastRemoved;
    }
}
