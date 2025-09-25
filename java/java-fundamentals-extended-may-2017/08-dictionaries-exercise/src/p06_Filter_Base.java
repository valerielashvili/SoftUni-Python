import java.nio.charset.Charset;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Scanner;

public class p06_Filter_Base {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String inputLine = scanner.nextLine();

        LinkedHashMap<String, Integer> employeeByAge = new LinkedHashMap<>();
        LinkedHashMap<String, Double> employeeBySalary = new LinkedHashMap<>();
        LinkedHashMap<String, String> employeeByPosition = new LinkedHashMap<>();

        String[] inputTokens = new String[2];
        String name = "";
        String value = "";
        int age = 0;
        double salary = 0.0;
        String position = "";

        while (!"filter base".equals(inputLine)) {
            inputTokens = inputLine.split(" -> ");
            name = inputTokens[0];
            value = inputTokens[1];

            boolean isInt = valueIsInt(value);
            boolean isDouble = valueIsDouble(value);

            if (isInt) {
                age = Integer.parseInt(value);
                if (!employeeByAge.containsKey(name)) {
                    employeeByAge.put(name, age);
                }
            } else if (isDouble) {
                salary = Double.parseDouble(value);
                if (!employeeBySalary.containsKey(name)) {
                    employeeBySalary.put(name, salary);
                }
            } else {
                position = value;
                if (!employeeByPosition.containsKey(name)) {
                    employeeByPosition.put(name, position);
                }
            }

            inputLine = scanner.nextLine();
        }
        inputLine = scanner.nextLine();

        if ("Age".equals(inputLine)) {
            for (Map.Entry<String, Integer> entryByAge : employeeByAge.entrySet()) {
                name = entryByAge.getKey();
                age = entryByAge.getValue();
                System.out.printf("Name: %s\nAge: %d\n====================\n", name, age);
            }
        } else if ("Salary".equals(inputLine)) {
            for (Map.Entry<String, Double> entryBySalary : employeeBySalary.entrySet()) {
                name = entryBySalary.getKey();
                salary = entryBySalary.getValue();
                System.out.printf("Name: %s\nSalary: %.2f\n====================\n", name, salary);
            }
        } else if ("Position".equals(inputLine)) {
            for (Map.Entry<String, String> entryByPosition : employeeByPosition.entrySet()) {
                name = entryByPosition.getKey();
                position = entryByPosition.getValue();
                System.out.printf("Name: %s\nPosition: %s\n====================\n", name, position);
            }
        }
    }

    private static boolean valueIsInt (String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            if (!Character.isDigit(inputValue.charAt(i))) {
                return false;
            }
        }
        return true;
    }

    private static boolean valueIsDouble (String inputValue) {
        for (int i = 0; i < inputValue.length(); i++) {
            if ('.' == inputValue.charAt(i)) {
                return true;
            }
        }
        return false;
    }
}
