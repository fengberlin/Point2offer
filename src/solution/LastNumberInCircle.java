package solution;

import java.util.ArrayList;
import java.util.List;

/**
 * 面试题62：圆圈中最后剩下的数字
 * 题目：0, 1, …, n-1这n个数字排成一个圆圈，从数字0开始每次从这个圆圈里
 * 删除第m个数字。求出这个圆圈里剩下的最后一个数字。
 */
public class LastNumberInCircle {

    /**
     * @param n the numbers of number
     * @param m mth number
     * @return
     */
    public int getLastNumberInCircle(int n, int m) {

//        if (n < 1 || m < 1) {
//            return -1;
//        }
//
//        int last = 0;
//        for (int i = 2; i <= n; i++) {
//            last = (last + m) % i;
//        }
//
//        return last;

        if(n==0)
            return -1;
        if(n==1)
            return 0;
        else
            // 这里考虑的是一些数学公式的推导，具体请看剑指offer
            return (getLastNumberInCircle(n - 1, m) + m) % n;
    }

    // 最好理解的做法
    public int getLastNumberInCircle1(int n, int m) {

        if (n == 0 || m == 0) {
            return -1;
        }

        // 这里要用ArrayList，因为涉及到随机读取，数组比链表效率要高
        List<Integer> list = new ArrayList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = 0;
        while (list.size() > 1) {
            // 模拟环形链表，要删除第m个数，其实是要删除index为m-1的数
            index = (index + m - 1) % list.size();
            list.remove(index);
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new LastNumberInCircle().getLastNumberInCircle1(5, 3));
    }
}
