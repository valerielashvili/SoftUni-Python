package p05_Static_Id_and_Rate;

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
            String[] tokens = inputLine.split("\\s+");

            if ("Create".equals(tokens[0])) {
                createAccount();
            } else if ("Deposit".equals(tokens[0])) {
                depositAmount(Integer.parseInt(tokens[1]), Double.parseDouble(tokens[2]));
            } else if ("SetInterest".equals(tokens[0])) {
                BankAccount.setInterestRate(Double.parseDouble(tokens[1]));
            } else if ("GetInterest".equals(tokens[0])) {
                requestInterest(Integer.parseInt(tokens[1]), Integer.parseInt(tokens[2]));
            }

            inputLine = reader.readLine();
        }
    }

    private static void requestInterest(int id, int years) {
        if (accounts.containsKey(id)) {
            double accountInterest = accounts.get(id).getInterest(years);
            System.out.printf("%.2f\n", accountInterest);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void depositAmount(int id, double amount) {
        if (accounts.containsKey(id)) {
            accounts.get(id).deposit(amount);
            System.out.printf("Deposited %.0f to ID%d\n", amount, id);
        } else {
            System.out.println("Account does not exist");
        }
    }

    private static void createAccount() {
        BankAccount account = new BankAccount();
        accounts.put(account.getId(), account);
        System.out.printf("Account ID%d created\n", account.getId());
    }
}
