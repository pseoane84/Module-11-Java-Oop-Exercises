// CheckingAccount.java
public class CheckingAccount extends BankAccount {
    private final double overdraftLimit; // e.g., 200 means balance can go down to -200
    private final double overdraftFee;   // e.g., 35 charged when crossing into negative

    public CheckingAccount(String accountNumber, double openingBalance, double overdraftLimit) {
        this(accountNumber, openingBalance, overdraftLimit, 0.0);
    }

    public CheckingAccount(String accountNumber, double openingBalance,
                           double overdraftLimit, double overdraftFee) {
        super(accountNumber, openingBalance);
        if (overdraftLimit < 0)   throw new IllegalArgumentException("overdraftLimit cannot be negative");
        if (overdraftFee < 0)     throw new IllegalArgumentException("overdraftFee cannot be negative");
        this.overdraftLimit = overdraftLimit;
        this.overdraftFee = overdraftFee;
    }

    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be > 0");

        double before = getBalance();
        double after  = before - amount;

        // refuse if it would exceed the overdraft limit
        if (after < -overdraftLimit) return false;

        // perform the withdrawal
        adjustBalance(-amount);

        // if we crossed from non-negative to negative, charge fee (once per crossing)
        if (overdraftFee > 0 && before >= 0 && after < 0) {
            adjustBalance(-overdraftFee);
        }
        return true;
    }

    public double getOverdraftLimit() { return overdraftLimit; }
    public double getOverdraftFee()   { return overdraftFee; }

    @Override
    public String toString() {
        return "CheckingAccount {accountNumber='" + getAccountNumber() +
               "', balance=" + getBalance() +
               ", overdraftLimit=" + overdraftLimit +
               ", overdraftFee=" + overdraftFee + "}";
    }
}
