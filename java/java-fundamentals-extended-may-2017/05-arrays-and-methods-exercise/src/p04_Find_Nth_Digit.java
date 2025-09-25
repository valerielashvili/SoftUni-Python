import java.util.Scanner;

public class p04_Find_Nth_Digit {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        long num = scanner.nextLong();
        int index = scanner.nextInt();

        int result = findNthDigit(num, index);

        System.out.println(result);
    }

    static int findNthDigit(long number, int index) {
        int counter = 0;
        long digitFound = 0;
        while (counter != index) {
            counter++;
            if (counter != index) {
                number /= 10;
            } else {
                number %= 10;
            }
            digitFound = number;
        }
        return (int)digitFound;
    }
}
