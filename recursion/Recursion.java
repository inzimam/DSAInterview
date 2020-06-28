package recursion;

public class Recursion {

    public static void main(String[] args) {
        Recursion recursion = new Recursion();
        recursion.printNumberDsc(5);
        recursion.printNumberAsc(5);
        System.out.println("factorial : " + recursion.factorial(4));
        System.out.println("factorial : " + recursion.factorialTailRec(6, 1));
        System.out.println("palindrome : " + recursion.isPalindrome("abccba", 0, 5));
        System.out.println("fib : " + recursion.fib(7));
    }

    void printNumberDsc(int num) {
        if (num < 1) {
            return;
        } else {
            System.out.print(num + " ");
            printNumberDsc(num - 1);
        }

    }

    void printNumberAsc(int num) {
        if (num < 1) {
            return;
        } else {
            System.out.print(1 + " ");
            printNumberAsc(num - 1);
        }
    }

    int factorial(int num) {
        if (num == 0) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    int factorialTailRec(int num, int k) {
        if (num == 0) {
            return k;
        } else {
            return factorialTailRec(num - 1, k * num);
        }
    }

    boolean isPalindrome(String str, int start, int end) {
        if (start == end || start > end) return true;

        if (str.charAt(start) != str.charAt(end))
            return false;
        else
            return isPalindrome(str, start + 1, end - 1);
    }

    int fib(int n) {
        if (n <= 1)
            return n;
        return fib(n - 1) + fib(n - 2);
    }
}
