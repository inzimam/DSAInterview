package binarysearch;

public class BinarySearch {
    public static void main(String[] args) {
        int[] asc = {2, 3, 6, 8, 9, 11, 19};
        System.out.println(binarySearchAsc(asc, 6, 0, asc.length - 1));
        int[] dsc = {19, 11, 9, 8, 6, 3, 2};
        System.out.println(binarySearchDsc(dsc, 6, 0, dsc.length - 1));
        int[] agnostic = {2, 3, 6, 8, 9, 11, 19};
        System.out.println(orderAgnosticSearch(agnostic, 3));
        int[] first = {2, 4, 10, 10, 10, 18, 20};
        System.out.println("firstOccurrence " + firstOccurrence(first, 10));
        System.out.println("lastOccurrence " + lastOccurrence(first, 10));
        int[] rotation = {11, 12, 15, 18, 2, 5, 6, 8};
        System.out.println("countNoOfRotation " + minIndexInRotatedArray(rotation));
        System.out.println("elementSearchInRotatedArray " + elementSearchInRotatedArray(rotation, 12));
        int[] d = {5, 10, 30, 20, 50, 40};
        System.out.println("searchInNearlySorted " + searchInNearlySorted(d, 30));
        System.out.println("floorInSortedArray " + floorInSortedArray(agnostic, 10));
        System.out.println("ceilInSortedArray " + ceilInSortedArray(agnostic, 10));
        char[] c = new char[]{'a', 'c', 'f', 'h'};
        System.out.println("nextCharInArray " + nextCharInArray(c, 'g'));
        int[] infinite = {2, 3, 6, 8, 9, 11, 19, 20, 21, 22, 23, 24, 25, 26, 27, 28, 29, 30, 31, 32, 33, 34, 35};
        System.out.println("elementInInfiniteArray " + elementInInfiniteArray(infinite, 11));
        int[] binary = {0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0, 0,
                1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1, 1};
        System.out.println("firstOneInBinarySorted " + firstOneInBinarySorted(binary));
        int[] minDiff = {4, 6, 10};
        System.out.println("minimumDiffElementInSortedArray " + minimumDiffElementInSortedArray(minDiff, 7));
        int[][] matrix = new int[][]{{10, 20, 30, 40}, {15, 25, 35, 45}, {27, 29, 37, 48}, {32, 33, 39, 50}};
        System.out.println("searchInSortedMatrix " + searchInSortedMatrix(matrix, 4, 4, 29));
        int[] minPages = {12, 34, 67, 90};
        System.out.println("allocateMinNoOfPages " + allocateMinNoOfPages(minPages, 2));
        int[] painter = {10, 10, 10, 10};
        System.out.println("painterProblem " + painterProblem(painter, painter.length, 2));
        int[] peak = {1};
        System.out.println("peakElement " + peakElement(peak, peak.length));


    }

    private static int binarySearchAsc(int[] arr, int k, int start, int end) {
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == k) {
                return mid;
            } else if (k < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int binarySearchDsc(int[] arr, int k, int start, int end) {

        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == k) {
                return mid;
            } else if (k < arr[mid]) {
                start = mid + 1;
            } else {
                end = mid - 1;
            }
        }
        return -1;
    }

    private static int orderAgnosticSearch(int[] arr, int k) {
        if (arr.length == 1) {
            return k == arr[0] ? 0 : -1;
        }
        int i = 1;
        boolean asc = false;
        while (i < arr.length) {
            if (arr[i - 1] == arr[i]) {
                i++;
            } else if (arr[i - 1] < arr[i]) {
                asc = true;
                break;
            } else {
                break;
            }
        }
        if (asc) return binarySearchAsc(arr, k, 0, arr.length - 1);
        else return binarySearchDsc(arr, k, 0, arr.length - 1);
    }

    private static int firstOccurrence(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (k == arr[mid]) {
                result = mid;
                end = mid - 1;
            } else if (k < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static int lastOccurrence(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (k == arr[mid]) {
                result = mid;
                start = mid + 1;
            } else if (k < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static int minIndexInRotatedArray(int[] arr) { // same as count of rotation
        int start = 0;
        int end = arr.length - 1;

        while (start <= end) {
            if (arr[start] <= arr[end]) {
                return start;
            }
            int mid = (start + end) / 2;
            int next = (mid + 1) % arr.length;
            int prev = (mid - 1 + arr.length) % arr.length;

            if (arr[mid] <= arr[next] && arr[mid] <= arr[prev]) {
                return mid;
            } else if (arr[mid] <= arr[end]) {
                end = mid - 1;
            } else if (arr[mid] >= arr[start]) {
                start = mid + 1;
            }
        }
        return -1;
    }

    private static int elementSearchInRotatedArray(int[] arr, int ele) {
        int minIndex = minIndexInRotatedArray(arr);
        if (minIndex != -1) {
            if (ele == arr[minIndex])
                return minIndex;
            else if (ele >= arr[minIndex] && ele <= arr[arr.length - 1]) {
                return binarySearchAsc(arr, ele, minIndex + 1, arr.length - 1);
            } else {
                return binarySearchAsc(arr, ele, 0, minIndex - 1);
            }
        }
        return minIndex;
    }

    private static int searchInNearlySorted(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            int next = (mid + 1) % arr.length;
            int prev = (mid + arr.length - 1) % arr.length;
            if (arr[mid] == k) {
                return mid;
            } else if (arr[prev] == k) {
                return prev;
            } else if (arr[next] == k) {
                return next;
            } else if (k < arr[prev]) {
                end = prev - 1;
            } else {
                start = next + 1;
            }
        }
        return -1;
    }

    private static int floorInSortedArray(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == k)
                return arr[mid];
            else if (k < arr[mid]) {
                end = mid - 1;
            } else {
                result = arr[mid];
                start = mid + 1;
            }
        }
        return result;
    }

    private static int ceilInSortedArray(int[] arr, int k) {
        int start = 0;
        int end = arr.length - 1;
        int result = -1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == k)
                return arr[mid];
            else if (k < arr[mid]) {
                result = arr[mid];
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static char nextCharInArray(char[] arr, char c) {
        int start = 0;
        int end = arr.length - 1;
        char result = '#';
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (c >= arr[mid]) {
                start = mid + 1;
            } else {
                result = arr[mid];
                end = mid - 1;
            }
        }
        return result;
    }

    private static int elementInInfiniteArray(int[] arr, int k) {
        int start = 0;
        int end = 1;
        while (k > arr[end]) {
            start = end;
            end = end * 2;
        }
        return binarySearchAsc(arr, k, start, end);
    }

    private static int firstOneInBinarySorted(int[] arr) {
        int start = 0;
        int end = 1;
        while (arr[end] == 0) {
            start = end;
            end = end * 2;
        }
        int result = -1;
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (arr[mid] == 1) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static int minimumDiffElementInSortedArray(int[] arr, int key) {
        int start = 0;
        int end = arr.length - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (arr[mid] == key) {
                return arr[mid];
            } else if (key < arr[mid]) {
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return Math.abs(key - arr[start]) < Math.abs(key - arr[start]) ? arr[start] : arr[end];
    }

    private static int peakElement(int[] arr, int n) {
        if (n == 1) return 0;
        int start = 0;
        int end = n - 1;
        while (start <= end) {
            int mid = start + (end - start) / 2;
            if (mid > 0 && mid < n - 1) {
                if (arr[mid - 1] < arr[mid] && arr[mid + 1] < arr[mid]) {
                    return mid;
                } else if (arr[mid - 1] > arr[mid]) {
                    end = mid - 1;
                } else {
                    start = mid + 1;
                }
            } else if (mid == 0) {
                if (arr[mid + 1] < arr[mid]) {
                    return mid;
                } else {
                    return mid + 1;
                }
            } else {
                if (arr[mid - 1] < arr[mid]) {
                    return mid;
                } else {
                    return mid - 1;
                }
            }
        }
        return -1;
    }

    private static String searchInSortedMatrix(int[][] arr, int m, int n, int key) {
        int i = 0;
        int j = n - 1;
        while (i <= m - 1 && j >= 0) {
            if (arr[i][j] == key) {
                return i + " : " + j;
            } else if (key < arr[i][j]) {
                j--;
            } else {
                i++;
            }
        }
        return "Not found";
    }

    private static int allocateMinNoOfPages(int[] arr, int s) {
        if (arr.length < s)
            return -1;
        int end = 0;
        int start = 0;
        int result = -1;
        for (int value : arr) {
            end = end + value;
            if (value > start) {
                start = value;
            }
        }
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (isValid(arr, mid, s)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean isValid(int[] arr, int value, int s) {
        int totalStudent = 1;
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > value) return false;

            if (sum + arr[i] > value) {
                totalStudent++;
                sum = arr[i];
                if (totalStudent > s) return false;
            } else {
                sum += arr[i];
            }
        }
        return true;
    }

    private static int painterProblem(int[] arr, int n, int p) {
        int start = 0;
        int end = 0;
        int result = -1;
        for (int i = 0; i < n; i++) {
            end += arr[i];
        }
        while (start <= end) {
            int mid = start + ((end - start) / 2);
            if (isValidPainter(arr, mid, p)) {
                result = mid;
                end = mid - 1;
            } else {
                start = mid + 1;
            }
        }
        return result;
    }

    private static boolean isValidPainter(int[] arr, int value, int p) {
        int current_sum = 0;
        int painter = 1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] > value)
                return false;
            if (arr[i] + current_sum > value) {
                painter++;
                current_sum = arr[i];
                if (painter > p) return false;
            } else {
                current_sum += arr[i];
            }
        }
        return true;
    }
}
