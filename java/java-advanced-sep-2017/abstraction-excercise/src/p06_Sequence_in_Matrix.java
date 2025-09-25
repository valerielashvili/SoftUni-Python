import java.util.Scanner;

public class p06_Sequence_in_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] input = scanner.nextLine().split("\\s+");
        int r = Integer.parseInt(input[0]);
        int c = Integer.parseInt(input[1]);
        String[][] matrix = new String[r][c];

        for (int i = 0; i < r; i++) {
            matrix[i] = scanner.nextLine().split("\\s+");
        }
        String resultStr = checkLongestSequence(matrix);

        if (resultStr.equals("")) {
            resultStr = matrix[0][0] + ",";
        }
        resultStr = resultStr.substring(0, resultStr.length() - 2);
        System.out.println(resultStr);
    }

    private static String checkLongestSequence(String[][] matrix) {
        String longestSeq = "";
        int maxCount = 0;

        for (int row = 0; row < matrix.length; row++) {
            for (int col = 0; col < matrix[row].length; col++) {

                // Checking vertical
                int columnCnt = 0;
                String columnSequence = matrix[row][col] + ", ";
                for (int cell = row; cell < matrix.length - 1; cell++) {
                    if (matrix[cell][col].equals(matrix[cell + 1][col])){
                        columnCnt++;
                        columnSequence += matrix[row][col] + ", ";
                    } else {
                        break;
                    }
                }
                if (columnCnt > maxCount) {
                    maxCount = columnCnt;
                    longestSeq = columnSequence;
                }
                // Checking diagonal
                int diagonalCnt = 0;
                String diagonalSequence = matrix[row][col] + ", ";
                for (int cell = row; cell < Math.min(matrix.length - 1, matrix[row].length - 1); cell++) {
                    if (matrix[cell][cell].equals(matrix[cell + 1][cell + 1])) {
                        diagonalCnt++;
                        diagonalSequence += matrix[cell][cell] + ", ";
                    } else {
                        break;
                    }
                }
                if (diagonalCnt > maxCount) {
                    maxCount = diagonalCnt;
                    longestSeq = diagonalSequence;
                }
            }
        }
        return longestSeq;
    }
}
