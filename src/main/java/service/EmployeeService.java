package service;

import model.Employee;
import java.io.*;
import java.util.*;

<<<<<<< HEAD
=======

>>>>>>> 2d18c731ece3cea05575d06e35c4c26550ffb8e9
public class EmployeeService {
    private ArrayList<Employee> employeeList = new ArrayList<>();
    private HashMap<Integer, Employee> employeeMap = new HashMap<>();
    private final String FILE_NAME = "employees.dat";

<<<<<<< HEAD
=======

>>>>>>> 2d18c731ece3cea05575d06e35c4c26550ffb8e9
    public void addEmployee(Employee e) {
        if (employeeMap.containsKey(e.getId()))
            throw new IllegalArgumentException("Employee ID already exists");
        employeeList.add(e);
        employeeMap.put(e.getId(), e);
    }
    public ArrayList<Employee> getAllEmployees() {
        return employeeList;
    }
    public ArrayList<Employee> searchEmployee(String key) {
        ArrayList<Employee> result = new ArrayList<>();
        for (Employee e : employeeList) {
            if (e.getName().toLowerCase().contains(key.toLowerCase()) ||
                    e.getDepartment().toLowerCase().contains(key.toLowerCase())) {
                result.add(e);
            }
        }
        return result;
    }
    public boolean updateEmployee(int id, String name, String dept, String pos, double sal) {
        Employee e = employeeMap.get(id);
        if (e == null) return false;
        e.setName(name);
        e.setDepartment(dept);
        e.setPosition(pos);
        e.setSalary(sal);
        return true;
    }
    public boolean deleteEmployee(int id) {
        Employee e = employeeMap.remove(id);
        if (e == null) return false;
        employeeList.remove(e);
        return true;
    }
    public void generateReport() {
        double total = 0;
        for (Employee e : employeeList) total += e.getSalary();
        System.out.println("Total Employees: " + employeeList.size());
        System.out.println("Total Salary: " + total);
        if (!employeeList.isEmpty())
            System.out.println("Average Salary: " + (total / employeeList.size()));
    }
    public void saveToFile() throws IOException {
        ObjectOutputStream oos = new ObjectOutputStream(new FileOutputStream(FILE_NAME));
        oos.writeObject(employeeList);
        oos.close();
    }
    @SuppressWarnings("unchecked")
    public void loadFromFile() throws IOException, ClassNotFoundException {
        ObjectInputStream ois = new ObjectInputStream(new FileInputStream(FILE_NAME));
        employeeList = (ArrayList<Employee>) ois.readObject();
        employeeMap.clear();
        for (Employee e : employeeList)
            employeeMap.put(e.getId(), e);
        ois.close();
    }
}