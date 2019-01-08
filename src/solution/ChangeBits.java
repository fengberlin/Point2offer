package solution;

/**
 * 题目：输入两个整数m和n，计算需要改变m的二进制表示中的多少位才能得到n。
 * 这个问题其实可以分两步走，第一步求这两个数的异或（^），因为异或运算将
 * 结果的位异或成1，所以第二步再统计异或后结果的二进制数的1的个数。
 */
public class ChangeBits {

    public static int change(int m, int n) {

        int result = m ^ n;
        int count = 0;

        while (result != 0) {
            result = result & (result - 1);
            count++;
        }

        return count;
    }

    public static void main(String[] args) {

        System.out.println(change(10, 13));
    }
}
