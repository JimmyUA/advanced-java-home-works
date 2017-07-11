package com.sergey.prykhodko.homework4.collections;

import java.util.HashSet;
import java.util.Set;

/**
 * Created by Sergey on 11.07.2017.
 */
public class SetMath {

    public static <T> Set<T> union(Set<T> first, Set<T> second){
        Set<T> result = new HashSet<>();

        result.addAll(first);
        result.addAll(second);

        return result;
    }

    public static <T> Set<T> intersection(Set<T> first, Set<T> second){
        Set<T> result = new HashSet<>();

        for (T t : first){
            if (second.contains(t)){
                result.add(t);
            }
        }

        return result;
    }

    public static <T> Set<T> difference(Set<T> first, Set<T> second){
        Set<T> result = new HashSet<>();

        for (T t : first){
            if (!second.contains(t)){
                result.add(t);
            }
        }

        for (T t : second){
            if (!first.contains(t)){
                result.add(t);
            }
        }

        return result;
    }


    public static void main(String[] args) {
        Set<Integer> set = new HashSet<>();
        Set<Integer> set2 = new HashSet<>();

        for (int i = 0; i < 7; i++){
            set.add(i);
        }

        for (int i = 3; i < 12; i++){
            set2.add(i);
        }

        Set<Integer> result = SetMath.union(set, set2);

        System.out.println(result);

        result = SetMath.intersection(set, set2);

        System.out.println(result);

        result = SetMath.difference(set, set2);

        System.out.println(result);
    }
}
