package solution;

import java.util.HashMap;
import java.util.Map;


/**
 * Author: Berlin
 * Problem 3-2：不修改数组找出重复的数字
 * 题目描述：在一个长度为n+1的数组里的所有数字都在1到n的范围内，所以数组中至
 * 少有一个数字是重复的。请找出数组中任意一个重复的数字，但不能修改输入的
 * 数组。例如，如果输入长度为8的数组{2, 3, 5, 4, 3, 2, 6, 7}，那么对应的
 * 输出是重复的数字2或者3。
 */
public class DuplicateNumber1 {

    // 方法1：时间复杂度为O(n)，空间复杂度为O(n)，没有修改原数组，但是需要一个额外的空间。
    // 一边扫描数组，并检查下一个要扫描的数是否已经存在散列表里面，如果不存在，则加入到散列表，否则就返回第一个重复的数字。
    public static int findDuplicateNumberWithNoMod0(int[] a) {
        if (a == null) {
            throw new NullPointerException("空对象。");
        }

        if (a.length == 0) {
            throw new IllegalArgumentException("空数组。");
        }

        Map<Integer, Integer> map = new HashMap<>();

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0 || a[i] > a.length - 1) {
                throw new IllegalArgumentException("数组内元素不满足题意。");
            }
            if (map.containsKey(a[i])) {
                return a[i];
            }
            map.put(a[i], i);
        }

        // 暂时使用-1来表示没有找到重复的数
        return -1;
    }

    // 方法2：时间复杂度为O(n)，空间复杂度为O(n)。
    // 比较原数组的元素和辅助数组下标为对应元素的位置的值，
    // 若不相等，则将原数组的元素复制到辅助数组下标为对应元素的位置；
    // 若相等就返回那个重复的元素。
    public static int findDuplicateNumberWithNoMod1(int[] a) {
        if (a == null) {
            throw new NullPointerException("空对象。");
        }

        if (a.length == 0 || a.length == 1) {
            throw new IllegalArgumentException("不合法参数。");
        }

        int[] b = new int[a.length];

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 1 || a[i] > a.length - 1) {
                throw new IllegalArgumentException("数组内元素不满足题意。");
            }
            if (a[i] != b[a[i]]) {
                b[a[i]] = a[i];
            } else {
                return a[i];
            }
        }

        return -1;
    }

    // 方法3：时间复杂度为O(n)，空间复杂度会比使用一个额外的存储原来的数值的数组要小，因为它使用列一个boolean数组。
    // 边扫描原数组，如果辅助数组中对应的元素不为true，则表示这个元素是第一次被扫描到，
    // 如果再有元素原前面的某个元素相同，则返回这个元素。
    public int findDuplicateNumber2(int[] a) {
        if (a == null) {
            throw new NullPointerException("空对象。");
        }

        if (a.length == 0) {
            throw new IllegalArgumentException("空数组。");
        }
        boolean[] k = new boolean[a.length];
        for (int i = 0; i < k.length; i++) {
            if (a[i] < 0 || a[i] > a.length - 1) {
                throw new IllegalArgumentException("数组内元素不满足题意。");
            }
            if (k[a[i]] == true) {
                return a[i];
            }
            k[a[i]] = true;
        }
        return -1;
    }

    // 方法4：时间复杂度为O(n)，空间复杂度为O(1)。
    // 个人不太喜欢这个方法。。。对于一些数组并不能得出正确答案。
    public static int findDuplicateNumberWithNoMod2(int[] a) {
        if (a == null || a.length == 0) {
            return -1;
        }

        int start = 1;
        int end = a.length - 1;
        while (end >= start) {
            int middle = ((end - start) >> 1) + start;
            int count = countRange(a, start, end);
            if (end == start) {
                if (count > 1)
                    return start;
                else
                    break;
            }

            if (count > (middle - start + 1))
                end = middle;
            else
                start = middle + 1;
        }
        return -1;
    }

    private static int countRange(int[] a, int start, int end) {
        if (a == null) {
            return 0;
        }
        int count = 0;
        for (int i = 0; i < a.length; i++) {
            if (a[i] >= start && a[i] <= end) {
                ++count;
            }
        }
        return count;
    }

    public static void main(String[] args) {

        int a[] = {2, 3, 5, 4, 3, 2, 6, 7};
        int duplication = findDuplicateNumberWithNoMod1(a);
        System.out.println(duplication);
    }
}
