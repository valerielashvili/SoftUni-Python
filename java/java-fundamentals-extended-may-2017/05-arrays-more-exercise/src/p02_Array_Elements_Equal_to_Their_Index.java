import java.util.Scanner;

public class p02_Array_Elements_Equal_to_Their_Index {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String integersInput = scanner.nextLine();
        String[] integersStrArray = integersInput.split(" ");

        String intResult = integersEqualToIndex(integersStrArray);
        System.out.println(intResult);
    }

    static String integersEqualToIndex(String[] intsFromInput) {

        int[] integersArray = new int[intsFromInput.length];
        String result = "";

        for (int i = 0; i < integersArray.length; i++) {
            integersArray[i] = Integer.parseInt(intsFromInput[i]);

            if (i == integersArray[i]) {
                result += integersArray[i] + " ";
            }
        }
        return result.trim();
    }
}
