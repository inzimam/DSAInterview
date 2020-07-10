package dynamicprogramming;

import util.Utils;

import java.util.ArrayList;

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
        int[] val = new int[]{4, 6, 5, 1000};
        int[] weight = new int[]{2, 1, 3, 1}; // W=5
        int W = 5;
        int[][] t = new int[weight.length + 1][W + 1];
        System.out.println("KnapsackProblem " + knapsack(t, val, weight, val.length, W));

        int[] subsetSum = new int[]{5, 9, 2, 7, 6};
        System.out.println("subsetSum : " + subsetSumProblem(subsetSum, 2, subsetSum.length));
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
        ArrayList<Integer> arrayList = new ArrayList<>();
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
                    arrayList.add(j);
                }
            }
        }
        int min = Integer.MAX_VALUE;
        for (Integer integer : arrayList) {
            int val = sum - (2 * integer);
            if (min > val) {
                min = val;
            }
        }
        return min;
    }

    private static boolean findSubsetOfGivenDiff(int[] arr, int diff, int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            sum = sum + arr[i];
        }
        int s1 = (diff + sum) / 2;
        return subsetSumProblem(arr, s1, n);
    }
}