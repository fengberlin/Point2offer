package solution;

/**
 * 面试题60：n个骰子的点数
 * 题目：把n个骰子扔在地上，所有骰子朝上一面的点数之和为s。
 * 输入n，打印出s的所有可能的值出现的概率。
 */
public class DicesProbability {

    private static final int maxValue = 6;

    // 方法一：递归
    public void printProbability(int n) {

        if (n <= 0) {
            return;
        }

        int maxSum = n * maxValue;
        int[] probabilities = new int[maxSum - n + 1];
        for (int i = 1; i <= maxValue; i++) {
            probability(n, n, i, probabilities);
        }

        printProbabilityHelper(n, maxSum, probabilities);
    }

    public void probability(int n, int cur, int sum, int[] probabilities) {

        if (cur == 1) {
            probabilities[sum - n]++;
        } else {
            for (int i = 1; i <= maxValue; i++) {
                probability(n, cur - 1, i + sum, probabilities);
            }
        }
    }

    public void printProbabilityHelper(int n, int maxSum, int[] probabilities) {

        double total = Math.pow(maxValue, n);
        for (int i = n; i <= maxSum; i++) {
            double ratio = probabilities[i - n] / total;
            System.out.print("P("+i + ")=");
            System.out.printf("%.4f", ratio);
            if (i != maxSum){
                System.out.print(", ");
            }
        }
    }

    // 方法二：循环
    public void printProbability1(int n) {

        if (n <= 0) {
            return;
        }

        int maxSum = n * maxValue;
        int[][] probabilities = new int[2][maxSum + 1];
        for (int i = 0; i < maxSum + 1; i++) {
            probabilities[0][i] = 0;
            probabilities[1][i] = 0;
        }

        for (int i = 1; i <= maxValue; i++) {
            probabilities[0][i] = 1;
        }

        int flag = 0;
        for (int i = 2; i <= n; i++) {
            for (int j = 0; j < i; j++) {
                probabilities[1 - flag][j] = 1;
            }
            for (int j = i; j <= maxValue * i ; j++) {
                probabilities[1 - flag][j] = 0;
                for (int k = 1; k <= j && k <= maxValue; k++) {
                    probabilities[1 - flag][j] += probabilities[flag][j - k];
                }
            }
            flag = 1 - flag;
        }
    }

    private static void printProbabilityHelper1(int n, int maxSum, int[][] probabilities, int flag) {

        double total = Math.pow(maxValue, n);
        for (int i = n; i < maxSum+1; i++) {
            double ratio = probabilities[flag][i] / total;
            System.out.print("P("+i + ")=");
            System.out.printf("%.4f", ratio);
            if (i != maxSum){
                System.out.print(", ");
            }
        }
    }
}
