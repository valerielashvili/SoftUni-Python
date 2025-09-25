import java.util.ArrayList;
import java.util.Arrays;
import java.util.Scanner;
import java.util.regex.Pattern;

public class p01_Rabbit_Hole {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Using pattern to reach better performance while splitting.
        // Regex anyway creates it every time we split a string.
        Pattern spacePattern = Pattern.compile(" ");
        ArrayList<String> commandsList = new ArrayList<>(Arrays.asList(spacePattern.split(scanner.nextLine())));
        int energy = Integer.parseInt(scanner.nextLine());

        int index = 0;
        boolean isExploaded = false;

        do {
            int length = commandsList.size();
            Pattern pipePattern = Pattern.compile("\\|");
            String[] currentCommand = pipePattern.split(commandsList.get(index));
            String action = currentCommand[0];

            if ("RabbitHole".equals(action)) {
                System.out.println("You have 5 years to save Kennedy!");
                break;
            }

            int energyValue = Integer.parseInt(currentCommand[1]);

            if ("Left".equals(action)) {
                index = Math.abs(index - energyValue) % length;
                energy -= energyValue;
            } else if ("Right".equals(action)) {
                index = Math.abs(index + energyValue) % length;
                energy -= energyValue;
            } else if ("Bomb".equals(action)) {
                commandsList.remove(index);
                energy -= energyValue;
                index = 0;
                isExploaded = true;
            }

            length = commandsList.size();

            if (!"RabbitHole".equals(commandsList.get(length - 1))) {
                commandsList.remove(commandsList.get(length - 1));
            }
            commandsList.add("Bomb|" + energy);

        } while (energy > 0);

        if (!isExploaded && energy <= 0) {
            System.out.println("You are tired. You can't continue the mission.");
        } else if (isExploaded && energy <= 0) {
            System.out.println("You are dead due to bomb explosion!");
        }

    }
}
