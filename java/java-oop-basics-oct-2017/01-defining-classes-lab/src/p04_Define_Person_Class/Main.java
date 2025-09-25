package p04_Define_Person_Class;

import java.util.ArrayList;
import java.util.List;

public class Main {
    public static void main(String[] args) {
        BankAccount account1 = new BankAccount(1, 30.0);
        BankAccount account2 = new BankAccount(1, 40.0);

        List<BankAccount> accounts = new ArrayList<>();
        accounts.add(account1);
        accounts.add(account2);

        Person andy = new Person("Andy Price", 32, accounts);

        double balance = andy.getBalance();
        System.out.println(balance);
    }
}
