package util;

import binarytree.BinaryTree;
import linkedlist.LinkedList;

public class Utils {
    public static int[] getRandomArray(int length) {
        int[] randoms = new int[length];
        for (int i = 0; i < length; i++) {
            randoms[i] = (int) (Math.random() * 10);
        }
        return randoms;
    }

    public static void printArray(int[] arr, String tag) {
        System.out.print(tag + ": ");
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public static void printArray(String[] arr, String tag) {
        System.out.print(tag + ": ");
        for (String a : arr) {
            System.out.print(a + " ");
        }
        System.out.println("");
    }

    public static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static void swap(int[] arr, int i, int j) {
        int temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    public static LinkedList getRandomLinkedList(int length) {
        LinkedList linkedList = new LinkedList();
        for (int i = 0; i < length; i++) {
            linkedList.insertNodeAtFront((int) (Math.random() * 10));
        }
        return linkedList;
    }

    public static BinaryTree getRandomBinaryTree(int length) {
        BinaryTree binaryTree = new BinaryTree();
        for (int i = 0; i < length; i++) {
            binaryTree.add((int) (Math.random() * 10));
        }
        return binaryTree;
    }
}
