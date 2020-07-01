package companywise;

import binarytree.BinaryTree;
import binarytree.Node;
import util.Utils;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.Set;

//https://www.geeksforgeeks.org/must-coding-questions-company-wise/#ola
public class Ola {

    public static void main(String[] args) {
        // 1. Given an array arr of N integers. Find the contiguous sub-array with maximum sum.
        int[] contiguousSubArray = new int[]{-2, 5, -1};
        System.out.println("contiguousSubArrayWithMaximumSum: " + contiguousSubArrayWithMaximumSum(contiguousSubArray, contiguousSubArray.length));

        // 2. Missing number in array
        int[] missingNumber = new int[]{1, 2, 3, 5, 6, 7, 8, 9, 10};
        System.out.println("missingNumberInArray: " + missingNumberInArray(missingNumber, missingNumber.length));

        // 3. Sort an array of 0s, 1s and 2s
        String[] strArr = {"1", "0", "1", "2", "1", "1", "0", "0", "1", "2", "1", "2", "1", "2", "1", "0", "0", "1", "1", "2", "2", "0", "0", "2", "2", "2", "1", "1", "1", "2", "0", "0", "0", "2", "0", "1", "1", "1", "1", "0", "0", "0", "2", "2", "1", "2", "2", "2", "0", "2", "1", "1", "2", "2", "0", "2", "2", "1", "1", "0", "0", "2", "0", "2", "2", "1", "0", "1", "2", "0", "0", "0", "0", "2", "0", "2", "2", "0", "2", "1", "0", "0", "2", "2"};
        sortArray012(strArr, strArr.length);
        Utils.printArray(strArr, "sortArray012");

        // 4. Search in a matrix
        int[][] searchInMatrix1 = new int[][]{{3, 30, 38}, {44, 52, 54}, {57, 60, 69}};
        System.out.println("searchInMatrix1: " + searchInMatrix(searchInMatrix1, 3, 3, 62));
        int[][] searchInMatrix2 = new int[][]{{18, 21, 27, 38, 55, 67}};
        System.out.println("searchInMatrix2: " + searchInMatrix(searchInMatrix2, 1, 6, 55));

        // 5. Left View of Binary Tree
        BinaryTree leftViewBinaryTree = Utils.getRandomBinaryTree(10);
        leftViewBinaryTree.print(System.out, leftViewBinaryTree.root);
        System.out.println("\nroot: " + leftViewBinaryTree.root.data + "\n");
        leftViewOfBinaryTree(leftViewBinaryTree.root, true);
        leftViewUtil(leftViewBinaryTree.root, 1);

        // 6. Mirror Tree
        BinaryTree mirrorBinaryTree = Utils.getRandomBinaryTree(10);
        System.out.println("\nbefore mirrorBinaryTree");
        mirrorBinaryTree.print(System.out, mirrorBinaryTree.root);
        System.out.println("\nafter mirrorBinaryTree\n");
        mirrorTree(mirrorBinaryTree.root);
        mirrorBinaryTree.print(System.out, mirrorBinaryTree.root);

        // 7. Connect Nodes at Same Level
        connectRight(mirrorBinaryTree.root);

        // 8. K distance from root
        printKDistanceNodes(mirrorBinaryTree.root, 2);

        // 9. Level order traversal in spiral form
        levelOrderSpiral(mirrorBinaryTree.root);

        // 10. First Non Repeating Character
        System.out.println("firstNonRepeatingChar : " + firstNonRepeatingChar("hello"));

        // 11. Find the number of islands
        ArrayList<ArrayList<Integer>> A = Utils.getArrayList(5, 5);
        System.out.println("findNoOfIslands : " + findNoOfIslands(A, 5, 5));

        // 12. Minimum indexed character 1st & 2nd way
        System.out.println("minimumIndexedCharacter " + minimumIndexedCharacter("adcffaet", "onkl"));
        System.out.println("minimumIndexedCharacter " + minimumIndexedCharacter1("geeksforgeeks", "set"));

        // 13. Maximum difference between two elements such that larger element appears after the smaller number
        int[] maxDifference = Utils.getRandomArray(10);
        Utils.printArray(maxDifference, "Array before maxDifference : ");
        System.out.println("maxDifference : " + maxDifference(maxDifference));
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

    // 2. Missing number in array
    private static int missingNumberInArray(int[] arr, int n) {
        int numberLen = n + 1;
        int totalSum = numberLen * (numberLen + 1) / 2;
        int arrSum = 0;
        for (int i = 0; i < n; i++) {
            arrSum += arr[i];
        }
        return totalSum - arrSum;
    }

    // 3. Sort an array of 0s, 1s and 2s
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

    // 4. Search in a matrix
    private static int searchInMatrix(int[][] arr, int n, int m, int x) {
        int i = 0, j = m - 1;
        while (i < n && j >= 0) {
            if (arr[i][j] == x) {
                return 1;
            } else if (arr[i][j] > x) {
                j--;
            } else {
                i++;
            }
        }
        return 0;
    }

    // 5. Left View of Binary Tree 1st Way
    private static void leftViewOfBinaryTree(Node node, boolean isLeft) {
        if (node == null) return;
        if (isLeft)
            System.out.print(node.data + " ");
        leftViewOfBinaryTree(node.left, true);
        leftViewOfBinaryTree(node.right, false);
    }

    private static int max_level = 0;

    // 5. 2nd way
    private static void leftViewUtil(Node root, int level) {
        if (root == null)
            return;
        if (max_level < level) {
            System.out.print(root.data + " ");
            max_level = level;
        }
        leftViewUtil(root.left, level + 1);
        leftViewUtil(root.right, level + 1);
    }

    // 6. Mirror Tree
    private static void mirrorTree(binarytree.Node root) {
        if (root == null)
            return;
        mirrorTree(root.left);
        mirrorTree(root.right);
        binarytree.Node temp = root.left;
        root.left = root.right;
        root.right = temp;
    }

    // 7. Connect Nodes at Same Level
    private static void connectRight(binarytree.Node p) {
        if (p == null) return;
        p.nextRight = null;
        connectRightRecur(p);
    }

    private static void connectRightRecur(binarytree.Node p) {
        if (p == null) return;
        if (p.left != null) p.left.nextRight = p.right;
        if (p.right != null) p.right.nextRight = p.nextRight != null ? p.nextRight.left : null;
        connectRight(p.left);
        connectRight(p.right);
    }

    // 8. K distance from root
    // Recursive function to print right view of a binary tree.
    private static void printKDistanceNodes(Node root, int k) {
        if (root == null) return;
        if (k == 0) {
            System.out.println(root.data + " ");
        } else {
            printKDistanceNodes(root.left, k - 1);
            printKDistanceNodes(root.right, k - 1);
        }
    }

    // 9. Level order traversal in spiral form
    private static void levelOrderSpiral(Node root) {

    }

    // 10. First Non Repeating Character
    private static String firstNonRepeatingChar(String str) {
        int[] arr = new int[256];
        for (int i = 0; i < str.length(); i++) {
            arr[str.charAt(i)]++;
        }
        for (int i = 0; i < str.length(); i++) {
            if (arr[str.charAt(i)] == 1) {
                return str.charAt(i) + "";
            }
        }
        return "-1";
    }

    // 11. Find the number of islands
    private static int findNoOfIslands(ArrayList<ArrayList<Integer>> A, int N, int M) {
        int noOfIslands = 0;
        for (int i = 0; i < N; i++) {
            for (int j = 0; j < M; j++) {
                if (A.get(i).get(j) == 1) {
                    noOfIslands += dfs(A, i, j);
                }
            }
        }
        return noOfIslands;
    }

    private static int dfs(ArrayList<ArrayList<Integer>> A, int i, int j) {
        if (i < 0 || i >= A.size() || j < 0 || j >= A.get(i).size() || A.get(i).get(j) == 0) {
            return 0;
        }
        A.get(i).set(j, 0);
        dfs(A, i + 1, j);
        dfs(A, i - 1, j);
        dfs(A, i, j + 1);
        dfs(A, i, j - 1);
        dfs(A, i + 1, j + 1);
        dfs(A, i - 1, j - 1);
        dfs(A, i + 1, j - 1);
        dfs(A, i - 1, j + 1);
        return 1;
    }


    // 12. Minimum indexed character 1st way
    private static String minimumIndexedCharacter(String str, String ptr) {
        int curr_min = Integer.MAX_VALUE;
        for (char c : ptr.toCharArray()) {
            if (str.indexOf(c) != -1 && str.indexOf(c) < curr_min) {
                curr_min = str.indexOf(c);
            }
        }
        return curr_min == Integer.MAX_VALUE ? "$" : str.charAt(curr_min) + "";
    }

    // 12. 2nd way
    private static char minimumIndexedCharacter1(String str, String ptr) {
        Set<Character> set = new HashSet<>();
        for (char c : ptr.toCharArray()) {
            set.add(c);
        }

        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                return str.charAt(i);
            }
        }
        return '$';
    }

    // 13. Maximum difference between two elements such that larger element appears after the smaller number
    private static int maxDifference(int[] arr) {
        int max_diff = arr[1] - arr[0];
        int min_element = arr[0];
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - min_element > max_diff) {
                max_diff = arr[i] - min_element;
            }
            if (arr[i] < min_element)
                min_element = arr[i];
        }
        return max_diff;
    }

    // 14. Find the element that appears once in sorted array
    private static void elementOnceAppears(int[] arr, int n) {

        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {

            }
        }
    }
}
