import java.util.Scanner;

public class p04_Phone {
    static Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) {
        String[] phoneNumsInput = scanner.nextLine().split(" ");
        String[] namesInput = scanner.nextLine().split(" ");
        String[] commandInput = scanner.nextLine().split(" ");

        while (!"done".equals(commandInput[0])) {
            if ("call".equals(commandInput[0])) {
                String callResult = callCheck(phoneNumsInput, namesInput, commandInput[1]);
                System.out.println(callResult);
            } else if ("message".equals(commandInput[0])) {
                String messageResult = messageCheck(phoneNumsInput, namesInput, commandInput[1]);
                System.out.println(messageResult);
            }
            commandInput = scanner.nextLine().split(" ");
        }
    }

    static String callCheck(String[] phoneNumsArr, String[] namesArr, String command) {
        String result = "";

        for (int i = 0; i < phoneNumsArr.length; i++) {

            if (command.equals(namesArr[i])) {
                result += String.format("calling %s...\n", phoneNumsArr[i]);
                result += numberSumCheck(phoneNumsArr[i]);
            } else if (command.equals(phoneNumsArr[i])) {
                result += String.format("calling %s...\n", namesArr[i]);
                result += numberSumCheck(phoneNumsArr[i]);
            }
        }
        return result;
    }

    static String numberSumCheck(String number) {
        char[] numberToChar = number.toCharArray();
        String digitToString = "";
        long sumOfDigits = 0;
        long minutes = 0, seconds = 0;
        String result = "";

        for (char digit : numberToChar) {
            if (digit >= 47 && digit <= 57) {
                digitToString = String.valueOf(digit);
                sumOfDigits += Long.parseLong(digitToString);
            }
        }
        //Calculating minutes and seconds
        minutes = sumOfDigits / 60;
        seconds = sumOfDigits % 60;

        if (sumOfDigits % 2 != 0) {
            result += String.format("no answer");
        } else if (sumOfDigits % 2 == 0) {
            result += String.format("call ended. duration: %02d:%02d", minutes, seconds);
        }
        return result;
    }

    static String messageCheck(String[] phoneNumsArr, String[] namesArr, String command) {
        String result = "";

        for (int i = 0; i < phoneNumsArr.length; i++) {

            if (command.equals(namesArr[i])) {
                result += String.format("sending sms to %s...\n", phoneNumsArr[i]);
                result += numberDiffCheck(phoneNumsArr[i]);
            } else if (command.equals(phoneNumsArr[i])) {
                result += String.format("sending sms to %s...\n", namesArr[i]);
                result += numberDiffCheck(phoneNumsArr[i]);
            }
        }
        return result;
    }

    static String numberDiffCheck (String number) {
        char[] numberToChar = number.toCharArray();
        String digitToString = "";
        long diffOfDigits = 0;
        String result = "";

        for (char digit : numberToChar) {
            if (digit >= 47 && digit <= 57) {
                digitToString += String.valueOf(digit);
                diffOfDigits -= Long.parseLong(digitToString);
            }
        }

        if (diffOfDigits % 2 != 0) {
            result = String.format("busy");
        } else if (diffOfDigits % 2 == 0) {
            result = String.format("meet me there");
        }
        return result;
    }
}