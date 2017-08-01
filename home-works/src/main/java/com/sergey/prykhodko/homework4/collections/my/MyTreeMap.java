package com.sergey.prykhodko.homework4.collections.my;

import java.math.BigDecimal;
import java.math.BigInteger;
import java.util.*;

/**
 * Created by Sergey on 07.07.2017.
 */
public class MyTreeMap<K extends Comparable, V> implements SortedMap<K, V> {
    private Comparator<K> comparator;
    private Entry<K, V> root;
    private Set<K> keySet;
    private int size = 0;

    public MyTreeMap(){
        comparator = null;
        root =null;
        keySet = new TreeSet<>();
    }

    public Enumeration<Entry<K, V>> elements() {
        return new Enumeration<Entry<K, V>>() {
            int count = 0;

            @Override
            public boolean hasMoreElements() {
                return count < keySet.size();
            }

            @Override
            public Entry<K, V> nextElement() {
                List<K> keys = new ArrayList<>(keySet);
                K key = keys.get(count++);
                return new Entry<K, V>(key, MyTreeMap.this.get(key));
            }
        };
    }

    @Override
    public Comparator<? super K> comparator() {
        return this.comparator;
    }

    @Override
    public SortedMap<K, V> subMap(K fromKey, K toKey) {
        return null;
    }

    @Override
    public SortedMap<K, V> headMap(K toKey) {
        return null;
    }

    @Override
    public SortedMap<K, V> tailMap(K fromKey) {
        return null;
    }

    @Override
    public K firstKey() {
        Entry<K, V> current = root;
        while (current.left != null) {
            current = current.left;
        }
        return current.getKey();
    }

    @Override
    public K lastKey() {
        Entry<K, V> current = root;
        while (current.right != null) {
            current = current.left;
        }
        return current.getKey();
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean containsKey(Object key) {
        Entry<K, V> current = root;
        K cKey = (K) key;
        while (current != null) {
            if (cKey.compareTo(current.getKey()) < 0 && current.left != null) {
                current = current.left;
            }
            else if (cKey.compareTo(current.getKey()) < 0 && current.right != null){
                current = current.right;
            }
            else if (cKey.compareTo(current.getKey()) == 0){
                return true;
            }
            else {
                break;
            }

        }
        return false;
    }

    @Override
    public boolean containsValue(Object value) {
        Entry<K, V> current = root;
        K cValue = (K) value;
        while (current != null) {
            if (cValue.compareTo(current.getValue()) < 0 && current.left != null) {
                current = current.left;
            }
            else if (cValue.compareTo(current.getValue()) < 0 && current.right != null){
                current = current.right;
            }
            else if (cValue.compareTo(current.getValue()) == 0){
                return true;
            }
            else {
                break;
            }

        }
        return false;
    }

    @Override
    public V get(Object key) {
        Entry<K, V> current = root;
        K cKey = (K) key;
        while (current != null) {
            if (cKey.compareTo(current.getKey()) < 0 && current.left != null) {
                current = current.left;
            }
            else if (cKey.compareTo(current.getKey()) > 0 && current.right != null){
                current = current.right;
            }
            else if (cKey.compareTo(current.getKey()) == 0){
                return current.getValue();
            }
            else {
                break;
            }

        }
        return null;    }

    @Override
    public V put(K key, V value) {
        Entry<K, V> temp = root;
        if (temp == null) {
            root = new Entry<>(key, value, null);
            size = 1;
            keySet.add(key);
            return root.getValue();
        }
        else {
            Entry<K, V> current = temp;
            while (current != null) {
                if (key.compareTo(current.key) < 0 && current.left != null) {
                    current = current.left;
                } else if (key.compareTo(current.key) > 0 && current.right != null) {
                    current = current.right;
                } else if (key.compareTo(current.key) < 0 && current.left == null) {
                    current.left = new Entry<>(key, value, current);
                    keySet.add(key);
                } else if (key.compareTo(current.key) > 0 && current.right == null) {
                    current.right = new Entry<>(key, value, current);
                    keySet.add(key);
                }
                else {
                    size++;
                    return null;

                }
            }
        }
        return null;
    }

    @Override
    public V remove(Object key) {
        boolean isRight = false;
        Entry<K, V> current = root;
        K cKey = (K) key;
        while (current != null) {
            if (cKey.compareTo(current.getKey()) < 0 && current.left != null) {
                current = current.left;
                isRight = false;
            }
            else if (cKey.compareTo(current.getKey()) < 0 && current.right != null){
                current = current.right;
                isRight = true;
            }
            else if (cKey.compareTo(current.getKey()) == 0){
                if (current.right != null) {
                    Entry<K, V> swap = current;
                    current = current.right;
                    current.parent = swap.parent;
                    if (isRight) {
                        current.parent.right = current;
                    }
                    else if (!isRight){
                        current.parent.left = current;
                    }
                    current.left = swap.left;
                    keySet.remove(key);
                    return swap.getValue();
                }
                else if (current.left != null) {
                    Entry<K, V> swap = current;
                    current = current.left;
                    current.parent = swap.parent;
                    if (isRight) {
                        current.parent.right = current;
                    }
                    else if (!isRight){
                        current.parent.left = current;
                    }
                    keySet.remove(key);
                    return swap.value;
                }
                else {
                    if (isRight) {
                        Entry<K, V> swap = current;
                        current = current.parent;
                        current.right = null;
                        keySet.remove(swap.getKey());
                        return swap.getValue();
                    }
                    else {
                        Entry<K, V> swap = current;
                        current = current.parent;
                        current.left = null;
                        size--;
                        keySet.remove(key);
                        return swap.getValue();
                    }

                }
            }

        }

        return null;
    }

    @Override
    public void putAll(Map<? extends K, ? extends V> m) {
        throw new UnsupportedOperationException();
    }

    @Override
    public void clear() {
        throw new UnsupportedOperationException();
    }

    @Override
    public Set<K> keySet() {
        return keySet;
    }

    @Override
    public Collection<V> values() {

        Collection<V> values = new LinkedList<>();
        for (K key : keySet) {
            values.add(this.get(key));
        }
        return values;
    }

    @Override
    public Set<Map.Entry<K, V>> entrySet() {
        Set<Map.Entry<K, V>> set = new TreeSet<>();
        for (K key: keySet) {
            set.add(new Entry<>(key, this.get(key)));
        }
        return set;
    }

    static final class Entry<K extends Comparable, V> implements Comparable, Map.Entry<K, V>{
        K key;
        V value;
        Entry<K,V> left;
        Entry<K,V> right;
        Entry<K,V> parent;

        Entry(K key, V value, Entry<K, V> parent){
            this.key = key;
            this.value =value;
            this.parent = parent;
        }

        Entry(K key, V value){
            this.key = key;
            this.value =value;
            this.parent = null;
        }

        public String toString(){
            return this.getKey() + "/" + this.getValue();
        }
        @Override
        public K getKey() {
            return key;
        }

        @Override
        public V getValue() {
            return value;
        }

        @Override
        public V setValue(V value) {
            V old = this.value;
            this.value = value;
            return old;
        }

        @Override
        public int compareTo(Object o) {
            return this.getKey().compareTo(((Entry<K, V>)o).getKey());
        }
    }

    public static <T extends Number> List<T> withoutBites(Collection<T> collection) {
        List<T> result = new ArrayList<>();
        int compareWith = 0b1111111111111111;
        int sumLowBits = 0;

        for (T element : collection) {
            int youngBits = (element.shortValue());
            youngBits &= compareWith;
            sumLowBits += youngBits;
        }

        int averadge = sumLowBits / collection.size();
        System.out.println(averadge);

//        for (T element : collection) {
//            element -= averadge;
//        }

        return result;
    }

    public static void main(String[] args) {
//        MyTreeMap<Integer, String> map = new MyTreeMap<Integer, String>();
//        map.put(8, "eight");
//        map.put(5, "five");
//        map.put(2, "two");
//        map.put(7, "seven");
//        map.put(11, "eleven");
//        map.put(116, "116");
//        map.put(1, "1");
//        map.put(3, "3");
//
//
//        System.out.println(map.remove(2));
//        for (Map.Entry<Integer, String> entry : map.entrySet())
//        {
//            System.out.println(entry.getKey() + "/" + entry.getValue());
//        }
//        for (Enumeration<Entry<Integer, String>> e = map.elements(); e.hasMoreElements();)
//            System.out.println(e.nextElement().toString());

        Collection<Integer> col = new ArrayList<>();
        col.add(33000);


        withoutBites(col);

        BigInteger b = new BigInteger("33000");
        System.out.println(b.shortValue());

        System.out.println(Short.MAX_VALUE);

    }


}
