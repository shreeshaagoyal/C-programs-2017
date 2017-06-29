import java.io.*;
public class Employee {
    String name;
    int age;
    String designation;
    double salary;
    static int numInstances = 0;

    public Employee(String name) {
        //constructor
        this.name = name;
        numInstances++;
    }

    public void empAge(int empAge) {
        this.age = empAge;
    }

    public void empDesignation(String empDesignation) {
        this.designation = empDesignation;
    }

    public void empSalary(double empSalary) {
        this.salary = empSalary;
    }

    public void printEmp() {
        System.out.println("Employee name: " + this.name);
        System.out.println("Employee age: " + this.age);
        System.out.println("Employee designation: " + this.designation);
        System.out.println("Employee salary: " + this.salary);
    }
    
}