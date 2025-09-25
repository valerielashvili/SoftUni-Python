import java.util.Scanner;

public class p06_Power_Plants {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split(" ");

        int[] plantsPowerLvl = new int[input.length];
        int passedDays = 0;
        int season = 0;

        for (int i = 0; i < plantsPowerLvl.length; i++) {
            plantsPowerLvl[i] = Integer.parseInt(input[i]);
        }

        while (true) {
            int powerSum = 0;

            for (int day = 0; day < plantsPowerLvl.length; day++) {
                powerSum = 0;
                for (int i = 0; i < plantsPowerLvl.length; i++) {
                    if (i != day && plantsPowerLvl[i] > 0) {
                        plantsPowerLvl[i]--;
                    }
                }
                passedDays++;

                for (int i = 0; i < plantsPowerLvl.length; i++) {
                    powerSum += plantsPowerLvl[i];
                }
                if (powerSum == 0) {
                    break;
                }
            }
            if (powerSum == 0) {
                break;
            }
            // All alive plants are blooming at the end of the season
            for (int i = 0; i < plantsPowerLvl.length; i++) {
                if (plantsPowerLvl[i] > 0) {
                    plantsPowerLvl[i]++;
                }
            }
            season++;
        }
        System.out.printf("survived %d days (%d seasons)", passedDays, season);
    }
}
