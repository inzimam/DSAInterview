package sorting;

public class BubbleSort {

    public static void main(String[] strg) {
        int[] arr = new int[]{7, 11, 2, 4, 3, 9, 19, 1, 23, 56, 13};
        BubbleSort bubbleSort = new BubbleSort();
        bubbleSort.printArray(arr);
        bubbleSort.sort(arr, arr.length);
        bubbleSort.sortRecursive(arr, arr.length);
        bubbleSort.printArray(arr);
    }

    private void sort(int[] arr, int n) {
        int temp = 0;
        for (int i = 0; i < n; i++) {
            for (int j = 1; j < (n - i); j++) {
                if (arr[j - 1] > arr[j]) {
                    temp = arr[j - 1];
                    arr[j - 1] = arr[j];
                    arr[j] = temp;
                }
            }
        }
    }

    private void sortRecursive(int[] arr, int len) {
        if (len == 1)
            return;
        for (int j = 0; j < len - 1; j++) {
            if (arr[j] > arr[j + 1]) {
                int temp = arr[j];
                arr[j] = arr[j + 1];
                arr[j + 1] = temp;
            }
        }
        sortRecursive(arr, len - 1);
    }


    private void printArray(int[] arr) {
        int n = arr.length;
        for (int i1 : arr) System.out.print(i1 + " ");
        System.out.println();
    }
}
