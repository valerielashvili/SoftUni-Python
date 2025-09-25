import java.util.ArrayList;
import java.util.Scanner;

public class p10_Plus_Remove {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        ArrayList<char[]> shapesList = new ArrayList<>();
        ArrayList<char[]> shapesCopy = new ArrayList<>();

        String inputLine = scanner.nextLine();
        while (!"END".equals(inputLine)) {
            shapesList.add(inputLine.toCharArray());
            shapesCopy.add(inputLine.toUpperCase().toCharArray());

            inputLine = scanner.nextLine();
        }
        manipulatePlusShapes(shapesList, shapesCopy);
        printResult(shapesList);

    }

    private static void printResult(ArrayList<char[]> shapesToPrint) {
        for (int i = 0; i < shapesToPrint.size(); i++) {
            System.out.println(String.valueOf(shapesToPrint.get(i)).replace("\0",""));
        }
    }

    private static void manipulatePlusShapes(ArrayList<char[]> shapesList, ArrayList<char[]> copyShapes) {

        for (int r = 0; r < shapesList.size() - 2; r++) {
            for (int c = 1; c < shapesList.get(r).length; c++) {
                try {
                    char charA = copyShapes.get(r)[c];
                    char charB = copyShapes.get(r + 1)[c - 1];
                    char charC = copyShapes.get(r + 1)[c];
                    char charD = copyShapes.get(r + 1)[c + 1];
                    char charE = copyShapes.get(r + 2)[c];

                    if (charA == charB && charB == charC && charC == charD && charD == charE) {
                        shapesList.get(r)[c] = '\0';
                        shapesList.get(r + 1)[c - 1] = '\0';
                        shapesList.get(r + 1)[c] = '\0';
                        shapesList.get(r + 1)[c + 1] = '\0';
                        shapesList.get(r + 2)[c] = '\0';
                    }
                } catch (IndexOutOfBoundsException e) {

                }
            }
        }
    }
}
