import java.util.Scanner;

public class p05_String_Commander {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String strToManipulate = scanner.nextLine();
        String[] tokens = scanner.nextLine().split(" ");

        int times = 0;

        while (!"end".equals(tokens[0])) {
            String command = tokens[0];

            if ("Left".equals(command)) {
                times = Integer.parseInt(tokens[1]);
                strToManipulate = moveLeftElement(strToManipulate, times);

            } else if ("Right".equals(command)) {
                times = Integer.parseInt(tokens[1]);
                strToManipulate = moveRightElement(strToManipulate, times);

            } else if ("Delete".equals(command)) {
                int startIndex = Integer.parseInt(tokens[1]);
                int endIndex = Integer.parseInt(tokens[2]);
                strToManipulate = deleteElements(strToManipulate, startIndex, endIndex);

            } else if ("Insert".equals(command)) {
                int insertIndex = Integer.parseInt(tokens[1]);
                String insertElement = tokens[2];
                strToManipulate = insertElements(strToManipulate, insertIndex, insertElement);
            }

            tokens = scanner.nextLine().split(" ");
        }

        System.out.println(strToManipulate);
    }

    public static String moveLeftElement(String strToManipulate, int times) {
        int leftPart = times % strToManipulate.length();
        strToManipulate = strToManipulate.substring(leftPart) + strToManipulate.substring(0, leftPart);

        return strToManipulate;
    }

    public static String moveRightElement(String strToManipulate, int times) {
        int rightPart = times % strToManipulate.length();
        strToManipulate = strToManipulate.substring(strToManipulate.length() - rightPart, strToManipulate.length())
                + strToManipulate.substring(0, strToManipulate.length() - rightPart);

        return strToManipulate;
    }

    public static String deleteElements(String strToManipulate, int startIndex, int endIndex) {
        strToManipulate = strToManipulate.substring(0, startIndex)
                + strToManipulate.substring(endIndex + 1, strToManipulate.length());

        return strToManipulate;
    }

    public static String insertElements(String strToManipulate, int index, String element) {
        strToManipulate = strToManipulate.substring(0, index)
                + element
                + strToManipulate.substring(index, strToManipulate.length());

        return strToManipulate;
    }
}
