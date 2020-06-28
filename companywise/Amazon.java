package companywise;

import java.util.HashSet;
import java.util.Set;

public class Amazon {

    public static void main(String[] args) {
        Amazon amazon = new Amazon();

        System.out.println("replace0with5: " + amazon.replace0with5(1016));
        int[] arr = {1, 2, 5, 1, 7, 2, 4, 2};
        int n = arr.length;
        amazon.removeDups(arr, n);
        int[] product = {1, 4, 3, -6, 7, -7};
        System.out.println("Product: " + amazon.maxProduct(product, product.length));
        System.out.println("Highest PowerOf2: " + amazon.highestPowerOf2(127));
        int[] nextGreat = {16, 17, 4, 3, 5, 2};
        amazon.replaceWithNextGreatest(nextGreat, nextGreat.length);
        System.out.println("countSubStringStartEndWith1: " + amazon.countSubStringStartEndWith1("001110111111000100101011"));
    }

    int replace0with5(int num) {
        int output = num;
        int temp = 1;
        if (num == 0) {
            num = num + (5 * temp);
        }

        while (output > 0) {
            if (output % 10 == 0) {
                num = num + (temp * 5);
            }
            output = output / 10;
            temp = temp * 10;
        }
        return num;
    }

    void removeDups(int[] arr, int n) {
        Set<Integer> mp = new HashSet<>();
        for (int i = 0; i < n; ++i) {
            if (!mp.contains(arr[i]))
                System.out.print(arr[i] + " ");
            mp.add(arr[i]);
        }
    }

    int maxProduct(int arr[], int n) {
        int min = Integer.MAX_VALUE;
        int secMin = Integer.MAX_VALUE;
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i++) {
            if (arr[i] > max) {
                secMax = max;
                max = arr[i];
            } else if (arr[i] > secMax) {
                secMax = arr[i];
            } else if (arr[i] < min) {
                secMin = min;
                min = arr[i];
            } else if (arr[i] < secMin) {
                secMin = arr[i];
            }
        }
        return Math.max(min * secMin, max * secMax);
    }

    int highestPowerOf2(int n) {
        int num = 1;
        while (num < n) {
            num = num * 2;
        }
        return num == n ? num : num / 2;

    }

    void replaceWithNextGreatest(int[] arr, int len) {
        int max = arr[len - 1];
        arr[len - 1] = -1;
        for (int i = len - 2; i >= 0; i--) {
            int value = arr[i];
            arr[i] = max;
            if (max < value)
                max = value;
        }
        printArray(arr, "replaceWithNextGreatest¬");
    }

    int countSubStringStartEndWith1(String str) {
        int count = 0;
        boolean start = false;
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) == '1') {
                start = true;
            } else {
                if (start) {
                    count++;
                }
                start = false;
            }
        }
        if (start) {
            count++;
        }
        return count;
    }

    private void printArray(int[] arr, String title) {
        System.out.println(title);
        for (int val : arr) {
            System.out.print("[" + val + "] ");
        }
    }
}
