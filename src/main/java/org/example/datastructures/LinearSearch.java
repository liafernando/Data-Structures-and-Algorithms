package org.example.datastructures1;

public class LinearSearch<T> implements Search<T> {
    @Override
    public void search(DataStructure<T> dataStructure, T target) {
        for (int i = 0; i < dataStructure.size(); i++) {
            if (dataStructure.get(i).equals(target)) {
                System.out.println("Found at index: " + i);
                return;
            }
        }
        System.out.println("Not found");
    }
}