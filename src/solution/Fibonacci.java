package solution;

/**
 * Author：Berlin
 * Problem 10：斐波那契数列。n = 0时，f(n) = 0；n = 1时，f(n) = 1；n > 1时，f(n) = f(n - 1) + f(n - 2)。
 */
public class Fibonacci {

    // 递归 时间复杂度O(2^n)
    public static long fibonacci_recursively(int n) {

        if (n == 0) {
            return 0;
        }

        if (n == 1) {
            return 1;
        }

        return fibonacci_recursively(n - 1) + fibonacci_recursively(n - 2);
    }

    // 循环 时间复杂度O(n)
    public static long fibonacci_loop(int n) {

        if (n < 0) {
            return -1;
        } else if (n < 2) {
            return n;
        }

        long n0 = 0, n1 = 1, sum = 0;

        // 如果n大于2，则从2开始到n，因为n==0和n==1时的数是已知的，直接相加就行
        for (int i = 2; i <= n; i++) {
            // n0和n1分别保存处于n-1位置的数和n位置的数也即之前相加起来的总和
            sum = n0 + n1;
            n0 = n1;
            n1 = sum;
        }

        return sum;
    }

    public static void main(String[] args) {
        System.out.println(fibonacci_loop(6));
    }
}
