import java.util.Scanner;

public class p09_LargestElement_in_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        int numArray[] = new int[n]; // Declaring an array with capacity of the inputted 'n' number
        int maxValue = Integer.MIN_VALUE;

        for (int i = 0; i < n; i++) {
            int num = Integer.parseInt(scanner.nextLine());
            numArray[i] = num; // Assigning values to the array
            if (numArray[i] > maxValue) {
                maxValue = numArray[i];
            }
        }
        System.out.println(maxValue);
    }
}
