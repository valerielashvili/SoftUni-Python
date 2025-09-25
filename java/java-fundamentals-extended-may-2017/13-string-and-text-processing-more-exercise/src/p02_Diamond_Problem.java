import java.util.Scanner;

public class p02_Diamond_Problem {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        boolean isDiamond = false;
        int startIndex = inputLine.indexOf("<");

        while (startIndex != -1) {
            int endIndex = inputLine.indexOf(">", startIndex + 1);

            if (startIndex < endIndex) {
                int caratsSum = 0;
                String diamond = inputLine.substring(startIndex + 1, endIndex);
                caratsSum += findCarats(diamond);

                if (caratsSum > 0) {
                    System.out.printf("Found %d carat diamond\n", caratsSum);
                    isDiamond = true;
                }

                startIndex = inputLine.indexOf("<", endIndex + 1);
            } else {
                isDiamond = false;
                break;
            }
        }
        if (!isDiamond){
            System.out.println("Better luck next time");
        }
    }

    public static int findCarats(String diamond) {
        int carats = 0;
        for (int i = 0; i < diamond.length(); i++) {
            if (Character.isDigit(diamond.charAt(i))) {
                carats += Integer.parseInt(Character.toString(diamond.charAt(i)));
            }
        }
        return carats;
    }
}
