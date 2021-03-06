package companywise;

import binarytree.BinaryTree;
import linkedlist.LinkedList;
import linkedlist.Node;
import util.Utils;

import java.util.Stack;

public class FlipKart {
    public static void main(String[] args) {

        // 1. Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
        int[] contiguousSubArray = new int[]{-2, 5, -1};
        System.out.println("contiguousSubArrayWithMaximumSum: " + contiguousSubArrayWithMaximumSum(contiguousSubArray, contiguousSubArray.length));


        // 2.  0 - 1 Knapsack Problem
        int[] val = new int[]{60, 100, 120};
        int[] weight = new int[]{10, 20, 30};
        System.out.println("KnapsackProblem " + KnapsackProblem(val, weight, val.length, 50));
        System.out.println("KnapsackProblemRec " + KnapsackProblemRec(val, weight, val.length, 50));

        // 3. inversion of array
        int[] arr = Utils.getRandomArray(10);
        System.out.println("inversionCountOfArray: " + inversionCountOfArray(arr, arr.length));

        // 4. Consecutive 1's not allowed
        System.out.println("countStrings: " + countStrings(5));

        // 5. Finding middle element in a linked list
        LinkedList linkedList = Utils.getRandomLinkedList(11);
        linkedList.print();
        System.out.println("findMiddleOfLinkedList: " + findMiddleOfLinkedList(linkedList.getHead()));

        // 14. Maximum Width of Tree
        System.out.print("dequeue : ");
        enqueue(5);
        enqueue(10);
        enqueue(11);
        System.out.print(dequeue() + " ");
        enqueue(14);
        System.out.print(dequeue() + " \n");


        // 15. Maximum Width of Tree
        BinaryTree binaryTree = Utils.getRandomBinaryTree(20);
        binaryTree.print(System.out, binaryTree.root);
        System.out.println("getMaxWidth : " + getMaxWidth(binaryTree.root));
    }

    // 1. Kadane's Algorithm
    // Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
    private static int contiguousSubArrayWithMaximumSum(int[] arr, int n) {
        int max_so_far = 0;
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            max_so_far = max_so_far + arr[i];
            if (max < max_so_far)
                max = max_so_far;
            if (max_so_far < 0)
                max_so_far = 0;
        }
        return max;
    }

    // 2.  0 - 1 Knapsack Problem  1st way
    private static int KnapsackProblem(int[] val, int[] wt, int n, int W) {
        int[][] arr = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    arr[i][j] = Utils.max(val[i - 1] + arr[i - 1][j - wt[i - 1]], arr[i - 1][j]);
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }
        return arr[n][W];
    }

    // 2nd way recursive
    private static int KnapsackProblemRec(int[] val, int[] wt, int n, int W) {
        if (n == 0 || W == 0) return 0;
        if (wt[n - 1] <= W) {
            return Utils.max(
                    val[n - 1] + KnapsackProblemRec(val, wt, n - 1, W - wt[n - 1])
                    , KnapsackProblemRec(val, wt, n - 1, W));
        }
        return KnapsackProblemRec(val, wt, n - 1, W);
    }

    // 3. inversion of array
    private static int inversionCountOfArray(int[] val, int n) {
        return 0;
    }

    // 4. Consecutive 1's not allowed
    private static int countStrings(int n) {

        int prev = 1, prev_prev = 1, prev_prev_prev = 1;
        for (int i = 1; i <= n; i++) {
            prev_prev_prev = prev_prev; // 1  1  2  3  5
            prev_prev = prev; // 1  2  3  5  8
            prev = prev_prev + prev_prev_prev; // 2 3 5 8 13
        }
        return prev;
    }

    // 5. Finding middle element in a linked list
    private static int findMiddleOfLinkedList(Node head) {
        Node slow = head;
        Node fast = head;
        while (slow.next != null && fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow.data;
    }

    // 14. Queue using two Stacks
    static Stack<Integer> s1 = new Stack<Integer>();
    static Stack<Integer> s2 = new Stack<Integer>();


    private static void enqueue(int x) {
        s1.push(x);
    }

    private static int dequeue() {
        if (s2.isEmpty()) {
            while (!s1.isEmpty())
                s2.push(s1.pop());
        }
        if (s2.isEmpty()) return -1;
        return s2.pop();
    }

    // 15. Maximum Width of Tree
    private static int max = Integer.MIN_VALUE;

    private static int getMaxWidth(binarytree.Node root) {
        int h = height(root);
        int[] arr = new int[h];
        maxWidthRec(root, arr, 0);
        return max;
    }

    private static void maxWidthRec(binarytree.Node node, int[] arr, int level) {
        if (node == null) return;
        arr[level]++;
        if (max < arr[level]) max = arr[level];
        maxWidthRec(node.left, arr, level + 1);
        maxWidthRec(node.right, arr, level + 1);
    }

    private static int height(binarytree.Node root) {
        if (root == null)
            return 0;
        int lDepth = height(root.left);
        int rDepth = height(root.right);
        return (lDepth > rDepth) ? (lDepth + 1) : (rDepth + 1);
    }
}
