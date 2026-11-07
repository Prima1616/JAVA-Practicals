//2.	Create an abstract class Accounts with the following details: 
//Data Members: (a) Balance (b) accountNumber (c) accountHoldersName (d) address 
//Methods: (a) withdrawl()- abstract (b) deposit()- abstract (c) display() to show the balance of the account number 
//Create a subclass of this class SavingsAccount and add the following details: Data Members: (a) rateOfInterest Methods: (a)	calculateAmount() 
//Write the Java program to implement this classes

import java.util.Scanner;

// 1. Abstract Base Class Accounts
abstract class Accounts {
    // Data Members
    double balance;
    long accountNumber;
    String accountHoldersName;
    String address;

    // Constructor to initialize basic account details
    Accounts(double balance, long accountNumber, String accountHoldersName, String address) {
        this.balance = balance;
        this.accountNumber = accountNumber;
        this.accountHoldersName = accountHoldersName;
        this.address = address;
    }

    // Abstract Methods
    abstract void withdrawl(double amount);
    abstract void deposit(double amount);

    // Concrete Method to display balance and account number
    void display() {
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Account Holder: " + accountHoldersName);
        System.out.println("Address: " + address);
        System.out.println("Current Balance: ₹" + balance);
    }
}

// 2. Subclass SavingsAccount
class SavingsAccount extends Accounts {
    // Additional Data Member
    double rateOfInterest;

    // Constructor
    SavingsAccount(double balance, long accountNumber, String accountHoldersName, String address, double rateOfInterest) {
        super(balance, accountNumber, accountHoldersName, address);
        this.rateOfInterest = rateOfInterest;
    }

    // Implementing abstract withdrawl method
    @Override
    void withdrawl(double amount) {
        if (amount > 0 && amount <= balance) {
            balance -= amount;
            System.out.println("₹" + amount + " withdrawn successfully.");
        } else if (amount > balance) {
            System.out.println("Withdrawal failed: Insufficient balance.");
        } else {
            System.out.println("Invalid withdrawal amount.");
        }
    }

    // Implementing abstract deposit method
    @Override
    void deposit(double amount) {
        if (amount > 0) {
            balance += amount;
            System.out.println("₹" + amount + " deposited successfully.");
        } else {
            System.out.println("Invalid deposit amount.");
        }
    }

    // Method to calculate total amount after interest
    void calculateAmount() {
        double interest = (balance * rateOfInterest) / 100.0;
        double totalAmount = balance + interest;
        System.out.println("Rate of Interest: " + rateOfInterest + "%");
        System.out.println("Annual Interest Earned: ₹" + interest);
        System.out.println("Total Balance with Interest: ₹" + totalAmount);
    }
}

// 3. Main Class 
public class BankAccountsDemo {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking inputs from user
        System.out.print("Enter Account Holder Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Account Number: ");
        long accNo = scanner.nextLong();

        System.out.print("Enter Initial Balance: ");
        double balance = scanner.nextDouble();

        System.out.print("Enter Rate of Interest (%): ");
        double roi = scanner.nextDouble();

        // Create SavingsAccount object
        SavingsAccount sa = new SavingsAccount(balance, accNo, name, address, roi);

        System.out.println("\n--- Account Created Successfully ---");
        sa.display();

        // Testing Deposit
        System.out.print("\nEnter amount to deposit: ");
        double dep = scanner.nextDouble();
        sa.deposit(dep);

        // Testing Withdrawal
        System.out.print("\nEnter amount to withdraw: ");
        double with = scanner.nextDouble();
        sa.withdrawl(with);

        // Final Display and Interest Calculation
        System.out.println("\n--- Final Account Summary ---");
        sa.display();
        sa.calculateAmount();

        scanner.close();
    }
}
