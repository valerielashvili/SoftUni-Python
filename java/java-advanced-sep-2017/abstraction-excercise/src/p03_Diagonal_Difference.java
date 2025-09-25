import java.util.Arrays;
import java.util.Scanner;

public class p03_Diagonal_Difference {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int[][] matrix = new int[n][n];

        for (int i = 0; i < matrix.length; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }

        int firstSum = sumRightDiagonal(matrix);
        int secondSum = sumLeftDiagonal(matrix);
        int result = Math.abs(firstSum - secondSum);
        System.out.println(result);
    }

    private static int sumLeftDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (j == matrix[0].length - 1 - i) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }

    private static int sumRightDiagonal(int[][] matrix) {
        int sum = 0;
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                if (i == j) {
                    sum += matrix[i][j];
                }
            }
        }
        return sum;
    }
}
