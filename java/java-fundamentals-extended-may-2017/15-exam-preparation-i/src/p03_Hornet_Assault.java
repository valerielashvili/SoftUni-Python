import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.stream.Collectors;

public class p03_Hornet_Assault {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String beehivesInput = scanner.nextLine();
        String hornetsInput = scanner.nextLine();

        ArrayList<Long> beehives = new ArrayList<>();
        ArrayList<Long> hornets = new ArrayList<>();

        if (beehivesInput.length() > 0) {
            beehives = Arrays.stream(beehivesInput.split(" "))
                    .mapToLong(Long::parseLong).boxed().collect(Collectors.toCollection(ArrayList::new));
        }
        if (hornetsInput.length() > 0) {
            hornets = Arrays.stream(hornetsInput.split(" "))
                    .mapToLong(Long::parseLong).boxed().collect(Collectors.toCollection(ArrayList::new));
        }

        for (int i = 0; i < beehives.size(); i++) {
            long hornetsPower = hornets.stream().mapToLong(Long::valueOf).sum();
            long beesAlive = beehives.get(i) - hornetsPower;

            if (beehives.get(i) >= hornetsPower) {
                if (hornets.size() > 0) {
                    hornets.remove(0);
                    if (beesAlive <= 0) {
                        beehives.remove(i);
                        i--;
                    } else {
                        beehives.set(i, beesAlive);
                    }
                }
            } else {
                beehives.remove(i);
                i--;
            }
        }

        if (beehives.size() > 0) {
            System.out.println(beehives.stream().map(Object::toString).collect(Collectors.joining(" ")));
        } else {
            if (hornets.size() > 0) {
                System.out.println(hornets.stream().map(Object::toString).collect(Collectors.joining(" ")));
            }
        }
    }
}
