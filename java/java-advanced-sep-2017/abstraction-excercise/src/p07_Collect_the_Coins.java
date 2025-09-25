import java.util.Scanner;

public class p07_Collect_the_Coins {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        char[][] board = new char[4][];

        for (int i = 0; i < 4; i++) {
            board[i] = scanner.nextLine().toCharArray();
        }
        char[] commands = scanner.nextLine().toCharArray();

        int coins = 0;
        int wallHits = 0;
        int row = 0;
        int col = 0;

        if (board[row][col] == '$') {
            coins++;
        }

        for (char c : commands) {
            int lastRow = row;
            int lastCol = col;

            if (c == 'V') {
                row++;
            } else if (c == '>') {
                col++;
            } else if (c == '^') {
                row--;
            } else if (c == '<') {
                col--;
            }
            boolean isInBorders = checkBorders(board, row, col);

            if (!isInBorders) {
                row = lastRow;
                col = lastCol;
                wallHits++;
            } else if (board[row][col] == '$') {
                coins++;
            }
        }
        System.out.println("Coins = " + coins);
        System.out.println("Walls = " + wallHits);
    }

    private static boolean checkBorders(char[][] board, int r, int c) {
        return r >= 0 && c >= 0 && r < 4 && c < board[r].length;
    }
}
