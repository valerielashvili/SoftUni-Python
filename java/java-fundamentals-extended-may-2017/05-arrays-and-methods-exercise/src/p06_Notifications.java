import java.util.Scanner;

public class p06_Notifications {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());

        String success = "";
        String error = "";

        for (int i = 0; i < n; i++) {

            String currentOperation = scanner.nextLine();

            if ("success".equals(currentOperation)) {

                String operationInput = scanner.nextLine();
                String messageInput = scanner.nextLine();
                success = showSuccess(operationInput, messageInput);
                System.out.println(success);

            } else if ("error".equals(currentOperation)) {

                String userInput = scanner.nextLine();
                int code = Integer.parseInt(scanner.nextLine());
                error = showError(userInput, code);
                System.out.println(error);

            }
            // The condition -
            // "If neither "success", nor "error" is given, nothing should be printed and the program should continue.",
            // executes by default without any necessity to write an "else" statement, because any other operationInput
            // different from "success" or "error" just won't enter the check and the program will continue continue
            // its execution.
        }
    }

    static String showSuccess(String operation, String message)
    {
        String repeatingChars = new String(new char[30]).replace("\0", "=");
        String result = "Successfully executed " + operation + ".\n" + repeatingChars + "\nMessage: " + message + ".";
        return result;
    }

    static String showError(String operation, int code)
    {
        String reason = "";
        if (code < 0) {
            reason = "Internal System Failure";
        } else {
            reason = "Invalid Client Data";
        }
        String repeatingChars = new String(new char[30]).replace("\0", "=");
        String result = "Error: Failed to execute " + operation + ".\n"
                + repeatingChars
                + "\nError Code: " + code
                + ".\nReason: " + reason + ".";
        return result;
    }
}
