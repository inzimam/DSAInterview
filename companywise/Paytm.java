package companywise;

import binarytree.BinaryTree;
import linkedlist.LinkedList;
import linkedlist.Node;
import util.Utils;

import java.util.ArrayList;

public class Paytm {
    public static void main(String[] args) {
        // Sort an array of 0s, 1s and 2s
        String[] strArr = {"1", "0", "1", "2", "1", "1", "0", "0", "1", "2", "1", "2", "1", "2", "1", "0", "0", "1", "1", "2", "2", "0", "0", "2", "2", "2", "1", "1", "1", "2", "0", "0", "0", "2", "0", "1", "1", "1", "1", "0", "0", "0", "2", "2", "1", "2", "2", "2", "0", "2", "1", "1", "2", "2", "0", "2", "2", "1", "1", "0", "0", "2", "0", "2", "2", "1", "0", "1", "2", "0", "0", "0", "0", "2", "0", "2", "2", "0", "2", "1", "0", "0", "2", "2"};
        sortArray012(strArr, strArr.length);
        Utils.printArray(strArr, "sortArray012");

        // Reverse words in a given string
        String reverseWords = "I am a good boy";
        System.out.println(reverseWords(reverseWords));

        //Reverse a linked list
        LinkedList linkedList = Utils.getRandomLinkedList(10);
        linkedList.print();
        linkedList.head = reverseLinkedList(linkedList.getHead());
        linkedList.print();

        //Reverse a Linked List in groups of given size.
        linkedList.head = reverseInGroups(linkedList.getHead(), 3);
        linkedList.print();

        //Max Sum without adjacent
        int[] arr = Utils.getRandomArray(10);
        Utils.printArray(arr, "Actual array");
        System.out.println("maxSumWithoutAdjacent: " + maxSumWithoutAdjacent(arr, arr.length));

        // Mirror Tree
        BinaryTree binaryTree = Utils.getRandomBinaryTree(10);
        binaryTree.traversePreOrder();
        System.out.println("");
        mirrorTree(binaryTree.root);
        binaryTree.traversePreOrder();
        System.out.println("");

        //Row with max 1s
        int[][] mat = {{0, 0, 0, 1}, {0, 1, 1, 1}, {1, 1, 1, 1}, {0, 1, 1, 1}};
        System.out.println("Index of row with maximum 1s is " + rowWithMax1(mat, 4, 4));

        //Frequencies of Limited Range Array Elements
        int[] frequencies = new int[]{2, 3, 3, 2, 5};
        frequenciesOfAllElements(frequencies, frequencies.length);
    }

    // Sort an array of 0s, 1s and 2s
    private static void sortArray012(String[] arr, int size) {
        int low = 0, mid = 0, high = size - 1;
        while (mid <= high) {
            switch (arr[mid]) {
                case "0": {
                    Utils.swap(arr, low, mid);
                    low++;
                    mid++;
                    break;
                }
                case "1": {
                    mid++;
                    break;
                }
                case "2": {
                    Utils.swap(arr, mid, high);
                    high--;
                    break;
                }
            }
        }
    }

    // Reverse words in a given string
    private static String reverseWords(String word) {
        String[] arr = word.split(" ");
        if (arr.length == 1) {
            return arr[0];
        }
        return arr[arr.length - 1] + " " + reverseWords(word.substring(0, word.lastIndexOf(" ")));
    }

    //Reverse a linked list
    private static Node reverseLinkedList(Node head) {
        Node prev = null;
        Node curr = head;
        while (curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //Reverse a Linked List in groups of given size.
    private static Node reverseInGroups(Node head, int k) {
        if (head == null)
            return null;
        Node prev = null;
        Node curr = head;
        int count = 0;
        while (count < k && curr != null) {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
            count++;
        }
        if (curr != null) {
            head.next = reverseInGroups(curr, k);
        }
        return prev;
    }

    //Max Sum without adjacent
    private static int maxSumWithoutAdjacent(int[] arr, int size) {
        int prev_prev_sum = 0;
        int prev_sum = arr[0];
        int curr_sum = 0;
        for (int i = 1; i < size; i++) {
            curr_sum = prev_prev_sum + arr[i];
            prev_prev_sum = Math.max(prev_sum, prev_prev_sum);
            prev_sum = curr_sum;
        }
        return Math.max(prev_sum, prev_prev_sum);
    }

    // Mirror Tree
    private static void mirrorTree(binarytree.Node root) {
        if (root == null)
            return;
        mirrorTree(root.left);
        mirrorTree(root.right);
        binarytree.Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    //Flattening a Linked List
    private static void flattenLinkedList(Node head) {
        //TBD
    }

    //Check for Balanced Tree
    private static boolean checkBalancedTree(binarytree.Node root) {
        int lh, rh;
        if (root == null)
            return true;
        lh = height(root.left);
        rh = height(root.right);

        if (Math.abs(lh - rh) <= 1 && checkBalancedTree(root.left) && checkBalancedTree(root.right))
            return true;
        return false;
    }

    private static int height(binarytree.Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }

    //Find the number of islands
    private static boolean findNoOfIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {
        return true;
    }

    //Coin Change
    private static boolean coinChange() {
        return true;
    }

    //Frequencies of Limited Range Array Elements
//    Given an array A[] of N positive integers which can contain integers from 1 to N where elements can be
//    repeated or can be absent from the array. Your task is to count frequency of all elements from 1 to N.
//    Note: Expected time complexity is O(n) with O(1) extra space.

    private static void frequenciesOfAllElements(int[] arr, int n) {
        int i = 0;
        while (i < n) {
            if (arr[i] <= 0) {
                i++;
                continue;
            }
            int index = arr[i] - 1;
            if (arr[index] > 0) {
                arr[i] = arr[index];
                arr[index] = -1;
            } else {
                arr[index]--;
                arr[i] = 0;
                i++;
            }
        }

        System.out.println("Below are counts of all elements");
        for (int j = 0; j < n; j++)
            System.out.println(j + 1 + "->" + Math.abs(arr[j]));

    }

    //    Convert array into Zig-Zag fashion
//    Given an array of DISTINCT elements, rearrange the elements of array in zig-zag fashion in O(n) time.
//    The converted array should be in form a < b > c < d > e < f.
    private static void convertArrayToZigZag(int[] arr) {

    }

    //Row with max 1s     ==== 1st way
    private static int rowWithMax1(int[][] arr, int m, int n) {
        int row = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int val = getFirstOccurence(arr[i], 0, n);
            if (val != -1 && val < min) {
                min = val;
                row = i;
            }
        }
        return row;
    }

    private static int getFirstOccurence(int[] arr, int low, int high) {
        if (high >= low) {
            int mid = low + (high - low) / 2;
            if ((mid == 0 || (arr[mid - 1] == 0)) && arr[mid] == 1)
                return mid;
            else if (arr[mid] == 0)
                return getFirstOccurence(arr, (mid + 1), high);
            else
                return getFirstOccurence(arr, low, (mid - 1));
        }
        return -1;
    }

    //Row with max 1s     ==== 2nd way
    private static int rowWithMax1(int[][] arr, int m, int n, int i) {
        int j = 0;
        while (j < n && i < m) {
            if (arr[j][i] == 1) {
                return j;
            }
            j++;
        }
        i++;
        return rowWithMax1(arr, m, n, i);
    }

    //Maximum Rectangular Area in a Histogram
    private static void areaOfHistogram(int[][] arr) {

    }
}
