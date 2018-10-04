package solution;

/**
 * 面试题42：连续子数组的最大和
 * 题目：输入一个整型数组，数组里有正数也有负数。数组中一个或连续的多个整
 * 数组成一个子数组。求所有子数组的和的最大值。要求时间复杂度为O(n)。
 */
public class GreatestSumOfSubarray {

    // 循环
    public int findGreatestSumOfSubarray(int[] data) {

        if (data == null || data.length == 0) {
            return 0;
        }

        int sum = 0;
        int maxSum = Integer.MIN_VALUE;
        for (int i = 0; i < data.length; i++) {

            if (sum <= 0) {
                sum = data[i];
            } else {
                sum += data[i];
            }

            if (sum > maxSum) {
                maxSum = sum;
            }

        }

        return maxSum;
    }

    // 动态规划(其实跟循环是一样的，循环也是动态规划思想)
    public int findGreatestSumOfSubarray1(int[] data) {

        if (data == null || data.length == 0) {
            return 0;
        }

        int sum = data[0];
        int maxSum = data[0];
        for (int i = 1; i < data.length; i++) {
            sum = sum > 0 ? sum + data[i] : data[i];
            maxSum = sum > maxSum ? sum : maxSum;
        }

        return maxSum;
    }
}
