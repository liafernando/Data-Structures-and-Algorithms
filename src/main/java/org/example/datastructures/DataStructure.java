package org.example.datastructures1;

public interface DataStructure<T> {
    void add(T item);
    T get(int index);
    void set(int index, T item);
    void delete(int index);
    int size();
}