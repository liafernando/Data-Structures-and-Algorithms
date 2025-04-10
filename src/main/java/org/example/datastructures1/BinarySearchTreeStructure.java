package org.example.datastructures1;

import java.util.List;

public class BinarySearchTreeStructure<T extends Comparable<T>> implements DataStructure<T> {
    private class Node {
        T data;
        Node left, right;

        Node(T data) {
            this.data = data;
        }
    }

    private Node root;

    public BinarySearchTreeStructure() {
        this.root = null;
    }

    public BinarySearchTreeStructure(List<T> items) {
        this();
        for (T item : items) {
            add(item);
        }
    }

    @Override
    public void add(T item) {
        root = addRecursive(root, item);
    }

    private Node addRecursive(Node node, T item) {
        if (node == null) {
            return new Node(item);
        }
        if (item.compareTo(node.data) < 0) {
            node.left = addRecursive(node.left, item);
        } else if (item.compareTo(node.data) > 0) {
            node.right = addRecursive(node.right, item);
        }
        return node;
    }

    @Override
    public T get(int index) {
        throw new UnsupportedOperationException("Binary Search Tree does not support indexed access.");
    }

    @Override
    public void set(int index, T item) {
        throw new UnsupportedOperationException("Binary Search Tree does not support indexed access.");
    }

    @Override
    public void delete(int index) {
        throw new UnsupportedOperationException("Binary Search Tree does not support indexed access.");
    }

    @Override
    public int size() {
        return sizeRecursive(root);
    }

    private int sizeRecursive(Node node) {
        if (node == null) {
            return 0;
        }
        return 1 + sizeRecursive(node.left) + sizeRecursive(node.right);
    }

    @Override
    public String toString() {
        return inorderTraversal(root);
    }

    private String inorderTraversal(Node node) {
        if (node == null) return "";
        return inorderTraversal(node.left) + node.data + " " + inorderTraversal(node.right);
    }
}