package recursion;

import util.Utils;

import java.util.Stack;

public class Recursion {

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);
        stack.push(5);
        reverseStack(stack);
        delMiddleInStack(stack);
        for (int s : stack) {
            System.out.println(s + " ");
        }
        System.out.println(kthGrammar(4, 5));
        subset("AAB", "");
        System.out.println("");
        insertSpace("ABC", "");
        System.out.println("");
        caseChange("abc", "");
        System.out.println("");
        caseOpposite("a1B2", "");
    }

    private static void reverseStack(Stack<Integer> s) {
        if (s.size() == 1) return;
        int temp = s.pop();
        reverseStack(s);
        insertAtStart(s, temp);
    }

    private static int kthGrammar(int N, int K) {
        if (N == 1)
            return 0;
        int mid = (int) Math.pow(2, N - 1) / 2;
        if (K <= mid) {
            return kthGrammar(N - 1, K);
        } else {
            return kthGrammar(N - 1, K - mid) == 0 ? 1 : 0;
        }
    }

    private static void insertAtStart(Stack<Integer> s, int val) {
        if (s.isEmpty()) {
            s.push(val);
            return;
        }
        int temp = s.pop();
        insertAtStart(s, val);
        s.push(temp);
    }


    private static void delMiddleInStack(Stack<Integer> s) {
        if (s.isEmpty())
            return;
        int mid = (s.size() + 1) / 2;
        solve(s, mid);
    }

    private static void solve(Stack<Integer> s, int k) {
        if (k == 1) {
            s.pop();
            return;
        }
        int temp = s.pop();
        solve(s, k - 1);
        s.push(temp);
    }

    private static void subset(String input, String output) {
        if (input.isEmpty()) {
            System.out.print(output + " ");
            return;
        }
        String output2 = output + input.charAt(0);
        subset(input.substring(1), output);
        subset(input.substring(1), output2);
    }

    private static void insertSpace(String input, String output) {
        if (input.isEmpty()) {
            System.out.print(output + " ");
            return;
        }
        if (output.isEmpty()) {
            insertSpace(input.substring(1) + "", input.charAt(0) + "");
            return;
        }
        String output1 = output + "_" + input.charAt(0);
        String output2 = output + input.charAt(0);
        insertSpace(input.substring(1) + "", output1);
        insertSpace(input.substring(1) + "", output2);
    }

    private static void caseChange(String input, String output) {
        if (input.isEmpty()) {
            System.out.print(output + " ");
            return;
        }
        String output1 = output + (input.charAt(0) + "").toUpperCase();
        String output2 = output + (input.charAt(0) + "");
        caseChange(input.substring(1), output1);
        caseChange(input.substring(1), output2);
    }

    private static void caseOpposite(String input, String output) {
        if (input.isEmpty()) {
            System.out.print(output + " ");
            return;
        }
        if (Utils.checkAlphabet(input.charAt(0)) == Utils.ALPHABET.LOWER
                || Utils.checkAlphabet(input.charAt(0)) == Utils.ALPHABET.UPPER) {
            caseOpposite(input.substring(1), output + (input.charAt(0) + "").toUpperCase());
            caseOpposite(input.substring(1), output + (input.charAt(0) + "").toLowerCase());
        } else {
            caseOpposite(input.substring(1), output + input.charAt(0));
        }
    }
}