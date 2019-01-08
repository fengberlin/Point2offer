package solution;

/**
 * 面试题67：把字符串转换成整数
 * 题目：请你写一个函数StrToInt，实现把字符串转换成整数这个功能。当然，不
 * 能使用atoi或者其他类似的库函数。
 */
public class String2Int {

    private boolean valid;

    public String2Int() {
        valid = true;
    }

    public boolean isValid() {
        return valid;
    }

    public int StrToInt(String str) {

        if (str == null || str.length() == 0) {
            valid = false;
            return 0;
        }
        int result = 0;
        int i = 0;
        int sign = 1;
        int digit = str.charAt(0);   // 判断第一个字符

        if (digit == '-' || digit == '+') {
            sign = (digit == '-') ? -1 : 1;

            if (str.length() == 1) {
                valid = false;
                return 0;    // 只有一个符号
            }
            i++;
        }

        while (i < str.length()) {
            digit = str.charAt(i++) - '0';    // 将字符转换成数字。因为char类型的字符（如果是数字）相减其实是计算两个数的距离
            if (digit >= 0 && digit <= 9) {
                if (result > Integer.MAX_VALUE / 10) {
                    valid = false;
                    return 0;
                } else if (result == Integer.MAX_VALUE / 10) {
                    if (sign == 1 && digit > 7) {
                        valid = false;    // 正数溢出
                        return 0;
                    } else if (sign == -1 && digit > 8) {
                        valid = false;    // 负数溢出
                        return 0;
                    }
                }
                result = result * 10 + digit;
            } else {
                valid = false;
                return 0;
            }
        }
        return sign > 0 ? result : -result;
    }
}
