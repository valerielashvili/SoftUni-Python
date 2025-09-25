import java.util.Scanner;

public class p11_Fortress {
    public static void main (String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int fortressWidth = 2 * n - 2; //Смятаме ширината на крепостта
        int sideCount = n / 2; //Смятаме лявата и дясната страни
        int underscoreCount = fortressWidth - sideCount * 2 - 2; //Смятаме централната част на първия и втория редове

        String fSides = repeatStr("^", sideCount);      //fortress Sides
        String underscore = repeatStr("_", underscoreCount);
        System.out.println("/" + fSides + "\\" + underscore + "/" + fSides + "\\");

        for (int i = 1; i <= n - 2; i++) {
            String innSpaces = repeatStr(" ", fortressWidth);
            String lastRow = "|" + innSpaces + "|";

            if (i == n - 2) {
                fortressWidth = fortressWidth - sideCount * 2;
                innSpaces = repeatStr(" ", sideCount + 1);
                lastRow = "|" + innSpaces + underscore + innSpaces + "|";
            }
            System.out.println(lastRow);
        }
        String fSidesBottom = repeatStr("_", sideCount);
        String bottomSpaces = repeatStr(" ", underscoreCount);
        System.out.println("\\" + fSidesBottom + "/" + bottomSpaces + "\\" + fSidesBottom + "/");
    }
    static String repeatStr (String stringToRepeat, int count) {
        String line = "";
        for (int i = 0; i < count; i++) {
            line += stringToRepeat;
        }
        return line;
    }
}
