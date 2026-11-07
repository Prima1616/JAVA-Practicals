import java.util.Scanner;

// 1. Gross Interface
interface Gross {
    double calculateGross();
}

// 2. Base Employee Class
class Employee {
    int empId;
    String empName;
    double basicSalary;

    Employee(int empId, String empName, double basicSalary) {
        this.empId = empId;
        this.empName = empName;
        this.basicSalary = basicSalary;
    }

    void displayEmployeeDetails() {
        System.out.println("Employee ID: " + empId);
        System.out.println("Employee Name: " + empName);
        System.out.println("Basic Salary: " + basicSalary);
    }
}

// 3. Salary Subclass (Extends Employee, Implements Gross)
class Salary extends Employee implements Gross {
    double hraPercent;
    double daPercent;
    double pfPercent;

    Salary(int empId, String empName, double basicSalary, double hraPercent, double daPercent, double pfPercent) {
        super(empId, empName, basicSalary);
        this.hraPercent = hraPercent;
        this.daPercent = daPercent;
        this.pfPercent = pfPercent;
    }

    double getHraAmount() {
        return (basicSalary * hraPercent) / 100.0;
    }

    double getDaAmount() {
        return (basicSalary * daPercent) / 100.0;
    }

    double getPfAmount() {
        return (basicSalary * pfPercent) / 100.0;
    }

    @Override
    public double calculateGross() {
        return basicSalary + getHraAmount() + getDaAmount();
    }

    public double calculateNet() {
        return calculateGross() - getPfAmount();
    }

    public void printSalarySlip() {
        System.out.println("\n--- Employee Salary Details ---");
        displayEmployeeDetails();
        System.out.println("HRA (" + hraPercent + "%): " + getHraAmount());
        System.out.println("DA (" + daPercent + "%): " + getDaAmount());
        System.out.println("PF Deduction (" + pfPercent + "%): " + getPfAmount());
        System.out.println("-------------------------------");
        System.out.println("Gross Salary: " + calculateGross());
        System.out.println("Net Salary: " + calculateNet());
        System.out.println("-------------------------------");
    }
}

// Main class
public class MultipleInheritance {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        System.out.print("Enter Employee ID: ");
        int id = scanner.nextInt();
        scanner.nextLine(); // Consume newline

        System.out.print("Enter Employee Name: ");
        String name = scanner.nextLine();

        System.out.print("Enter Basic Salary: ");
        double basic = scanner.nextDouble();

        System.out.print("Enter HRA % : ");
        double hra = scanner.nextDouble();

        System.out.print("Enter DA % : ");
        double da = scanner.nextDouble();

        System.out.print("Enter PF % : ");
        double pf = scanner.nextDouble();

        Salary empSalary = new Salary(id, name, basic, hra, da, pf);
        empSalary.printSalarySlip();

        scanner.close();
    }
}
