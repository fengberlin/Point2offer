package solution;

import java.util.Arrays;

/**
 * 面试题66：构建乘积数组
 * 题目：给定一个数组A[0, 1, …, n-1]，请构建一个数组B[0, 1, …, n-1]，其
 * 中B中的元素B[i] =A[0]×A[1]×… ×A[i-1]×A[i+1]×…×A[n-1]。不能使用除法。
 */
public class ConstructArray {

    // b[i]可以分成a[0]×a[1]×… ×a[i-1]和a[i+1]×…×a[n-1]两部分
    public int[] construct(int[] a) {

        if (a == null || a.length == 0) {
            return null;
        }

        int[] b = new int[a.length];
        b[0] = 1;
        // 计算下三角
        for (int i = 1; i < a.length; i++) {
            b[i] = b[i - 1] * a[i - 1];
        }

        int temp = 1;
        // 计算上三角
        for (int i = a.length - 2; i >= 0; i--) {
            temp *= a[i + 1];
            b[i] *= temp;
        }

        return b;
    }

    public static void main(String[] args) {

        System.out.println(Arrays.toString(new ConstructArray().construct(new int[]{1,2,3,4,5})));
    }
}
