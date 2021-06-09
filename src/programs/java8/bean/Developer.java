package programs.java8.bean;

import java.math.BigDecimal;

public class Developer {

    String name;
    BigDecimal salary;
    int age;

    public Developer(String name, BigDecimal salary) {
        this.name = name;
        this.salary = salary;
    }

    public String getName()
    {
        return name;
    }

    public int getAge()
    {
        return age;
    }

    public void setAge(int age)
    {
        this.age = age;
    }

    public void setName(String name)
    {
        this.name = name;
    }

    public BigDecimal getSalary()
    {
        return salary;
    }

    public void setSalary(BigDecimal salary)
    {
        this.salary = salary;
    }
}