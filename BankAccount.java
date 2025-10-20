import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankAccount {
    private final String accountNumber;
    private double balance;

    private final List<Transaction> history = new ArrayList<>();

    public BankAccount(String accountNumber, double openingBalance) {
        if (accountNumber == null || accountNumber.isBlank()) {
            throw new IllegalArgumentException("accountNumber is required");
        }
        if (openingBalance < 0) {
            throw new IllegalArgumentException("openingBalance must be non-negative");
        }
        this.accountNumber = accountNumber;
        this.balance = openingBalance;

        // log account opening
        history.add(new Transaction(
                LocalDateTime.now(), "OPEN",
                openingBalance, this.balance, "Opening balance"));
    }

    public void deposit(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Deposit amount must be positive");
        balance += amount;
        log("DEPOSIT", amount, null);
    }

    /** Returns true if withdrawal succeeded; false if insufficient funds. */
    public boolean withdraw(double amount) {
        if (amount <= 0) throw new IllegalArgumentException("Withdrawal amount must be positive");
        if (amount > balance) {
            log("WITHDRAW_DECLINED", amount, "Insufficient funds");
            return false;
        }
        balance -= amount;
        log("WITHDRAW", amount, null);
        return true;
    }

    public String getAccountNumber() { return accountNumber; }
    public double getBalance() { return balance; }

    public List<Transaction> getHistory() {
        return Collections.unmodifiableList(history);
    }

   
    public void recordTransaction(String entry) {
        if (entry == null || entry.isBlank()) {
            throw new IllegalArgumentException("transaction entry required");
        }
        log("NOTE", 0.0, entry);
    }

    public List<Transaction> getTransactionHistory() {
        return getHistory();
    }

    public void printStatement() {
        System.out.println("Statement for " + accountNumber);
        for (Transaction t : history) {
            System.out.printf("%s | %-17s | %8.2f | %8.2f | %s%n",
                    t.timestamp(), t.type(), t.amount(), t.balanceAfter(),
                    t.note() == null ? "" : t.note());
        }
    }

    @Override
    public String toString() {
        return "BankAccount {accountNumber='" + accountNumber + "', balance=" + balance + "}";
    }

    // ---- for subclasses (Checking/Savings) ----
    protected void adjustBalance(double delta) { this.balance += delta; }
    protected void log(String type, double amount, String note) {
        history.add(new Transaction(LocalDateTime.now(), type, amount, this.balance, note));
    }
}
