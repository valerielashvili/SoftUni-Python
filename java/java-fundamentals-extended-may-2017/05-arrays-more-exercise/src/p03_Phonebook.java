import java.util.Scanner;

public class p03_Phonebook {
    static Scanner scanner = new Scanner(System.in);
    public static void main(String[] args) {
        String phoneNumsInput = scanner.nextLine();
        String namesInput = scanner.nextLine();

        String foundNumber = findTheNumber(phoneNumsInput, namesInput);
        System.out.println(foundNumber);
    }

    static String findTheNumber(String phones, String names) {
        String[] phoneNumsArr = phones.split(" ");
        String[] namesArr = names.split(" ");

        String compareTheName = "";
        String result = "";

        while (!"done".equals(compareTheName)) {
            compareTheName = scanner.nextLine();

            for (int i = 0; i < phoneNumsArr.length; i++) {
                if (compareTheName.equals(namesArr[i])) {
                    result += String.format("%s -> %s\n", namesArr[i], phoneNumsArr[i]);
                } else if ("done".equals(compareTheName)) {
                    break;
                }
            }
        }
        return result;
    }
}
