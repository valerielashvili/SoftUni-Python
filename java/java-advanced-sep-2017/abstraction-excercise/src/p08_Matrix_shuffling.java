import java.util.Scanner;

public class p08_Matrix_shuffling {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] size =scanner.nextLine().split("\\s+");
        int row = Integer.parseInt(size[0]);
        int col = Integer.parseInt(size[1]);

        String[][] matrix = new String[row][col];

        for (int i = 0; i < row; i++) {
            matrix[i] = scanner.nextLine().split("\\s++");
        }

        String inputLine = scanner.nextLine();

        while (!"END".equals(inputLine)) {
            String[] tokens = inputLine.split("\\s+");

            if (isValidInput(tokens, row, col)) {
                int row1 = Integer.parseInt(tokens[1]);
                int col1 = Integer.parseInt(tokens[2]);
                int row2 = Integer.parseInt(tokens[3]);
                int col2 = Integer.parseInt(tokens[4]);

                String cellToSwap1 = matrix[row1][col1];
                String cellToSwap2 = matrix[row2][col2];
                matrix[row1][col1] = cellToSwap2;
                matrix[row2][col2] = cellToSwap1;

                for (int i = 0; i < row; i++) {
                    for (String cell : matrix[i]) {
                        System.out.printf("%s ", cell);
                    }
                    System.out.println();
                }
            } else {
                System.out.println("Invalid input!");
            }

            inputLine = scanner.nextLine();
        }
    }

    private static boolean isValidInput(String[] tokens, int row, int col) {
        boolean inputCheck = false;

        if (tokens.length == 5) {
            int r1 = Integer.parseInt(tokens[1]);
            int c1 = Integer.parseInt(tokens[2]);
            int r2 = Integer.parseInt(tokens[3]);
            int c2 = Integer.parseInt(tokens[4]);

            inputCheck = "swap".equals(tokens[0]) &&
                    r1 >= 0 && c1 >= 0 && r2 >= 0 && c2 >= 0 &&
                    r1 <= row && r2 <= row && c1 <= col && c2 <= col;
        }
        return inputCheck;
    }
}
