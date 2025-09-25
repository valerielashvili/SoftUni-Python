package p04_Define_Person_Class;

import java.util.List;

class Person {
    private String name;
    private int age;
    private List<BankAccount> accounts;

    public Person(String name, int age) {
        this.name = name;
        this.age = age;
    }

    public Person(String name, int age, List<BankAccount> accounts) {
        this(name, age);
        this.accounts = accounts;
    }

    public double getBalance() {
        return this.accounts.stream().mapToDouble(BankAccount::getBalance).sum();
    }
}
