package com.sergey.prykhodko.homework4.collections;

import java.lang.reflect.Type;
import java.util.*;

/**
 * Created by Sergey on 09.07.2017.
 */
public class QueueWrapper {
    private Queue queue;



//    public static <T> List<T> asList(Queue<T> queue){
//
//        return Collections.unmodifiableList();
//    }

    public static void main(String[] args) {
        Queue<String> queue = new PriorityQueue<>();
        queue.add("one");
        queue.add("two");
        queue.add("three");
        queue.add("four");
        queue.add("five");
        queue.add("six");

//        List<String> list = QueueWrapper.asList(queue);
        //list.remove(1);
//        for (String s : list){
//            System.out.println(s);
//        }
//
//        queue.poll();
//        System.out.println();
//
//        for (String s : list){
//            System.out.println(s);
//        }

    }
}
