package solution;

/**
 * 面试题21：调整数组顺序使奇数位于偶数前面
 * 题目：输入一个整数数组，实现一个函数来调整该数组中数字的顺序，使得所有
 * 数位于数组的前半部分，所有偶数位于数组的后半部分。
 */
public class ReorderArray {

    public void swap(int[] array, int index0, int index1) {
        int temp = array[index0];
        array[index0] = array[index1];
        array[index1] = temp;
    }

    public boolean isEven(int n) {
        return (n & 0x1) == 0;
    }

    // 方法1 这个交换的逻辑在快速排序里面出现过
    public void reorder0(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        int start = 0;
        int end = array.length - 1;
        while (start < end) {
            while (start < end && !isEven(array[start])) start++;
            while (start < end && isEven(array[end])) end--;
            if (start < end) {
                swap(array, start, end);
            }
        }
    }

    // 如果要保证奇数和偶数的相对位置，就不能用方法1了，因为方法1并不是稳定的，它会改变元素的相对位置
    // 方法2，若要保证相对位置，则可以用冒泡排序的思想或者插入排序的思想，两者都是稳定的。
    // 冒泡思想，时间复杂度O(n^2)
    public void reorder1(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - i - 1; j++) {
                if ((array[j] & 0x1) == 0 && (array[j + 1] & 0x1) == 1) {
                    swap(array, j, j + 1);
                }
            }
        }
    }

    // 插入思想，时间复杂度O(n^2)
    public void reorder2(int[] array) {
        if (array == null || array.length == 0) {
            return;
        }
        for (int i = 0; i < array.length; i++) {
            if ((array[i] & 0x1) == 1) {
                int temp = array[i];
                int j = i - 1;
                while (j >= 0 && (array[j] & 0x1) == 0) {
                    array[j + 1] = array[j];
                    j--;
                }
                array[j + 1] = temp;
            }
        }
    }

}
