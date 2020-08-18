package heap;

import util.EntryMaxHeap;
import util.EntryMinHeap;
import util.Utils;

import java.util.*;

public class Heap {
    public static void main(String[] args) {
        int[] arr = new int[]{7, 10, 4, 3, 20, 15};
        System.out.println(kthSmallestElement(arr, 3));
        kLargestElement(arr, 3);
        arr = new int[]{6, 5, 3, 2, 8, 10, 9};
        System.out.println("");
        kSortedArray(arr, 3);
        System.out.println("");
        arr = new int[]{5, 6, 7, 8, 9};
        kClosestNumber(arr, 3, 7);
        arr = new int[]{1, 1, 1, 3, 2, 2, 5};
        System.out.println("");
        kFrequentNumbers(arr, 2);
        kFrequentSort(arr);
        Utils.printArray(arr, "kFrequentSort");
        int[][] closest = new int[][]{{1, 2}, {-2, -2}, {5, 8}, {0, 1}};
        kClosestPoint(closest, 2);
        arr = new int[]{1, 2, 3, 4, 5};
        System.out.println("connectRopesToMinCost " + connectRopesToMinCost(arr));
        arr = new int[]{1, 3, 12, 5, 15, 11};
        System.out.println("sumOfArrayBetween2Values " + sumOfArrayBetween2Values(arr, 3, 6));
    }

    private static int kthSmallestElement(int[] arr, int k) {
        //Max Heap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        for (int i = 0; i < arr.length; i++) {
            maxHeap.add(arr[i]);
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        return maxHeap.poll();
    }

    private static void kLargestElement(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();

        // Min Heap
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        while (!minHeap.isEmpty()) {
            System.out.println(minHeap.poll() + " ");
        }
    }

    // Nearly sorted array
    private static void kSortedArray(int[] arr, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(arr[i]);
            if (minHeap.size() > k) {
                arrayList.add(minHeap.poll());
            }
        }
        while (!minHeap.isEmpty()) {
            arrayList.add(minHeap.poll());
        }
        for (int a : arrayList) {
            System.out.print(a + " ");
        }
    }


    private static void kClosestNumber(int[] arr, int k, int x) {
        PriorityQueue<EntryMaxHeap> minHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            minHeap.add(new EntryMaxHeap(Math.abs(x - arr[i]), arr[i]));
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        System.out.print(k + " ClosestNumber of " + x + " : ");
        while (!minHeap.isEmpty())
            System.out.print(minHeap.poll().getValue() + " ");
    }

    private static void kFrequentNumbers(int[] arr, int k) {
        PriorityQueue<EntryMinHeap> minHeap = new PriorityQueue<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            } else {
                hashMap.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            minHeap.add(new EntryMinHeap(entry.getValue(), entry.getKey()));
            if (minHeap.size() > k) {
                minHeap.remove();
            }
        }
        while (!minHeap.isEmpty()) {
            EntryMinHeap e = minHeap.poll();
            System.out.print(e.getValue() + " : " + e.getKey() + "\n");
        }
    }

    private static void kFrequentSort(int[] arr) {
        PriorityQueue<EntryMaxHeap> maxHeap = new PriorityQueue<>();
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            } else {
                hashMap.put(arr[i], 1);
            }
        }
        for (Map.Entry<Integer, Integer> entry : hashMap.entrySet()) {
            maxHeap.add(new EntryMaxHeap(entry.getValue(), entry.getKey()));
        }
        int i = 0;
        while (!maxHeap.isEmpty()) {
            EntryMaxHeap e = maxHeap.poll();
            int j = e.getKey();
            while (j > 0) {
                arr[i] = e.getValue();
                j--;
                i++;
            }
        }
    }

    // x2 + y2
    private static void kClosestPoint(int[][] arr, int k) {
        PriorityQueue<EntryMaxHeap> maxHeap = new PriorityQueue<>();
        for (int i = 0; i < arr.length; i++) {
            int diff = (int) Math.sqrt(arr[i][0] * arr[i][0] + arr[i][1] * arr[i][1]);
            maxHeap.add(new EntryMaxHeap(diff, i));
            if (maxHeap.size() > k) {
                maxHeap.remove();
            }
        }
        while (!maxHeap.isEmpty()) {
            EntryMaxHeap entryMaxHeap = maxHeap.poll();
            System.out.println(arr[entryMaxHeap.getValue()][0] + " :" + arr[entryMaxHeap.getValue()][1]);
        }
    }

    private static int connectRopesToMinCost(int[] arr) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int value : arr) {
            minHeap.add(value);
        }
        int cost = 0;
        while (minHeap.size() > 1) {
            int sum = minHeap.poll() + minHeap.poll();
            cost = cost + sum;
            minHeap.add(sum);
        }
        return cost;
    }

    private static int sumOfArrayBetween2Values(int[] arr, int k1, int k2) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        int sum = 0;
        for (int i = 0; i < arr.length; i++) {
            maxheap.add(arr[i]);
            if (maxheap.size() >= k2) {
                maxheap.remove();
            }
        }
        while (maxheap.size() > k1) {
            sum = sum + maxheap.poll();
        }
        return sum;
    }
}
