package solution;

/**
 * Author：Berlin
 * 题目：一只青蛙一次可以跳上1级台阶，也可以跳上2级。求该青蛙跳上一个n级的台阶总共有多少种跳法。
 * 题目解释：即n = 0时，有f(0) = 0种跳法；n = 1时，有f(1) = 1种跳法；
 * n = 2时，有f(2) = 2种跳法；n = 3时，有f(3) = 3种跳法；
 * 当n > 3时，有f(n - 1) + f(n - 2)种跳法。
 */
public class JumpSteps {

    // 其实这就是一个斐波那契数列
    public static long jumpSteps(int n) {

        if (n < 0) {
            return -1;
        } else if (n <= 2) {
            return n;
        }

        long n1 = 1, n2 = 2, sum = 0;

        for (int i = 3; i <= n; i++) {
            sum = n1 + n2;
            n1 = n2;
            n2 = sum;
        }

        return sum;
    }
}
