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
        

        // Exercise 3: Creating a Checking Account
        // Create a CheckingAccount instance
        // Perform withdrawal operations with overdraft

        // Exercise 4: Managing Customer's Accounts
        // Create a BankCustomer instance
        // Add multiple accounts and display total balance

        // Exercise 5: Transaction History
        // Add transactions to accounts and retrieve history

        // Exercise 6: Generate Banking Report
        // Generate and display a customer's banking report

        // Exercise 7: Update Interest Rates
        // Update the interest rate and observe calculations

        // Exercise 8: Override Withdrawal Method
        // Demonstrate overridden withdrawal method

        // Complete all exercises and print results
    }
}