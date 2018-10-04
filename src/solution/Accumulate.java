package solution;

/**
 * 面试题64：求1 + 2 + … + n
 * 题目：求1+2+…+n，要求不能使用乘除法、for、while、if、else、switch、case
 * 等关键字及条件判断语句（A?B:C）。
 */
public class Accumulate {

    // 短路求值，不需要用到if语句判断递归结束条件
    public long getSum(int n) {

        int sum = n;
        boolean bool = sum != 0 && (sum += getSum(n - 1)) > 0;
        return sum;
    }

    public static void main(String[] args) {
        System.out.println(new Accumulate().getSum(100));
    }

}
