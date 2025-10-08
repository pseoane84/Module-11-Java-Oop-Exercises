public class Main {
    public static void main(String[] args) {

        // Exercise 0: Using the Example Person Class
        // Create an instance of Person
        // Use the instance to print "Hello, my name is [name] and I'm [age] years old."
        Person person = new Person("Simon", 24);
        System.out.println("Hello, my name is " + person.getName() + " and I'm " + person.getAge() + " years old.");

        // Exercise 1: Creating a Bank Account
        // Create a BankAccount instance
        // Perform deposit and withdrawal operations.
        BankAccount account = new BankAccount("123456", 1000);
        account.deposit(500);
        System.out.println("Balance after deposit: " + account.getBalance());

        boolean success = account.withdraw(200);
        System.out.println("Withdrawal successful: " + success);
        System.out.println("Balance after withdrawal: " + account.getBalance());

        boolean failed = account.withdraw(2000);
        System.out.println("Withdrawal successful: " + failed);

        System.out.println("Final: " + account);

        // Exercise 2: Creating a Savings Account
        // Create a SavingsAccount instance
        // Perform deposit operations with interest
        SavingsAccount sav = new SavingsAccount("S-001", 1000.0, 0.03); // 3% APR

        sav.deposit(500);
        System.out.println("Balance after deposit with interest: " + sav.getBalance());

        // (Optional) show polymorphism: BankAccount ref pointing to SavingsAccount
        BankAccount poly = new SavingsAccount("S-002", 200.0, 0.06); // 6% APR
        poly.deposit(100);
        System.out.println("Poly balance: " + poly.getBalance());

        // (Optional) apply monthly interest on entire balance
        sav.applyMonthlyInterest();
        System.out.println("Balance after applying monthly interest: " + sav.getBalance());
        System.out.println("Final: " + sav);

        // Exercise 3: Creating a Checking Account
        // Create a CheckingAccount instance
        // Perform withdrawal operations with overdraft
        CheckingAccount chk = new CheckingAccount("C-001", 300.0, 200.0, 35.0);

        System.out.println("Start balance: " + chk.getBalance());

        boolean w1 = chk.withdraw(200.0); // OK, stays positive
        System.out.println("Withdraw 200 -> " + w1 + " | balance: " + chk.getBalance());

        boolean w2 = chk.withdraw(150.0); // crosses into negative: fee applies
        System.out.println("Withdraw 150 -> " + w2 + " | balance: " + chk.getBalance());

        boolean w3 = chk.withdraw(200.0); // would exceed -200 limit -> refused
        System.out.println("Withdraw 200 -> " + w3 + " | balance: " + chk.getBalance());

        System.out.println("Final: " + chk);
    
        // Exercise 4: Managing Customer's Accounts
        // Create a BankCustomer instance
        // Add multiple accounts and display total balance
        BankCustomer cust1 = new BankCustomer("CUST-001", "Pablo Seoane");

        sav = new SavingsAccount("S-100", 1000.0, 0.03); // 3% APR
        sav.deposit(500.0); // adds 500 + monthly interest on deposit (≈ 1.25)

        chk = new CheckingAccount("C-200", 300.0, 200.0, 35.0);
        chk.withdraw(200.0);    // stays positive
        chk.withdraw(150.0);    // crosses negative, fee applies in our design

        cust1.addAccount(sav);
        cust1.addAccount(chk);

        // Show details
        cust1.printSummary();
        System.out.printf("Computed total balance: %.2f%n", cust1.getTotalBalance());

        // Exercise 5: Transaction History
        // Add transactions to accounts and retrieve history
        BankCustomer cust = new BankCustomer("CUST-002", "Pablo S.");

        SavingsAccount sav2 = new SavingsAccount("S-300", 1000.0, 0.03);
        sav2.deposit(500.0);              // logs DEPOSIT + INTEREST_CREDIT
        sav2.applyMonthlyInterest();      // if you kept this method, it should also log
        cust.addAccount(sav2);

        CheckingAccount chk2 = new CheckingAccount("C-900", 300.0, 200.0, 35.0);
        chk2.withdraw(200.0);             // WITHDRAW
        chk2.withdraw(150.0);             // WITHDRAW + OVERDRAFT_FEE
        chk2.withdraw(200.0);             // WITHDRAW_DECLINED (would exceed limit)
        cust.addAccount(chk2);

        // Retrieve and print histories
        System.out.println("\n--- SAVINGS HISTORY ---");
        sav2.printStatement();

        System.out.println("\n--- CHECKING HISTORY ---");
        chk2.printStatement();

        // Or iterate yourself:
        System.out.println("\nLast 3 transactions on checking:");
        chk2.getHistory().stream()
        .skip(Math.max(0, chk2.getHistory().size() - 3))
        .forEach(t -> System.out.printf("%s - %s: %.2f (bal: %.2f) %s%n",
                t.timestamp(), t.type(), t.amount(), t.balanceAfter(),
                t.note() == null ? "" : "- " + t.note()));

            // Exercise 6: Generate Banking Report
            // Generate and display a customer's banking report
        }
    
        static void runExercise6() {
            BankCustomer cust = new BankCustomer("CUST-003", "Pablo Seoane");
    
            SavingsAccount sav = new SavingsAccount("S-777", 1000.0, 0.03);
            sav.deposit(500.0);
            // If you kept this method and it logs interest on the full balance, you can call it:
            // sav.applyMonthlyInterest();
    
            CheckingAccount chk = new CheckingAccount("C-888", 300.0, 200.0, 35.0);
            chk.withdraw(200.0);
            chk.withdraw(150.0);
            chk.withdraw(200.0);
    
            cust.addAccount(sav);
            cust.addAccount(chk);
    
            BankingReport.printCustomerReport(cust);
        }

        // Exercise 7: Update Interest Rates
        // Update the interest rate and observe calculations

        // Exercise 8: Override Withdrawal Method
        // Demonstrate overridden withdrawal method

        // Complete all exercises and print results
}