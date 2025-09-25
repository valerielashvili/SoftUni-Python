import java.util.Scanner;

public class p17_Altitude {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String input = scanner.nextLine();
        String allCommands[] = input.split(" ");

        Double altitude = Double.parseDouble(allCommands[0]);

        for (int i = 1; i < allCommands.length - 1; i += 2) {
            String command = allCommands[i];
            Double newAltitude = Double.parseDouble(allCommands[i + 1]);

            if ("up".equals(command)) {
                altitude += newAltitude;

            } else if ("down".equals(command)) {
                altitude -= newAltitude;
            }
            if (altitude <= 0) {
                break;
            }
        }
        if (altitude <= 0) {
            System.out.println("crashed");
        } else {
            System.out.printf("got through safely. current altitude: %.0fm", altitude);
        }
    }
}
