package companywise;

import util.Utils;

public class Samsung {
    public static void main(String[] args) {
        // 1. Longest Increasing Subsequence
//        int[] arr = Utils.getRandomArray(10);
        int[] arr = {10, 22, 9, 33, 21, 50, 41, 60};
        Utils.printArray(arr, "Actual array");
        System.out.println("longestSubsequence: " + longestSubsequence(arr, arr.length));
    }

    // 1. Longest Increasing Subsequence
    private static int longestSubsequence(int[] arr, int n) {
        int[] dp = new int[n];
        int i, j, max = 0;

        for (i = 0; i < n; i++)
            dp[i] = 1;

        for (i = 1; i < n; i++) {
            for (j = 0; j < i; j++) {
                if (arr[i] > arr[j] && dp[i] < dp[j] + 1) {
                    dp[i] = dp[j] + 1;
                    max = Math.max(max, dp[i]);
                }
            }
        }

        return max;
    }
}
