package controller;

import model.Employee;
import service.EmployeeService;
import view.EmployeeView;

import java.time.LocalDate;
import java.util.Scanner;

public class EmployeeController {
    public static void main(String[] args) {
        EmployeeService service = new EmployeeService();
        EmployeeView view = new EmployeeView();
        Scanner sc = new Scanner(System.in);

        while (true) {
            try {
                view.showMenu();
                int choice = sc.nextInt();

                switch (choice) {
                    case 1 -> {
                        System.out.print("ID: "); int id = sc.nextInt();
                        System.out.print("Name: "); String name = sc.next();
                        System.out.print("Department: "); String dept = sc.next();
                        System.out.print("Position: "); String pos = sc.next();
                        System.out.print("Salary: "); double sal = sc.nextDouble();
                        service.addEmployee(new Employee(id, name, dept, pos, sal, LocalDate.now()));
                        System.out.println("Employee Added Successfully");
                    }
                    case 2 -> service.getAllEmployees().forEach(System.out::println);
                    case 3 -> {
                        System.out.print("Search (name/department): ");
                        String key = sc.next();
                        service.searchEmployee(key).forEach(System.out::println);
                    }
                    case 4 -> {
                        System.out.print("ID: "); int id = sc.nextInt();
                        System.out.print("Name: "); String name = sc.next();
                        System.out.print("Dept: "); String dept = sc.next();
                        System.out.print("Pos: "); String pos = sc.next();
                        System.out.print("Salary: "); double sal = sc.nextDouble();
                        System.out.println(service.updateEmployee(id, name, dept, pos, sal)
                                ? "Updated Successfully" : "Employee Not Found");
                    }
                    case 5 -> {
                        System.out.print("ID: "); int id = sc.nextInt();
                        System.out.println(service.deleteEmployee(id)
                                ? "Deleted Successfully" : "Employee Not Found");
                    }
                    case 6 -> service.generateReport();
                    case 7 -> { service.saveToFile(); System.out.println("Data Saved"); }
                    case 8 -> { service.loadFromFile(); System.out.println("Data Loaded"); }
                    case 9 -> { System.out.println("Thank You"); return; }
                    default -> System.out.println("Invalid Choice");
                }
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
                sc.nextLine();
            }
        }
    }
}