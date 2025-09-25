import java.util.Arrays;
import java.util.Scanner;

public class p05_Maximal_Sum {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();

        int[][] matrix = new int[r][c];

        for (int i = 0; i < r; i++) {
            int[] row = Arrays.stream(scanner.nextLine().split("\\s+")).mapToInt(Integer::parseInt).toArray();
            matrix[i] = row;
        }
        int[] sumAndPos = findMaximalSum(matrix);
        printMatrix(matrix, sumAndPos[0], sumAndPos[1], sumAndPos[2]);
    }

    private static void printMatrix(int[][] matrix, int maxSum, int startRow, int startCol) {
        System.out.println("Sum = " + maxSum);
        for (int i = 0; i < 3; i++) {
            for (int j = 0; j <3; j++) {
                System.out.print(matrix[startRow + i][startCol + j] + " ");
            }
            System.out.println();
        }
    }

    private static int[] findMaximalSum(int[][] matrix) {
        int maxSum = Integer.MIN_VALUE;
        int sum = 0;
        int[] sumAndPosition = new int[3];
        for (int i = 0; i < matrix.length - 2; i++) {
            for (int j = 0; j < matrix[0].length - 2; j++) {
                sum = matrix[i][j] + matrix[i][j+1] + matrix[i][j+2]
                        + matrix[i+1][j] + matrix[i+1][j+1] + matrix[i+1][j+2]
                        + matrix[i+2][j] + matrix[i+2][j+1] + matrix[i+2][j+2];
                if (maxSum < sum) {
                    maxSum = sum;
                    sumAndPosition[0] = maxSum;
                    sumAndPosition[1] = i;
                    sumAndPosition[2] = j;
                }
            }
        }
        return sumAndPosition;
    }
}
