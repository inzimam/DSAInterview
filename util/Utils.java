package util;

import binarytree.BinaryTree;
import linkedlist.LinkedList;
import linkedlist.Node;

import java.util.ArrayList;
import java.util.Random;

public class Utils {
    public static void main(String[] args) {
        BinaryTree binaryTree = new BinaryTree();
        binaryTree.add(8);
        binaryTree.add(5);
        binaryTree.add(2);
        binaryTree.add(7);
        binaryTree.add(11);
        binaryTree.add(3);
        binaryTree.print(System.out, binaryTree.root);
        System.out.println("findSumInBST " + findSumInBST(binaryTree.root, 3));
    }

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

    public static void printArrayList(ArrayList<Integer> arrayList, String tag) {
        System.out.print(tag + ": ");
        for (int a : arrayList) {
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

    public static void insertion() {
        LinkedList linkedList = Utils.getRandomLinkedList(10);
        linkedList.print();
        linkedList.head = insertionSort(linkedList.getHead());
        linkedList.print();
    }

    public static ArrayList<Integer> plusOne(ArrayList<Integer> A) {

        int sum = 0;
        int carry = 1;
        int i = A.size() - 1;

        while (i >= 0) {
            sum = A.get(i) + carry;
            carry = sum >= 10 ? 1 : 0;
            int digit = sum % 10;
            A.set(i, digit);
            i--;
        }
        if (carry > 0)
            A.add(0, carry);
        while (A.size() > 0 && A.get(0) == 0) {
            A.remove(0);
        }
        return A;
    }

    public static Node insertionSort(Node head) {
        Node temp = head;
        Node res = null;
        while (temp != null && temp.next != null) {
            if (temp.data < temp.next.data) {
                temp = temp.next;
            } else {

            }
        }
        return res;
    }

    public static void sortArray(int[] arr, int n) {
        int i = 0;
        while (i < n) {
            if (arr[i] > 0) {
                int elementIndex = arr[i] - 1;
                if (arr[elementIndex] < 0) {
                    arr[elementIndex]--;
                    arr[i] = 0;
                    i++;
                } else {
                    int temp = arr[elementIndex];
                    arr[elementIndex] = -1;
                    arr[i] = temp;
                }
            } else {
                i++;
            }
        }
    }

    public static boolean steppingNumber(int num) {
        int mod2 = -1;
        while (num > 0) {
            int mod1 = num % 10;
            if (mod2 != -1 && Math.abs(mod1 - mod2) != 1) {
                return false;
            }
            num /= 10;
            mod2 = mod1;
        }
        return true;
    }

    public static void print2D(int[][] mat) {
        for (int i = 0; i < mat.length; i++) {
            System.out.println("");
            for (int j = 0; j < mat[i].length; j++)
                System.out.print(mat[i][j] + " ");
        }
        System.out.println("");
    }

    static int sum = 0;

    public static int findSumInBST(binarytree.Node root, int k) {
        if (root == null) return 0;
        if (root.data <= k) {
            sum = sum + root.data;
        }
        findSumInBST(root.left, k);
        findSumInBST(root.right, k);
        return sum;
    }
}
