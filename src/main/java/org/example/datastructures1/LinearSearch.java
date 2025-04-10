package org.example.datastructures1;

public class LinearSearch<T> implements Search<T> {
    @Override
    public String search(DataStructure<T> dataStructure, T target) {
        for (int i = 0; i < dataStructure.size(); i++) {
            if (dataStructure.get(i).equals(target)) {
                return "Found at index: " + i;
            }
        }
        return "Not found";
    }
}
