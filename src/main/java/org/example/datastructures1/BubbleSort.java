package org.example.datastructures1;

public class BubbleSort<T extends Comparable<T>> implements Sorting<T> {
    @Override
    public void sort(DataStructure<T> dataStructure) {
        int n = dataStructure.size();
        for (int i = 0; i < n - 1; i++) {
            for (int j = 0; j < n - i - 1; j++) {
                if (dataStructure.get(j).compareTo(dataStructure.get(j + 1)) > 0) {
                    T temp = dataStructure.get(j);
                    dataStructure.set(j, dataStructure.get(j + 1));
                    dataStructure.set(j + 1, temp);
                }
            }
        }
    }
}