package companywise;

import java.util.HashSet;
import java.util.Set;

public class Ola {

    public static void main(String[] args) {
        int[] val = new int[]{60, 100, 120};
        int[] weight = new int[]{10, 20, 30};
        System.out.println("Inzy " + KnapsackProblem(val, weight, val.length, 50));

//        geeksforgeeks set
//        adcffaet onkl
        System.out.println("minimumIndexedCharacter " + minimumIndexedCharacter("adcffaet", "onkl"));
        System.out.println("minimumIndexedCharacter " + minimumIndexedCharacter1("geeksforgeeks", "set"));
    }

    //    0 - 1 Knapsack Problem
    private static int KnapsackProblem(int[] val, int[] wt, int n, int W) {
        int[][] arr = new int[n + 1][W + 1];

        for (int i = 0; i <= n; i++) {
            for (int j = 0; j <= W; j++) {
                if (i == 0 || j == 0) {
                    arr[i][j] = 0;
                } else if (wt[i - 1] <= j) {
                    arr[i][j] = max(arr[i - 1][j], val[i - 1] + arr[i - 1][j - wt[i - 1]]);
                } else {
                    arr[i][j] = arr[i - 1][j];
                }
            }
        }
        return arr[n][W];
    }

    private static int max(int v1, int v2) {
        return Math.max(v1, v2);
    }

    static String minimumIndexedCharacter(String str, String ptr) {
        int curr_min = Integer.MAX_VALUE;
        for (char c : ptr.toCharArray()) {
            if (str.indexOf(c) != -1 && str.indexOf(c) < curr_min) {
                curr_min = str.indexOf(c);
            }
        }
        return curr_min == Integer.MAX_VALUE ? "$" : str.charAt(curr_min) + "";
    }

    static char minimumIndexedCharacter1(String str, String ptr) {
        Set<Character> set = new HashSet<>();
        for (char c : ptr.toCharArray()) {
            set.add(c);
        }

        for (int i = 0; i < str.length(); i++) {
            if (set.contains(str.charAt(i))) {
                return str.charAt(i);
            }
        }
        return '$';
    }

}
