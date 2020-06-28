package arrays;

import java.util.*;

public class ArraysQuestions {
    private final static String TAG = ArraysQuestions.class.getName();

    public static void main(String[] args) {
//        System.out.println("args = " + args);

        int[] arr = new int[]{4, 2, 3, 1};
        System.out.println(TAG + citiesGap(arr.length, 2, arr));

        int ar[] = {3, 5, 4, 5, 3, 4};
        System.out.println(TAG + ArraysQuestions.findSingle(ar, ar.length));

        int[] a = {2, 3, 5, 4, 5, 3, 4};
        int n = 7;
        System.out.println(TAG + ArraysQuestions.singleNumber(a, n));

        int[] b = {15, 18, 16, 18, 16, 15, 89};
        System.out.println(TAG + ArraysQuestions.singleNumber(b, n));


        arr = new int[]{5, 32, 1, 7, 10, 50, 19, 21, 2};
        findTriplet(arr, arr.length);
        a = new int[]{-2, -3, 4, -1, -2, 1, 5, -3};
        System.out.println("Maximum contiguous sum is " +
                maxSubArraySum(a));

        String str = "geeksforgeeks";
        int index = firstNonRepeating(str);

        System.out.println(
                index == -1
                        ? "Either all characters are repeating or string "
                        + "is empty"
                        : "First non-repeating character is "
                        + str.charAt(index));


//        int[] arr = {1, 2, 3};
        arr = new int[]{4, 11, 2, 5, 11, 13, 5};
        int[] arr1 = {1, 2, 2, 0, 0, 1, 2, 2, 1};
        System.out.println("Minima : " + findMinima(arr, arr.length));
        System.out.println("Minima : " + localMinima(arr, arr.length));
        sortZeroOneTwoArray(arr1, arr1.length);
        printPairsUsingSet(arr, 12);
        largestAndSmallestNumberFromIntegerArray(arr);

        System.out.println(printMissingNumber(new int[]{1, 9, 2, 4, 6, 7, 5, 8, 3}, 10));


        removeDuplicatesFromArray(new int[]{1, 2, 1, 2, 2, 2, 3, 4, 3, 6});

        reverseAnArray(new int[]{1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 11});

        swapNumbers(3, 4);

        missingNumberInGivenIntegerArray(new int[]{1, 2, 3, 4, 5, 7, 8, 9, 10, 11});

        int[] arr2 = {11, 16, 90, 20, 110, 9};
        System.out.println("MaximumDifference is " + maxDiff(arr2, arr2.length));
        arr = new int[]{-21, -54, -19, -40, -32, -21, -12, -9, -3, -2};
        int arr2D[][] = {{0, 1, 1, 1},
                {0, 1, 0, 1},
                {0, 1, 1, 0},
                {1, 0, 1, 0}};
        int[] lisArr = {50, 3, 10, 7, 60, 80, 90};
        maxSumContiguous(arr);

        System.out.println("LIS: " + _lis(lisArr));


        a = new int[]{1, -7, 4, -1, -2, 1, 5, -3};
        System.out.println(abc(a));
        String name = "i like this program very much";
        String sd[] = name.split(" ");
        reverseWords(sd);
        int R = 4;
        int C = 6;
        int[][] arr5 =
                {{1, 2, 3, 4, 5, 6},
                        {7, 8, 9, 10, 11, 12},
                        {13, 14, 15, 16, 17, 18},
                        {19, 20, 21, 22, 23, 24}};
        spiralPrint(R, C, arr5);

        int[] arr4 = {15, 2, 4, 8, 10, 5, 10, 23};
        n = arr4.length;
        int sum = 22;
        subArraySum(arr4, n, sum);
        int[] A = {0, 0, 0, 0, 1, 1, 1, 1, 1, 1, 1, 1};

        System.out.println("Total number of 1's present are " + count(A, 0, A.length - 1));

        arr = new int[]{20, 22, 23, 24, 25, 24, 22, 26, 25, 24};
        System.out.println("Random Integer array : " + Arrays.toString(arr));
        duplicateNumberOnGivenIntegerArray(arr);
        largestAndSmallestNumberInUnsortedIntegerArray(arr);
        allPairsOfIntegerArrayWhoseSumIsEqualToGivenNumber(arr, 11);
        reverseArray(arr);
        System.out.println("findKthLargest " + findKthLargest(new int[]{3, 2, 1, 5, 6, 4}, 2));
        intersectionOfTwoSortedArray(new int[]{2, 3, 3, 5, 7, 10,}, new int[]{1, 2, 3, 3, 6, 7, 8, 9, 10});
        topTwoNumbers(arr);
        getSequence(arr);
        int arr6[] = {1, 9, 3, 10, 4, 20, 2};
//        int arr2[] = {2, 5, 3, 7, 4, 8, 5, 13, 6};
        n = arr6.length;
        System.out.println("findLongestConseqSubseq " + findLongestConseqSubseq(arr6, n));
        System.out.println("rotLeft " + Arrays.toString(rotLeft(new int[]{1, 2, 3, 4, 5}, 4)));
        intersectionOfTwoUnsortedArrays(new int[]{3, 3, 3, 2, 5, 5, 7, 10,}, new int[]{3, 3, 6, 7, 1, 2, 8, 9, 10});

        int k = 7;
        int[] arrSmall = new int[]{12, 3, 5, 7, 4, 19, 26};  // 3, 4, 5, 7, 12, 19, 26
        System.out.print("K'th smallest element is " + kthSmallest(arrSmall, 0, arrSmall.length - 1, k));
    }

    private static int citiesGap(int n, int y, int[] arr) {
        int count = 0;
        Set<Integer> uniqueChars = new HashSet<>();
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < n; j++) {
                if (Math.abs(arr[i] - arr[j]) >= y && !uniqueChars.contains(arr[i])
                        && !uniqueChars.contains(arr[j])) {
                    uniqueChars.add(arr[i]);
                    uniqueChars.add(arr[j]);
                    count++;
                }
            }
        }
        return count;
    }

    private ArrayList<String> sortArrayList(ArrayList<String> arrayList) {
        HashMap<String, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arrayList.size(); i++) {
            hashMap.put(arrayList.get(i), getCount(arrayList.get(i)));
        }
        return sortByValue(hashMap);
    }


    private int getCount(String str) {
        str = str.replace(" ", "");
        char[] chars = str.toCharArray();
        Set<Character> uniqueChars = new HashSet<>();

        for (char c : chars) {
            uniqueChars.add(c);
        }
        return uniqueChars.size();
    }


    private ArrayList<String> sortByValue(HashMap<String, Integer> map) {
        ArrayList<String> names = new ArrayList<>();
        List<Map.Entry<String, Integer>> list = new LinkedList<>(map.entrySet());
        Collections.sort(list, (o1, o2) -> o2.getValue().compareTo(o1.getValue()));
        Map<String, Integer> sortedMap = new LinkedHashMap<>();
        for (Map.Entry<String, Integer> entry : list) {
            names.add(entry.getKey());
            sortedMap.put(entry.getKey(), entry.getValue());
        }
        return names;
    }

    static int findSingle(int ar[], int ar_size) {
        // Do XOR of all elements and return
        int res = ar[0];
        for (int i = 1; i < ar_size; i++)
            res = res ^ ar[i];

        return res;
    }

    static int singleNumber(int[] nums, int n) {
        HashSet<Integer> m = new HashSet<>();
        long sum1 = 0, sum2 = 0;
        for (int i = 0; i < n; i++) {
            if (!m.contains(nums[i])) {
                sum1 += nums[i];
                m.add(nums[i]);
            }
            sum2 += nums[i];
        }

        // applying the formula.
        return (int) (2 * (sum1) - sum2);
    }

    //Find a triplet such that sum of two equals to third element
    static void findTriplet(int[] arr, int n) {
        HashMap<Integer, Integer> set = new HashMap<>();
        for (int i = 0; i < n; i++) {
            set.put(arr[i], i);
        }
        boolean contained = false;
        for (int i = 0; i < n - 1; i++) {
            for (int j = i + 1; j < n; j++) {
                if (i == j) continue;
                int val = arr[i] + arr[j];

                if (set.containsKey(val) && set.get(val) != i && set.get(val) != j) {
                    contained = true;
                    System.out.println(arr[i] + " + " + arr[j] + " = " + val);
                }
            }
        }
        if (!contained) {
            System.out.println("no such triplet exist");
        }
    }

    // Largest Sum Contiguous Subarray
    static int maxSubArraySum(int[] a) {
        int size = a.length;
        int max_so_far = Integer.MIN_VALUE, max_ending_here = 0;
        for (int value : a) {
            max_ending_here = max_ending_here + value;
            if (max_so_far < max_ending_here)
                max_so_far = max_ending_here;
            if (max_ending_here < 0)
                max_ending_here = 0;
        }
        return max_so_far;
    }

    static final int NO_OF_CHARS = 256;
    static char count[] = new char[NO_OF_CHARS];

    /* calculate count of characters
       in the passed string */
    static void getCharCountArray(String str) {
        for (int i = 0; i < str.length(); i++)
            count[str.charAt(i)]++;
    }

    /* The method returns index of first non-repeating
       character in a string. If all characters are repeating
       then returns -1 */
    static int firstNonRepeating(String str) {
        getCharCountArray(str);
        int index = -1, i;

        for (i = 0; i < str.length(); i++) {
            if (count[str.charAt(i)] == 1) {
                index = i;
                break;
            }
        }

        return index;
    }

    //    Question 28 : Given an array containing zeroes, ones and twos only. Write a function to sort the
//    given array in O(n) time complexity.
    static void sortZeroOneTwoArray(int[] arr, int len) {
        int start = 0;
        int end = len - 1;
        for (int i = 0; i < len; i++) {
            if (arr[i] == 0) {
                while (start > 0 && arr[start] == 0) {
                    start++;
                }
                arr[i] = arr[start];
                arr[start] = 0;
                start++;
            } else if (arr[i] == 2) {
                while (end > 0 && arr[end] == 2) {
                    end--;
                }
                arr[i] = arr[end];
                arr[end] = 2;
                end--;
            }
        }
        System.out.println("");
    }

//    Question 29 : Find local minima in array
//    A local minima is less than its neighbours

    static int localMinima(int[] arr, int len) {
        if (len == 1)
            return arr[0];
        for (int i = 1; i < len - 1; i++) {
            if (i == 1) {
                if (arr[i - 1] < arr[i]) {
                    return arr[i - 1];
                }
            } else if (arr[i] < arr[i - 1] && arr[i] < arr[i + 1]) {
                return arr[i];
            } else if (i == len - 2) {
                if (arr[i + 1] < arr[i])
                    return arr[i + 1];
            }
        }
        return -1;
    }

    static int findMinima(int[] arr, int len) {
        return findMinima(arr, 0, len - 1);
    }

    static private int findMinima(int[] arr, int start, int end) {
        int mid = start + (end - start) / 2;
        int len = arr.length;
        if ((mid == 0 || arr[mid] < arr[mid - 1]) && mid == len - 1 || arr[mid] < arr[mid + 1]) {
            return arr[mid];
        } else if (arr[mid - 1] < arr[mid]) {
            return findMinima(arr, start, mid);
        } else {
            return findMinima(arr, mid + 1, len);
        }
    }


    // Question 46 : Find all subsets of set (power set) in java.
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> list = new ArrayList<>();
        subsetsHelper(list, new ArrayList<Integer>(), nums, 0);
        return list;
    }

    private void subsetsHelper(List<List<Integer>> list, List<Integer> resultList, int[] nums, int start) {
        list.add(resultList);
        for (int i = start; i < nums.length; i++) {
            // add element
            resultList.add(nums[i]);
            // Explore
            subsetsHelper(list, resultList, nums, i + 1);
            // remove
            resultList.remove(resultList.size() - 1);
        }
    }

    public double findMedianSortedArrays(int[] nums1, int[] nums2) {

        int len = nums1.length + nums2.length;
        len = (len / 2) + 1;
        int i = 0;
        int m = 0;
        int n = 0;
        int last = 0;
        while (m < nums1.length || n < nums2.length) {
            if (i == len) {
                double val1 = last == 1 ? nums1[m] : nums2[n];
                double val = len % 2 == 0 ? nums1[m] + nums2[n] / 2 : val1;
                return val;
            }
            if (nums1[m] <= nums2[n]) {
                last = 1;
                m++;
            } else {
                last = 2;
                n++;
            }
            i++;
        }
        return 0;
    }

    private static int printMissingNumber(int[] numbers, int count) {
        int missingNo = -1;
        int totalSum = 0;
        int actualSum = 0;
        for (int i = 0; i < numbers.length; i++) {
            totalSum = totalSum + numbers[i];
        }
        actualSum = (count * (count + 1)) / 2;
        System.out.println("Inzy " + totalSum + " : " + actualSum);
        missingNo = actualSum - totalSum;
        return missingNo;
    }

    private static void largestAndSmallestNumberFromIntegerArray(int[] numbers) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int i = 0; i < numbers.length; i++) {
            if (numbers[i] > max) {
                max = numbers[i];
            } else if (min > numbers[i]) {
                min = numbers[i];
            }
        }
        System.out.println("Max " + max + " Min " + min);
    }

    public static void printPairsUsingSet(int[] numbers, int sum) {
        Set set = new HashSet(numbers.length);

        for (int value : numbers) {
            int target = sum - value;
            if (!set.contains(target)) {
                set.add(value);
            } else {
                System.out.printf("(%d, %d) %n", value, target);
            }
        }
    }


    private static void removeDuplicatesFromArray(int[] arr) {
        HashMap<Integer, Boolean> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (!hashMap.containsKey(arr[i])) {
                System.out.print(arr[i] + " ");
            }
            hashMap.put(arr[i], true);
        }
        System.out.println(" ");
    }

    private static void reverseAnArray(int[] arr) {
        int l = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[l];
            arr[l] = temp;
            l--;
        }
        printArray(arr);
    }

    // 4,3
    private static void swapNumbers(int a, int b) {
        System.out.println("Before " + a + " " + b);
        a = a + b;
        b = a - b;
        a = a - b;

        System.out.println("After " + a + " " + b);
    }

    private static void missingNumberInGivenIntegerArray(int[] arr) {
        for (int i = 1; i < arr.length; i++) {
            if (arr[i] - arr[i - 1] > 1) {
                System.out.print(arr[i] - 1 + " is missing");
            }
        }
    }
 /* The function assumes that there are at least two
    elements in array.
    The function returns a negative value if the array is
    sorted in decreasing order.
    Returns 0 if elements are equal */


    private static int maxDiff(int[] arr, int size) {
        int max_diff = arr[1] - arr[0], min_val = arr[0];
        for (int i = 1; i < size - 1; i++) {
            if (arr[i] - min_val > max_diff)
                max_diff = arr[i] - min_val;
            if (arr[i] < min_val)
                min_val = arr[i];
        }
        return max_diff;
    }


    private static void longestLine(int[][] arr) {
        int line = 0;
        for (int i = 0; i < arr.length; i++) {
            for (int j = 0; j < arr[i].length; j++) {

            }
        }
    }

    private static int _lis(int[] arr) {
        int count = 0;
        for (int i = 0; i < arr.length - 1; i++) {
            if (arr[i] < arr[i + 1]) {
                count++;
            }
        }
        return count;
    }


    private static void maxSumContiguous(int[] arr) {
        int sum = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length - 1; i++) {
            if (sum < arr[i] + arr[i + 1]) {
                sum = arr[i] + arr[i + 1];
            }
        }
        System.out.println("max sum of contiguous: " + sum);
    }

    private static int count(int A[], int left, int right) {

        if (A[right] == 0)
            return 0;
        if (A[left] == 1)
            return right - left + 1;
        int mid = (right + left) / 2;
        return count(A, left, mid) + count(A, mid + 1, right);
    }

    private static void subArraySum(int[] arr, int n, int sum) {
        int curr_sum = 0, start = 0, end = -1;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < n; i++) {
            curr_sum = curr_sum + arr[i];
            if (curr_sum == sum) {
                end = i;
                break;
            }

            if (hashMap.containsKey(curr_sum - sum)) {
                start = hashMap.get(curr_sum - sum) + 1;
                end = i;
                break;
            }
            hashMap.put(curr_sum, i);
        }
        if (end == -1) {
            System.out.println("No sub-sequence found");
        } else {
            System.out.println("start : " + start + " end : " + end);
        }
    }

    private static void spiralPrint(int m, int n, int[][] arr) {
        int i, k = 0, l = 0;

        while (k < m && l < n) {
            for (i = l; i < n; ++i) {
                System.out.print(arr[k][i] + " ");
            }
            k++;
            System.out.println("");
            for (i = k; i < m; ++i) {
                System.out.print(arr[i][n - 1] + " ");
            }
            n--;
            System.out.println("");
            if (k < m) {
                for (i = n - 1; i >= l; --i) {
                    System.out.print(arr[m - 1][i] + " ");
                }
                m--;
            }
            System.out.println("");
            if (l < n) {
                for (i = m - 1; i >= k; --i) {
                    System.out.print(arr[i][l] + " ");
                }
                l++;
            }
            System.out.println("");
        }

    }


    public int totalParents(int input1, int input2, int[] input3) {
        int totalParents = 0;
        if (input3 == null || input1 == 0)
            return totalParents;

        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < input1; i++) {
            if (input3[i] == -1) {
                continue;
            }
            if (hashMap.containsKey(input3[i])) {
                int count = hashMap.get(input3[i]);
                hashMap.put(input3[i], count + 1);
            } else {
                hashMap.put(input3[i], 1);
            }
        }

        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > input2) {
                totalParents++;
            }
        }
        return totalParents;
    }

    public static void reverseWords(String sd[]) {
        for (int i = sd.length - 1; i >= 0; i--) {
            System.out.print(sd[i] + " ");
        }
    }

    private static int abc(int[] arr) {
        int curr_max = arr[0];
        int actual_max = arr[0];
        for (int i = 1; i < arr.length; i++) {
            curr_max = Math.max(arr[i], curr_max + arr[i]);
            actual_max = Math.max(actual_max, curr_max);

        }
        return actual_max;
    }

    // cabb abcc

    static int abc(int n) {
        int sum = 0;
        for (int i = 0; i < n; i++) {
            if (i % 3 == 0 || i % 5 == 0 || i % 7 == 0) {
                sum = sum + i;
            }
        }
        return sum;
    }


    static void intersectionOfTwoUnsortedArrays(int[] arr1, int[] arr2) {
        Set<Integer> set = new HashSet<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int v : arr1) {
            set.add(v);
        }

        for (int v : arr2) {
            if (set.contains(v)) {
                set.remove(v);
                arrayList.add(v);
            }
        }
        System.out.println("intersection " + arrayList);
    }

    static int[] rotLeft(int[] a, int d) {
        int[] arr = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            if (d + i < a.length)
                arr[i] = a[d + i];
            else
                arr[i] = a[a.length - i - d];
        }
        return arr;
    }


    static int findLongestConseqSubseq(int arr[], int n) {
        Set<Integer> H = new HashSet<>();
        int ans = 0;
        for (int v : arr) {
            H.add(v);
        }
        for (int i = 0; i < n; i++) {
            if (!H.contains(arr[i] - 1)) {
                int j = arr[i];
                while (H.contains(j)) {
                    j++;
                }
                if (ans < j - arr[i]) {
                    ans = j - arr[i];
                }
            }
        }
        return ans;
    }


    private static void largestAndSmallestNumberInUnsortedIntegerArray(int[] arr) {
        int max = Integer.MIN_VALUE;
        int min = Integer.MAX_VALUE;
        for (int value : arr) {
            if (value >= max) {
                max = value;
            } else if (value < min) {
                min = value;
            }
        }
        System.out.println("Min " + min + " : Max " + max);
    }

    private static void allPairsOfIntegerArrayWhoseSumIsEqualToGivenNumber(int[] arr, int sum) {
        Set<Integer> set = new HashSet<>(arr.length);

        for (int value : arr) {
            int target = sum - value;
            if (set.contains(target)) {
                System.out.println("Pairs " + value + " " + target);
            } else {
                set.add(value);
            }
        }
    }


    private static void duplicateNumberOnGivenIntegerArray(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int value : arr) {
            if (hashMap.containsKey(value)) {
                hashMap.put(value, hashMap.get(value) + 1);
            } else {
                hashMap.put(value, 1);
            }
        }
        System.out.println("duplicateNumbers : " + hashMap);
    }

    private static void reverseArray(int[] arr) {
//        int[] temp = new int[arr.length];
        int j = arr.length - 1;
        for (int i = 0; i < arr.length / 2; i++) {
            int temp = arr[i];
            arr[i] = arr[j];
            arr[j] = temp;
            j--;
        }
        System.out.println(Arrays.toString(arr));
    }


    //new int[]{2, 3, 3, 5, 7, 10,}, new int[]{1, 2, 3, 3, 6, 7, 8, 9, 10}
    private static void intersectionOfTwoSortedArray(int[] arr, int[] arr1) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        int length = Math.min(arr.length, arr1.length);
        int i = 0;
        int j = 0;
        while (i < length) {
            if (arr[i] == arr1[j]) {
                arrayList.add(arr[i]);
                j++;
                i++;
            } else if (arr[i] > arr1[j]) {
                j++;
            } else if (arr[i] < arr1[j]) {
                i++;
            }
        }

        System.out.println(arrayList);
    }


    private static int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> q = new PriorityQueue<Integer>(k);
        for (int i : nums) {
            q.offer(i);

            if (q.size() > k) {
                q.poll();
            }
        }
        return q.peek();
    }

    private static void topTwoNumbers(int[] arr) {
        int max = Integer.MIN_VALUE;
        int sec_max = Integer.MIN_VALUE;
        for (int val : arr) {
            if (val >= max) {
                max = val;
            } else if (val > sec_max) {
                sec_max = val;
            }
        }
        System.out.println(max + " : " + sec_max);
    }


    //{20, 22, 23, 24, 25, 24, 22, 26, 25, 24};
    private static void getSequence(int[] arr) {
        HashMap<Integer, Integer> hashMap = new HashMap<>();

        for (int i = 0; i < arr.length; i++) {
            int val = 0;
            for (int j = i; j < arr.length; j++) {
                if (arr[i] - arr[j] <= 5 && arr[i] - arr[j] >= -5) {
                    val = j;
                } else {
                    break;
                }
            }
            hashMap.put((i + 1), (val + 1));
        }

        Iterator hmIterator = hashMap.entrySet().iterator();

        int max = Integer.MIN_VALUE;
        int sDate = -1;
        int edate = -1;
        while (hmIterator.hasNext()) {
            Map.Entry mapElement = (Map.Entry) hmIterator.next();
            int enddate = ((int) mapElement.getValue());
            int startdate = (int) mapElement.getKey();
            if ((enddate - startdate) > max) {
                max = enddate - startdate;
                sDate = startdate;
                edate = enddate;
            }
        }
        System.out.println(sDate + " " + edate);
    }

    private static int partition(int[] arr, int low, int high) {
        int pivot = arr[high];
        int j = low;
        for (int i = low; i < high; i++) {
            if (arr[i] <= pivot) {
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
                j++;
            }
        }
        int temp = arr[j];
        arr[j] = arr[high];
        arr[high] = temp;
        return j;
    }

    private static int kthSmallest(int[] arr, int low, int high, int k) {
        if (k > 0 && k <= high - low + 1) {
            int p = partition(arr, low, high);
            if (p - low == k - 1)
                return arr[p];
            if ((p - low) > k - 1)
                return kthSmallest(arr, low, p - 1, k);
            return kthSmallest(arr, p + 1, high, k - p + low - 1);
        }
        return -1;
    }

    public static int partition(Integer[] arr, int l,
                                int r) {
        int x = arr[r], i = l;
        for (int j = l; j <= r - 1; j++) {
            if (arr[j] <= x) {
                //Swapping arr[i] and arr[j]
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;

                i++;
            }
        }

        //Swapping arr[i] and arr[r]
        int temp = arr[i];
        arr[i] = arr[r];
        arr[r] = temp;

        return i;
    }

    // This function returns k'th smallest element
    // in arr[l..r] using QuickSort based method.
    // ASSUMPTION: ALL ELEMENTS IN ARR[] ARE DISTINCT
    public static int kthSmallest(Integer[] arr, int l,
                                  int r, int k) {
        // If k is smaller than number of elements
        // in array
        if (k > 0 && k <= r - l + 1) {
            // Partition the array around last
            // element and get position of pivot
            // element in sorted array
            int pos = partition(arr, l, r);

            // If position is same as k
            if (pos - l == k - 1)
                return arr[pos];

            // If position is more, recur for
            // left subarray
            if (pos - l > k - 1)
                return kthSmallest(arr, l, pos - 1, k);

            // Else recur for right subarray
            return kthSmallest(arr, pos + 1, r, k - pos + l - 1);
        }

        // If k is more than number of elements
        // in array
        return Integer.MAX_VALUE;
    }

    private static void printArray(int[] arr) {
        for (int a : arr) {
            System.out.print(a + " ");
        }
    }
}
