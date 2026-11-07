//Write a program to implement the Multiple Inheritance kind of framework (Bank Interface, Customer & Account classes).
import java.util.Scanner;

// 1. Bank Interface
interface Bank {
    void displayBank();
}

// 2. Customer Class
class Customer {
    String name;
    String address;

    Customer(String name, String address) {
        this.name = name;
        this.address = address;
    }

    void displayCustomer() {
        System.out.println("Customer Name: " + name);
        System.out.println("Address: " + address);
    }
}

// 3. Account Class (Extends Customer, Implements Bank)
class Account extends Customer implements Bank {
    int accountNumber;
    double balance;

    Account(String name, String address, int accountNumber, double balance) {
        super(name, address);
        this.accountNumber = accountNumber;
        this.balance = balance;
    }

    @Override
    public void displayBank() {
        System.out.println("Bank Name: State Bank of India");
    }

    void displayAccount() {
        System.out.println("\n--------------------");
        System.out.println("Bank Account Details");
        System.out.println("--------------------");
        displayBank();
        displayCustomer();
        System.out.println("Account Number: " + accountNumber);
        System.out.println("Balance: " + balance);
        System.out.println("--------------------");
    }
}

// 4. Main Class
public class BankMultipleInheritance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Taking inputs from user
        System.out.print("Enter Customer Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Address: ");
        String address = scanner.nextLine();

        System.out.print("Enter Account Number: ");
        int accountNumber = scanner.nextInt();

        System.out.print("Enter Balance: ");
        double balance = scanner.nextDouble();

        // Creating Account object with user inputs
        Account a = new Account(name, address, accountNumber, balance);

        // Displaying details
        a.displayAccount();

        scanner.close();
    }
}