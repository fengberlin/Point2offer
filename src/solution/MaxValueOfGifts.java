package solution;

/**
 * 面试题47：礼物的最大价值
 * 题目：在一个m×n的棋盘的每一格都放有一个礼物，每个礼物都有一定的价值
 * （价值大于0）。你可以从棋盘的左上角开始拿格子里的礼物，并每次向左或
 * 者向下移动一格直到到达棋盘的右下角。给定一个棋盘及其上面的礼物，请计
 * 算你最多能拿到多少价值的礼物？
 */
public class MaxValueOfGifts {

    public static int maxValue(int[][] values, int rows, int cols) {

        if (values == null || rows <= 0 || cols <= 0) {
            return 0;
        }

        int[][] dp = new int[rows][cols];
        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                int leftValue = 0;
                int upValue = 0;
                if (row > 0) {
                    upValue = dp[row - 1][col];
                }
                if (col > 0) {
                    leftValue = dp[row][col - 1];
                }
                dp[row][col] = Math.max(upValue, leftValue) + values[row][col];
            }
        }

        return dp[rows - 1][cols - 1];
    }

    // 使用一维数组代替二维数组
    public static int maxValue1(int[][] values, int rows, int cols) {

        if (values == null || rows <= 0 || cols <= 0) {
            return 0;
        }

        // 因为只需要用到(row-1, col)和(row, col - 1)的值，
        // 并且只用保存(row, col)的左边和上边及其之后的数，
        // 刚好就需要一个长度为cols的一维数组.
        int[] dp = new int[cols];
        for (int row = 0; row < cols; row++) {
            for (int col = 0; col < cols; col++) {
                int leftValue = 0;
                int upValue = 0;
                if (row > 0) {
                    upValue = dp[col];
                }
                if (col > 0) {
                    leftValue = dp[col - 1];
                }
                dp[col] = Math.max(upValue, leftValue) + values[row][col];
            }
        }
        return dp[cols - 1];
    }

    public static void main(String[] args) {
        int[][] vals = {{1, 10, 3, 8},
                        {12, 2, 9, 6},
                        {5, 7, 4, 11},
                        {3, 7, 16, 5}};
        System.out.println(maxValue1(vals, 4, 4));
    }
}
