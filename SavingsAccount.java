public class SavingsAccount extends BankAccount {
    /** Annual interest rate as a decimal, e.g., 0.03 = 3% APR. */
    private double annualInterestRate;

    /** Do not allow withdrawals that would drop balance below this threshold. */
    private final double minimumBalance;

    // Keep your existing constructor for backwards compatibility (min = 0)
    public SavingsAccount(String accountNumber, double openingBalance, double annualInterestRate) {
        this(accountNumber, openingBalance, annualInterestRate, 0.0);
    }

    // New constructor with minimumBalance
    public SavingsAccount(String accountNumber, double openingBalance,
                          double annualInterestRate, double minimumBalance) {
        super(accountNumber, openingBalance);
        if (annualInterestRate < 0) throw new IllegalArgumentException("annualInterestRate cannot be negative");
        if (minimumBalance < 0)     throw new IllegalArgumentException("minimumBalance cannot be negative");
        this.annualInterestRate = annualInterestRate;
        this.minimumBalance = minimumBalance;
    }

    public double getAnnualInterestRate() { return annualInterestRate; }
    public void setAnnualInterestRate(double newRate) {
        if (newRate < 0) throw new IllegalArgumentException("annualInterestRate cannot be negative");
        double old = this.annualInterestRate;
        this.annualInterestRate = newRate;
        log("INTEREST_RATE_UPDATE", 0.0, String.format("APR: %.4f -> %.4f", old, newRate));
    }
    public double getMinimumBalance() { return minimumBalance; }

    /** Interest-bearing deposit (interest on deposit amount, monthly rate). */
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

    /** OVERRIDE: refuse withdrawals that would breach the minimum balance. */
    @Override
    public boolean withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal must be > 0");
        double after = getBalance() - amount;
        if (after < minimumBalance) {
            log("WITHDRAW_DECLINED", amount,
                "Would breach minimum balance (min: " + minimumBalance + ")");
            return false;
        }
        adjustBalance(-amount);
        log("WITHDRAW", amount, null);
        return true;
    }

    /** Optional helper if you kept it: apply monthly interest to the whole balance. */
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
        return "SavingsAccount {accountNumber='" + getAccountNumber() +
               "', balance=" + getBalance() +
               ", annualInterestRate=" + annualInterestRate +
               ", minimumBalance=" + minimumBalance + "}";
    }
}
