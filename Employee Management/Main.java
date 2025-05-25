import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int choice;

        do {
            System.out.println("\n--- Employee Management System ---");
            System.out.println("1. Add Employee");
            System.out.println("2. View All Employees");
            System.out.println("3. Search Employee by ID");
            System.out.println("4. Delete Employee by ID");
            System.out.println("5. Exit");
            System.out.print("Enter your choice: ");
            choice = sc.nextInt();

            try {
                switch (choice) {
                    case 1:
                        System.out.print("Enter ID: ");
                        int id = sc.nextInt();
                        sc.nextLine(); // consume newline
                        System.out.print("Enter Name: ");
                        String name = sc.nextLine();
                        System.out.print("Enter Department: ");
                        String dept = sc.nextLine();
                        System.out.print("Enter Salary: ");
                        double salary = sc.nextDouble();
                        EmployeeManager.addEmployee(new Employee(id, name, dept, salary));
                        System.out.println("Employee added successfully!");
                        break;

                    case 2:
                        System.out.println("\nAll Employees:");
                        for (Employee emp : EmployeeManager.getAllEmployees()) {
                            System.out.println(emp);
                        }
                        break;

                    case 3:
                        System.out.print("Enter ID to search: ");
                        int searchId = sc.nextInt();
                        Employee emp = EmployeeManager.searchById(searchId);
                        if (emp != null)
                            System.out.println(emp);
                        else
                            System.out.println("Employee not found.");
                        break;

                    case 4:
                        System.out.print("Enter ID to delete: ");
                        int deleteId = sc.nextInt();
                        EmployeeManager.deleteById(deleteId);
                        System.out.println("Employee deleted if existed.");
                        break;

                    case 5:
                        System.out.println("Exiting...");
                        break;

                    default:
                        System.out.println("Invalid choice!");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        } while (choice != 5);

        sc.close();
    }
}
