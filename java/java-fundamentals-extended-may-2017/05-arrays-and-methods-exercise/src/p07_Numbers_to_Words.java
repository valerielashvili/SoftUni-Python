import java.util.Scanner;

public class p07_Numbers_to_Words {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int n = Integer.parseInt(scanner.nextLine());
        String result = "";

        for (int i = 0; i < n; i++) {
            int number = Integer.parseInt(scanner.nextLine());
            result = letterizeNumber(number);
            System.out.println(result);
        }
    }

    static String letterizeNumber(int num) {
        String result = "";
        String hundredsArr[] = {"one-hundred", "two-hundred", "three-hundred", "four-hundred", "five-hundred",
                "six-hundred", "seven-hundred", "eight-hundred", "nine-hundred"};
        String teensArr[] = {"eleven", "twelve", "thirteen", "fourteen", "fifteen", "sixteen", "seventeen",
                "eighteen", "nineteen"};
        String tensArr[] = {"ten", "twenty", "thirty", "forty", "fifty", "sixty", "seventy", "eighty", "ninety"};
        String onesArr[] = {"one", "two", "three", "four", "five", "six", "seven", "eight", "nine"};

        int hundreds = 0, onesAndTeens = 0, tens = 0;
        String hundredsResult = "", teensResult = "", tensResult = "", onesResult = "";
        boolean isNegative = false;

        if (num > 999) {
            result = "too large";
        } else  if (num < -999) {
            result = "too small";
        }
        if ((num > 0 || num < 0) && num <= 999 && num >= -999) {
            if (num < 0) {
                // If the number is negative making it positive so our calculations could be correct
                isNegative = true;
                num = num * (-1);
            }
            //Calculating hundreds, ones and teens, and tens
            hundreds = num / 100;
            onesAndTeens = num % 10; // <- Ones and teens
            tens = (num % 100) / 10;
            if (num > 99) { // If the number does not have 3 digits the program won't print it
                if (num % 100 == 0) { // Checking for hundreds
                    for (int i = 0; i < hundreds; i++) {
                        result = hundredsArr[i];
                    }
                } else if (num % 100 <= 9) { // Checking numbers which last 2 digits are less than 10
                    for (int i = 0; i < hundreds; i++) { // (i.e. 101, 305, 609, etc.).
                        hundredsResult = hundredsArr[i];
                    }
                    for (int i = 0; i < onesAndTeens; i++) {
                        onesResult = onesArr[i];
                    }
                    result = hundredsResult + " and " + onesResult;
                } else if (num % 100 <= 19) { // Checking for teens (i.e. 111, 814, 919).
                    for (int i = 0; i < hundreds; i++) {
                        hundredsResult = hundredsArr[i];
                    }
                    for (int i = 0; i < onesAndTeens; i++) {
                        teensResult = teensArr[i];
                    }
                    result = hundredsResult + " and " + teensResult;
                } else if (num % 100 > 19) { // Checking numbers which last 2 digits are greater than 20
                    for (int i = 0; i < hundreds; i++) { // (i.e. 120, 345, 650, etc.).
                        hundredsResult = hundredsArr[i];
                    }
                    for (int i = 0; i < tens; i++) {
                        tensResult = tensArr[i];
                    }
                    for (int i = 0; i < onesAndTeens; i++) {
                        onesResult = onesArr[i];
                    } if (num % 10 == 0) {
                        result = hundredsResult + " and " + tensResult;
                    } else {
                        result = hundredsResult + " and " + tensResult + " " + onesResult;
                    }
                }
            }
            if (isNegative) {
                result = "minus " + result;
            }
        }
        return result;
    }
}
