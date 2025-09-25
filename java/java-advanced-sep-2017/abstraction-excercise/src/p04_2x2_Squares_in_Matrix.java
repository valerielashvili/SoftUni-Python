import java.util.Scanner;

public class p04_2x2_Squares_in_Matrix {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int r = scanner.nextInt();
        int c = scanner.nextInt();
        scanner.nextLine();
        String[][] matrix = new String[r][c];

        for (int i = 0; i < r; i++) {
            String[] row = scanner.nextLine().split("\\s+");
            matrix[i] = row;
        }
        int result = countSquares(matrix);
        System.out.println(result);
    }

    private static int countSquares(String[][] matrix) {
        int count = 0;
        for (int i = 0; i < matrix.length - 1; i++) {
            for (int j = 0; j < matrix[0].length - 1; j++) {
                String l1 = matrix[i][j];
                String l2 = matrix[i][j + 1];
                String l3 = matrix[i + 1][j];
                String l4 = matrix[i + 1][j + 1];
                if (l1.equals(l2) && l2.equals(l3) && l3.equals(l4)) {
                    count++;
                }
            }
        }
        return count;
    }
}
