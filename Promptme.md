# Module 11 – Relational Databases and MVC
User: Pablo Seoane


## 🎯 Purpose

> Track your AI interactions (GitHub Copilot, ChatGPT, Claude, etc.) to reflect on learning, practice markdown, and build a reference for future projects.

### 💡 What to Document

> Document all your AI Assist interactions, including questions you ask, code explanations, implementation help, debugging assistance, learning conversations, code reviews, planning discussions, refactoring help, tool usage, career advice, and more.
>
> **Remember:** There's no such thing as a "dumb question" when learning to code. Document everything!

### 📝 How to Use This Log

> 1. Provide **📎 Context** on what you were working on so the coach can understand the purpose of your question.
> 2. Paste your exact question under **📎 Context** in the relevant **Prompt – XX** section.
> 3. Paste the AI’s full answer under **Response – XX** in the relevant section.

---

## ✏️ Prompt - 01

AI helper: ChatGPT
**📎 Context:** First I created a new project and attached the Business Document and Grading Sheet for Mod 11.
I have Installed Java (v17) and verified the installation. I have also created a new repo and cloned the repo provided by Codeboxx with Java exercises.

inside the repo are some exercises and instructions: Instructions 1. Clone this repository and create your own. 2. Open the project folder in VS Code. - Install the 'Extension Pack for Java' extension - If you're getting an error about needing to install the JDK and you have already installed it, it means that you need to set your environment variables properly. 3. Complete each exercise in the given order. Each time you finish an exercise, perform a commit with a relevant commit description. The exercises will ask you to: - Create new classes. Each class is in its own file (see Person.java) - Create methods and attributes - Use inheritance - Manipulate data and show results with System.out.println() -- The (Main) part of each exercises needs to be done in the main method of the Main class. # Exercise 1: Creating a Bank Account 1. Create a BankAccount class with attributes: accountNumber (String) and balance (double). 2. Implement a constructor to initialize the account details. 3. Add a deposit(double amount) method to increase the balance. 4. Add a withdraw(double amount) method to decrease the balance. Ensure the withdrawal amount is less than the balance. 5. (Main) Create an instance of BankAccount and demonstrate deposit and withdrawal operations. The file called Main.java has the following: // Exercise 1: Creating a Bank Account // Create a BankAccount instance // Perform deposit and withdrawal operations. I will create a new code called BankAccount.java, what do I do next?

## 🤖 Response - 01
Great—nice setup so far. After you add BankAccount.java, do these steps:

1) Implement the class (encapsulation + basic validation)

Create it in the same folder/package as Main.java (use the same package line if your project has one).
java code (...)

2) Use it from Main.java

Open Main.java and, inside the main method, create an instance and call the methods:
java code (...)

3) Run it

VS Code (Java Extension Pack):

Press ▶️ “Run” on Main.java, or use Run > Start Debugging.

4) Commit your work

Use clear, atomic commits:

feat(oop): add BankAccount class with deposit/withdraw

chore(main): demo BankAccount operations in Main

---

## ✏️ Prompt - 02

AI helper: Copilot
**📎 Context:** Im working on exercise #5, I created Transaction.java, and made some changes into SavingsAccount.java and CheckingAcount.java. After those updates and creating the new code for exercise #5 in Main.java 5 PROBLEMS popped in my terminal.

With right click in the first error I asked Copilot to explain problem

## 🤖 Response - 02

This error means that the SavingsAccount class does not have a method called applyMonthlyInterest(). To fix this, you need to define the method inside the SavingsAccount class.

Here's an example of how you might implement it:

// ...existing code...
public class SavingsAccount {
    private double balance;
    private double annualInterestRate;

    // ...existing constructors and methods...

    public void applyMonthlyInterest() {
        double monthlyInterest = balance * (annualInterestRate / 12);
        balance += monthlyInterest;
    }

    // ...existing code...
}


Explanation:

The method calculates monthly interest by dividing the annual rate by 12.
It then adds the interest to the account balance.
Gotcha:
Make sure annualInterestRate is expressed as a decimal (e.g., 0.05 for 5%). If it's a percentage, divide by 100 first.

Let me know if you need help adapting this to your specific class structure!

The conversation continues like this:

(PS) Im attaching the file so you can diagnose and proceed to make the update

(Copilot) The method applyMonthlyInterest() has been added to the SavingsAccount class. It now applies monthly interest to the entire balance and logs the transaction, resolving the error in your code.

You can now call sav.applyMonthlyInterest() in your Main.java without issues. Let me know if you need further help or want to test the update!

That fix solved the first 2 PROBLEMS.

The next 3 errors where related to duplicate local variables (cust, sav and chk) I fix those with the right click Fix option.

---

## ✏️ Prompt - 03

AI helper: Copilot and ChatGPT
**📎 Context:** creating file BankingReport.java

I have run into some problems with the BankingReport.java file you sent. According to Copilot its because you have used Java 25 features and I have being instructed to work and install JDK 17. Forgot to gave you that information as part of the context for my project. Copilot has made some changes in the file, this is the current code (...)

Please take this into account, let me know if I need to make any changes to the code you sent for Main.java

## 🤖 Response - 03

You’re good—your BankingReport.java is now JDK-17 friendly. The only “too new” bit I’d used was the arrow-style switch; your classic switch … case … break; fix is perfect.

Do you need to change Main.java?

Only make sure you call the report. Nothing else in Main.java needs JDK-25 features.

Here’s a clean JDK-17 snippet you can drop into Main.java (keep your other exercise runners as you like):

---

## ✏️ Prompt - 04

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 04

Paste the AI's answer here

---

## ✏️ Prompt - 05

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 05

Paste the AI's answer here

---

## ✏️ Prompt - 06

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 06

Paste the AI's answer here

---

## ✏️ Prompt - 07

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 07

Paste the AI's answer here

---

## ✏️ Prompt - 08

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 08

Paste the AI's answer here

---

## ✏️ Prompt - 09

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 09

Paste the AI's answer here

---

## ✏️ Prompt - 10

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 10

Paste the AI's answer here

---

## ✏️ Prompt - 11

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 11

Paste the AI's answer here

---

## ✏️ Prompt - 12

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 12

Paste the AI's answer here

---

## ✏️ Prompt - 13

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 13

Paste the AI's answer here

---

## ✏️ Prompt - 14

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 14

Paste the AI's answer here

---

## ✏️ Prompt - 15

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 15

Paste the AI's answer here

---

## ✏️ Prompt - 16

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 16

Paste the AI's answer here

---

## ✏️ Prompt - 17

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 17

Paste the AI's answer here

---

## ✏️ Prompt - 18

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 18

Paste the AI's answer here

---

## ✏️ Prompt - 19

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 19

Paste the AI's answer here

---

## ✏️ Prompt - 20

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 20

Paste the AI's answer here

---

## ✏️ Prompt - 21

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 21

Paste the AI's answer here

---

## ✏️ Prompt - 22

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 22

Paste the AI's answer here

---

## ✏️ Prompt - 23

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 23

Paste the AI's answer here

---

## ✏️ Prompt - 24

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 24

Paste the AI's answer here

---

## ✏️ Prompt - 25

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 25

Paste the AI's answer here

---

## ✏️ Prompt - 26

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 26

Paste the AI's answer here

---

## ✏️ Prompt - 27

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 27

Paste the AI's answer here

---

## ✏️ Prompt - 28

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 28

Paste the AI's answer here

---

## ✏️ Prompt - 29

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 29

Paste the AI's answer here

---

## ✏️ Prompt - 30

**📎 Context:** Write what you were working on here

Paste your prompt or question here

## 🤖 Response - 30

Paste the AI's answer here

---
