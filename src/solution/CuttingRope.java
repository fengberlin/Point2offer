package solution;

/**
 * Author：Berlin
 * Problem 14：剪绳子。
 * 题目描述：给你一根长度为n绳子，请把绳子剪成m段（m、n都是整数，n>1并且m≥1）。
 * 每段的绳子的长度记为k[0]、k[1]、……、k[m]。k[0]*k[1]*…*k[m]可能的最大乘
 * 积是多少？例如当绳子的长度是8时，我们把它剪成长度分别为2、3、3的三段，此
 * 时得到最大的乘积18。
 */
public class CuttingRope {

    // 动态规划
    public static int maxProduct0(int ropeLength) {


        // 当length <= 3的时候，我们直接返回结果。
        // 例如如果整个绳子的长度为3，我们必须把绳子剪开，因为题目要求m > 1，其中一段为2，另一段为1，这样结果就是2。
        if (ropeLength < 2) {
            return 0;
        }

        if (ropeLength == 2) {
            return 1;
        }

        if (ropeLength == 3) {
            return 2;
        }

        // 例如当length == 4的时候，我们可以把绳子剪成两段，其中一段为3另一段为１，
        // 这样长度为3的那一段的最大值就是3而不是2，因为这一段我们不需要再剪了。
        // 当然长度为4的最大值是2和2的组合，我们已经存储了2的长度。

        // 各段长度的乘积的最大值存储在product数组里面，
        // 数组中的第i个元素表示把长度为i的绳子剪成若干段后各段长度乘积的最大值。
        // 要预留一个位置（即第0个位置）给绳子没剪的时候（例如绳子长度为4，剪了一段3之后，
        // 在计算长度为3的绳子的最大乘积的时候，当然是不剪的时候最大，即max = products[3] + products[0]）时的情况。
        int[] products = new int[ropeLength + 1];
        products[0] = 0;
        products[1] = 1;
        products[2] = 2;
        products[3] = 3;

        int max = 0;
        for (int i = 4; i <= ropeLength ; i++) {

            max = 0;

            // j <= i/2时因为在剪的时候，大于绳子的二分之一的长度的时候，
            // 剪出的是同样长度的两段绳子。例如剪长度为4的绳子，在其四分之一
            // 处剪和在其四分之三处剪同样时得到一段长为1的绳子和一段长为3的绳子。
            for (int j = 0; j <= i/2 ; j++) {
                int product = products[j] * products[i - j];
                if (max < product) {
                    max = product;
                }

                products[i] = max;
            }
        }

        max = products[ropeLength];

        return max;
    }


    // 贪心算法
    // 策略：当n>=5时，尽可能多地剪长度为3的绳子；
    // 当剩下的绳子长度为4时，把绳子剪成两段长度为2的绳子。因为2*2 > 3*1
    // 贪心选择性的证明：
    // 当n<5时，无论怎么剪切，乘积product <= n，当n为4时，product最大为2*2=4；
    // 当n>=5时，可以证明2(n-2)>n或者3(n-3)>n，即说明我们在绳子剩下的长度大于等于5的时候，
    // 我们就把它尽量多地剪成长度为3或长度为2的绳子段。而又因为3(n-3)>=2(n-2)，所以应该尽量多地剪长度为3的绳子。
    public static int maxProduct1(int ropeLength) {

        if (ropeLength < 2) {
            return 0;
        }

        if (ropeLength == 2) {
            return 1;
        }

        if (ropeLength == 3) {
            return 2;
        }

        // 记录剪成长度为3的绳子能剪多少段。这里其实是尽可能地剪去长度为3的绳子段，贪心选择性的证明如上。
        int timesOf3 = ropeLength / 3;

        if ((ropeLength - timesOf3 * 3) == 1) {
            timesOf3--;
        }

        // 计算剩下的绳子能剪成多少段长度为2的绳子
        int timesOf2 = (ropeLength - timesOf3 * 3) / 2;

        return (int)(Math.pow(3, timesOf3)) * (int)(Math.pow(2, timesOf2));

    }
}
