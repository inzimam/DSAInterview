package strings;


import java.util.*;

public class StringQuestions {
    public static void main(String[] args) {

        mergeTwoSortedArray(new int[]{2, 5, 7, 9, 13}, new int[]{1, 4, 7, 8, 10, 11, 12, 13, 14});
        findMinimum(new int[]{12, 5, 17, 2, 13, 6, 4, 1, 8});
        int a[] = {1, 0, 0, 1, 0, 1, 0, 1, 1, 1,
                1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0};

        int n = a.length;

        sortBinaryArray(a, n);
        System.out.print("Sorted: ");
        for (int i = 0; i < n; i++)
            System.out.print(a[i] + " ");


        String s1 = "AGGTAB";
        String s2 = "GXTXAYB";

        char[] X = s1.toCharArray();
        char[] Y = s2.toCharArray();
        int m = X.length;
        n = Y.length;
        System.out.println("");
        System.out.println("Length of LCS is" + " " + lcs1(X, Y, m, n));
        pairOfIntegerArray(new int[]{1, 4, 8, 10, 11, 12, 7, 13, 3, 14}, 15);
        secHighestSalary(new int[]{1, 4, 14, 8, 13, 10, 11, 12, 7, 13, 3, 14});
        printCommon(new int[]{2, 5, 7, 8, 9, 13}, new int[]{1, 4, 7, 8, 10, 11, 12, 13, 14},
                new int[]{1, 5, 8, 10, 11, 12, 13, 14});
        isAnagram("kkashpfi", "pshkakif");
        //        int a[] = {1, 0, 0, 1, 0, 1, 0, 1, 1, 1,
//                1, 1, 1, 0, 0, 1, 1, 0, 1, 0, 0};
//        printDuplicate("TimesInternet");
//        sortBinaryArray(a, a.length);
//        System.out.println(remove("acbbcddc"));// ac
        removeDuplicates("acbbcddc");

        System.out.println(wordIsInString("TimesInternet", "rner"));

        firstNonRepeatedChar("abcdcdba");
        System.out.println("Reverse: " + reverseRecursion("prinzya"));
        System.out.println("Only Digit: " + onlyDigit("-23451415151"));
        System.out.println("Is Anagram: " + isAnagram("abcder", "bacree"));
        System.out.println("Occurrence: " + occurrenceOfGivenChar("-23451415151", '5'));
        System.out.println("Palindrome: " + isPalindrome("abcdcba", 0, "abcdcba".length() - 1));
        System.out.println("Interleaved: " + isInterleaved("ABC", "DEF", "ADBECF"));
        System.out.println("LCS: " + LCS("bqdrcvefgh", "abcvdefgh", "bqdrcvefgh".length(), "abcvdefgh".length()));
        System.out.println("LPS: " + LPS("adbbca", "adbbca".length()));


        System.out.println(isAnagram("abicadefghija", "adeijafgihabc"));
        System.out.println(reverseRecursively("Combination"));
        System.out.println("isaNumber " + isaNumber("manada.d"));
        System.out.println("occurrenceOfGivenCharacter " + occurrenceOfGivenCharacter("manadad", 'm'));
        System.out.println("rotationOfEachOther " + rotationOfEachOther("IndiaVsEngland", "EnglandVsIndia"));
        System.out.println("rotationOfEachOther " + rotationOfEachOther("IndiaVsEngland", "EnglandIndiaVs"));
        System.out.println("rotationOfEachOther " + checkRotation("IndiaVsEngland", "EnglandVsIndia"));
        System.out.println("rotationOfEachOther " + checkRotation("IndiaVsEngland", "VsEnglandIndia"));
        System.out.println("isPalindromString " + isPalindromString("IndiaVaaidnI"));


        firstNonRepeatingChar("abicadefghija");
        printDuplicateCharacters("Connmbination");
        numberOfVowelsInString("number Of Vowelss In String");
        permutation("1234");
        System.out.println("reverseWords : " + reverseWords("How do you reverse words in a given sentence without using any library method"));
        System.out.println("reverseWords : " + reverseWordsRecursive("How do you reverse words in a given sentence without using any library method"));

        countTheOccurrenceOfGivenChar("countTheOccurrenceOfGivenChar", 'c');

        firstNonRepeatedCharacterFromString("firstNonRepeatedCharacterFromString");

        String str = "gnisnealogielsa";
        findNonRepeatingCharacter(str);
        upcaseLength3("I am indian boy aaa bbbb bb.");
        str = "13z31tjkdhj53iiii8";
        sumOfNumber(str);


        System.out.println("reversedUsingRecursion " + reversedUsingRecursion("schoolmaster"));
        System.out.println("isDigitaNumber " + isDigitaNumber("125678"));
        System.out.println(atoi("65536688"));
        System.out.println("validShuffleOfTwoString " + validShuffleOfTwoString("abc", "def", "dacbef"));

        System.out.println("removeGivenCharacter " + removeGivenCharacter("isanagramsWord", 'a'));
        System.out.print(string_minimization("aabcccabba"));
    }

    static char firstNonRepeated(String str) {

        return "".charAt(0);
    }

    static boolean isAnagram(String str, String anagram) {
        if (str.length() != anagram.length())
            return false;
        for (int i = 0; i < str.length(); i++) {
            if (anagram.contains("" + str.charAt(i))) {
                int index = anagram.indexOf(str.charAt(i));
                anagram = anagram.substring(0, index) + anagram.substring(index + 1);
            }
        }
        return anagram.isEmpty();
    }

    static int lcs1(char[] X, char[] Y, int m, int n) {

        int[][] L = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (X[i - 1] == Y[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }

        int index = L[m][n];
        char[] chars = new char[index];
        int i = m, j = n, k = index;

        while (i > 0 && j > 0) {
            if (X[i - 1] == Y[j - 1]) {
                chars[index - 1] = X[i - 1];
                index--;
                i--;
                j--;
            } else if (L[i - 1][j] > L[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.print("LCS: ");
        for (char c : chars) {
            System.out.print("" + c);
        }
        System.out.println("");
        return L[m][n];
    }

    private static void printCommon(int[] arr1, int[] arr2, int[] arr3) {
        int i = 0, j = 0, k = 0;
        String output = "";
        while (i < arr1.length && j < arr2.length && k < arr3.length) {
            if (arr1[i] == arr2[j] && arr2[j] == arr3[k]) {
                output = output + arr1[i];
                i++;
                j++;
                k++;
            } else if (arr1[i] < arr2[j]) {
                i++;
            } else if (arr2[j] < arr3[k]) {
                j++;
            } else {
                k++;
            }
        }
        System.out.println("Common: " + output);
    }

    static void secHighestSalary(int[] arr) {
        int max = Integer.MIN_VALUE;
        int secMax = Integer.MIN_VALUE;
        for (int i = 0; i < arr.length; i++) {
            if (max < arr[i]) {
                secMax = max;
                max = arr[i];
            } else if (secMax < arr[i] && arr[i] != max) {
                secMax = arr[i];
            }
        }
        System.out.println("secHighestSalary: " + secMax);
    }


    static void mergeTwoSortedArray(int[] arr1, int[] arr2) {
        int size1 = arr1.length, size2 = arr2.length;
        int i = 0, j = 0, k = 0;
        int[] output = new int[size1 + size2];
        while (i < size1 && j < size2) {
            if (arr1[i] < arr2[j]) {
                output[k] = arr1[i];
                i++;
                k++;
            } else {
                output[k] = arr2[j];
                j++;
                k++;
            }
        }
        while (i < size1) {
            output[k] = arr1[i];
            i++;
            k++;
        }
        while (j < size2) {
            output[k] = arr2[j];
            j++;
            k++;
        }

        for (int val : output) {
            System.out.println("Inzy " + val);
        }
    }

    static void findMinimum(int[] arr) {
        int size = arr.length;
        int min = arr[0];
        for (int i = 1; i < size; i++) {
            if (arr[i] < min) {
                min = arr[i];
            }
        }
        System.out.println("Minimum: " + min);
    }


    static int lcs(char[] X, char[] Y, int m, int n) {
        int[][] L = new int[m + 1][n + 1];

        for (int i = 0; i <= m; i++) {
            for (int j = 0; j <= n; j++) {
                if (i == 0 || j == 0) {
                    L[i][j] = 0;
                } else if (X[i - 1] == Y[j - 1]) {
                    L[i][j] = L[i - 1][j - 1] + 1;
                } else {
                    L[i][j] = max(L[i - 1][j], L[i][j - 1]);
                }
            }
        }
        int index = L[m][n];
        char[] lcs = new char[index];
        int i = m, j = n;
        while (i > 0 && j > 0) {
            if (X[i - 1] == Y[j - 1]) {
                lcs[index - 1] = X[i - 1];
                index--;
                i--;
                j--;
            } else if (L[i - 1][j] > L[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }
        System.out.print("LCS: ");
        for (char c : lcs) {
            System.out.print(c);
        }
        System.out.println("");
        return L[m][n];
    }

    public static void solution(String[] arr) {
        solution1(arr, 0, arr.length - 1, "");
    }

    public static void solution1(String[] arr, int start, int end, String val) {
        if (val != null && !val.equals("")) {
            boolean found = false;
            for (int i = start; i < end; i++) {
                if (arr[i].contains(val)) {
                    System.out.println("" + val);
                    found = true;
                }
            }
            if (!found) {
                System.out.println("null");
            }
        }
        int i = 0;
        while (arr[i].contains("print")) {
            solution1(arr, 0, i, arr[i].substring(arr[i].indexOf("(") + 1, arr[i].indexOf(")")));
            i++;
        }
    }

    static void pairOfIntegerArray(int[] arr, int k) {
        int length = arr.length;
        HashMap<Integer, Integer> hashMap = new HashMap<>();
        System.out.print("Pairs: ");
        for (int i = 0; i < length; i++) {
            int value = k - arr[i];
            if (hashMap.containsKey(value)) {
                System.out.print(" : " + hashMap.get(value) + "," + i);
            } else {
                hashMap.put(arr[i], i);
            }
        }
        System.out.println("");
    }

    static int max(int a, int b) {
        return Math.max(a, b);
    }

    static void removeDuplicates(String z) {
        String k = "";
        int i;
        for (i = 1; i < z.length(); i++) {
            if (z.charAt(i) != z.charAt(i - 1)) {
                k = k + z.charAt(i - 1);
            }
        }
        if (z.charAt(i - 2) != z.charAt(i - 1) || k.equals("")) {
            k += z.charAt(i - 1);
        }
        System.out.println(k);
    }

    private static String removeUtil1(String str, char last_removed) {
        if (str.length() < 2)
            return str;

        if (str.charAt(0) == str.charAt(1)) {
            last_removed = str.charAt(0);
            while (str.length() > 1 && str.charAt(0) == str.charAt(1))
                str = str.substring(1);
            str = str.substring(1);
            return removeUtil(str, last_removed);
        }
        String remStr = removeUtil(str.substring(1), last_removed);

        if (remStr.length() != 0 && remStr.charAt(0) == str.charAt(0)) {
            last_removed = remStr.charAt(0);
            return remStr.substring(1);
        }
        if (remStr.length() == 0 && last_removed == str.charAt(0)) {
            return remStr;
        }
        return str.charAt(0) + remStr;
    }

    private static String remove(String str) {
        char last_removed = '\0';
        return removeUtil(str, last_removed);
    }

    //********
    //**  22 Feb 2020
    //********

    // How do you print duplicate characters from a string?

    static void printDuplicate(String str) {
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (hashMap.containsKey(c)) {
                hashMap.put(c, hashMap.get(c) + 1);
            } else {
                hashMap.put(c, 1);
            }
        }
        for (Map.Entry<Character, Integer> entry : hashMap.entrySet()) {
            if (entry.getValue() > 1) {
                System.out.println("Duplicate : " + entry.getKey());
            }
        }
    }

    // How do you check if two strings are anagrams of each other?
    static boolean anagramsStrings(String str, String anagram) {
        if (str.length() != anagram.length())
            return false;
        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (anagram.contains(c + "")) {
                anagram = anagram.substring(0, anagram.indexOf(c) - 1) + anagram.substring(anagram.indexOf(c));
            }
        }
        return true;
    }

    static void sortBinaryArray(int[] arr, int n) {
        int j = -1;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == 0) {
                j++;
                int temp = arr[i];
                arr[i] = arr[j];
                arr[j] = temp;
            }
        }
        System.out.println("Duplicate : " + arr);
    }

    private static String removeUtil(String str, char last_removed) {
        if (str.length() < 2) {
            return str;
        }
        if (str.charAt(0) == str.charAt(1)) {
            last_removed = str.charAt(0);
            while (str.length() > 1 && str.charAt(0) == str.charAt(1))
                str = str.substring(1);
            str = str.substring(1);
            return removeUtil(str, last_removed);
        }

        String remStr = removeUtil(str.substring(1), last_removed);

        if (remStr.length() != 0 && remStr.charAt(0) == str.charAt(0)) {
            last_removed = remStr.charAt(0);
            return remStr.substring(1);
        }
        if (remStr.length() == 0 && last_removed == str.charAt(0)) {
            return remStr;
        }
        return str.charAt(0) + remStr;
    }


    static boolean wordIsInString(String str, String word) {
        int j = 0;
        for (int i = 0; i < str.length(); i++) {
            if (j == word.length())
                break;
            else if (str.charAt(i) == word.charAt(j)) {
                j++;
            } else {
                j = 0;
            }
        }
        return j == word.length();
    }

    static String LCS(String A, String B, int m, int n) {
        int[][] output = new int[m + 1][n + 1];

        for (int i = 1; i <= m; i++) {
            for (int j = 1; j <= n; j++) {
                if (i == 0 || j == 0) {
                    output[i][j] = 0;
                } else if (A.charAt(i - 1) == B.charAt(j - 1)) {
                    output[i][j] = output[i - 1][j - 1] + 1;
                } else {
                    output[i][j] = maxOf(output[i - 1][j], output[i][j - 1]);
                }
            }
        }
        int index = output[m][n];
        String out = "";
        int i = m, j = n;

        while (i > 0 && j > 0) {
            if (A.charAt(i - 1) == B.charAt(j - 1)) {
                out = A.charAt(i - 1) + out;
                i--;
                j--;
                index--;
            } else if (output[i - 1][j] > output[i][j - 1]) {
                i--;
            } else {
                j--;
            }
        }


        return index + "-" + out;

    }

    static String LPS(String A, int m) {
        int[][] output = new int[m][m];
        for (int i = 0; i < m; i++) {
            for (int j = 0; j < m; j++) {
                if (i == j) {
                    output[i][j] = 1;
                } else if (i > j) {
                    output[i][j] = 0;
                } else if (A.charAt(i) == A.charAt(j)) {
                    output[i][j] = output[i - 1][j - 1] + 2;
                } else {
                    output[i][j] = maxOf(output[i + 1][j], output[i][j - 1]);
                }
            }
        }
        System.out.println("");
        return "";
    }

    static int maxOf(int a, int b) {
        return Math.max(a, b);
    }

    static void firstNonRepeatedChar(String str) {
        HashSet<Character> repeated = new HashSet<>();
        HashSet<Character> nonRepeated = new HashSet<>();

        for (int i = 0; i < str.length(); i++) {
            char c = str.charAt(i);
            if (nonRepeated.contains(c)) {
                nonRepeated.remove(c);
                repeated.add(c);
            } else {
                nonRepeated.add(c);
            }
        }
        if (nonRepeated.iterator().hasNext())
            System.out.println("Non Repeated: " + nonRepeated.iterator().next());
        else System.out.println("No Non Repeated");

        if (repeated.iterator().hasNext())
            System.out.println("Repeated: " + repeated.iterator().next());
        else System.out.println("No Repeated Character");
    }

    static String reverseRecursion(String str) {
        if (str.isEmpty())
            return "";
        int len = str.length() - 1;
        return str.charAt(len) + "" + reverseRecursion(str.substring(0, len));
    }

    static boolean onlyDigit(String str) {
        for (int i = 0; i < str.length(); i++) {
            if (str.charAt(i) < 48 || str.charAt(i) > 57) {
                return false;
            }
        }
        return true;
    }


    static int occurrenceOfGivenChar(String str, char c) {
        int count = 0;
        for (int i = 0; i < str.length(); i++) {
            if (c == str.charAt(i)) {
                count++;
            }
        }

        return count;
    }

    static boolean isPalindrome(String str1, int start, int end) {
        if (start > end || start == end) return true;
        if (str1.charAt(start) != str1.charAt(end))
            return false;
        return isPalindrome(str1, start + 1, end - 1);
    }

    // AB CD   ACBD
    static boolean isInterleaved(String A, String B, String C) {
        if (A.length() + B.length() != C.length())
            return false;
        int j = 0, k = 0;
        for (int i = 0; i < C.length(); i++) {
            if (j < A.length() && C.charAt(i) == A.charAt(j)) {
                j++;
            } else if (k < B.length() && C.charAt(i) == B.charAt(k)) {
                k++;
            } else {
                return false;
            }
        }
        return true;
    }


    private static String reverseWords(String str) {
        String[] arr = str.split(" ");
        String rev = "";
        for (int i = arr.length - 1; i >= 0; i--) {
            rev = rev + arr[i] + " ";
        }
        return rev;
    }

    private static String reverseWordsRecursive(String str) {
        String[] arr = str.split(" ");
        if (str.isEmpty() || !str.contains(" ")) {
            return str;
        }
        return reverseWordsRecursive(str.substring(str.indexOf(" ")).trim()) + " " + arr[0];
    }

    private static boolean rotationOfEachOther(String str, String rotation) {
        if (str.length() != rotation.length())
            return false;
        int index = -1;
        char[] strArr = str.toCharArray();
        char[] rotationArr = rotation.toCharArray();
        index = rotation.indexOf(strArr[0]);
        if (index != -1) {
            for (int i = 0; i < strArr.length; i++) {

                if (strArr[i] != rotationArr[index]) {
                    return false;
                }
                index = index + 1;
                if (strArr.length - 1 < index) {
                    index = 0;
                }
            }
        }
        return true;
    }

    private static boolean isPalindromString(String str) {
        char[] arr = str.toCharArray();
        for (int i = 0, j = arr.length - 1; j >= arr.length / 2 && i <= arr.length / 2; i++, j--) {
            if (arr[i] != arr[j]) {
                return false;
            }
        }
        return true;
    }

    private static boolean checkRotation(String original, String rotation) {
        if (original.length() != rotation.length()) {
            return false;
        }

        String concatenated = original + original;
        return concatenated.contains(rotation);
    }

    private static void firstNonRepeatingChar(String word) {
        Set<Character> repeating = new HashSet<>();
        List<Character> nonrepeating = new ArrayList<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (repeating.contains(c))
                continue;
            if (nonrepeating.contains(c)) {
                nonrepeating.remove((Character) c);
                repeating.add(c);
            } else {
                nonrepeating.add(c);
            }
        }
        System.out.println("nonrepeating " + nonrepeating);
        System.out.println("repeating " + repeating);
    }

    private static void printDuplicateCharacters(String word) {
        HashMap<Character, Integer> map = new HashMap<>();
        for (int i = 0; i < word.length(); i++) {
            char c = word.charAt(i);
            if (map.containsKey(c)) {
                map.put(c, map.get(c) + 1);
            } else {
                map.put(c, 1);
            }
        }
        System.out.println("word " + map);
    }

    private static String reverseRecursively(String str) {

        if (str.length() < 2)
            return str;
        return reverseRecursively(str.substring(1)) + str.charAt(0);
    }

    private static boolean isaNumber(String str) {
        boolean isaNo = true;
        for (char c : str.toCharArray()) {
            if (Character.getNumericValue(c) < 0 || Character.getNumericValue(c) > 9) {
                isaNo = false;
                break;
            }
        }
        return isaNo;
    }

    private static void numberOfVowelsInString(String str) {
        String vowelStr = "AEIOUaeiou";
        int consta = 0, vow = 0;
        for (char c : str.toCharArray()) {
            if (((int) c <= 90 && (int) c >= 65) || ((int) c <= 122 && (int) c >= 97)) {
                if (vowelStr.contains(String.valueOf(c))) {
                    vow++;
//                    System.out.println("Vowel : " + c + " ");
                } else {
                    consta++;
//                    System.out.println("Consta : " + c + " ");
                }
            }
        }
        System.out.println("Consta " + consta + " vow " + vow);
    }

    private static int occurrenceOfGivenCharacter(String str, char c) {
        int occurrence = 0;
        for (int i = 0; i < str.length(); i++) {
            char ch = str.charAt(i);
            if (ch == c) {
                occurrence++;
            }
        }
        return occurrence;
    }


    private static void permutation(String word) {
        permutation("", word);
    }

    private static void permutation(String perm, String word) {
        if (word.isEmpty()) {
            System.out.println(perm);
        } else {
            for (int i = 0; i < word.length(); i++) {
                permutation(perm + word.charAt(i), word.substring(0, i) + word.substring(i + 1));
            }
        }
    }

    // Question No : 1
    private static void countTheOccurrenceOfGivenChar(String str, char c) {
        char[] arr = str.toCharArray();
        int count = 0;
        for (int i = 0; i < arr.length; i++) {
            if (arr[i] == c) {
                count++;
            }
        }
        System.out.println("countTheOccurrenceOfGivenChar : " + count);
    }


    // Question No : 2
    private static void firstNonRepeatedCharacterFromString(String str) {
        char[] arr = str.toCharArray();
        HashMap<Character, Integer> hashMap = new HashMap<>();
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.containsKey(arr[i])) {
                hashMap.put(arr[i], hashMap.get(arr[i]) + 1);
            } else {
                hashMap.put(arr[i], 1);
            }
        }
        for (int i = 0; i < arr.length; i++) {
            if (hashMap.get(arr[i]) == 1) {
                System.out.println("firstNonRepeatedCharacterFromString : " + arr[i]);
                break;
            }
        }
    }

    private static void findNonRepeatingCharacter(String str) {
        char[] arr = str.toCharArray();
        for (char a : arr) {
            if (str.indexOf(a) == str.lastIndexOf(a)) {
                System.out.println(a + " is first non repeating char");
                break;
            }
        }
    }

    private static void upcaseLength3(String str) {
        String result = "";
        String[] arr = str.split(" ");
        for (String s : arr) {
            if (s.length() == 3) {
                result = result + " " + s.toUpperCase();
            } else {
                result = result + " " + s;
            }
        }
        System.out.println("Final String: " + result);
    }

    public static void sumOfNumber(String str) {
        char[] ar = str.toCharArray();
        // 13 z 31 t j k d h j 53 i i i i 8
        String num = "";
        int sum = 0;
        for (int i = 0; i < ar.length; i++) {
            if (Character.isDigit(ar[i])) {
                num = num + ar[i] + "";
            } else {
                if (!num.equals(""))
                    sum = sum + Integer.parseInt(num);
                num = "";
            }
        }
        if (!num.equals(""))
            sum = sum + Integer.parseInt(num);
        System.out.println("India " + sum);

    }

    static int string_minimization(String str) {

        int n = str.length();
        if (n < 2) {
            return 0;
        }
        int i = n / 2;
        String left = str.substring(0, i);
        String right = str.substring(i);

        int rightpos = i - 1;
        char cr = right.charAt(rightpos);
        char cl = left.charAt(0);
        if (cr == cl) {
            while (left.charAt(0) == cr) {
                left = left.substring(1);
            }
            while (right.charAt(rightpos) == cl) {
                rightpos--;
                right = right.substring(0, rightpos);
            }
        }
        String finalStr = right + left;
        return finalStr.length();
    }

    static int string_minimizationq(String s) {

        int n = s.length();
        if (n < 2) {
            return 0;
        }
        int len = 0;
        int i = n / 2;
        while (i < n) {
            if (s.charAt(i) == s.charAt(len)) {
                ++len;
                ++i;
            } else {
                if (len == 0) { // no prefix
                    ++i;
                } else {
                    // search for shorter prefixes
                    --len;
                }
            }
        }
        return len;
    }

    private static String reversedUsingRecursion(String str) {

        if (str.isEmpty())
            return str;
        return reversedUsingRecursion(str.substring(1)) + str.charAt(0);

    }


    private static int isDigitaNumber(String str) {
        int count = 0;
        if (str == null)
            return count;
        for (int c : str.toCharArray()) {
            System.out.println("Inzy" + c);
            if ((c >= 65 && c <= 90) || (c >= 97 && c <= 122)) {
                count++;
            }
        }
        return count;
    }




    private static boolean stringRotationOfEachOther(String str, String rotation) {
        if (str.length() != rotation.length()) {
            return false;
        }
        String concanated = str + str;
        return concanated.contains(rotation);
    }



    private static int atoi(String input) { //1234
        int value = 0;
        for (int i = 0; i < input.length(); i++) {
            value = value + Character.getNumericValue(input.charAt(i)) * getVal(input.length() - i - 1);
        }
        return value;
    }

    private static int getVal(int num) {
        int val = 1;
        for (int j = 0; j < num; j++) {
            val = val * 10;
        }
        return val;
    }



    private static boolean validShuffleOfTwoString(String first, String second, String shuffle) {
        int index = -1;
        boolean valid;
        for (char c : first.toCharArray()) {
            if (shuffle.indexOf(c) != -1 && shuffle.indexOf(c) > index) {
                index = shuffle.indexOf(c);
                shuffle = shuffle.substring(0, shuffle.indexOf(c)) + shuffle.substring(shuffle.indexOf(c) + 1);
            } else {
                return false;
            }

        }
        valid = shuffle.equals(second);
        return valid;
    }

    public static String removeCharRecursive(String word, char ch) {
        int index = word.indexOf(ch);
        if (index == -1) {
            return word;
        }
        return removeCharRecursive(word.substring(0, index) + word.substring(index + 1), ch);
    }


    private static String removeGivenCharacter(String str, char c) {
        while (str.indexOf(c) != -1) {
            str = str.substring(0, str.indexOf(c)) + str.substring(str.indexOf(c) + 1);
        }
        return str;
    }
}
