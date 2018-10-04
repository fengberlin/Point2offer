package solution;

/**
 * 面试题56（二）：数组中唯一只出现一次的数字
 * 题目：在一个数组中除了一个数字只出现一次之外，其他数字都出现了三次。请
 * 找出那个只出现一次的数字。
 */
public class NumberAppearingOnce {

    public int findNumberAppearingOnce(int[] data) {

        if (data == null || data.length == 0) {
            throw new RuntimeException("data input is invalid");
        }

        // bitSum保存每个二进制位1出现的次数
        int[] bitSum = new int[32];
        // 把数组中所有数字的二进制位全加起来
        for (int i = 0; i < data.length; i++) {
            int bitMask = 1;
            // 下面是遍历一个数字的所有二进制位
            for (int j = bitSum.length - 1; j >= 0 ; j--) {
                int bit = data[i] & bitMask;
                if (bit != 0) {
                    bitSum[j] += 1;
                }
                bitMask = bitMask << 1;
            }
        }

        int result = 0;
        for (int i = 0; i < bitSum.length; i++) {
            result = result << 1;    // result保存的是位出现的次数，那就需要左移运算来算出那个数
            result += bitSum[i] % 3;    // 重复3次的数的对应的二进制位模3都等于0，那就相当于模3都等于1是那个只出现一次的数对应的位
        }

        return result;
    }
}
