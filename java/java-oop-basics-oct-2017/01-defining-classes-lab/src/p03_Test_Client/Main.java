package p03_Test_Client;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class Main {
    private static HashMap<Integer, BankAccount> accounts = new HashMap<>();
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        String inputLine = reader.readLine();

        while (!"End".equals(inputLine)) {
            String[] tokens = inputLine.split("\\s++");
            int id = Integer.parseInt(tokens[1]);

            if ("Create".equals(tokens[0])) {
                createBankAccount(id);
            } else if ("Deposit".equals(tokens[0])) {
                depositAmount(id, tokens[2]);
            } else if ("Withdraw".equals(tokens[0])) {
                withdrawAmount(id, tokens[2]);
            } else if ("Print".equals(tokens[0])) {
                print(id);
            }
            inputLine = reader.readLine();
        }
    }

    private static void print(int id) {
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            System.out.println(accounts.get(id));
        }
    }

    private static void withdrawAmount(int id, String amount) {
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
           String message = accounts.get(id).withdraw(Double.parseDouble(amount));
           if (message.length() > 0) {
               System.out.println(message);
           }
        }
    }

    private static void depositAmount(int id, String amount) {
        if (!accounts.containsKey(id)) {
            System.out.println("Account does not exist");
        } else {
            accounts.get(id).deposit(Double.parseDouble(amount));
        }
    }

    private static void createBankAccount(int id) {
        if (accounts.containsKey(id)) {
            System.out.println("Account already exists");
        } else {
            BankAccount account = new BankAccount(id);
            accounts.putIfAbsent(id, account);
        }
    }
}
