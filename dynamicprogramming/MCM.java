package dynamicprogramming;

import java.util.Arrays;

public class MCM {
    public static void main(String[] args) {
        int[] mcm = {1, 2, 3, 4, 5};
        int[][] t = new int[mcm.length + 1][mcm.length + 1];
        for (int[] ints : t) {
            Arrays.fill(ints, -1);
        }
        System.out.println("mcm " + mcm(t, mcm, 1, mcm.length - 1));

        String s = "aaabba";
        char[] arr = s.toCharArray();
        t = new int[arr.length + 1][arr.length + 1];
        for (int i = 0; i <= arr.length; i++) {
            Arrays.fill(t[i], -1);
        }
        System.out.println("palindromePartition " + palindromePartition(t, arr, 0, arr.length - 1));
    }


    private static int mcm(int[][] t, int[] arr, int i, int j) {
        int result = Integer.MAX_VALUE;
        if (i >= j) return 0;
        for (int k = i; k < j; k++) {
            if (t[i][k] == -1)
                t[i][k] = mcm(t, arr, i, k);
            if (t[k + 1][j] == -1)
                t[k + 1][j] = mcm(t, arr, k + 1, j);
            result = Math.min(result, t[i][k] + t[k + 1][j] + arr[i - 1] * arr[k] * arr[j]);
        }
        return result;
    }


    private static int palindromePartition(int[][] t, char[] arr, int i, int j) {
        int result = Integer.MAX_VALUE;
        if (i >= j) {
            return 0;
        }
        if (isPalindrome(arr, i, j)) {
            return 0;
        }
        for (int k = i; k < j; k++) {
            if (t[i][k] == -1)
                t[i][k] = palindromePartition(t, arr, i, k);
            if (t[k + 1][j] == -1)
                t[k + 1][j] = palindromePartition(t, arr, k + 1, j);
            result = Math.min(result, t[i][k] + t[k + 1][j] + 1);
        }
        return result;
    }

    private static boolean isPalindrome(char[] arr, int i, int j) {
        if (i >= j) return true;
        if (arr[i] == arr[j]) {
            return isPalindrome(arr, i + 1, j - 1);
        }
        return false;
    }

}
