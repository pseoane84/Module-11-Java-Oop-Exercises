public class Main {
 public static void main(String[] args) {
    // runExercise0();
    // runExercise1();
    // runExercise2();
    // runExercise3();
    // runExercise4();
    // runExercise5();
    // runExercise6();
    // runExercise7();
    runExercise8();
}

        // Exercise 0: Using the Example Person Class
        // Create an instance of Person
        // Use the instance to print "Hello, my name is [name] and I'm [age] years old."
    static void runExercise0() {
        Person person = new Person("Simon", 24);
        System.out.println("Hello, my name is " + person.getName() + " and I'm " + person.getAge() + " years old.");
    }

    // Exercise 1: Creating a Bank Account
    // Create a BankAccount instance
    // Perform deposit and withdrawal operations.
    static void runExercise1() {
        BankAccount account = new BankAccount("123456", 1000);
        account.deposit(500);
        System.out.println("Balance after deposit: " + account.getBalance());

        boolean success = account.withdraw(200);
        System.out.println("Withdrawal successful: " + success);
        System.out.println("Balance after withdrawal: " + account.getBalance());

        boolean failed = account.withdraw(2000);
        System.out.println("Withdrawal successful: " + failed);

        System.out.println("Final: " + account);
    }
    // Exercise 2: Creating a Savings Account
    // Create a SavingsAccount instance
    // Perform deposit operations with interest

    static void runExercise2() {
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

    }
    // Exercise 3: Creating a Checking Account
    // Create a CheckingAccount instance
    // Perform withdrawal operations with overdraft

    static void runExercise3() {
        CheckingAccount chk = new CheckingAccount("C-001", 300.0, 200.0, 35.0);

        System.out.println("Start balance: " + chk.getBalance());

        boolean w1 = chk.withdraw(200.0); // OK, stays positive
        System.out.println("Withdraw 200 -> " + w1 + " | balance: " + chk.getBalance());

        boolean w2 = chk.withdraw(150.0); // crosses into negative: fee applies
        System.out.println("Withdraw 150 -> " + w2 + " | balance: " + chk.getBalance());

        boolean w3 = chk.withdraw(200.0); // would exceed -200 limit -> refused
        System.out.println("Withdraw 200 -> " + w3 + " | balance: " + chk.getBalance());

        System.out.println("Final: " + chk);
    }

    // Exercise 4: Managing Customer's Accounts
    // Create a BankCustomer instance
    // Add multiple accounts and display total balance

    static void runExercise4() {
        BankCustomer cust1 = new BankCustomer("CUST-001", "Pablo Seoane");

        SavingsAccount sav = new SavingsAccount("S-100", 1000.0, 0.03); // 3% APR
        sav.deposit(500.0); // adds 500 + monthly interest on deposit (≈ 1.25)

        CheckingAccount chk = new CheckingAccount("C-200", 300.0, 200.0, 35.0);
        chk.withdraw(200.0); // stays positive
        chk.withdraw(150.0); // crosses negative, fee applies in our design

        cust1.addAccount(sav);
        cust1.addAccount(chk);

        // Show details
        cust1.printSummary();
        System.out.printf("Computed total balance: %.2f%n", cust1.getTotalBalance());
    }

    // Exercise 5: Transaction History
    // Add transactions to accounts and retrieve history
    static void runExercise5() {

        BankCustomer cust = new BankCustomer("CUST-002", "Pablo S.");

        SavingsAccount sav2 = new SavingsAccount("S-300", 1000.0, 0.03);
        sav2.deposit(500.0); // logs DEPOSIT + INTEREST_CREDIT
        sav2.applyMonthlyInterest(); // if you kept this method, it should also log
        sav2.recordTransaction("Customer requested monthly statement");
        cust.addAccount(sav2);

        CheckingAccount chk2 = new CheckingAccount("C-900", 300.0, 200.0, 35.0);
        chk2.withdraw(200.0); // WITHDRAW
        chk2.withdraw(150.0); // WITHDRAW + OVERDRAFT_FEE
        chk2.withdraw(200.0); // WITHDRAW_DECLINED (would exceed limit)
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
    }

    // Exercise 6: Generate Banking Report
    // Generate and display a customer's banking report
    // runExercise6(); // Uncomment to run
    static void runExercise6() {
        BankCustomer cust = new BankCustomer("CUST-001", "Pablo Seoane");
    SavingsAccount sav = new SavingsAccount("S-100", 1000.0, 0.03);
    CheckingAccount chk = new CheckingAccount("C-200", 300.0, 200.0, 35.0);
    cust.addAccount(sav);
    cust.addAccount(chk);
    cust.generateReport();
    }

    // Exercise 7: Update Interest Rates
    // Update the interest rate and observe calculations
    static void runExercise7() {
        System.out.println("\n=== Exercise 7: Update Interest Rates ===");
        SavingsAccount sav = new SavingsAccount("S-APR", 1000.0, 0.03); // 3% APR

        // Deposit BEFORE rate change (3% APR -> 0.25% monthly)
        sav.deposit(600.0); // adds 600 + 1.50
        System.out.printf("After $600 deposit at 3%% APR: %.2f%n", sav.getBalance()); // 1601.50

        // Update APR to 6%
        sav.setAnnualInterestRate(0.06);
        System.out.println("APR updated to 6%.");

        // Deposit AFTER rate change (6% APR -> 0.5% monthly)
        sav.deposit(400.0); // adds 400 + 2.00
        System.out.printf("After $400 deposit at 6%% APR: %.2f%n", sav.getBalance()); // 2003.50

        // Apply monthly interest on full balance at the new rate
        sav.applyMonthlyInterest(); // + (2003.50 * 0.5%) = +10.02
        System.out.printf("After monthly interest on full balance at 6%% APR: %.2f%n", sav.getBalance()); // 2013.52

        // Optional: print the transaction log
        System.out.println("\n-- Savings Statement --");
        sav.printStatement();
    }

    // Exercise 8: Override Withdrawal Method
    // Demonstrate overridden withdrawal method
    static void runExercise8() {
        System.out.println("\n=== Exercise 8: Override Withdrawal Method ===");

        BankAccount base = new BankAccount("B-100", 500.0);
        SavingsAccount sav = new SavingsAccount("S-100", 500.0, 0.03, 200.0); // min balance = 200

        // Try to withdraw 350 from both accounts
        boolean baseOk = base.withdraw(350.0); // leaves 150, allowed by base class
        boolean savOk1 = sav.withdraw(350.0); // would leave 150 < 200 -> declined by override

        System.out.println("Base withdraw 350 -> " + baseOk + " | balance: " + base.getBalance());
        System.out.println("Savings withdraw 350 (min 200) -> " + savOk1 + " | balance: " + sav.getBalance());

        // Withdraw 250 from savings (500 - 250 = 250 >= 200) -> allowed
        boolean savOk2 = sav.withdraw(250.0);
        System.out.println("Savings withdraw 250 -> " + savOk2 + " | balance: " + sav.getBalance());

        // Polymorphism: a BankAccount reference pointing to a SavingsAccount
        BankAccount poly = new SavingsAccount("S-200", 400.0, 0.04, 150.0);
        boolean polyOk = poly.withdraw(300.0); // calls SavingsAccount.withdraw (override), not base
        System.out.println("Poly (BankAccount->Savings) withdraw 300 -> " + polyOk +
                " | balance: " + poly.getBalance());

        // Optional: print statements to see the logged WITHDRAW / WITHDRAW_DECLINED
        System.out.println("\n-- Savings S-100 Statement --");
        sav.printStatement();

        System.out.println("\n-- Poly S-200 Statement --");
        poly.printStatement();
    }

    // Complete all exercises and print results
 }