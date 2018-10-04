package solution;

/**
 * 小东所在公司要发年终奖，而小东恰好获得了最高福利，他要在公司年会上参与一个抽奖游戏，
 * 游戏在一个n*m的棋盘上进行，上面放着n*m个价值不等的礼物，每个小的棋盘上面放置着一个礼物，
 * 他需要从左上角开始游戏，每次只能向下或者向右移动一步，到达右下角停止，一路上的格子里的
 * 礼物小东都能拿到，请设计一个算法使小东拿到价值最高的礼物。
 * 给定一个矩阵board，其中每个元素为对应格子的礼物价值,
 * 请返回能获得的最大价值，保证每个礼物价值大于100小于1000。
 */
public class Bonus {

    public int getHighestBonus(int[][] board) {

        if (board == null || board.length == 0) {
            return 0;
        }

        int rows = board.length;
        int cols = board[0].length;
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
                dp[row][col] = Math.max(upValue, leftValue) + board[row][col];
            }
        }

        return dp[rows - 1][cols - 1];
    }

    // 经典的一个动态规划
    public int getHighestBonus1(int[][] board) {

        if (board == null || board.length == 0) {
            return 0;
        }

        int rows = board.length;
        int cols = board[0].length;

        // dp矩阵放置每个过程的最大值
        int[][] dp = new int[rows][cols];

        // 下面两个for循环先初始化第一行和第一列
        dp[0][0] = board[0][0];
        for (int i = 1; i < cols; i++) {
            dp[0][i] = dp[0][i - 1] + board[0][i];
        }

        for (int i = 1; i < rows; i++) {
            dp[i][0] = dp[i - 1][0] + board[i][0];
        }

        for (int row = 1; row < rows; row++) {
            for (int col = 1; col < cols; col++) {
                dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + board[row][col];
            }
        }

        return dp[rows - 1][cols - 1];
    }

    public int getHighestBonus2(int[][] board) {

        if (board == null || board.length == 0) {
            return 0;
        }

        int rows = board.length;
        int cols = board[0].length;

        // dp矩阵放置每个过程的最大值
        int[][] dp = new int[rows][cols];

        for (int row = 0; row < rows; row++) {
            for (int col = 0; col < cols; col++) {
                if (row == 0 && col == 0) {
                    dp[row][col] = board[row][col];
                } else {
                    if (row == 0) {
                        dp[row][col] = dp[row][col - 1] + board[row][col];
                    } else if (col == 0) {
                        dp[row][col] = dp[row - 1][col] + board[row][col];
                    } else {
                        dp[row][col] = Math.max(dp[row - 1][col], dp[row][col - 1]) + board[row][col];
                    }
                }
            }
        }

        return dp[rows - 1][cols - 1];
    }

    public static void main(String[] args) {
        int[][] vals = {{1, 10, 3, 8},
                {12, 2, 9, 6},
                {5, 7, 4, 11},
                {3, 7, 16, 5}};
        System.out.println(new Bonus().getHighestBonus1(vals));
    }

}
