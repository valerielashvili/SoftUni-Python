import java.util.Scanner;

public class p10_Count_NegativeElements_in_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int numArray[] = new int[n];
        int counter = 0;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            numArray[i] = num;

            if (numArray[i] < 0) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
