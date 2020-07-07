package dynamicprogramming;

import util.Utils;

public class UnBoundedKnapsack {
    // 1. Unbounded Knapsack
    // 2. Rod cutting problem
    // 3. coin change problem 1
    // 4.coin change problem 2
    // 5.
    // 6.
    // 7.
    public static void main(String[] args) {
        int[] val = {10, 40, 50, 70};
        int[] wt = {1, 3, 4, 5};
        System.out.println("unboundedKnapsack " + unboundedKnapsack(val, wt, 4, 8));

        int[] length = {1, 2, 3, 4, 5, 6, 7, 8};
        int[] price = {1, 5, 8, 9, 10, 17, 17, 20};
        System.out.println("rodCutting " + rodCutting(price, length, length.length, 8));

        int[] coin = {2, 5, 3, 6};
        System.out.println("coinChange " + coinChange(coin, coin.length, 10));
    }

    private static int unboundedKnapsack(int[] val, int[] wt, int n, int W) {
        int[][] dp = new int[n + 1][W + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    dp[i][j] = Utils.max(dp[i - 1][j], val[i - 1] + dp[i][j - wt[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][W];
    }

    private static int rodCutting(int[] price, int[] length, int n, int N) {
        int[][] dp = new int[n + 1][N + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= N; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (length[i - 1] <= j) {
                    dp[i][j] = Utils.max(dp[i - 1][j], price[i - 1] + dp[i][j - length[i - 1]]);
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][n];
    }

    private static int coinChange(int[] coin, int n, int sum) {
        int[][] dp = new int[n + 1][sum + 1];
        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= sum; j++) {
                if (i == 0 && j == 0) {
                    dp[i][j] = 1;
                } else if (i == 0) {
                    dp[i][j] = 0;
                } else if (j == 0) {
                    dp[i][j] = 1;
                } else if (coin[i - 1] <= j) {
                    dp[i][j] = dp[i - 1][j] + dp[i][j - coin[i - 1]];
                } else {
                    dp[i][j] = dp[i - 1][j];
                }
            }
        }
        return dp[n][sum];
    }
}
