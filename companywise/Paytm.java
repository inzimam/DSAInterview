package companywise;

import Linkedlist.LinkedList;
import binarytree.Node;
import java.util.HashSet;
import java.util.Set;

public class Paytm {
    public static void main(String[] args) {
        int[] arr = new int[]{2, 0, 1, 2, 2, 1, 2, 0, 1, 2, 2, 1, 0, 1, 1, 1, 0, 1, 0};
        String[] strArr = {"1", "0", "1", "2", "1", "1", "0", "0", "1", "2", "1", "2", "1", "2", "1", "0", "0", "1", "1", "2", "2", "0", "0", "2", "2", "2", "1", "1", "1", "2", "0", "0", "0", "2", "0", "1", "1", "1", "1", "0", "0", "0", "2", "2", "1", "2", "2", "2", "0", "2", "1", "1", "2", "2", "0", "2", "2", "1", "1", "0", "0", "2", "0", "2", "2", "1", "0", "1", "2", "0", "0", "0", "0", "2", "0", "2", "2", "0", "2", "1", "0", "0", "2", "2"};
        sortArrayOf0s1s2s(strArr, strArr.length);
        printArray(strArr);
        arr = new int[]{1, 4, 2, 5, 9, 1, 2, 7};
        arr = new int[]{100, 4, 2, 5, 9, 1, 2, 100};
        System.out.println(reverseString("i.like.this.program.very.much"));
        System.out.println(maxSum(arr, arr.length));

        LinkedList linkedList = new LinkedList();
        linkedList.add(2);
        linkedList.add(4);
        linkedList.addAtFirst(1);
        linkedList.add(5);
        linkedList.add(6);
        linkedList.add(7);
        linkedList.add(8);
        linkedList.addAtPosition(3, 8);
        linkedList.traverse();
        linkedList.head = reverseLinkedList(linkedList.head);
        linkedList.traverse();
        linkedList.head = reverseLinkedListInGroups(linkedList.head, 2);
        linkedList.traverse();
        Node head = makeBinaryTree();
        Node newHead = mirrorBinaryTree(head);
        System.out.println("Inzy " + isBalanced(head));
        int[][] mat = {{0, 0, 0, 1},
                {0, 1, 1, 1},
                {1, 1, 1, 1},
                {0, 1, 1, 1}};
        System.out.println("Index of row with maximum 1s is "
                + findRowMaxOne(mat, 4, 4));
        arr = new int[]{2, 3, 3, 2, 5};
        findCounts(arr, arr.length);
//        geeksforgeeks set
//        adcffaet onkl
        System.out.println("minimumIndexedCharacter "
                + minimumIndexedCharacter("adcffaet", "onkl"));
        System.out.println("minimumIndexedCharacter "
                + minimumIndexedCharacter1("geeksforgeeks", "set"));
    }

    static String minimumIndexedCharacter(String str, String ptr) {
        int curr_min = Integer.MAX_VALUE;
        for (char c : ptr.toCharArray()) {
            if (str.indexOf(c) != -1 && str.indexOf(c) < curr_min) {
                curr_min = str.indexOf(c);
            }
        }
        return curr_min == Integer.MAX_VALUE ? "$" : str.charAt(curr_min) + "";
    }

    static char minimumIndexedCharacter1(String str, String ptr) {
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

    static void findCounts(int[] arr, int n) {
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


    static int findRowMaxOne(int[][] mat, int m, int n) {
        int row = -1;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < m; i++) {
            int val = getFirstOccurence(mat[i], 0, n);
            if (val != -1 && val < min) {
                min = val;
                row = i;
            }
        }
        return row;
    }


    static int getFirstOccurence(int[] arr, int low, int high) {
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

    private static int rowWithMax1s(int[][] arr, int m, int n, int i) {
        int j = 0;
        while (j < n && i < m) {
            if (arr[j][i] == 1) {
                return j;
            }
            j++;
        }
        i++;
        return rowWithMax1s(arr, m, n, i);
    }

    private static Node makeBinaryTree() {
        Node head = new Node(1);
        head.left = new Node(3);
        head.right = new Node(2);
        head.right.left = new Node(5);
        head.right.right = new Node(4);
//        head.right.right.right = new Node(4);
//        head.right.right.right.right = new Node(4);
//        head.right.right.right.right.right = new Node(4);
        return head;
    }

    static boolean isBalanced(Node node) {

        int lh, rh;
        if (node == null)
            return true;
        lh = height(node.left);
        rh = height(node.right);

        if (Math.abs(lh - rh) <= 1 && isBalanced(node.left) && isBalanced(node.right))
            return true;
        return false;
    }

    static int height(Node node) {
        if (node == null)
            return 0;
        return 1 + Math.max(height(node.left), height(node.right));
    }


    private static Node mirrorBinaryTree(Node node) {
        if (node == null)
            return null;

        Node temp = node.left;
        node.left = node.right;
        node.right = temp;
        mirrorBinaryTree(node.left);
        mirrorBinaryTree(node.right);
        return node;
    }

    static int maxSum(int[] list, int list_len) {
        int prev_sum = list[0];
        int prev_prev_sum = 0;
        int curr_sum;
        for (int i = 1; i < list_len; i++) {
            curr_sum = prev_prev_sum + list[i];
            prev_prev_sum = Math.max(prev_prev_sum, prev_sum);
            prev_sum = curr_sum;
        }
        return Math.max(prev_prev_sum, prev_sum);
    }

    //    Sort an array of 0s, 1s and 2s
    private static void sortArrayOf0s1s2s(String[] arr, int size) {
        int low = 0, mid = 0, high = size - 1;

        while (mid <= high) {
            switch (arr[mid]) {
                case "0": {
                    swap(arr, low, mid);
                    mid++;
                    low++;
                    break;
                }
                case "1": {
                    mid++;
                    break;
                }
                case "2": {
                    swap(arr, mid, high);
                    high--;
                    break;
                }
            }
        }
    }

    private static void swap(String[] arr, int i, int j) {
        String temp = arr[i];
        arr[i] = arr[j];
        arr[j] = temp;
    }

    //Given a String of length S, reverse the whole string without reversing the individual words in it. Words are separated by dots.
    private static String reverseString(String str) {
        String[] arr = str.split("\\.");
        if (arr.length == 1) {
            return arr[0];
        }
        return arr[arr.length - 1] + reverseString(str.substring(0, str.lastIndexOf(".")));
    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }

    private static void printArray(String[] arr) {
        for (String a : arr) {
            System.out.print(a + " ");
        }
        System.out.println(" ");
    }

    public static Linkedlist.Node reverseLinkedList(Linkedlist.Node head) {
        Linkedlist.Node prev = null;
        Linkedlist.Node curr = head;

        while (curr != null) {
            Linkedlist.Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
        }
        return prev;
    }

    public static Linkedlist.Node reverseLinkedListInGroups(Linkedlist.Node head, int k) {
        if (head == null)
            return null;
        Linkedlist.Node prev = null;
        Linkedlist.Node curr = head;
        int i = 0;
        while (i < k && curr != null) {
            Linkedlist.Node temp = curr.next;
            curr.next = prev;
            prev = curr;
            curr = temp;
            i++;
        }
        if (curr != null)
            head.next = reverseLinkedListInGroups(curr, k);
        return prev;
    }
}
