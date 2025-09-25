import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p02_Icarus {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<Integer> planes = Arrays.stream(scanner.nextLine().split(" "))
                .mapToInt(Integer::parseInt).boxed().collect(Collectors.toCollection(ArrayList::new));

        int index = Integer.parseInt(scanner.nextLine());
        String inputLine = scanner.nextLine();

        int initialDamage = 1;

        while (!"Supernova".equals(inputLine)) {
            String[] commands = inputLine.split(" ");
            String direction = commands[0];
            int position = Integer.parseInt(commands[1]);
            int nextIndex = 0;

            if ("left".equals(direction)) {
                nextIndex = Math.abs(index - position) % planes.size();
                for (int i = index - 1; i >= nextIndex; i--) {
                    planes.set(i, planes.get(i) - 1);
                    index = i;
                }
            } else if ("right".equals(direction)) {
                nextIndex = Math.abs(index + position) % planes.size();
                for (int i = index + 1; i <= nextIndex; i++) {
                    planes.set(i, planes.get(i) - 1);
                }
            }

            inputLine = scanner.nextLine();
        }
        System.out.println(planes.stream().map(Object::toString).collect(Collectors.joining(" ")));
    }
}
