package companywise;

import util.Utils;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.HashSet;

public class MMT {
    public static void main(String[] args) {
        System.out.println(distinctPalindromicSubstrings("aaabba"));
        String str = "this is a test string";
        String pat = "tist";
        System.out.println("Smallest window is :\n " + findSubString(str, pat));
        int[] arr = {7, 9, 5, 6, 3, 2};
        System.out.println("maximumDifference :  " + maximumDifference(arr, arr.length));
        System.out.println("longestPrefixSuffix :  " + longestPrefixSuffix("aabcdeaabfaab"));
        int[][] cost = {{1, 2, 3},
                {4, 8, 2},
                {1, 5, 3}};
        System.out.println("minCost :  " + minCost(cost));
        int[] S = {2, 5, 6, 8, 9, 11, 14};
        int[] F = {7, 6, 9, 15, 10, 13, 15};
        System.out.println("nMeetingsInSingleRoom :  " + nMeetingsInSingleRoom(S, F, S.length));
        int[][] matrix = {{1, 4, 8, 9, 4, 5, 2}, {-2, 3, 4, 5, 7, 6, 3}, {4, 0, 8, 2, 7, 5, 98},
                {985, 752, 0, -875, 452, 457, 52}, {89, 89, 89, 547, 427, 632, 478},
                {12, 47, 98, 39, 54, 78, 99}, {-9, 25, -98, 457, -999, 999, 500}};
        transposeMatrix(matrix);
        System.out.println("getTrailingZero :  " + getTrailingZero(24));
        int[] perm = {1, 2, 3, 6, 5, 4};
        nextPermutation(perm, perm.length);
    }

    private static int distinctPalindromicSubstrings(String s) {
        int n = s.length();
        int[][] dp = new int[n][n];
        HashSet<String> set = new HashSet<>();
        for (int i = 0; i < n; i++) {
            dp[i][i] = 1;
            set.add(s.substring(i, i + 1));
        }
        for (int i = 0; i < n - 1; i++) {
            if (s.charAt(i) == s.charAt(i + 1)) {
                dp[i][i + 1] = 1;
                set.add(s.substring(i, i + 2));
            } else {
                dp[i][i + 1] = 0;
            }
        }
        for (int i = 3; i <= n; i++) {
            for (int start = 0; start <= n - i; start++) {
                int end = i + start - 1;
                if (s.charAt(start) == s.charAt(end) && dp[start + 1][end - 1] == 1) {
                    dp[start][end] = 1;
                    set.add(s.substring(start, end + 1));
                } else {
                    dp[start][end] = 0;
                }
            }
        }
        return set.size();
    }


    // Function to find smallest window containing
    // all characters of 'pat'
    private static String findSubString(String str, String pat) {
        int no_of_chars = 256;
        int sLen = str.length();
        int pLen = pat.length();
        if (pLen > sLen) {
            return "-1";
        }
        int count = 0;
        int start = 0;
        int startIndex = -1;
        int minLength = Integer.MAX_VALUE;

        int[] hash_pat = new int[no_of_chars];
        int[] hash_str = new int[no_of_chars];
        for (int i = 0; i < pLen; i++) {
            hash_pat[pat.charAt(i)]++;
        }
        for (int i = 0; i < sLen; i++) {
            hash_str[str.charAt(i)]++;
            if (hash_pat[str.charAt(i)] != 0 && hash_str[str.charAt(i)] <= hash_pat[str.charAt(i)]) {
                count++;
            }
            if (count == pLen) {
                while (hash_pat[str.charAt(start)] == 0 || hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]) {
                    if (hash_str[str.charAt(start)] > hash_pat[str.charAt(start)]) {
                        hash_str[str.charAt(start)]--;
                    }
                    start++;
                }
                int len = i - start + 1;
                if (minLength > len) {
                    minLength = len;
                    startIndex = start;
                }
            }
        }
        if (startIndex == -1) {
            return "-1";
        }
        return str.substring(startIndex, startIndex + minLength);
    }

    // 2 3 10 6 4 8 1
    private static int maximumDifference(int[] arr, int n) {
        int maxDiff = Integer.MIN_VALUE;
        int min = arr[0]; // 2

        for (int i = 1; i < n; i++) {
            if (arr[i] - min > maxDiff) {  //
                maxDiff = arr[i] - min;    // 1 8
            }
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        return maxDiff;
    }

    static int longestPrefixSuffix(String s) {
        int n = s.length();
        int[] lps = new int[n];
        lps[0] = 0;
        int len = 0;
        int i = 1;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                len++;
                lps[i] = len;
                i++;
            } else {
                if (len == 0) {
                    lps[i] = 0;
                    i++;
                } else {
                    len = lps[len - 1];
                }
            }
        }
        int res = lps[n - 1];
        return Math.min(res, n / 2);
    }

    private static int minCost(int[][] cost) {
        int row = cost.length;
        int col = cost[0].length;
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (i == 0 && j == 0) {
                } else if (i == 0) {
                    cost[0][j] += cost[0][j - 1];
                } else if (j == 0) {
                    cost[i][0] += cost[i - 1][0];
                } else {
                    cost[i][j] += Math.min(cost[i - 1][j], cost[i][j - 1]);
                }
            }
        }
        return cost[row - 1][col - 1];
    }

    static class SortByFinish implements Comparator<Meeting> {
        @Override
        public int compare(Meeting o1, Meeting o2) {
            return o1.finish - o2.finish;
        }
    }

    static class Meeting {
        int start = 0;
        int finish = 0;

        public Meeting(int start, int finish) {
            this.start = start;
            this.finish = finish;
        }
    }

    private static int nMeetingsInSingleRoom(int[] S, int[] F, int n) {
        ArrayList<Meeting> arrayList = new ArrayList<>();
        int count = 1;
        for (int i = 0; i < n; i++) {
            arrayList.add(new Meeting(S[i], F[i]));
        }
        arrayList.sort(new SortByFinish());
        int i = 0, j = 1;
        while (i < n && j < n) {
            if (arrayList.get(i).finish <= arrayList.get(j).start) {
                count++;
                i++;
                j++;
            } else {
                j++;
            }
        }
        return count;
    }

    private static void transposeMatrix(int[][] matrix) {
        Utils.print2D(matrix);
        int N = matrix.length;
        for (int i = 0; i < N; i++) {
            for (int j = i + 1; j < N; j++) {
                int temp = matrix[i][j];
                matrix[i][j] = matrix[j][i];
                matrix[j][i] = temp;
            }
        }
        Utils.print2D(matrix);
    }

    private static int getTrailingZero(int n) {
        int count = 0;
        int i = 5;
        while (i <= n) {
            count = count + (n / i);
            i = i * 5;
        }
        return count;
    }

    // 1 1 2 6 7 5
    private static int nextPermutation(int[] arr, int n) {
        int i = arr.length - 2;
        while (i >= 0) {
            if (arr[i] < arr[n - 1]) {
                int temp = arr[i];
                arr[i] = arr[n - 1];
                arr[n - 1] = temp;
                break;
            }
            i--;
        }
        partSort(arr, n, i + 1, n - 1);
        return 0;
    }

    static void partSort(int[] arr, int N, int l, int r) {

        int[] temp = new int[r - l + 1];
        int j = 0;
        for (int i = l; i <= r; i++) {
            temp[j] = arr[i];
            j++;
        }
        Arrays.sort(temp);
        j = 0;
        for (int i = l; i <= r; i++) {
            arr[i] = temp[j];
            j++;
        }

        // Print the modified array
        for (int i = 0; i < N; i++) {
            System.out.print(arr[i] + " ");
        }
    }
}
