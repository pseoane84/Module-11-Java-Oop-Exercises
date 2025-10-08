import java.text.NumberFormat;
import java.time.format.DateTimeFormatter;
import java.util.List;
import java.util.Locale;

public final class BankingReport {
    private static final DateTimeFormatter TS = DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm:ss");
    private static final NumberFormat MONEY = NumberFormat.getCurrencyInstance(Locale.US);

    private BankingReport() {
        // prevent instantiation
    }

    public static void main(String[] args) {
        System.out.println("BankingReport main method placeholder.");
        // You can add code here to test printCustomerReport or other functionality.
    }

    public static void printCustomerReport(BankCustomer customer) {
        System.out.println("========== Banking Report ==========");
        System.out.println("Customer: " + customer.getName() + " (" + customer.getId() + ")");
        System.out.printf("Accounts: %d%n", customer.getAccounts().size());
        System.out.printf("Total Balance: %s%n%n", MONEY.format(customer.getTotalBalance()));

        double totalDeposits = 0, totalWithdrawals = 0, totalInterest = 0, totalFees = 0;
        int declinedCount = 0;

        for (BankAccount a : customer.getAccounts()) {
            List<Transaction> hist = a.getHistory();
            System.out.println(" Transactions (" + hist.size() + "):");
            for (Transaction t : hist) {
                System.out.printf("    %s | %-17s | %8.2f | %s",
                        TS.format(t.timestamp()), t.type(), t.amount(), MONEY.format(t.balanceAfter()));
                if (t.note() != null && !t.note().isBlank()) System.out.print(" | " + t.note());
                System.out.println();
                    switch (t.type()) {
                        case "DEPOSIT":
                            totalDeposits += t.amount();
                            break;
                        case "WITHDRAW":
                            totalWithdrawals += t.amount();
                            break;
                        case "INTEREST_CREDIT":
                            totalInterest += t.amount();
                            break;
                        case "OVERDRAFT_FEE":
                            totalFees += t.amount();
                            break;
                        case "WITHDRAW_DECLINED":
                            declinedCount++;
                            break;
                    }
            }
            System.out.println();
        }

        System.out.println("--- Totals Across Accounts ---");
        System.out.printf("Total Deposits: %s%n", MONEY.format(totalDeposits));
        System.out.printf("Total Withdrawals: %s%n", MONEY.format(totalWithdrawals));
        System.out.printf("Interest Credited: %s%n", MONEY.format(totalInterest));
        System.out.printf("Overdraft Fees: %s%n", MONEY.format(totalFees));
        System.out.printf("Declined Withdrawals: %d%n", declinedCount);
        System.out.println("====================================");
    }
}