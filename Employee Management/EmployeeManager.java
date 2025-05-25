import java.io.*;
import java.util.*;

public class EmployeeManager {
    private static final String FILE_NAME = "employees.txt";

    public static void addEmployee(Employee emp) throws IOException {
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME, true))) {
            writer.write(emp.toString());
            writer.newLine();
        }
    }

    public static List<Employee> getAllEmployees() throws IOException {
        List<Employee> list = new ArrayList<>();
        try (BufferedReader reader = new BufferedReader(new FileReader(FILE_NAME))) {
            String line;
            while ((line = reader.readLine()) != null) {
                list.add(Employee.fromString(line));
            }
        }
        return list;
    }

    public static Employee searchById(int id) throws IOException {
        for (Employee emp : getAllEmployees()) {
            if (emp.getId() == id) return emp;
        }
        return null;
    }

    public static void deleteById(int id) throws IOException {
        List<Employee> updatedList = new ArrayList<>();
        for (Employee emp : getAllEmployees()) {
            if (emp.getId() != id) {
                updatedList.add(emp);
            }
        }
        try (BufferedWriter writer = new BufferedWriter(new FileWriter(FILE_NAME))) {
            for (Employee emp : updatedList) {
                writer.write(emp.toString());
                writer.newLine();
            }
        }
    }
}
