package org.example.datastructures1;

public class QuickSort<T extends Comparable<T>> implements Sorting<T> {
    @Override
    public void sort(DataStructure<T> dataStructure) {
        quickSort(dataStructure, 0, dataStructure.size() - 1);
    }

    private void quickSort(DataStructure<T> dataStructure, int low, int high) {
        if (low < high) {
            int pi = partition(dataStructure, low, high);
            quickSort(dataStructure, low, pi - 1);
            quickSort(dataStructure, pi + 1, high);
        }
    }

    private int partition(DataStructure<T> dataStructure, int low, int high) {
        T pivot = dataStructure.get(high);
        int i = low - 1;
        for (int j = low; j < high; j++) {
            if (dataStructure.get(j).compareTo(pivot) < 0) {
                i++;
                T temp = dataStructure.get(i);
                dataStructure.set(i, dataStructure.get(j));
                dataStructure.set(j, temp);
            }
        }
        T temp = dataStructure.get(i + 1);
        dataStructure.set(i + 1, dataStructure.get(high));
        dataStructure.set(high, temp);
        return i + 1;
    }
}