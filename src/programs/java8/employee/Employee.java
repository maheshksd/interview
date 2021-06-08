package programs.java8.employee;

import java.util.Arrays;
import java.util.List;

public class Employee
{
    private String name;
    private int age;

    public Employee(String name, int age) {
        super();
        this.name = name;
        this.age = age;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public int getAge() {
        return age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public String toString()
    {
        return "Employee Name: "+name+" age: "+age;
    }

    public static List<Employee> getList()
    {
        return Arrays.asList(
                new Employee("AA",11),
                new Employee("BB",22),
                new Employee("CC",33),
                new Employee("DD",44),
                new Employee("EE",22),
                new Employee("FF",33)
        );
    }
}