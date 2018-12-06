package solution;

/**
 * Author：Berlin
 * Problem 12：矩阵中的路径
 * 题目描述：请设计一个函数，用来判断在一个矩阵中是否存在一条包含某字符串所有
 * 字符的路径。路径可以从矩阵中任意一格开始，每一步可以在矩阵中向左、右、
 * 上、下移动一格。如果一条路径经过了矩阵的某一格，那么该路径不能再次进入
 * 该格子。例如在下面的3×4的矩阵中包含一条字符串“bfce”的路径（路径中的字
 * 母用下划线标出）。但矩阵中不包含字符串“abfb”的路径，因为字符串的第一个
 * 字符b占据了矩阵中的第一行第二个格子之后，路径不能再次进入这个格子。
 * A B T G
 * C F C S
 * J D E H
 */
public class PathInMatrix {

//    public static boolean hasPath(char[][] matrix, int rows, int cols, char[] str) {
//
//        boolean[][] visited = new boolean[rows][cols];
//        for (int i = 0; i < rows; i++) {
//            for (int j = 0; j < cols; j++) {
//                if (hasPathCore(matrix, rows, cols, i, j, str, 0, visited)) {
//                    return true;
//                }
//            }
//        }
//        return false;
//    }
//
//    /**
//     * @param matrix 输入的矩阵
//     * @param rows 矩阵的行数
//     * @param cols 矩阵的列数
//     * @param row 行坐标
//     * @param col 列坐标
//     * @param str 输入的路径
//     * @param pathLength 表示路径的长度
//     * @param visited 记录矩阵的某个元素是否被访问了
//     * @return
//     */
//    private static boolean hasPathCore(char[][] matrix, int rows, int cols,
//                                       int row, int col, char[] str, int pathLength, boolean[][] visited) {
////        int index = row * cols + col;    // 如果用一维数组表示一个矩阵时，则像这样计算那个元素的下标
//        if (matrix == null || str == null || matrix.length == 0 || matrix[0].length == 0 || str.length == 0) {
//            return false;
//        }
//
//        if (row < 0 || row >= rows || col < 0 || col >= cols ||
//                matrix[row][col] != str[pathLength] || visited[row][col] == true) {
//            return false;
//        }
//
//        // 如果pathLength达到了str的长度，则表示有这个路径(这个pathLength从0开始)
//        if (pathLength == str.length - 1) {
//            return true;
//        }
//
//        // 已检查过的元素则标记为true
//        visited[row][col] = true;
//
//        // 这里体现了回溯的思想，如果矩阵中的一个元素在给定的路径中，则探索这个元素的上下左右4个位置，如果找不到则回溯到上一个元素
//        if (hasPathCore(matrix, rows, cols, row - 1, col, str, pathLength + 1, visited) ||
//                hasPathCore(matrix, rows, cols, row + 1, col, str, pathLength + 1, visited) ||
//                hasPathCore(matrix, rows, cols, row, col - 1, str, pathLength + 1, visited) ||
//                hasPathCore(matrix, rows, cols, row, col + 1, str, pathLength + 1, visited)) {
//
//            return true;
//        }
//
//        visited[row][col] = false;
//        return false;
//    }

    public static boolean hasPath(char[] matrix, int rows, int cols, String str) {

        if (matrix == null) {
            return false;
        }

        boolean[] visited = new boolean[matrix.length];

        for (int i = 0; i < rows; i++) {
            for (int j = 0; j < cols; j++) {
                if (hasPathCore(matrix, rows, cols, i, j, 0, visited, str)) {
                    return true;
                }
            }
        }

        return false;
    }

    private static boolean hasPathCore(char[] matrix, int rows, int cols,
                                int row, int col, int pathLength, boolean[] visited, String str) {

        int index = row * cols + col;
        if (matrix == null || str == null || matrix.length == 0 ||
                str.length() == 0 || row < 0 || row >= rows || col < 0 || col >= cols ||
                matrix[index] != str.charAt(pathLength) || visited[index] == true) {

            return false;
        }

        if (pathLength == str.length() - 1) {
            return true;
        }

        visited[index] = true;

        if (hasPathCore(matrix, rows, cols, row + 1, col, pathLength + 1, visited, str) ||
                hasPathCore(matrix, rows, cols, row - 1, col, pathLength + 1, visited, str) ||
                hasPathCore(matrix, rows, cols, row, col + 1, pathLength + 1, visited, str) ||
                hasPathCore(matrix, rows, cols, row, col - 1, pathLength + 1, visited, str)) {
            return true;
        }

        visited[index] = false;

        return false;

    }

    public static void main(String[] args) {
        String m = "A";
        char[] matrix = m.toCharArray();
        String str = "B";
        System.out.println(hasPath(matrix, 1, 1, str));
    }
}
