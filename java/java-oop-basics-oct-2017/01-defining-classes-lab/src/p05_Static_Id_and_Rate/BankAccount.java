package p05_Static_Id_and_Rate;

public class BankAccount {
    private final static double DEFAULT_INTEREST_RATE = 0.02;

    private static double rate = DEFAULT_INTEREST_RATE;
    private static int bankAccountCount;

    private int id;
    private double balance;

    BankAccount() {
        this.id = ++bankAccountCount;
    }

    static void setInterestRate(double interest) {
        rate = interest;
    }

    void deposit(double amount) {
        this.balance += amount;
    }

    int getId() {
        return this.id;
    }

    double getInterest(int years) {
        return this.balance * rate * years;
    }

    @Override
    public String toString() {
        return "ID" + this.id;
    }
}
