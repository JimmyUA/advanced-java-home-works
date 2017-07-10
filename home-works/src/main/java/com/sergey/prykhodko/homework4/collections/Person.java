package com.sergey.prykhodko.homework4.collections;

/**
 * Created by Sergey on 10.07.2017.
 */
public class Person implements Comparable{
    private int age;

    public Person(int age){
        this.age = age;
    }

    public void setAge(int age) {
        this.age = age;
    }

    public int getAge() {
        return age;
    }

    @Override
    public int compareTo(Object o) {
        return this.getAge() - ((Person)o).getAge();
    }
}
