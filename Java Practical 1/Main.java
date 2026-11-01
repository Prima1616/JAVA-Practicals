// Create a class called Employee. Employee has three private data members name, department and salary. Initialize these data member via constructor. Display all the information for 5 employee of same company. Also display name of their company. Use static member concept to implement this code
class Employee {
    private String Name;
    private String Department;
    private double Salary;
    private static String Company;

    public Employee(String Name, String Department, double Salary) {
        this.Name = Name;
        this.Department = Department;
        this.Salary = Salary;
    }

    public static void setCompanyName(String cName) {
        Company = cName;
    }

    public void displayInfo() {
        System.out.println("Company: " + Company);
        System.out.println("Name: " + Name);
        System.out.println("Department: " + Department);
        System.out.println("Salary: " + Salary);
        System.out.println("------------------------");
    }
}

public class Main {
    public static void main(String[] args) {
        Employee.setCompanyName("Nexis Global Ltd.");

        Employee e1 = new Employee("Prima Paul", "IT", 52000);
        Employee e2 = new Employee("Sneha Sen", "HR", 48000);
        Employee e3 = new Employee("Aniket Sharma", "IT", 72000);
        Employee e4 = new Employee("Pooja Das", "Testing", 56000);
        Employee e5 = new Employee("Vikram Patel", "Accounts", 63000);

        e1.displayInfo();
        e2.displayInfo();
        e3.displayInfo();
        e4.displayInfo();
        e5.displayInfo();
    }
}
