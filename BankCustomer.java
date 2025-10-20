import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

public class BankCustomer {
    private final String id;
    private final String name;
    private final List<BankAccount> accounts = new ArrayList<>();

    public BankCustomer(String id, String name) {
        if (id == null || id.isBlank()) throw new IllegalArgumentException("id required");
        if (name == null || name.isBlank()) throw new IllegalArgumentException("name required");
        this.id = id;
        this.name = name;
    }

    public void addAccount(BankAccount account) {
        if (account == null) throw new IllegalArgumentException("account required");
        accounts.add(account);
    }

    /** Sum balances across all accounts (BankAccount, SavingsAccount, CheckingAccount, etc.). */
    public double getTotalBalance() {
        double total = 0.0;
        for (BankAccount a : accounts) total += a.getBalance();
        return total;
    }

    /** Read-only view so callers can iterate without mutating the internal list. */
    public List<BankAccount> getAccounts() {
        return Collections.unmodifiableList(accounts);
    }

    public String getId() { return id; }
    public String getName() { return name; }

    /** Convenience: print a small statement. */
    public void printSummary() {
        System.out.println("Customer: " + name + " (" + id + ")");
        for (BankAccount a : accounts) {
            System.out.println(" - " + a); // uses each account's toString()
        }
        System.out.println("Total balance: " + getTotalBalance());
    }

    public void generateReport() {
        System.out.println("Customer: " + name + " (" + id + ")");
        for (BankAccount a : accounts) {
            System.out.println(" - " + a.toString());
        }
        System.out.printf("Total balance: %.2f%n", getTotalBalance());
    }

    @Override
    public String toString() {
        return "BankCustomer{id='" + id + "', name='" + name + "', accounts=" + accounts.size() + "}";
    }
}
