package solution;

/**
 * 面试题56（一）：数组中只出现一次的两个数字
 * 题目：一个整型数组里除了两个数字之外，其他的数字都出现了两次。请写程序
 * 找出这两个只出现一次的数字。要求时间复杂度是O(n)，空间复杂度是O(1)。
 */
public class NumbersAppearOnce {

    //num1,num2分别为长度为1的数组。传出参数
    //将num1[0],num2[0]设置为返回结果
    // 解题思路：一个数异或它自己本身等于0，所以我们可以先简化题目，
    // 即找出只出现一次的数字，异或之后结果就是那个数字。
    // 如果要找出两个，那么只要把这个数组分成两个子数组就行。
    // 那么怎么划分这两个子数组使得两个不同的数分别落在不同的子数组。
    // 我们知道两个不同的数字异或之后不为0，即其二进制数至少含有一个1。
    // 那么，我们可以找到从右边数起的第一个1，这个位置记为第n位，
    // 这正好是两个数的二进制位的第一次不同(从右边起)，然后我们以第n位
    // 是不是1划分成两个子数组，这样两个不同的数必然分到不同的子数组，
    // 相同的数就会被分到同一个子数组。
    public void findNumsAppearOnce(int[] data, int[] num1 , int[] num2) {

        if (data == null || data.length <= 1) {
            return;
        }

        int resultAfterXOR = 0;
        // 先把数组中的每个数字互相异或
        for (int i = 0; i < data.length; i++) {
            resultAfterXOR = resultAfterXOR ^ data[i];
        }

        int positionOfFirstBit1 = findFirstBitOf1(resultAfterXOR);

        if (positionOfFirstBit1 == -1) {
            return;
        }

        num1[0] = num2[0] = 0;
        for (int i = 0; i < data.length; i++) {
            if (isBit1(data[i], positionOfFirstBit1)) {
                num1[0] = num1[0] ^ data[i];    // 0异或其他数都等于这个数
            } else {
                num2[0] = num2[0] ^ data[i];
            }
        }

    }

    public int findFirstBitOf1(int number) {

        if (number == 0) {
            return -1;
        }
        int position = 0;
        int flag = 1;
        // int在Java默认4字节，所以int有32位
        while (((number & flag) == 0) && (position < 32)) {
            flag = flag << 1;
            position++;
        }

        return position;
    }

    // 判断从右边数起的position位是否为1(position从0开始)
    public boolean isBit1(int number, int position) {

        number = number >> position;
        return ((number & 1) == 1);

        // return ((number & (1 << position)) == (1 << position));
    }
}
