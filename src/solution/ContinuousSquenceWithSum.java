package solution;

import java.util.ArrayList;

/**
 * 面试题57（二）：和为s的连续正数序列
 * 题目：输入一个正数s，打印出所有和为s的连续正数序列（至少含有两个数）。
 * 例如输入15，由于1+2+3+4+5=4+5+6=7+8=15，所以结果打印出3个连续序列1～5、
 * 4～6和7～8。
 */
public class ContinuousSquenceWithSum {

    // 双指针滑动，如果序列和大于sum，则大指针加1（为了包含更多的数取测试序列和与sum的大小关系），否则小指针加1
    public ArrayList<ArrayList<Integer>> findContinuousSquenceWithSum(int sum) {

        ArrayList<ArrayList<Integer>> result = new ArrayList<>();
        if (sum <= 0) {
            return result;
        }

        int small = 1;
        int big = 2;
        while (small < big) {
            int curSum = (small + big) * (big - small + 1) / 2;    // 等差数列的求和公式
            if (curSum < sum) {
                big++;
            } else if (curSum > sum) {
                small++;
            } else {
                ArrayList<Integer> list = new ArrayList<>();
                for (int i = small; i <= big; i++) {
                    list.add(i);
                }
                result.add(list);
                small++;
            }
        }

        return result;
    }
}
