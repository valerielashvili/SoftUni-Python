import java.util.Scanner;

public class p11_String_Matrix_Rotation {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int rotation = Integer.parseInt(scanner.nextLine().split("[\\\\(\\\\)]")[1]);
        String inputLine = scanner.nextLine();

        StringBuilder textLines = new StringBuilder();
        int maxLength = 0;

        while (!"END".equals(inputLine)) {
            if (inputLine.length() > maxLength) {
                maxLength = inputLine.length();
            }
            textLines.append(inputLine).append("\n");

            inputLine = scanner.nextLine();
        }
        rotation /= 90;
        rotation %= 4;

        StringBuilder resultMatrix = new StringBuilder();
        if (rotation == 0) {
            resultMatrix = textLines;
        } else if (rotation == 1) {
            resultMatrix = rotateMatrix(textLines, maxLength);
        } else if (rotation == 2) {
            resultMatrix = textLines.reverse();
        } else if (rotation == 3) {
            resultMatrix = rotateMatrix(textLines, maxLength).reverse();
        }
        System.out.println(resultMatrix.toString());
    }

    private static StringBuilder rotateMatrix(StringBuilder textLines, int maxLength) {
        String[] matrix = textLines.toString().split("\n");
        StringBuilder result = new StringBuilder();
        for (int c = 0; c < maxLength; c++) {
            for (int r = matrix.length; r > 0; r--) {
                if (c >= matrix[r - 1].length()) {
                    result.append(" ");
                    continue;
                }
                result.append(matrix[r - 1].charAt(c));
            }
            result.append("\n");
        }
        return result;
    }
}
