package solution;

/**
 * 面试题63：股票的最大利润
 * 题目：假设把某股票的价格按照时间先后顺序存储在数组中，请问买卖交易该股
 * 票可能获得的利润是多少？例如一只股票在某些时间节点的价格为{9, 11, 8, 5,
 * 7, 12, 16, 14}。如果我们能在价格为5的时候买入并在价格为16时卖出，则能
 * 收获最大的利润11。
 */
public class MaximalProfit {

    // 在某一个数字卖出的时候，只要找出这个数字之前的最小值即可
    public int getMaxProfit(int[] prices) {

        if (prices == null || prices.length <= 1) {
            return 0;
        }

        int min = prices[0];    // 保存在第i个数字买入时，之前的i-1个数字的最小值
        int maxDiff = 0;
        for (int i = 1; i < prices.length; i++) {
            if (prices[i] < min) {
                min = prices[i];
            }

            int currentDiff = prices[i] - min;
            if (currentDiff > maxDiff) {
                maxDiff = currentDiff;
            }
        }

        return maxDiff;
    }
}
