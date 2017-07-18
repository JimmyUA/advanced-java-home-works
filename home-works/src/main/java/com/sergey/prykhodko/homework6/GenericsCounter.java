package com.sergey.prykhodko.homework6;

import com.sun.org.apache.xerces.internal.xs.StringList;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by Sergey on 14.07.2017.
 */
public class GenericsCounter {



    public static <T extends Comparable<T>> int countLessElements(T[] array, T element){
        int result = 0;
        for (T t : array){
            if (t.compareTo(element) < 0){
                result++;
                System.out.println(t);
            }
        }
        return result;
    }


    static class TrainOn implements Comparable<TrainOn> {
        private int number;

        public TrainOn(int number) {
            this.number = number;
        }

        public int getNumber() {
            return number;
        }

        @Override
        public int compareTo(TrainOn o) {
            return this.number - o.getNumber();
        }
    }

    public static void main(String[] args) {
        String[] array = {"jdhf", "ehfbe", "jejf", "iweuf", "ewojsb"};
        String cliche = "k";

        TrainOn[] tr = {new TrainOn(3), new TrainOn(5), new TrainOn(63), new TrainOn(26),
                new TrainOn(53)};

        TrainOn toCompare = new TrainOn(10);
        System.out.println(countLessElements(array, cliche));

        System.out.println();
        System.out.println(countLessElements(tr, toCompare));
    }
}
