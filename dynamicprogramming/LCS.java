package dynamicprogramming;

import util.Utils;

import java.util.Arrays;

public class LCS {
    public static void main(String[] args) {
        String X = "geerkest";
        String Y = "ekest";
        int[][] t = new int[X.length() + 1][Y.length() + 1];
        for (int[] ints : t) {
            Arrays.fill(ints, -1);
        }
        System.out.println("lcs recursion : " + longestSubSequence(t, X, Y, X.length(), Y.length()));
        System.out.println("lcs dp : " + longestSubSequence(X, Y, X.length(), Y.length()));
        System.out.println("longestSubString : " + longestSubString(X, Y, X.length(), Y.length()));
        System.out.println("printLongestSubSequence : " + printLongestSubSequence(X, Y, X.length(), Y.length()));
        System.out.println("shortestCommonSuperSequence : " + shortestCommonSuperSequence(X, Y, X.length(), Y.length()));
        X = "heap";
        Y = "pea";
        System.out.println("minNoOfInsetionDeletion : " + minNoOfInsertionDeletion(X, Y, X.length(), Y.length()));
        X = "agbcba";
        System.out.println("longestPalindromicSubsequence : " + longestPalindromicSubsequence(X, X.length()));
        System.out.println("minNoOfDelForPalindrome : " + minNoOfDelForPalindrome(X, X.length()));
    }

    private static int longestSubSequence(int[][] t, String X, String Y, int m, int n) {
        if (m == 0 || n == 0)
            return 0;
        if (t[m][n] != -1)
            return t[m][n];
        if (X.charAt(m - 1) == Y.charAt(n - 1)) {
            return t[m][n] = 1 + longestSubSequence(t, X, Y, m - 1, n - 1);
        } else {
            return t[m][n] = Utils.max(longestSubSequence(t, X, Y, m, n - 1)
                    , longestSubSequence(t, X, Y, m - 1, n));
        }
    }

    private static int longestSubSequence(String X, String Y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Utils.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        return dp[m][n];
    }

    private static int longestSubString(String X, String Y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        int longest = 0;
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if ((X.charAt(i - 1) == Y.charAt(j - 1))) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                    if (dp[i][j] > longest) {
                        longest = dp[i][j];
                    }
                } else {
                    dp[i][j] = 0;
                }
            }
        }
        return longest;
    }

    private static String printLongestSubSequence(String X, String Y, int m, int n) {
        int[][] dp = new int[m + 1][n + 1];
        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    dp[i][j] = 0;
                } else if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                    dp[i][j] = 1 + dp[i - 1][j - 1];
                } else {
                    dp[i][j] = Utils.max(dp[i - 1][j], dp[i][j - 1]);
                }
            }
        }
        int i = m, j = n;
        String output = "";
        while (i > 0 && j > 0) {
            if (X.charAt(i - 1) == Y.charAt(j - 1)) {
                output = X.charAt(i - 1) + output;
                i--;
                j--;
            } else {
                if (dp[i - 1][j] > dp[i][j - 1]) {
                    i--;
                } else {
                    j--;
                }
            }
        }
        return output;
    }

    private static int shortestCommonSuperSequence(String X, String Y, int m, int n) {
        return m + n - longestSubSequence(X, Y, m, n);
    }

    private static int minNoOfInsertionDeletion(String X, String Y, int m, int n) {
        return m + n - (2 * longestSubSequence(X, Y, m, n));
    }

    private static int longestPalindromicSubsequence(String S, int n) {
        StringBuilder reverse = new StringBuilder(S);
        reverse = reverse.reverse();
        return longestSubSequence(S, reverse.toString(), n, n);
    }

    private static int minNoOfDelForPalindrome(String S, int n) {
        StringBuilder reverse = new StringBuilder(S);
        reverse = reverse.reverse();
        return S.length() - longestSubSequence(S, reverse.toString(), n, n);
    }
}
