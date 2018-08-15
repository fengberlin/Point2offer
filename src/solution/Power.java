package solution;

/**
 * 面试题16：数值的整数次方
 * 题目：实现函数double Power(double base, int exponent)，求base的exponent次方
 */
public class Power {

    public static double power(double base, int exponent) {

        // 0的0次方没有意义，所以我们设置当出现这种情况时，返回0
        if (Double.compare(base, 0.0) == 0 ||
                (Double.compare(base, 0.0) == 0 && exponent == 0)) {
            return 0.0;
        }

        if (exponent == 0) {
            return 1.0;
        }

        double result = 0.0;

        if (exponent > 0) {
            result = power_core(base, exponent);
        } else {
            result = 1.0/power_core(base, -exponent);
        }

        return result;
    }

    public static double power_core(double base, int exponent) {

        double result = 1.0;

        for (int i = 0; i < exponent; i++) {
            result *= base;
        }

        return result;
    }

    /**
     * an = a^(n/2) * a^(n/2), n为偶数；
     * an = a^((n-1)/2) * a^((n-1)/2) * a, n为奇数。
     * @param base
     * @param exponent
     * @return
     */
    public static double power_core_another(double base, int exponent) {

        if (exponent == 0) {
            return 1;
        }

        if (exponent == 1) {
            return base;
        }

        double result = power_core_another(base, exponent >> 1);
        result *= result;

        // 判断exponent是否是偶数
        if ((exponent & 0x1) == 1) {
            result *= base;
        }

        return result;
    }
}
