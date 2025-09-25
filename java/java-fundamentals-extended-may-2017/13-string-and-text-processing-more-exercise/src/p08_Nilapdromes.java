import java.util.Scanner;

public class p08_Nilapdromes {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String nilapdrome = scanner.nextLine();

        int borderLength = 0;
        String leftBorder = "";
        String rightBorder = "";
        String core = "";

        while (!"end".equals(nilapdrome)) {
            borderLength = nilapdrome.length() / 2;
            leftBorder = nilapdrome.substring(0, borderLength);

            if (nilapdrome.length() % 2 == 0) {
                rightBorder = nilapdrome.substring(borderLength, nilapdrome.length());
            } else {
                rightBorder = nilapdrome.substring(borderLength + 1, nilapdrome.length());
            }

            while (!leftBorder.equals(rightBorder) && leftBorder.length() > 0) {
                leftBorder = leftBorder.substring(0, leftBorder.length() - 1);
                rightBorder = rightBorder.substring(1, rightBorder.length());
            }

            borderLength = leftBorder.length();

            if (leftBorder.equals(rightBorder) && borderLength > 0) {
                core = nilapdrome.substring(borderLength, nilapdrome.length() - rightBorder.length());

                if (!core.isEmpty()) {
                    nilapdrome = core + rightBorder + core;
                    System.out.println(nilapdrome);
                }
            }

            nilapdrome = scanner.nextLine();
        }
    }
}
