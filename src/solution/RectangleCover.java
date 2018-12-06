package solution;

/**
 * Author：Berlin
 * 题目描述：我们可以用2*1的小矩形横着或者竖着去覆盖更大的矩形。
 * 请问用n个2*1的小矩形无重叠地覆盖一个2*n的大矩形，总共有多少种方法？
 */
public class RectangleCover {

    public static long cover(int n) {

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
