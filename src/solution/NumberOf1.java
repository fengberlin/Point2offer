package solution;

/**
 * 面试题43：从1到n整数中1出现的次数
 * 题目：输入一个整数n，求从1到n这n个整数的十进制表示中1出现的次数。例如
 * 输入12，从1到12这些整数中包含1 的数字有1，10，11和12，1一共出现了5次。
 */
public class NumberOf1 {

    public int numberOf1Between1AndN(int n) {

        if (n < 1) {
            return 0;
        }

        int count = 0;
        for (int i = 1; i <= n ; i++) {
            count += numOf1(i);
        }
        return count;
    }

    private int numOf1(int num) {

        int count = 0;
        int value;
        while (num != 0) {
            value = num % 10;
            if (value == 1) {
                count++;
            }
            num = num / 10;
        }
        return count;
    }

    /**
     * 我们从低位到高位求每位1出现的次数，累加求和即可
     * 例如：求0~abcde中1的个数，现在我们求c这一位中1出现的次数，其他位雷同
     * 有两部分组成:
     * 第一部分：ab * 100，表示当ab这两位在0~ab-1范围内时，de可以从0~99取值
     * 第二部分：如果c>1时，当ab为ab时1的个数为0~99
     *         如果c=1时，当ab为ab时1的个数为de + 1
     *         如果c<0时，当ab为ab是1的个数为0
     */
    private int numberOf1Between1AndN1(int n) {

        int exp = 1;
        int ans = 0;
        while((n / exp) != 0)
        {
            ans += n / (exp * 10) * exp;
            if(n % (exp * 10) / exp  > 1) ans += exp;
            else if(n % (exp * 10) / exp == 1) ans += (n % exp + 1);
            exp *= 10;
        }
        return ans;
    }

    private int numberOf1Between1AndN2(int n) {

        StringBuilder sb = new StringBuilder(n);
        for (int i = 1; i <= n; i++) {
            sb.append(i);
        }

        int count = 0;
        for (int i = 0; i < sb.length(); i++) {
            if (sb.charAt(i) == '1') {
                count++;
            }
        }
        return count;
    }

}
