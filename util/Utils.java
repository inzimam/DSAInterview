package util;

import binarytree.BinaryTree;
import linkedlist.LinkedList;

import java.util.ArrayList;
import java.util.Random;

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
            binaryTree.add(getRandom());
        }
        return binaryTree;
    }

    private static int getRandom() {
        Random r = new Random();
        int low = 10;
        int high = 100;
        return r.nextInt(high - low) + low;
    }

    public static ArrayList<ArrayList<Integer>> getArrayList(int m, int n) {
        ArrayList<ArrayList<Integer>> A = new ArrayList<>();

        for (int i = 0; i < m; i++) {
            ArrayList<Integer> arrayList = new ArrayList<>();
            for (int j = 0; j < n; j++) {
                if ((i + j) % 3 == 0) arrayList.add(1);
                else arrayList.add(0);
            }
            A.add(arrayList);
        }
        return A;
    }

    public static int max(int v1, int v2) {
        return Math.max(v1, v2);
    }

    public static int min(int v1, int v2) {
        return Math.min(v1, v2);
    }

    public enum ALPHABET {
        LOWER,
        UPPER,
        NOT_ALPHABET
    }

    public static ALPHABET checkAlphabet(char ch) {

        if (ch >= 'A' && ch <= 'Z')
            return ALPHABET.UPPER;
        else if (ch >= 'a' && ch <= 'z')
            return ALPHABET.LOWER;
        else
            return ALPHABET.NOT_ALPHABET;
    }
}
