import java.util.Arrays;
import java.util.Scanner;

public class p13_Blur_Filter {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int blurAmount = Integer.parseInt(scanner.nextLine());
        int row = scanner.nextInt();
        int column = scanner.nextInt();
        long[][] matrix = new long[row][column];
        scanner.nextLine();

        for (int i = 0; i < matrix.length; i++) {
            matrix[i] = Arrays.stream(scanner.nextLine().split("\\s+")).mapToLong(Long::parseLong).toArray();
        }

        // Use for loops if stream works slower
        /*for (int i = 0; i < matrix.length; i++) {
            String[] cells = scanner.nextLine().split("\\s+");
            for (int j = 0; j < matrix[0].length; j++) {
                matrix[i][j] = Long.parseLong(cells[j]);
            }
        }*/

        int rCoordinate = scanner.nextInt();
        int cCoordinate = scanner.nextInt();

        for (int r = 0; r < matrix.length; r++) {
            for (int c = 0; c < matrix[0].length; c++) {
                if (rCoordinate == r - 1) {
                    if (cCoordinate == c - 1 || cCoordinate == c || cCoordinate == c + 1) {
                        matrix[r][c] += blurAmount;
                    }
                } else if (rCoordinate == r) {
                    if (cCoordinate == c - 1 || cCoordinate == c || cCoordinate == c + 1) {
                        matrix[r][c] += blurAmount;
                    }
                } else if (rCoordinate == r + 1) {
                    if (cCoordinate == c - 1 || cCoordinate == c || cCoordinate == c + 1) {
                        matrix[r][c] += blurAmount;
                    }
                }
            }
        }

        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[i].length; j++) {
                System.out.printf("%d ", matrix[i][j]);
            }
            System.out.println();
        }
    }
}
