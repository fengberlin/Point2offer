package solution;

/**
 * 面试题17：打印1到最大的n位数
 * 题目：输入数字n，按顺序打印出从1最大的n位十进制数。比如输入3，
 * 则打印出1、2、3一直到最大的3位数即999。
 */
public class Print1ToMaxOfNDigits {

    /**
     * 方法1
     * @param n 表示n位
     */
    public static void print1ToMaxOfNDigits(int n) {

        if (n <= 0) {
            return;
        }

        char[] number = new char[n];
        // number数组用字符0填充，从下标为0开始表示n位的数的最高位
        for (int i = 0; i < n; i++) {
            number[i] = '0';
        }

//        while (!increment(number)) {
//            printNumber(number);
//        }
        for (int i = 0; i < 10; i++) {
            number[0] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(number, n, 0);
        }
    }

    // 这里其实就是将那个数对应的位做加法运算
    // 例如：number = {'0', '0'}就表示2位的数，一开始从数组的最左边开始做加1操作
    // 如果前面的位表示的是0，则不输出这个0
    private static boolean increment(char[] number) {
        boolean isOverflow = false;
        int nTakeOver = 0;    // 进位标志
        int nLength = number.length;
        for (int i = nLength - 1; i >= 0; i--) {
            int nSum = number[i] - '0' + nTakeOver;    // 当前位
            if (i == nLength - 1) {
                nSum++;
            }
            // 判断最后加的那个位有没有溢出，也就是当数组的元素为'9'时，
            // 它加1会变成10，这时就要判断有没有溢出。
            if (nSum >= 10) {
                if (i == 0) {    // 在这里判断的是当进位发生在最高位时，这时发生溢出
                    isOverflow = true;
                } else {
                    nSum -= 10;
                    nTakeOver = 1;
                    number[i] = (char) ('0' + nSum);
                }
            } else {
                number[i] = (char) ('0' + nSum);
                break;
            }
        }

        return isOverflow;
    }

    private static void printNumber(char[] number) {
        boolean isBeginWith0 = true;
        int nLength = number.length;

        for (int i = 0; i < nLength; i++) {
            if (isBeginWith0 && number[i] != '0') {
                isBeginWith0 = false;
            }

            if (!isBeginWith0) {
                System.out.println(number[i]);
            }
        }
        System.out.println();
    }

    // 方法2
    // 将问题转换成数字排列的解法，使用递归。
    // 也是说，n位从0到9的全排列。
    public static void print1ToMaxOfNDigitsRecursively(char[] number, int length, int index) {
        if (index == length - 1) {
            printNumber(number);
            return;
        }

        for (int i = 0; i < 10; i++) {
            number[index + 1] = (char) (i + '0');
            print1ToMaxOfNDigitsRecursively(number, length, index + 1);
        }
    }

    public static void main(String[] args) {
        print1ToMaxOfNDigits(2);
    }
}
