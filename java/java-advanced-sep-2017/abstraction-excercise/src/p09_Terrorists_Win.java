import java.util.Scanner;

public class p09_Terrorists_Win {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        while (inputLine.contains("|")) {
            int firstIndex = inputLine.indexOf("|");
            int endIndex = ordinalIndexOf(inputLine);
            String bomb = inputLine.substring(firstIndex + 1, endIndex);

            int bombPower = calculateBombPower(bomb);
            int startInjuryIndex = firstIndex - bombPower;
            int endInjuryIndex = endIndex + bombPower + 1;

            String destroyArea = "";
            if (firstIndex < bombPower) {
                destroyArea = inputLine.substring(0, endInjuryIndex);
            } else if (endInjuryIndex > inputLine.length()) {
                destroyArea = inputLine.substring(startInjuryIndex, inputLine.length());
            } else {
                destroyArea = inputLine.substring(startInjuryIndex, endInjuryIndex);
            }
            String charsToReplace = String.format("%0" + destroyArea.length() + "d", 0).replace("0", ".");
            inputLine = inputLine.replace(destroyArea, charsToReplace);
        }
        System.out.println(inputLine);
    }

    private static int calculateBombPower(String bomb) {
        int bombPower = 0;
        for (int i = 0; i < bomb.length(); i++) {
            bombPower += (int) bomb.charAt(i);
        }
        return bombPower % 10;
    }

    private static int ordinalIndexOf(String str) {
        int n = 2;
        int pos = str.indexOf("|");
        while (--n > 0 && pos != -1)
            pos = str.indexOf("|", pos + 1);
        return pos;
    }
}
