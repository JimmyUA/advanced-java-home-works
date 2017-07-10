package com.sergey.prykhodko.homework4.collections;

import java.util.Set;
import java.util.TreeSet;

/**
 * Created by Sergey on 09.07.2017.
 */

public class Iterators {

    public static  Set<Person> filter(Set<Person> personSet, int age) {
        Set<Person> result = new TreeSet<>();
        for (Person person : personSet) {
            if (person.getAge() >= age) {
                result.add(person);
            }
        }
        return result;
    }

    public static void main(String[] args) {
        Set<Person> personSet = new TreeSet<>();
        personSet.add(new Person(23));
        personSet.add(new Person(30));
        personSet.add(new Person(22));
        personSet.add(new Person(34));
        personSet.add(new Person(43));
        personSet.add(new Person(21));
        personSet.add(new Person(18));
        personSet.add(new Person(2));
        personSet.add(new Person(56));

        Set<Person> old = Iterators.filter(personSet, 30);

        for (Person p : old) {
            System.out.println(p.getAge());
        }
    }
}

