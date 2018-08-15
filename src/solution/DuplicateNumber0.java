package solution;

import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

/**
 * Author: Berlin
 * Problem 3-1：找出数组中重复的数字。
 * 题目描述：在一个长度为n的数组里的所有数字都在0到n-1的范围内。数组中某些数字是重复的，但不知道有几个数字重复了，
 * 也不知道每个数字重复了几次。请找出数组中任意一个重复的数字。例如，如果输入长度为7的数组{2, 3, 1, 0, 2, 5, 3}，
 * 那么对应的输出是重复的数字2或者3。
 */
public class DuplicateNumber0 {

    // 方法1：此方法时间复杂度为O(nlgn)，还有一个缺点是原数组会被修改。
    // 此方法先将数组排序，然后比较前后的两个数是否相同。
    public static int findDuplicateNumber0(int[] a) {
        if (a == null) {
            throw new NullPointerException("空对象。");
        }

        if (a.length == 0) {
            throw new IllegalArgumentException("空数组。");
        }

        Arrays.sort(a);

        for (int i = 0; i < a.length-1; i++) {
            // 这里要注意：长度为n的数组里的所有数字都在0到n-1的范围内，所以要有一个判断。
            if (a[i] < 0 || a[i] > a.length - 1) {
                throw new IllegalArgumentException("数组内元素不满足题意。");
            }
            if (a[i] == a[i+1]) {
                int duplication = a[i];
                return duplication;
            }
        }

        // 暂时使用-1来表示没有找到重复的数
        return -1;
    }

    // 方法2：时间复杂度为O(n),空间复杂度为O(1)，同时也修改了数组的结构。
    // 代码中尽管有一个两重循环，但每个数字最多只要交换两次就能找到属于它自己的位置，因此总的时间复杂度为O(n)。
    // 又因为是in-place操作，所以空间复杂度为O(1)。
    public static int findDuplicateNumber1(int[] a) {
        if (a == null) {
            throw new NullPointerException("空对象。");
        }

        if (a.length == 0) {
            throw new IllegalArgumentException("空数组。");
        }

        for (int i = 0; i < a.length; i++) {
            if (a[i] < 0 || a[i] > a.length - 1) {
                throw new IllegalArgumentException("数组内元素不满足题意。");
            }
            while (a[i] != i) {
                if (a[i] == a[a[i]]) {
                    return a[i];
                } else {
                    int temp = a[i];
                    a[i] = a[temp];
                    a[temp] = temp;
                }
            }
        }

        // 暂时使用-1来表示没有找到重复的数
        return -1;
    }

    public static void main(String[] args) {

        int a[] = {2, 3, 1, 0, 2, 5, 3};
        int duplication = findDuplicateNumber1(a);
        System.out.println(duplication);
    }
}
