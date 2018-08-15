package solution;

/**
 * Author：Berlin
 * Problem 4：二维数组中的查找。
 * 题目描述：题目：在一个二维数组中，每一行都按照从左到右递增的顺序排序，
 * 每一列都按照从上到下递增的顺序排序。请完成一个函数，
 * 输入这样的一个二维数组和一个整数，判断数组中是否含有该整数。
 */
public class FindInPartiallySortedMatrix {

    // 时间复杂度：O(nlgn)，空间复杂度：O(1)
    // 方法1：根据题目运用二分查找法，对每一行用二分查找法判断是否找到那个数。
    public static boolean find0(int[][] a, int key) {

        if (a == null || a.length == 0 || a[0].length == 0) {
            return false;
        }

        for (int i = 0; i < a.length; i++) {
            int low = 0;
            int high = a[i].length - 1;
            // 根据题目，每一行和每一列都是递增的，所以这里判断一下每行的第一个数和最后一个数是否满足条件，不满足的话直接跳到下一行。
            if (a[i][0] > key || a[i][a[i].length-1] < key) {
                continue;
            }
            // 下面用二分查找每一行
            while (low <= high) {
                int mid = ((high - low) >>> 1) + low;    // 这里避免数字太大导致溢出
                if (a[i][mid] > key) {
                    high = mid - 1;
                } else if (a[i][mid] < key) {
                    low = mid + 1;
                } else {
                    return true;
                }
            }
        }

        return false;

    }

    // 时间复杂度：O(n)，空间复杂度：O(1)
    // 方法2：这个方法每次先判断右上角的那个数与要查找的那个数的大小关系，
    // 如果右上角的那个数大于要查找的那个数，则无需考虑右上角的那个数所在的列，
    // 如果右上角的那个数小于要查找的那个数，则无需考虑右上角的那个数所在的行。
    // 这个题目也可以从左下角开始判断，原理是一样的。
    public static boolean find1(int[][] a, int key) {

        if (a == null || a.length == 0) {
            return false;
        }

        int row = 0;
        int col = a[0].length - 1;
        while (row < a.length && col >= 0) {
            if (a[row][col] < key) {
                row++;
            } else if (a[row][col] > key) {
                col--;
            } else {
                return true;
            }
        }

        return false;
    }

    public static void main(String[] args) {
        int[][] a = {
                {1,4,7,11},
                {2,5,8,12},
                {3,6,9,16},
                {10,13,14,17},
                {18,21,23,26}
        };

        System.out.println(find1(a, 9));
    }
}
