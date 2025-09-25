import java.math.BigInteger;
import java.util.Scanner;

public class p05_Pascals_Triangle {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        BigInteger[][] pascalPyramid = fillPyramid(n);

        for (int i = 0; i < pascalPyramid.length; i++) {
            for (int j = 0; j < pascalPyramid[0].length; j++) {
                if (pascalPyramid[i][j] != null) {
                    System.out.print(pascalPyramid[i][j] + " ");
                }
            }
            System.out.println();
        }
    }

    private static BigInteger[][] fillPyramid(int n) {
        BigInteger[][] result = new BigInteger[n][n];

        for (int row = 0; row < n; row++) {
            result[row][0] = BigInteger.ONE;
            result[row][row] = BigInteger.ONE;
            if (row > 1) {
                for (int col = 1; col < row; col++) {
                    BigInteger[] previousRow = result[row - 1];
                    BigInteger sum = previousRow[col - 1].add(previousRow[col]);
                    result[row][col] = sum;
                }
            }
        }
        return result;
    }
}
