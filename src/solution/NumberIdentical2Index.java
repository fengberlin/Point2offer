package solution;

/**
 * 面试题53（三）：数组中数值和下标相等的元素
 * 题目：假设一个单调递增的数组里的每个元素都是整数并且是唯一的。请编程实
 * 现一个函数找出数组中任意一个数值等于其下标的元素。例如，在数组{-3, -1,
 * 1, 3, 5}中，数字3和它的下标相等。
 */
public class NumberIdentical2Index {

    // 二分查找的运用
    public int getNumberSameAsIndex(int[] data) {

        if (data == null || data.length == 0) {
            return -1;
        }

        int start = 0;
        int end = data.length - 1;
        while (start <= end) {
            int mid = ((end - start) >> 1) + start;
            if (data[mid] < mid) {
                start = mid + 1;
            } else if (data[mid] > mid) {
                end = mid - 1;
            } else {
                return mid;
            }
        }

        return -1;
    }
}
