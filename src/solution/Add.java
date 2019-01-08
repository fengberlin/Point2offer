package solution;

/**
 * 面试题65：不用加减乘除做加法
 * 题目：写一个函数，求两个整数之和，要求在函数体内
 * 不得使用＋、－、×、÷ 四则运算符号。
 */
public class Add {

    public long add(long a, long b) {

        long sum, carry;
        do {
            sum = a ^ b;    // 各位相加
            carry = (a & b) << 1;    // 计算进位
            a = sum;
            b = carry;
        } while (b != 0);    // 重复执行直到不产生进位为止

        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Add().add(2147483647, 1));
    }
}
