package companywise;

import util.Utils;

import java.util.*;

public class Amazon {

    public static void main(String[] args) {
        Amazon amazon = new Amazon();
        System.out.println("isPalindrome " + isPalindrome(".,"));
        System.out.println("lengthOfLastWord " + lengthOfLastWord("Hello World "));
        System.out.println("solve1 " + solve1("the   sky is blue"));
        System.out.println("solve2 " + solve2("hqghumeaylnlfdxfi"));
        System.out.println("compareVersion " + compareVersion("4444371174137455", "5.168"));
        ArrayList<Integer> AB = new ArrayList<>(Arrays.asList(4, 5, 2, 10, 8));
        prevSmaller(AB);
        Utils.printArrayList(AB, "printPrevSmaller ");
        System.out.println(solve("xxikrwmjvsvckfrqxnibkcasompsuyuogauacjrr"));
        ArrayList<Integer> A = new ArrayList<>(Arrays.asList(21, 1, 45, 10, 33));
        System.out.println(amazon.maximumGap(A));

        ArrayList<Integer> S = new ArrayList<>(Arrays.asList(10, 9, 8, 7, 6, 5, 4, 3, 2, 1));
        slidingMaximum1(S, 2);
        ArrayList<Integer> numbers = new ArrayList<>(Arrays.asList(1, 2, 3, 0, 3));
        solve(numbers, numbers.size());
        System.out.println("replace0with5: " + amazon.replace0with5(1016));
        int[] arr = {1, 2, 5, 1, 7, 2, 4, 2};
        int n = arr.length;
        amazon.removeDups(arr, n);
        int[] product = {1, 4, 3, -6, 7, -7};
        System.out.println("\nProduct: " + amazon.maxProduct(product, product.length));
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
        Utils.printArray(arr, "replaceWithNextGreatest¬");
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

    private ArrayList<Integer> getPositiveList(ArrayList<Integer> A) {
        ArrayList<Integer> positive = new ArrayList<>();
        for (Integer integer : A) {
            if (integer > 0) {
                positive.add(integer);
            }
        }
        return positive;
    }

    private int firstMissingPositive(ArrayList<Integer> A) {
        ArrayList<Integer> positive = getPositiveList(A);
        for (int i = 0; i < positive.size(); i++) {
            int val = Math.abs(positive.get(i)) - 1;
            if (val < positive.size() && positive.get(i) > 0) {
                positive.set(val, -positive.get(val));
            }
        }
        int i;
        for (i = 0; i < positive.size(); i++) {
            if (positive.get(i) > 0) {
                return i + 1;
            }
        }
        return positive.size() + 1;
    }

    private static int solve(List<Integer> B, int A) {
        int[] cnt = new int[A];
        int s = 0;

        for (int i = 0; i < A; i++) {
            s += B.get(i);
        }

        if (s % 3 != 0)
            return 0;
        s /= 3;

        int ss = 0;

        for (int i = A - 1; i >= 0; i--) {
            ss += B.get(i);
            if (ss == s)
                cnt[i] = 1;
        }

        for (int i = A - 2; i >= 0; i--)
            cnt[i] += cnt[i + 1];

        int ans = 0;
        ss = 0;

        for (int i = 0; i + 2 < A; i++) {
            ss += B.get(i);
            if (ss == s)
                ans += cnt[i + 2];
        }
        return ans;
    }

    public int solve(ArrayList<String> A) {
        if (A.size() < 3) return 0;
        double a = Double.parseDouble(A.get(0));
        double b = Double.parseDouble(A.get(1));
        double c = Double.parseDouble(A.get(2));

        for (int i = 3; i < A.size(); i++) {
            double temp = Double.parseDouble(A.get(i));
            double sum = a + b + c;
            if (sum > 1 && sum < 2) return 1;
            if (a + b + c >= 2) {
                if (a > b && a > c) {
                    a = temp;
                } else if (b > a && b > c) {
                    b = temp;
                } else {
                    c = temp;
                }
            } else {
                if (a < b && a < c) {
                    a = temp;
                } else if (b < a && b < c) {
                    b = temp;
                } else {
                    c = temp;
                }
            }
        }
        double sum = a + b + c;
        if (sum > 1 && sum < 2) return 1;
        return 0;
    }

    public int maximumGap(final List<Integer> A) {
        if (A.size() < 2) return 0;
        int first = A.get(0);
        int sec = A.get(1);
        int diff = Math.abs(first - sec);
        for (int i = 2; i < A.size(); i++) {
            if (A.get(i) > Math.max(first, sec)) {
                if (diff < Math.abs(A.get(i) - Math.max(first, sec))) {
                    diff = Math.abs(A.get(i) - Math.max(first, sec));
                    if (first > sec) {
                        sec = A.get(i);
                    } else {
                        first = A.get(i);
                    }
                }
            } else {
                if (Math.abs(A.get(i) - first) > Math.abs(A.get(i) - sec)) {
                    sec = A.get(i);
                    diff = Math.abs(A.get(i) - first);
                } else {
                    first = A.get(i);
                    diff = Math.abs(A.get(i) - sec);
                }
            }
        }
        return diff;
    }

    public int solution(int[] A) {
        ArrayList<Integer> arrayList = segregate(A);
        for (int i = 0; i < arrayList.size(); i++) {
            int val = Math.abs(arrayList.get(i) - 1);
            if (val < arrayList.size() && arrayList.get(val) > 0) {
                arrayList.set(val, -arrayList.get(val));
            }
        }
        for (int i = 0; i < arrayList.size(); i++) {
            if (arrayList.get(i) > 0) {
                return i + 1;
            }
        }
        return arrayList.size() + 1;
    }

    public ArrayList<Integer> segregate(int[] A) {
        ArrayList<Integer> arrayList = new ArrayList<>();
        for (int value : A) {
            if (value > 0) {
                arrayList.add(value);
            }
        }
        return arrayList;
    }

    class Container implements Comparable<Container> {
        String number;

        public Container(int number) {
            this.number = String.valueOf(number);
        }

        @Override
        public int compareTo(Container c) {
            String first = this.number + c.number;
            String second = c.number + this.number;
            return second.compareTo(first);
        }
    }

    public String largestNumber(final List<Integer> A) {
        if (A == null || A.isEmpty()) {
            return "0";
        }

        StringBuilder sb = new StringBuilder();
        Container[] containers = new Container[A.size()];

        int index = 0;
        for (int n : A) {
            containers[index] = new Container(n);
            index++;
        }
        Arrays.sort(containers);
        if ("0".equals(containers[0].number)) {
            return "0";
        }

        for (Container n : containers) {
            sb.append(n.number);
        }
        return sb.toString();
    }

    public class Interval {
        int start;
        int end;

        Interval() {
            start = 0;
            end = 0;
        }

        Interval(int s, int e) {
            start = s;
            end = e;
        }
    }

    boolean doesOverlap(Interval a, Interval b) {
        return (Math.min(a.end, b.end) >= Math.max(a.start, b.start));
    }

    public ArrayList<Interval> insert(ArrayList<Interval> intervals, Interval newInterval) {
        ArrayList<Interval> ans = new ArrayList<>();
        int n = intervals.size();

        if (n == 0) {
            ans.add(newInterval);
            return ans;
        }


        // Case 1 and Case 2 (new interval to be
        // inserted at corners)
        if (newInterval.end < intervals.get(0).start ||
                newInterval.start > intervals.get(n - 1).end) {
            if (newInterval.end < intervals.get(0).start)
                ans.add(0, newInterval);

            for (int i = 0; i < n; i++)
                ans.add(intervals.get(i));

            if (newInterval.start > intervals.get(n - 1).end)
                ans.add(newInterval);

            return ans;
        }

        if (newInterval.start <= intervals.get(0).start &&
                newInterval.end >= intervals.get(n - 1).end) {
            ans.add(newInterval);
            return ans;
        }

        // Case 4 and Case 5
        // These two cases need to check whether
        // intervals overlap or not. For this we
        // can use a subroutine that will perform
        // this function.
        boolean overlap = true;
        for (int i = 0; i < n; i++) {
            overlap = doesOverlap(intervals.get(i), newInterval);
            if (!overlap) {
                ans.add(intervals.get(i));

                // Case 4 : To check if given interval
                // lies between two intervals.
                if (i < n &&
                        newInterval.start > intervals.get(i).end &&
                        newInterval.end < intervals.get(i + 1).start)
                    ans.add(newInterval);

                continue;
            }

            // Case 5 : Merge Overlapping Intervals.
            // Starting time of new merged interval is
            // minimum of starting time of both
            // overlapping intervals.
            Interval temp = new Interval();
            temp.start = Math.min(newInterval.start,
                    intervals.get(i).start);

            // Traverse the set until intervals are
            // overlapping
            while (i < n && overlap) {

                // Ending time of new merged interval
                // is maximum of ending time both
                // overlapping intervals.
                temp.end = Math.max(newInterval.end,
                        intervals.get(i).end);
                if (i == n - 1)
                    overlap = false;
                else
                    overlap = doesOverlap(intervals.get(i + 1),
                            newInterval);
                i++;
            }

            i--;
            ans.add(temp);
        }
        return ans;
    }

    static void prevSmaller(ArrayList<Integer> A) {
        Stack<Integer> stack = new Stack<>();
        for (int i = 0; i < A.size(); i++) {
            int val = A.get(i);
            while (!stack.isEmpty() && stack.peek() >= val) {
                stack.pop();
            }
            if (stack.isEmpty()) {
                A.set(i, -1);
            } else {
                A.set(i, stack.peek());
            }
            stack.push(val);
        }
    }

    public static String solve(String A) { // iergxwhddh
        int[] charCount = new int[26];
        StringBuilder output = new StringBuilder();
        int curr = 0;
        for (int i = 0; i < A.length(); i++) {
            charCount[A.charAt(i) - 'a']++;
            if (charCount[A.charAt(curr) - 'a'] > 1) {
                curr++;
                while (curr <= i && charCount[A.charAt(curr) - 'a'] > 1) {
                    curr++;
                }
                if (curr >= i) {
                    output.append("#");
                } else {
                    output.append(A.charAt(curr));
                }
            } else {
                output.append(A.charAt(curr));
            }
        }
        return output.toString();
    }

    public static ArrayList<Integer> slidingMaximum(final List<Integer> A, int B) {
        PriorityQueue<Integer> maxheap = new PriorityQueue<>(Collections.reverseOrder());
        ArrayList<Integer> output = new ArrayList<>();

        for (int i = 0; i < A.size(); i++) {
            maxheap.add(A.get(i));
            if (maxheap.size() == B) {
                output.add(maxheap.peek());
                if (maxheap.contains(A.get(i - B + 1)))
                    maxheap.remove(A.get(i - B + 1));
            }
        }
        return output;
    }

    public static ArrayList<Integer> slidingMaximum1(final List<Integer> A, int B) {
        ArrayList<Integer> result = new ArrayList<>();
        int max = Integer.MIN_VALUE;
        for (int i = 0; i < A.size(); i++) {
            max = Math.max(max, A.get(i));
            if (i - B + 1 >= 0) {
                result.add(max);
                if (A.get(i - B + 1) == max) {
                    max = Integer.MIN_VALUE;
                    for (int j = i - B + 2; j <= i; j++) {
                        max = Math.max(max, A.get(j));
                    }
                }
            }
        }
        return result;
    }

    public int largestRectangleArea(ArrayList<Integer> A) {
        int max = Integer.MIN_VALUE;
        for (int i = 1; i < A.size(); i++) {
            if (A.get(i - 1) > A.get(i)) {
                int j = i - 1;
                while (j >= 0) {
                    max = Math.max(max, A.get(j) * (i - j));
                    j--;
                }
                j = i;
            }
        }
        return max;
    }

    public static int isPalindrome(String A) {
        int i = 0;
        A = A.toLowerCase();
        int j = A.length() - 1;
        while (i < j) {
            while (i < A.length() && !((A.charAt(i) - 'a' >= 0 && A.charAt(i) - 'a' <= 26) ||
                    (A.charAt(i) - '0' >= 0 && A.charAt(i) - '0' <= 9))) {
                i++;
            }
            while (j >= 0 && !((A.charAt(j) - 'a' >= 0 && A.charAt(j) - 'a' <= 26) ||
                    (A.charAt(j) - '0' >= 0 && A.charAt(j) - '0' <= 9))) {
                j--;
            }
            if (i >= A.length() || j < 0) return 1;
            if (A.charAt(i) == A.charAt(j)) {
                i++;
                j--;
            } else {
                return 0;
            }
        }
        return 1;
    }

    public int strStr(final String A, final String B) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < B.length(); i++) {
            if (!hashMap.containsKey(B.charAt(i)))
                hashMap.put(B.charAt(i), i);
        }
        for (int i = 0; i < A.length(); i++) {
            if (hashMap.containsKey(A.charAt(i))) {
                return hashMap.get(A.charAt(i));
            }
        }
        return -1;
    }

    public static int lengthOfLastWord(final String A) {

        int len = 0;
        for (int i = A.length() - 1; i >= 0; i--) {
            if (A.charAt(i) != ' ') {
                len++;
            } else if (A.charAt(i) == ' ' && len != 0) {
                return len;
            }
        }
        return len;
    }

    public static String solve1(String A) {
        String res = "";
        StringBuilder word = new StringBuilder();
        for (int i = 0; i < A.length(); i++) {
            if (A.charAt(i) == ' ') {
                if (!word.equals("")) {
                    res = word + " " + res;
                    word = new StringBuilder();
                }
            } else {
                word.append(A.charAt(i));
            }
        }
        res = word + " " + res;
        return res.trim();
    }

    public static int solve2(String A) { // hqghumeaylnlfdxfi
        int count = 0;
        int i = 0;
        int j = A.length() - 1;
        while (i <= j) {
            if (A.charAt(i) == A.charAt(j)) {
                i++;
                j--;
            } else {
                count++;
                j--;
            }
        }
        return count;
    }

    public static int compareVersion(String A, String B) {
        int vnum1 = 0, vnum2 = 0;
        for (int i = 0, j = 0; (i < A.length()
                || j < B.length()); ) {
            while (i < A.length() && A.charAt(i) != '.') {
                vnum1 = vnum1 * 10 + (A.charAt(i) - '0');
                i++;
            }
            while (j < B.length() && B.charAt(j) != '.') {
                vnum2 = vnum2 * 10 + (B.charAt(j) - '0');
                j++;
            }
            if (vnum1 > vnum2)
                return 1;
            if (vnum2 > vnum1)
                return -1;
            vnum1 = vnum2 = 0;
            i++;
            j++;
        }
        return 0;
    }
}