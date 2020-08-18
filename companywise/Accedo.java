package companywise;

import java.util.HashMap;

public class Accedo {
    public static void main(String[] args) {
        System.out.println(solution(-999));
        System.out.println(solution1(4));
        int[] arr = new int[]{2, -2, 3, 0, 4, -7};
        System.out.println(findSubarraySum(arr));
    }

    private static int solution(int N) {
        boolean isNegative = false;
        if (N < 0) {
            isNegative = true;
            N = -1 * N;
        }
        String str = N + "";
        int max = Integer.MIN_VALUE;
        for (int i = 0; i <= str.length(); i++) {
            str = str.substring(0, i) + "5" + str.substring(i);
            int val = Integer.parseInt(str);
            if (isNegative) {
                val = val * -1;
            }
            if (val > max) {
                max = val;
            }
            str = N + "";
        }
        return max;
    }

    public static String solution1(int N) {
        String result = "";
        for (int i = 0; i < N; i++) {
            if (i % 2 == 0) {
                result = result + "+";
            } else {
                result = result + "-";
            }
        }
        return result;
    }

    static int findSubarraySum(int[] A) {
        if (A.length >= 100000) return -1;
        HashMap<Integer, Integer> prevSum = new HashMap<>();
        int res = 0;
        int currsum = 0;

        for (int value : A) {
            currsum += value;
            if (currsum == 0)
                res++;
            if (prevSum.containsKey(currsum)) // currsum - sum
                res += prevSum.get(currsum);

            Integer count = prevSum.get(currsum);
            if (count == null)
                prevSum.put(currsum, 1);
            else
                prevSum.put(currsum, count + 1);
        }
        return res;
    }
}
