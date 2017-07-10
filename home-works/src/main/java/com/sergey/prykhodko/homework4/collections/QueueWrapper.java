package com.sergey.prykhodko.homework4.collections;

import java.lang.reflect.Type;
import java.util.*;
import java.util.concurrent.ConcurrentLinkedQueue;

/**
 * Created by Sergey on 09.07.2017.
 */
public class QueueWrapper<T> implements List<T>{
    private Queue queue;


    @Override
    public int size() {
        return queue.size();
    }

    @Override
    public boolean isEmpty() {
        return queue.isEmpty();
    }

    @Override
    public boolean contains(Object o) {
        return queue.contains(o);
    }

    @Override
    public Iterator<T> iterator() {
        return queue.iterator();
    }

    @Override
    public Object[] toArray() {
        return queue.toArray();
    }

    @Override
    public <T1> T1[] toArray(T1[] a) {
        return (T1[])queue.toArray(a);
    }

    @Override
    public boolean add(T t) {
        return queue.add(t);
    }

    @Override
    public boolean remove(Object o) {
        return queue.remove(o);
    }

    @Override
    public boolean containsAll(Collection<?> c) {
        return queue.containsAll(c);
    }

    @Override
    public boolean addAll(Collection<? extends T> c) {
        return queue.addAll(c);
    }

    @Override
    public boolean addAll(int index, Collection<? extends T> c) {
        return queue.addAll(c);
    }

    @Override
    public boolean removeAll(Collection<?> c) {
        return queue.removeAll(c);
    }

    @Override
    public boolean retainAll(Collection<?> c) {
        return queue.retainAll(c);
    }

    @Override
    public void clear() {
        queue.clear();
    }

    @Override
    public T get(int index) {
        if (index >queue.size() - 1 || index < 0) {
            throw new IllegalArgumentException();
        }
        List<T> temp = new ArrayList<>(queue);

        return temp.get(index);
    }

    @Override
    public T set(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void add(int index, T element) {
        throw new UnsupportedOperationException();
    }

    @Override
    public T remove(int index) {
        Queue<T> temp = new ConcurrentLinkedQueue<>(queue);
        for (int i = 0; i < index; i++){
            temp.poll();
            i++;
        }
        queue.remove(temp.peek());
        return temp.poll();
    }

    @Override
    public int indexOf(Object o) {
        Queue<T> temp = new ConcurrentLinkedQueue<>(queue);
        int i;
        for (i = 0; i < temp.size(); i++){
            if (temp.poll().equals((T)o)){
                break;
            }
            else if (i == temp.size() -1){
                return -1;
            }
            i++;
        }
        return i;
    }

    @Override
    public int lastIndexOf(Object o) {
        Queue<T> temp = new ConcurrentLinkedQueue<>(queue);
        int index = 0;
        int i;
        for (i = 0; i < temp.size(); i++){
            if (temp.poll().equals((T)o)){
                index = i;
            }
            i++;
        }
        if (index == 0){
            return -1;
        }
        return index;
    }

    @Override
    public ListIterator<T> listIterator() {
        return new LinkedList<T>(queue).listIterator();
    }

    @Override
    public ListIterator<T> listIterator(int index) {
        return new LinkedList<T>(queue).listIterator(index);
    }

    @Override
    public List<T> subList(int fromIndex, int toIndex) {
        return new LinkedList<T>(queue).subList(fromIndex, toIndex);
    }

    public List<T> asList(Queue<T> queue){
        this.queue = queue;
        return Collections.unmodifiableList(this);
    }

    public static void main(String[] args) {
        Queue<String> queue = new ArrayDeque<>();
        queue.add("one");
        queue.add("two");
        queue.add("three");
        queue.add("four");
        queue.add("five");
        queue.add("six");

        QueueWrapper<String> wrapper = new QueueWrapper<>();
        List<String> list = wrapper.asList(queue);

        System.out.println(list.size());

        queue.poll();

        System.out.println(list.size());
    }
}
