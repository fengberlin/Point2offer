package solution;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

/**
 * Author；Berlin
 * 题目描述：有两个排序的数组A1和A2，内存在A1的末尾有足够多的空余空间容纳A2。
 * 请实现一个函数，把A2中的所有数字插入A1中，并且所有的数字是排序的（都是升序或都是降序）。
 * 这里做一个规定，复制好之后，排序按从小到大排。
 */
public class CopyAnother {

    /**
     * @param a 等待插入的数组
     * @param b 将元素插入a数组的数组
     * @param aNum a数组中元素的个数
     * @param bNum b数组中元素的个数
     */
    public static void copy(int[] a, int aNum, int[] b, int bNum) {

        if (a == null || b == null || a.length == 0 || b.length == 0) {
            return;
        }

        int aIndex = aNum - 1;
        int bIndex = bNum - 1;
        int newIndex = aNum + bNum - 1;

        while(aIndex >= 0 && bIndex >= 0) {

            if (a[aIndex] >= b[bIndex]) {
                a[newIndex--] = a[aIndex--];
            } else {
                a[newIndex--] = b[bIndex--];
            }
        }

        while (bIndex >= 0) {
            a[newIndex--] = b[bIndex--];
        }

    }


    public static void main(String[] args) {

        int[] a = new int[10];
        int[] b = {1, 2, 3, 4, 5};

        a[0] = 2;
        a[1] = 4;
        a[2] = 7;

        copy(a, 3, b, 5);

        for (int i = 0; i < 8; i++) {
            System.out.print(a[i] + " ");
        }

        System.out.println();
    }
}
