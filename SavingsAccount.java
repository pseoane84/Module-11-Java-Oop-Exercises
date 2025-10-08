// SavingsAccount.java
public class SavingsAccount extends BankAccount {
    /** Annual interest rate as a decimal (e.g., 0.03 for 3% APR). */
    private double annualInterestRate;

    public SavingsAccount(String accountNumber, double openingBalance, double annualInterestRate) {
        super(accountNumber, openingBalance);
        if (annualInterestRate < 0) {
            throw new IllegalArgumentException("annualInterestRate cannot be negative");
        }
        this.annualInterestRate = annualInterestRate;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }

    /** Update the APR; future interest uses the new rate. */
    public void setAnnualInterestRate(double newRate) {
        if (newRate < 0) throw new IllegalArgumentException("annualInterestRate cannot be negative");
        double old = this.annualInterestRate;
        this.annualInterestRate = newRate;
        // Log the change (amount 0.0 is fine; we care about the note)
        log("INTEREST_RATE_UPDATE", 0.0, String.format("APR: %.4f -> %.4f", old, newRate));
    }

    /**
     * Deposit with interest applied to the deposit amount (simple monthly credit).
     * Example: with 3% APR, monthlyRate = 0.03/12; deposit(500) adds 500 + (500 * monthlyRate).
     */
    @Override
    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit must be > 0");
        double monthlyRate = annualInterestRate / 12.0;

        // principal
        super.deposit(amount);

        // interest on this deposit
        double interest = amount * monthlyRate;
        if (interest > 0) {
            adjustBalance(interest);
            log("INTEREST_CREDIT", interest, "Monthly rate on deposit");
        }
    }

    /** Apply monthly interest to the current balance (optional helper). */
    public void applyMonthlyInterest() {
        double monthlyRate = annualInterestRate / 12.0;
        double interest = getBalance() * monthlyRate;
        if (interest > 0) {
            adjustBalance(interest);
            log("INTEREST_CREDIT", interest, "Monthly rate on full balance");
        }
    }

    @Override
    public String toString() {
        return "SavingsAccount {accountNumber='" + getAccountNumber() + "', balance=" 
               + getBalance() + ", annualInterestRate=" + annualInterestRate + "}";
    }
}
