package org.example.datastructures1;

import java.util.ArrayList;
import java.util.List;

public class ArrayListStructure<T> implements DataStructure<T> {
    private final ArrayList<T> list;

    public ArrayListStructure() {
        this.list = new ArrayList<>();
    }

    @Override
    public void add(T item) {
        list.add(item);
    }

    @Override
    public T get(int index) {
        return list.get(index);
    }

    @Override
    public void set(int index, T item) {
        list.set(index, item);
    }

    @Override
    public void delete(int index) {
        list.remove(index);
    }

    @Override
    public int size() {
        return list.size();
    }

    @Override
    public String toString() {
        return list.toString();
    }
}