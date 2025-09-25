import java.util.Scanner;

public class p11_Count_of_GivenElement_in_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String integersStr = scanner.nextLine();
        int num = Integer.parseInt(scanner.nextLine());
        int counter = 0;

        String integersArray[] = integersStr.split(" ");
        int numArray[] = new int[integersArray.length];

        for (int i = 0; i < integersArray.length; i++) {
            numArray[i] = Integer.parseInt(integersArray[i]);

            if (numArray[i] == num) {
                counter++;
            }
        }
        System.out.println(counter);
    }
}
