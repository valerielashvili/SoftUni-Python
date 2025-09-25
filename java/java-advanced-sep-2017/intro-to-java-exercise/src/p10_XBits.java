import java.util.Scanner;

public class p10_XBits {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String[] binaryNums = new String[8];

        for (int i = 0; i < binaryNums.length; i++) {
            binaryNums[i] = String.format("%32s", Integer.toBinaryString(Integer.parseInt(scanner.nextLine())))
                    .replace(" ", "0");
        }

        int counter = 0;
        for (int i = 0; i < binaryNums.length - 2; i++) {
            for (int j = 0; j <= binaryNums[i].length() - 3; j++) {
                int firstGroup = Integer.parseInt(binaryNums[i].substring(j, j + 3), 2);
                int secondGroup = Integer.parseInt(binaryNums[i + 1].substring(j, j + 3), 2);
                int thirdGroup = Integer.parseInt(binaryNums[i + 2].substring(j, j + 3), 2);

                // Valid X-bits combinations - "101", "010", "101", correspond to the
                // following decimal numbers - "5", "2" and "5" respectively.
                if (firstGroup == 5 && secondGroup == 2 && thirdGroup == 5) {
                    counter++;
                }
            }
        }
        System.out.println(counter);
    }
}
