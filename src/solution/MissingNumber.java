package solution;

/**
 * 面试题53（二）：0到n-1中缺失的数字
 * 题目：一个长度为n-1的递增排序数组中的所有数字都是唯一的，并且每个数字
 * 都在范围0到n-1之内。在范围0到n-1的n个数字中有且只有一个数字不在该数组
 * 中，请找出这个数字。
 */
public class MissingNumber {

    public int getMissingNumber(int[] data) {

        if (data == null || data.length == 0) {
            return 0;
        }

        int start = 0;
        int end = data.length - 1;
        int mid;
        while (start <= end) {
            mid = ((end - start) >> 1) + start;
            if (data[mid] != mid) {
                // 如果mid不等于data[mid]然而data[mid-1]等于mid-1,说明data[mid]正好时那个确实的数
                if (mid == 0 || data[mid - 1] == mid - 1) {
                    return mid;
                } else {
                    // 否则只在左边找
                    end = mid - 1;
                }
            } else {
                // 如果data[mid]等于mid，则只用在右边找
                start = mid + 1;
            }
        }

        // 如果start遍历到data.length也找不到，说明缺失的数为最后一个数
        if (start == data.length) {
            return data.length;
        }

        return -1;
    }
}
