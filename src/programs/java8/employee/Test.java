package programs.java8.employee;

import java.util.*;
import java.util.stream.Collectors;

public class Test
{

    public static void main(String[] args)
    {
        List<Employee> employeeList = Employee.getList();

        //Example-1
        List<String> employeeFilteredList = employeeList.stream()
                .filter(e->e.getAge()>20)
                .map(Employee::getName)
                .collect(Collectors.toList());

        employeeFilteredList.forEach((name)-> System.out.println(name));

        //employee-2
        long count = employeeList.stream().filter(e->e.getAge()==22).count();
        System.out.println(count);

        //Example-3
        Optional<Employee>  employee = employeeList.stream().filter(e->e.getName().equalsIgnoreCase("AA")).findAny();
        employee.ifPresent(System.out::println);

        //Example-4
        employeeList.stream().mapToInt(Employee::getAge).max();

        //Example-5, Sort by age and Name
        employeeList.sort(Comparator.comparing(Employee::getAge).thenComparing(Employee::getName));
        System.out.println(employeeList);

        //Example-6 Join the all employee names with “,”
        List<String> employeeNames = employeeList
                .stream()
                .map(Employee::getName)
                .collect(Collectors.toList());
        String employeeNamesStr = String.join(",", employeeNames);
        System.out.println("Employees are: "+employeeNamesStr);

        //Example-7 Group by name
        Map<String, List<Employee>> map = employeeList.stream()
                .collect(Collectors.groupingBy(Employee::getName));
        map.forEach((name,employeeListTemp)->System.out.println("Name: "+name+" ==>"+employeeListTemp));

        //Example-8 Remove duplicates using set
        Integer[] arr1=new Integer[]{1,2,3,4,3,2,4,2};
        List<Integer> listWithDuplicates1 = Arrays.asList(arr1);

        Set<Integer> setWithoutDups = listWithDuplicates1.stream().collect(Collectors.toSet());
        setWithoutDups.forEach((i)->System.out.print(" "+i));

        //Example-8 Remove duplicates using distinct
        Integer[] arr2=new Integer[]{1,2,3,4,3,2,4,2};
        List<Integer> listWithDuplicates2 = Arrays.asList(arr2);
        List<Integer> listWithoutDups = listWithDuplicates2.stream().distinct().collect(Collectors.toList());
        listWithoutDups.forEach((i)->System.out.print(" "+i));

        //Example-9 Square then filter the numbers which are greater 10000 and then find average of them
        Integer[] arr=new Integer[]{100,24,13,44,114,200,40,112};
        List<Integer> list = Arrays.asList(arr);
        OptionalDouble average = list.stream()
                .mapToInt(n->n*n)
                .filter(n->n>10000)
                .average();

        if(average.isPresent())
            System.out.println(average.getAsDouble());


    }
}
