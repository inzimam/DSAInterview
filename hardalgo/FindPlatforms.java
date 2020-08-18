package hardalgo;

import java.util.Arrays;

public class FindPlatforms {
    public static void main(String[] args) {
        int[] arr = {900, 940, 950, 1100, 1500, 1800};
        int[] dep = {910, 1059, 1120, 1130, 1900, 2000};
        System.out.println("Result : " + findPlatform(arr, dep, dep.length));
    }

    private static int findPlatform(int[] arr, int[] dep, int n) {
        Arrays.sort(arr);
        Arrays.sort(dep);
        int i = 0, j = 0;
        int platformNeeded = 0, result = 1;
        while (i < n && j < n) {
            if (arr[i] <= dep[j]) {
                platformNeeded++;
                i++;
            } else {
                platformNeeded--;
                j++;
            }
            if (platformNeeded > result) {
                result = platformNeeded;
            }
        }
        return result;
    }
}
