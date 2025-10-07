public class BankAccount {
    private final String accountNumber;
    private double balance;         

    public BankAccount(String accountNumber, double openingBalance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("accountNumber is required");
        }
        if (openingBalance < 0) {
            throw new IllegalArgumentException("openingBalance must be non-negative");
        }
        this.accountNumber = accountNumber;
        this.balance = openingBalance;
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
    }
    
    /** Returns true if withdrawal succeeded; false if insufficient funds. */
    public boolean withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (amount > balance) return false; // Insufficient funds
        balance -= amount;
        return true;
    }

    public String getAccountNumber() {return accountNumber; }   
    public double getBalance() {return balance; }

    @Override
    public String toString() {
        return "BankAccount {accountNumber='" + accountNumber + "', balance=" + balance + "}";
    }

    protected void adjustBalance(double delta) {
    this.balance += delta; // used by subclasses (e.g., for overdraft math)
    }
}
