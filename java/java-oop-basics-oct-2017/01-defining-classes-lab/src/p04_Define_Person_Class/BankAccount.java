package p04_Define_Person_Class;

class BankAccount {
    private int id;
    private double balance;

    BankAccount(int id, double amount) {
        this.id = id;
        this.balance = amount;
    }

    double getBalance() {
        return this.balance;
    }
}
