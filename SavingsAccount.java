public class SavingsAccount extends BankAccount {
    private final double annualInterestRate; // as a percentage, e.g., 2.5 for 2.5%

    public SavingsAccount(String accountNumber, double openingBalance, double annualInterestRate) {
        super(accountNumber, openingBalance);           
        if (annualInterestRate < 0) {
            throw new IllegalArgumentException("annualInterestRate must be non-negative");
        }
        this.annualInterestRate = annualInterestRate;
    }

    public double getAnnualInterestRate() {
        return annualInterestRate;
    }
    /**
     * Deposit with interest applied to the deposit amount (simple monthly credit).
     * Example: with 3% APR, monthlyRate = 0.03/12; deposit(500) actually adds 500 + (500 * monthlyRate).
     */

    @Override
    public void deposit(double amount) {
        double monthlyRate = annualInterestRate / 12.0;
        double interestOnDeposit = amount * monthlyRate;
        super.deposit(amount + interestOnDeposit);
    }

    public void applyMonthlyInterest() {
        double monthlyRate = annualInterestRate / 12.0;
        double interest = getBalance() * monthlyRate;
        if (interest > 0) super.deposit(interest);
    }

    @Override
    public String toString() {
        return "SavingsAccount {accountNumber='" + getAccountNumber() + "', balance=" + getBalance() + ", annualInterestRate=" + annualInterestRate + "}";
    }
    
}
