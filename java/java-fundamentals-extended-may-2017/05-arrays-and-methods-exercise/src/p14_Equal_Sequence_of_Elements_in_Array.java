import java.util.Scanner;

public class p14_Equal_Sequence_of_Elements_in_Array {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String integersStr = scanner.nextLine();

        String integersStrArr[] = integersStr.split(" ");
        int integersArr[] = new int[integersStrArr.length];

        boolean isEqual = true;
        int currentInt = 0;
        int previousInt = Integer.parseInt(integersStrArr[0]);

        for (int i = 0; i < integersStrArr.length - 1; i++) {
            integersArr[i] = Integer.parseInt(integersStrArr[i]);

            currentInt = integersArr[i];

            if (previousInt != currentInt) {
                isEqual = false;
                break;
            }
            previousInt = currentInt;
        }

        if (isEqual) {
            System.out.println("Yes");
        } else {
            System.out.println("No");
        }
    }
}
