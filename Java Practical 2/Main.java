// Create a class named “Employee” to store information of an employee (emp_no, name, department, basic_pay, DA, HRA and gross_salary). Write a program, which will take as input the emp_no, name, department, basic_pay for several employees. The program will calculate the DA, HRA and total for each employee and display the details of the employee having the highest gross salary.
import java.util.Scanner;

class Employee {
    int Emp_no;
    String Name;
    String Department;
    double Basic_pay;
    double Da;
    double Hra;
    double Gross_salary;

    public void calculateSalary() {
        Da = 0.40 * Basic_pay;
        Hra = 0.20 * Basic_pay;
        Gross_salary = Basic_pay + Da + Hra;
    }

    public void displayDetails() {
        System.out.println("----------------------------------------");
        System.out.println("Employee Number : " + Emp_no);
        System.out.println("Name            : " + Name);
        System.out.println("Department      : " + Department);
        System.out.println("Basic Pay       : " + Basic_pay);
        System.out.println("DA (40%)        : " + Da);
        System.out.println("HRA (20%)       : " + Hra);
        System.out.println("Gross Salary    : " + Gross_salary);
        System.out.println("----------------------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter the number of employees: ");
        int n = scanner.nextInt();

        if (n <= 0) {
            System.out.println("Invalid number of employees.");
            scanner.close();
            return;
        }

        Employee[] employees = new Employee[n];

        for (int i = 0; i < n; i++) {
            System.out.println("\nEnter details for employee " + (i + 1) + ":");
            employees[i] = new Employee();

            System.out.print("Employee No: ");
            employees[i].Emp_no = scanner.nextInt();
            scanner.nextLine();

            System.out.print("Name: ");
            employees[i].Name = scanner.nextLine();

            System.out.print("Department: ");
            employees[i].Department = scanner.nextLine();

            System.out.print("Basic Pay: ");
            employees[i].Basic_pay = scanner.nextDouble();

            employees[i].calculateSalary();
        }

        Employee highestPaid = employees[0];
        for (int i = 1; i < n; i++) {
            if (employees[i].Gross_salary > highestPaid.Gross_salary) {
                highestPaid = employees[i];
            }
        }

        System.out.println("\n=== Employee with the Highest Gross Salary ===");
        highestPaid.displayDetails();

        scanner.close();
    }
}