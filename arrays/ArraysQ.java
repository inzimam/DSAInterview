package arrays;

import java.util.HashMap;
import java.util.HashSet;

public class ArraysQ {
    public static void main(String[] args) {
        // Find the element that appears once in an array where every other element appears twice
        int[] arr = {5, 4, 5, 3, 4};
        System.out.println("findSingle1 " + findSingle1(arr, arr.length));
        System.out.println("findSingle2 " + findSingle2(arr, arr.length));

        //Find a triplet such that sum of two equals to third element
        arr = new int[]{5, 32, 1, 7, 10, 50, 19, 21, 2};
        findTriplet(arr, arr.length);
    }

    // 1st way
    private static int findSingle1(int[] ar, int n) {
        // Do XOR of all elements and return
        int res = ar[0];
        for (int i = 1; i < n; i++)
            res = res ^ ar[i];
        return res;
    }

    // 2nd way
    private static int findSingle2(int[] arr, int n) {
        HashSet<Integer> m = new HashSet<>();
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            if (!m.contains(arr[i])) {
                sum1 += arr[i];
                m.add(arr[i]);
            }
            sum2 += arr[i];
        }
        // applying the formula.
        return (int) (2 * (sum1) - sum2);
    }

    static void findTriplet(int[] arr, int n) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            hashMap.put(arr[i], i);
        }
        boolean contained = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j) continue;
                int val = arr[i] + arr[j];

                if (hashMap.containsKey(val) && hashMap.get(val) != i && hashMap.get(val) != j) {
                    contained = true;
                    System.out.println(arr[i] + " + " + arr[j] + " = " + val);
                }
            }
        }
        if (!contained) {
            System.out.println("no such triplet exist");
        }
    }
}
