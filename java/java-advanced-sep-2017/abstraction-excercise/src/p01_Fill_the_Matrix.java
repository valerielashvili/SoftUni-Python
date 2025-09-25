import java.util.Scanner;

public class p01_Fill_the_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] tokens = scanner.nextLine().split(",\\s+");
        int n = Integer.parseInt(tokens[0]);
        int[][] matrix = new int[n][n];

        if ("A".equals(tokens[1])) {
            matrix = fillByPatternA(n);
        } else if ("B".equals(tokens[1])) {
            matrix = fillByPatternB(n);
        }
        printMatrix(matrix);
    }

    private static void printMatrix(int[][] matrix) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.print(matrix[i][j] + " ");
            }
            System.out.println();
        }
    }

    private static int[][] fillByPatternB(int n) {
        int[][] result = new int[n][n];
        int counter = 1;
        for (int i = 0; i < n; i++) {
            if (i % 2 == 0) {
                for (int j = 0; j < n; j++) {
                    result[j][i] = counter++;
                }
            } else {
                for (int j = n - 1; j >= 0 ; j--) {
                    result[j][i] = counter++;
                }
            }
        }
        return result;
    }

    private static int[][] fillByPatternA(int n) {
        int[][] result = new int[n][n];
        int counter = 1;
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                result[j][i] = counter++;
            }
        }
        return result;
    }
}
