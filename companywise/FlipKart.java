package companywise;

import util.Utils;

public class FlipKart {
    public static void main(String[] args) {
        int[] val = new int[]{60, 100, 120};
        int[] weight = new int[]{10, 20, 30};
        System.out.println("Inzy " + KnapsackProblem(val, weight, val.length, 50));
    }

    // 2.  0 - 1 Knapsack Problem
    private static int KnapsackProblem(int[] val, int[] wt, int n, int W) {
        int[][] arr = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    arr[i][j] = Utils.max(arr[i - 1][j], val[i - 1] + arr[i - 1][j - wt[i - 1]]);
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }
        return arr[n][W];
    }
}
