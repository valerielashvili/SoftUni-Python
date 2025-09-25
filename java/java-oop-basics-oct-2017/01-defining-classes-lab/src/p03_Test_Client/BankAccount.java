package p03_Test_Client;

class BankAccount {
    private int id;
    private double balance;

    BankAccount(int id) {
        this.id = id;
        this.balance = 0.0;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    String withdraw(double amount) {
        if (balance - amount < 0) {
            return "Insufficient balance";
        } else {
            this.balance -= amount;
        }
        return "";
    }

    @Override
    public String toString() {
        return String.format("Account ID%d, balance %.2f", this.id, this.balance);
    }
}
