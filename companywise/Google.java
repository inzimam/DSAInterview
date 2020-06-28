package companywise;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Stack;

class Google {

    public static void main(String[] args) {
        int[] arr = {1, 2,  4, 5, 6, 7, 8, 9, 10};
        subArrayWithGivenSum(arr, 10);
        System.out.println("Valid : " + validParenthesis(""));

        char[] arr1 = {5, 3, 4, 9, 7, 6};
        char[] arr2 = {4, 3, 2, 1};
        nextGreaterElementPermutation(arr2, arr2.length);
    }

    static void subArrayWithGivenSum(int[] arr, int sum) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        int currSum = 0;
        int j = 0;
        for (int i = 0; i < arr.length; i++) {
            currSum = currSum + arr[i];
            if (currSum == sum) {
                System.out.println(j + " , " + i);
                return;
            } else if (currSum < sum) {
                hashMap.put(i, currSum);
            } else {
                while (currSum > sum) {
                    currSum = currSum - arr[j];
                    j++;
                }
                if (currSum == sum) {
                    System.out.println(j + " , " + i);
                    return;
                }
            }
        }
    }

    static void nextGreaterElementPermutation(char[] arr, int len) {

        int min = Integer.MAX_VALUE;
        int minPos = len - 1;
        int i;
        for (i = len - 1; i > 0; i--) {
            if (arr[i] < min) {
                min = arr[i];
                minPos = i;
            }
            if (arr[i - 1] < arr[i]) {
                break;
            }
        }
        if (i == 0) {
            System.out.println("No value found");
            return;
        }

        arr[minPos] = arr[i - 1];
        arr[i - 1] = (char) min;
        Arrays.sort(arr, i, len);
        printArray(arr, "nextGreaterElementPermutation");

    }

    static boolean validParenthesis(String str) {
        Stack<Character> stack = new Stack<>();
        for (int i = 0; i < str.length(); i++) {
            if (stack.empty()) {
                stack.push(str.charAt(i));
                continue;
            }
            char c = stack.pop();
            if (str.charAt(i) == c) {
                stack.push(c);
                stack.push(c);
            }
        }
        return stack.isEmpty();
    }

    static private void printArray(char[] arr, String title) {
        System.out.println(title);
        for (int val : arr) {
            System.out.print("[" + val + "] ");
        }
    }
}
