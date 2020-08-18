package dynamicprogramming;

import util.Utils;

public class KnapsackVariations {
    // 1. Knapsack
    // 2. Subset sum
    // 3. equal sum partition
    // 4. count of subset sum
    // 5. Minimum subset sum difference
    // 6. Target Sum
    // 7. No of subset of given difference
    public static void main(String[] args) {

        // 2.  0 - 1 Knapsack Problem
//        A : [ 377, 932, 309, 945, 440, 627, 324, 538, 539, 119, 83, 930, 542, 834, 116, 640, 659, 705, 931, 978, 307, 674, 387, 22, 746, 925, 73, 271, 830, 778, 574, 98, 513, 987, 291, 162, 637, 356, 768, 656, 575, 32, 53, 351, 151, 942, 725, 967, 431, 108, 192, 8, 338, 458, 288, 754, 384, 946, 910, 210, 759, 222, 589, 423, 947, 507, 31 ]
//        B : [ 14, 19, 1, 42, 13, 6, 11, 10, 25, 38, 49, 34, 46, 42, 3, 1, 42, 37, 25, 21, 47, 22, 49, 50, 19, 35, 32, 35, 4, 50, 19, 39, 1, 39, 28, 18, 29, 44, 49, 34, 8, 22, 11, 18, 14, 15, 10, 17, 36, 2, 1, 50, 20, 7, 49, 4, 25, 9, 45, 10, 40, 3, 46, 36, 44, 44, 24 ]
//        C : 588
        int[] val = new int[]{377, 932, 309, 945, 440, 627, 324, 538, 539, 119, 83, 930, 542, 834, 116, 640, 659, 705, 931, 978, 307, 674, 387, 22, 746, 925, 73, 271, 830, 778, 574, 98, 513, 987, 291, 162, 637, 356, 768, 656, 575, 32, 53, 351, 151, 942, 725, 967, 431, 108, 192, 8, 338, 458, 288, 754, 384, 946, 910, 210, 759, 222, 589, 423, 947, 507, 31};
        int[] weight = new int[]{14, 19, 1, 42, 13, 6, 11, 10, 25, 38, 49, 34, 46, 42, 3, 1, 42, 37, 25, 21, 47, 22, 49, 50, 19, 35, 32, 35, 4, 50, 19, 39, 1, 39, 28, 18, 29, 44, 49, 34, 8, 22, 11, 18, 14, 15, 10, 17, 36, 2, 1, 50, 20, 7, 49, 4, 25, 9, 45, 10, 40, 3, 46, 36, 44, 44, 24}; // W=5
        int W = 588;
        int[][] t = new int[weight.length + 1][W + 1];
//        System.out.println("KnapsackProblem " + knapsack(t, val, weight, val.length, W));
        System.out.println("KnapsackProblem " + knapsack01(val, weight, val.length, W));

        int[] subsetSum = new int[]{5, 9, 2, 7, 6};
        System.out.println("subsetSum : " + subsetSumProblem(subsetSum, 11, subsetSum.length));
        System.out.println("equalSumPartition" + (equalSumPartition(subsetSum, subsetSum.length) ? "YES" : "NO"));
        System.out.println("countOfSubsetSum " + countOfSubsetSum(subsetSum, 5, subsetSum.length));
        System.out.println("minSubsetSumDiff " + minSubsetSumDiff(subsetSum, subsetSum.length));
        System.out.println("findSubsetOfGivenDiff " + findSubsetOfGivenDiff(subsetSum, 2, subsetSum.length));
    }

    private static int knapsack(int[][] t, int[] val, int[] wt, int n, int W) {
        if (n == 0 || W == 0)
            return 0;
        if (wt[n - 1] > W) {
            return t[n][W] = knapsack(t, val, wt, n - 1, W);
        } else {
            return t[n][W] = Utils.max(knapsack(t, val, wt, n - 1, W), val[n - 1] + knapsack(t, val, wt, n - 1, W - wt[n - 1]));
        }
    }

    private static int knapsack01(int[] val, int[] wt, int n, int W) {
        int[][] arr = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                } else if (wt[i - 1] > j) {
                    arr[i][j] = arr[i - 1][j];
                } else {
                    arr[i][j] = Utils.max(arr[i - 1][j], val[i - 1] + arr[i - 1][j - wt[i - 1]]);
                }
            }
        }
        return arr[n][W];
    }

    private static boolean subsetSumProblem(int[] arr, int sum, int n) {
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j < sum + 1; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    private static boolean equalSumPartition(int[] arr, int n) {
        int total = 0;
        for (int i = 0; i < n; i++) {
            total = total + arr[i];
        }
        if (total % 2 != 0) {
            return false;
        }
        return subsetSumProblem(arr, total / 2, n);
    }

    private static int countOfSubsetSum(int[] arr, int sum, int n) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }

    private static int minSubsetSumDiff(int[] arr, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        int maxValue = Integer.MIN_VALUE;
        boolean[][] dp = new boolean[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = true;
                } else if (i == 0) {
                    dp[i][j] = false;
                } else if (j == 0) {
                    dp[i][j] = true;
                } else if (arr[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] || dp[i - 1][j - arr[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
                if (dp[n][j] && j < (sum / 2) + 1) {
                    maxValue = j;
                }
            }
        }
        return sum - (2 * maxValue);
    }

    private static boolean findSubsetOfGivenDiff(int[] arr, int diff, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        // subset1 - subset2 = diff
        // subset1 + subset2 = sum
        int s1 = (diff + sum) / 2;
        return subsetSumProblem(arr, s1, n);
    }
}