package solution;

/**
 * Author：Berlin
 * Problem 13：机器人的运动范围
 * 题目描述：地上有一个m行n列的方格。一个机器人从坐标(0, 0)的格子开始移动，它
 * 每一次可以向左、右、上、下移动一格，但不能进入行坐标和列坐标的数位之和大于k的
 * 格子。例如，当k为18时，机器人能够进入方格(35, 37)，因为3+5+3+7=18。但它不
 * 能进入方格(35, 38)，因为3+5+3+8=19。请问该机器人能够到达多少个格子？
 */
public class RobotMove {

    public static int movingCount(int rows, int cols, int threshold) {
        if (threshold < 0 || rows <= 0 || cols <= 0) {
            return 0;
        }

        boolean[] visited = new boolean[rows * cols];

        int count = movingCountCore(rows, cols, 0, 0, threshold, visited);

        return count;
    }

    // 这也是一个回溯的思想
    private static int movingCountCore(int rows, int cols, int row, int col, int threshold, boolean[] visited) {

        int count = 0;

        if (checkParameter(rows, cols, row, col, threshold, visited)) {

            visited[row * cols + col] = true;

            count = 1 + movingCountCore(rows, cols, row + 1, col, threshold, visited) +
                    movingCountCore(rows, cols, row - 1, col, threshold, visited) +
                    movingCountCore(rows, cols, row, col + 1, threshold, visited) +
                    movingCountCore(rows, cols, row, col - 1, threshold, visited);
        }

        return count;

    }

    // 计算一个数各个数位的和
    private static int getDigitNumSum(int number) {

        int sum = 0;
        while (number > 0) {
            sum += number % 10;
            number /= 10;
        }
        return sum;
    }

    // 检查参数的合法性
    private static boolean checkParameter(int rows, int cols, int row, int col,
                                          int threshold, boolean[] visited) {
        int index = row * cols + col;

        if (row < 0 || row >= rows || col < 0 || col >= cols ||
                getDigitNumSum(row) + getDigitNumSum(col) > threshold || visited[index] == true) {
            return false;
        }

        return true;
    }
}
