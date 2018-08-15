package solution;

/**
 * Problem 15：二进制中1的个数
 * 题目描述：请实现一个函数，输入一个整数，输出该数二进制表示中1的个数。
 * 例如把9表示成二进制是1001，有2位是1。因此如果输入9，该函数输出2。
 */
public class NumOf1InBinary {

    // 方法1
    // 这个方法是先与1相与，判断这个数是否变为0，如果不是的话
    // 这个数右移一位（在这里使用了Java的有符号右移），然后
    // 1的个数加1，因为如果这个数不为0，则其二进制数至少有一位是1，
    // 只要这个数与1相与，当那个是1的位与1相与时，通过判断不为0，则1的个数加1。
    // 缺点：当输入的数是负数的时候，当进行有符号的右移时，移位后最高位会设为1，
    // 所以一直进行右移的话，最后这个数字的所有位都是1，最终陷入死循环状态。
    public static int numOf1_solution0(int number) {

        int count = 0;

        while (number != 0) {

            if ((number & 1) != 0) {
                count++;
            }
            number = number >> 1;
        }

        return count;
    }

    // 方法2
    // 为了避免死循环，我们可以先将这个数与1相与，判断这个数的最低位是否为1，
    // 以此类推不断将1左移，再判断这个数的次低位是否为1。
    public static int numOf1_solution1(int number) {

        int count = 0;
        int flag = 1;
        while (flag != 0) {
            if ((number & flag) != 0) {
                count++;
            }
            flag = flag << 1;
        }
        return count;
    }

    // 方法3
    // 这时一个巧妙的解法。我们先将这个数减去1，然后再与这个数相与。
    // 只要这个数有多少个1，就进行多少次相与操作。
    // 假设这个数的最右边的位是1，那么减去1之后，这个位就变成了0而其他位保持不变。
    // 也就是最后一位相当于做了取反操作，由1变成了0。
    // 假设这个数的最右边的位不是而是0，，如果该数的二进制数最右边的1位于第m位，
    // 那么减去1后，第m位由1变成0，，而第m位之后的所有0都变成1，第m位之前的所有位都保持不变。
    // 例如：一个二进制数1100，它的第二位是从最右边数起的第一个1.减去1之后，第二位变成0，
    // 它后面的两位变为1，而前面的1保持不变，因此得到的结果是1011。
    // 如果再进行这个数与减去了1的这个数相与，就相当于把从最右边数起的1变成0，得到1000。
    // 所以我们只要再进行这样的操作，就能把这个数的二进制数的所有1变成0，这样记录下这样的
    // 操作次数，就能计算出1的个数。
    public static int numOf1_solution2(int number) {

        int count = 0;
        while (number != 0) {
            count++;
            number = number & (number - 1);
        }
        return count;
    }

    public static void main(String[] args) {
        System.out.println(Integer.toBinaryString(100));
        System.out.println(numOf1_solution2(100));
    }
}
