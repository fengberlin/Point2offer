package solution;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * 面试题57（一）：和为s的两个数字
 * 题目：输入一个递增排序的数组和一个数字S，在数组中查找两个数，
 * 使得他们的和正好是S，如果有多对数字的和等于S，输出两个数的乘积最小的。
 */
public class TwoNumbersWithSum {

    // 方法一
    // 使用HashMap，如果sum-data[i]不在数组中，则把data[i]添加进HashMap中，
    // 否则的话则证明找到了这两个数，然后计算他们的乘积，然后取乘积最小的一对数字。
    public List<Integer> find2NumbersWithSum(int[] data, int sum) {

        if (data == null || data.length ==0) {
            return null;
        }

        List<Integer> list = new ArrayList<>();
        Map<Integer, Integer> map = new HashMap<>();
        int minValue = Integer.MAX_VALUE;
        for (int i = 0; i < data.length; i++) {
            if (!map.containsKey(sum - data[i])) {
                map.put(data[i], i);
            } else {
                int min = data[i] * (sum - data[i]);
                if (min < minValue) {
                    minValue = min;
                    list.clear();
                    list.add(sum - data[i]);
                    list.add(data[i]);
                }
            }
        }

        return list;
    }

    // 方法二
    // 利用题目所说的递增有序性，则设置两个指针，分别指向头尾，然后判断指针所指的两个数的和，
    // 如果是大于给定的sum，则表示尾指针需要指向一个较小的数，所以尾指针减1，同理可得另一种情况。
    // 如果是等于给定的sum，则两个指针分别向前向后移动。
    public List<Integer> find2NumbersWithSum1(int[] data, int sum) {

        if (data == null || data.length ==0) {
            return null;
        }

        int low = 0;
        int high = data.length - 1;
        int minValue = Integer.MAX_VALUE;
        List<Integer> list = new ArrayList<>();
        while (low <= high) {
            if (data[low] + data[high] > sum) {
                high--;
            } else if (data[low] + data[high] < sum) {
                low++;
            } else {
                int min = data[low] * data[high];
                if (min < minValue) {
                    minValue = min;
                    list.clear();
                    list.add(data[low]);
                    list.add(data[high]);
                }
                low++;
                high--;
            }
        }

        return list;
    }
}
