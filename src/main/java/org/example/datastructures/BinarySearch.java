package org.example.datastructures1;

public class BinarySearch<T extends Comparable<T>> implements Search<T> {
    @Override
    public String search(DataStructure<T> dataStructure, T target) {
        int left = 0;
        int right = dataStructure.size() - 1;

        while (left <= right) {
            int mid = left + (right - left) / 2;
            T midValue = dataStructure.get(mid);

            if (midValue.equals(target)) {
                return "Found at index: " + mid;
            }
            if (midValue.compareTo(target) < 0) {
                left = mid + 1;
            } else {
                right = mid - 1;
            }
        }
        return "Not found";
    }
}
