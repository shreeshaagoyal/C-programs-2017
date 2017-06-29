import java.io.*;
public class EmployeeTest {
    public static void main(String []args) {
        Employee emp1 = new Employee("Shreeshaa");
        Employee emp2 = new Employee("Shivanshu");

        emp1.empAge(18);
        emp1.empDesignation("Computer Scientist, Microbiologist, and Immunologist");
        emp1.empSalary(100);
        emp1.printEmp();

        emp2.empAge(23);
        emp2.empDesignation("Senior Software Engineer");
        emp2.empSalary(90840);
        emp2.printEmp();
    }
}