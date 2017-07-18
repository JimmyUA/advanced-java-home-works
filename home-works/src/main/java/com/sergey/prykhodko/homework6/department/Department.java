package com.sergey.prykhodko.homework6.department;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 18.07.2017.
 */
public class Department <T extends Person> {
    private List<T> employees;
    private String name;

    public Department(String name) {
        this.name = name;
        employees = new ArrayList<>();
    }

    public void  addEmployee(T employee){
        employees.add(employee);
    }

    public double everageAge(){
        int totalAge = 0;
        for (T employee : employees){
            totalAge += employee.getAge();
        }
        return totalAge / employees.size() * 1.0;
    }

    public boolean hasSameAverageAge(Department<? extends Person> department){
        return this.everageAge() == department.everageAge();
    }

    public static void main(String[] args) {
        Department<Employee> first = new Department<>("Billing team");
        first.addEmployee(new Employee("Mark", 34));
        first.addEmployee(new Employee("Marko", 32));
        first.addEmployee(new Employee("Marik", 24));
        first.addEmployee(new Employee("Maruk", 29));
        first.addEmployee(new Employee("Mareko", 21));

        Department<Person> second = new Department<>("Support team");
        second.addEmployee(new Employee("Bob", 34));
        second.addEmployee(new Employee("Bobby", 31));
        second.addEmployee(new Employee("Toby", 24));
        second.addEmployee(new Employee("Rob", 29));
        second.addEmployee(new Employee("Djeko", 21));

        System.out.println(first.hasSameAverageAge(second));
    }
}
