package companywise;

import util.Utils;

public class Samsung {
    public static void main(String[] args) {
        // 1. Longest Increasing Subsequence
//        int[] arr = Utils.getRandomArray(10);
        int[] arr = new int[]{0, 8, 4, 12, 2, 10, 6, 14, 1, 9, 5, 13, 3, 11, 7, 15};
        Utils.printArray(arr, "Actual array");
        System.out.println("longestSubsequence: " + longestSubsequence(arr, arr.length));
    }

    // 1. Longest Increasing Subsequence
    private static int longestSubsequence(int[] arr, int n) {
        int max = 0;
        int currentMax = 1;
        for (int i = 1; i < n; i++) {
            if (arr[i - 1] < arr[i]) {
                currentMax++;
            } else {
                currentMax = 1;
            }
            max = Utils.max(currentMax, max);
        }
        return max;
    }
}
