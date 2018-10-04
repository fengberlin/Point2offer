package solution;

import java.util.LinkedList;
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
            return (getLastNumberInCircle(n - 1, m) + m) % n;
    }

    public int getLastNumberInCircle1(int n, int m) {

        if (n == 0 || m == 0) {
            return -1;
        }

        List<Integer> list = new LinkedList<>();
        for (int i = 0; i < n; i++) {
            list.add(i);
        }

        int index = -1;
        while (list.size() > 1) {
            index = (index + m) % list.size();
            list.remove(index);
            index--;
        }

        return list.get(0);
    }

    public static void main(String[] args) {
        System.out.println(new LastNumberInCircle().getLastNumberInCircle1(5, 3));
    }
}
