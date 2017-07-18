package com.sergey.prykhodko.homework6.department;

/**
 * Created by Sergey on 18.07.2017.
 */
public class Person {
    private String name;
    private int age;

    public String getName() {
        return name;
    }

    public int getAge() {
        return age;
    }

    public Person(String name, int age) {

        this.name = name;
        this.age = age;
    }
}
