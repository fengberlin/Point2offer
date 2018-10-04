package solution;

/**
 * 面试题65：不用加减乘除做加法
 * 题目：写一个函数，求两个整数之和，要求在函数体内
 * 不得使用＋、－、×、÷ 四则运算符号。
 */
public class Add {

    public int add(int a, int b) {

        int sum = 0, carry = 0;
        do {
            sum = a ^ b;    // 各位相加
            carry = (a & b) << 1;    // 计算进位
            a = sum;
            b = carry;
        } while (b != 0);    // 重复执行知道不产生进位为止

        return a;
    }

    public static void main(String[] args) {
        System.out.println(new Add().add(5, 17));
    }
}
