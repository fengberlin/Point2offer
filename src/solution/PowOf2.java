package solution;

/**
 * 题目描述：判断一个整数是否是2的整数次方。
 * 一个数如果是2的整数次方，那么它的二进制数必定只含有一个1，其余的都为0。
 * 那么的话我们可以先把这个数减1，然后再与这个数相与，如果结果为0，即证明是
 * 2的整数次方。
 */
public class PowOf2 {

    public static boolean isPowOf2(int number) {

        if (number <= 0) {
            return false;
        }

        // 判断这个数的二进制数是否只包含一个1
        if ((number & (number - 1)) == 0) {
            return true;
        }

        return false;
    }

    public static void main(String[] args) {

        System.out.println(isPowOf2(0));
    }
}
