import java.util.Arrays;
import java.util.Scanner;

public class p04_Maximum_Sum_of_2x2_Submatrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int[] dimensions = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        int rows = dimensions[0];
        int cols = dimensions[1];
        int[][] matrix = new int[rows][cols];

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split(", ")).mapToInt(Integer::parseInt).toArray();
        }

        int maxVal = Integer.MIN_VALUE;
        int row = 0;
        int col = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                int sum = matrix[i][j] + matrix[i][j + 1] + matrix[i + 1][j] + matrix[i + 1][j + 1];
                if (maxVal < sum) {
                    maxVal = sum;
                    row = i;
                    col = j;
                }
            }
        }
        System.out.printf("%d %d\n", matrix[row][col], matrix[row][col + 1]);
        System.out.printf("%d %d\n", matrix[row + 1][col], matrix[row + 1][col + 1]);
        System.out.println(maxVal);
    }
}
